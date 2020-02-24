package com.abc.project;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class TransferFilter implements Filter {


	public int theAmnt;

	public TransferFilter() {
		// TODO Auto-generated constructor stub
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String amnt  = request.getParameter("amnt");
		theAmnt = Integer.parseInt(amnt);
		if (theAmnt<=0) {
				((HttpServletResponse) response).sendRedirect("/BankApp/errorTransfer.jsp");
			}
		else {
			chain.doFilter(request, response);
		}
	}
}