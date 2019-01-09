package com.robin.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String uri = request.getRequestURI();
		HttpSession session= request.getSession();

		if(session.getAttribute("name")!=null) {
			return true;
		}
		// UTL:除了login 和register是可以公开访问的，其他的URL都进行拦截控制
		if (uri.indexOf("/login") >= 0 || uri.indexOf("/register") >= 0 ) {
			return true;
		}
		request.getRequestDispatcher("/login").forward(request, response);
		
		//response.sendRedirect("login");
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
