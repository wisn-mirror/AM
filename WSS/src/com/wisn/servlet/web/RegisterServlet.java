package com.wisn.servlet.web;

import com.wisn.bean.Admin;
import com.wisn.servlet.BaseServlet;
import com.wisn.utils.LogUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 
 * @author Wisn
 * 2016年9月30日   上午9:24:16
 *
 */
@WebServlet("/web/register")
public class RegisterServlet extends BaseServlet {
	private static final long serialVersionUID = 5507001835503546202L;
	public RegisterServlet() {
		super();
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			try {
				String  username=request.getParameter("username");
				String  password=request.getParameter("password");
				String  code=request.getParameter("code");
				//todo 添加验证码验证
				if(username==null||"".equals(username)||password==null||"".equals(password)){
					request.getRequestDispatcher("/register.jsp").forward(request, response);
				}else{
					//验证身份
					AuthServiceImpl   auth=new  AuthServiceImpl();
					//loginParamter 
					Admin register = auth.UserRegister(username,password);
					if(register==null){
//						response.getWriter().print(JsonPars.toJson("",new Result(" ERROR Incorrect username or password  ",null), 500));
						request.getRequestDispatcher("/register.jsp").forward(request, response);
					}else{
						request.getSession().setAttribute("admin", register);
						request.getRequestDispatcher("/Manager.jsp").forward(request, response);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				LogUtils.e("AdminLoginServlet:"+e.toString());
				//response.getWriter().print(JsonPars.toJson("",new Result("  Server  Error ",""), 500));
				request.getRequestDispatcher("/AdminLogin.jsp").forward(request, response);
			}
	}

}
