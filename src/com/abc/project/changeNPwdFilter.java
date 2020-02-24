package com.abc.project;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;


public class changeNPwdFilter implements Filter {

	private String np;
	private String cnp;
	private String npwd;
	private String cnpwd;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)throws IOException, ServletException  {
		np = request.getParameter("np");
		cnp = request.getParameter("cnp");
		if (np.equals(cnp)) {
			chain.doFilter(request, response);
		}
		else {
			((HttpServletResponse) response).sendRedirect("/BankApp/errorChangeNPwd.jsp");
		}
	}
}