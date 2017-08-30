package com.wisn.pic.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wisn
 *
 */
@WebServlet("/servlet/testcookie")
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CookieServlet() {
        super();
    }
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		System.out.println("testcookie username"+username);
		if("wisn".equals(username)){
			response.getWriter().print("login Success");
			request.getSession().setAttribute("username", "wisn");
			Cookie  newCookie=new Cookie("username","wisnCookie");
			newCookie.setMaxAge(60*60*1000);
			response.addCookie(newCookie);
		}else{
			response.getWriter().print("username  is  error");
			request.getSession().removeAttribute("username");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
