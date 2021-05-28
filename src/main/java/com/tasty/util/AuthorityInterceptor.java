package com.tasty.util;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.tasty.member.vo.LoginVO;

import lombok.extern.log4j.Log4j;

@Log4j
public class AuthorityInterceptor extends HandlerInterceptorAdapter {

	private static Map<String, Integer> authMap = new HashMap<String, Integer>();
	
	private String url = null;
	
	static {
		
		// 회원
		authMap.put("/member/memberUpdate.do", 4);
		authMap.put("/member/memberWithdraw.do", 4);
		authMap.put("/member/memberWithdrawForm.do", 4);
		authMap.put("/member/myShopPage.do", 5);
		authMap.put("/member/shopUpdate.do", 6);
		authMap.put("/member/masterShopUpdate.do", 9);
		authMap.put("/member/memberList.do", 9);
		authMap.put("/member/shopReg.do", 9);
		authMap.put("/member/shopView.do", 9);
		authMap.put("/member/view.do", 9);
		
		// 즐겨찾기
		
		// 톡
		authMap.put("/chat/list.do", 4);		
		authMap.put("/chat/update.do", 4);		
		authMap.put("/chat/view.do", 4);		
		authMap.put("/chat/write.do", 4);		
		// 대기열
		authMap.put("/waiting/nowUpdate.do", 5);
		
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		log.info("!!!!  [AuthorityFilter] !!!!!");
		
		url = request.getServletPath();
		
		int pathIndex = url.indexOf("/", 2);
		
		int rowPathIndex = url.indexOf("/", 0);
		
		// log.info("!!!!!!!!!!!!!!!!!!!! [pathIndex] : " + pathIndex);
		
		String path = "";
		
		if(pathIndex >= 0) {
			
			path = url.substring(0, pathIndex);
			
		} else {
			
			path  = url.substring(0, rowPathIndex);
				
		}	
		
		if(!path.equals("/member") && !path.equals("/waiting") && !path.equals("/bookmark") 
			&& !path.equals("/replies") && !path.equals("/chatRoom") && !path.equals("/vendor") 
			&& !path.equals("/resources") && !path.equals("/js") && !path.equals("/css") && !path.equals("/img") 
			&& !path.equals("/error") && !path.equals("getRoom") && !path.equals("/createRoom") && !path.equals("/") && !path.equals("/upload")) {
			
			if(request.getQueryString() != null) {
				
				request.getSession().setAttribute("url", url + "?" + request.getQueryString());
				
				log.info("URL 저장 : " + request.getSession().getAttribute("url"));
				
			} else {
				
				request.getSession().setAttribute("url", url);
				
				log.info("URL 저장 : " + request.getSession().getAttribute("url"));
				
				
			}
			
		}
		
		
		// log.info("[AuthorityFilter : url]" + url);
		
		HttpSession session = request.getSession();
		
		LoginVO vo = (LoginVO) session.getAttribute("login");
		
		if(!checkAuthority(vo)) {
			
			response.sendRedirect("/error/auth_error.do");
			
			return false;
			
			
		}
		
		if(vo == null && !checkAuthority(vo)) {
			
			response.sendRedirect("/error/login_error.do");
			
			return false;
			
		}
		
		return super.preHandle(request, response, handler);
		
		
	}
	
	private boolean checkAuthority(LoginVO vo) {
		
		Integer pageGradeNo = authMap.get(url);
		
		if(pageGradeNo == null) {
			
			log.info("권한이 필요 없는 Page");
			
			return true;
			
		}
		
		if(vo == null) {
			
			log.info("로그인이 필요한 서비스 입니다.");
			
			return false;
			
		}
		
		if(pageGradeNo > vo.getGradeNo()) {
			
			log.info("권한이 없습니다.");
			
			return false;
			
		}
		
		return true;
		
	}
	
}
