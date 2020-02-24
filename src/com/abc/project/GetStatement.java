package com.abc.project;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class GetStatement extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public ArrayList al;


	protected void service(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		int accno = (int) session.getAttribute("accno");
		System.out.println(accno);
		Model model = new Model();
		model.setAccno(accno);
		al = model.getStatement();
		if(al.isEmpty()==false)
		{
			session.setAttribute("al",al);
			try {
				response.sendRedirect("/BankApp/getStatementSuccess.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else
		{
			try {
				response.sendRedirect("/BankApp/getStatementFail.html");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}