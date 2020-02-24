package com.abc.project;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;


public class changePwdFilter implements Filter {

	private String npwd;
	private String cnpwd;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)throws IOException, ServletException  {
		npwd = request.getParameter("npwd");
		cnpwd = request.getParameter("cnpwd");
		if (npwd.equals(cnpwd)) {
			chain.doFilter(request, response);
		}
		else {
			((HttpServletResponse) response).sendRedirect("/BankApp/errorChangePwd.jsp");
		}
	}
}