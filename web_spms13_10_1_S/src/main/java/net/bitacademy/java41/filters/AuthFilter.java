package net.bitacademy.java41.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.java41.vo.Member;

public class AuthFilter implements Filter {
	FilterConfig config;
	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain next) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		
		Member member = (Member)request.getSession().getAttribute("member");
		if(member != null 
				|| request.getServletPath().startsWith("/auth")
				|| request.getServletPath().startsWith("/member/signup")){
			next.doFilter(request, response);
		} else {
			response.sendRedirect(request.getContextPath()+"/auth/loginForm.do");
		}
	}

	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}


}
