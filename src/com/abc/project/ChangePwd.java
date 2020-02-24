package com.abc.project;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ChangePwd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int accno;
	private String pwd;
	private boolean result;
 
	protected void service(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		accno = (int) session.getAttribute("accno");
		pwd = request.getParameter("npwd");
		Model model = new Model();
		model.setAccno(accno);
		model.setPwd(pwd);
		 result = model.changePwd();
		if (result==true) {
			try {
				response.sendRedirect("/BankApp/changePwdSuccess.html");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
			try {
				response.sendRedirect("/BankApp/changePwdFail.html");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
