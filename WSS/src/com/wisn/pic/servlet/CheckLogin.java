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
@WebServlet("/servlet/checkcookie")
public class CheckLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CheckLogin() {
        super();
    }
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String   username= (String)request.getSession().getAttribute("username");
	System.out.println("checkcookie username"+username);	
	if("wisn".equals(username)){
			response.getWriter().print("login succcess");
		}else{
			response.getWriter().print("500");
			 
		}
	}
	/**
	 *查找cookie中的 值
	 * @param cookies
	 * @param name
	 * @return
	 */
	
	private Cookie findCookie(Cookie[] cookies, String name ) {
		if(cookies!=null){
			for(Cookie cookie:cookies){
				if(name.equals(cookie.getName())){
					System.out.println("存在cookie");
					return cookie;
				}
			}
		} 
		return null;
	}
	
	/**
	 * 添加字符串
	 * @param oldStr
	 * @param newStr
	 * @return
	 */
	public String addStr(String oldStr,String newStr){
		if(newStr.length()==0){
			return oldStr;
		}else if(oldStr.length()==0){
			return newStr+";";
		}else{
			return oldStr+";"+newStr;
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
