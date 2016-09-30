package com.wisn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wisn.bean.Admin;
import com.wisn.bean.DeviceInformation;
import com.wisn.bean.Result;
import com.wisn.code.JsonPars;
import com.wisn.core.IDS;
import com.wisn.service.AuthService;
import com.wisn.serviceimpl.AuthServiceImpl;
import com.wisn.serviceimpl.DeviceInfoServiceImpl;
/**
 * 
 * @author Wisn
 * 2016年9月30日   上午9:24:16
 *
 */
@WebServlet("/adminLogin")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 5507001835503546202L;
	public AdminLoginServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); 
	
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			try {
				String  username=request.getParameter("username");
				String  password=request.getParameter("password");
				String  code=request.getParameter("code");
				/*if("".equals(code)||code==null){
					return ;
				}*/
				//添加验证码验证
				if(username==null||"".equals(username)||password==null||"".equals(password)){
					response.getWriter().print(JsonPars.toJson("",new Result(" Lack of necessary parameters ",""), 500));
				}else{
					//验证身份
					AuthServiceImpl   auth=new  AuthServiceImpl();
					//loginParamter 
					Admin appLogin = auth.DeviceLogin(username,password);
					if(appLogin==null){
						response.getWriter().print(JsonPars.toJson("",new Result(" ERROR Incorrect username or password  ",null), 500));
					}else{
						request.getSession().setAttribute("admin", appLogin);
						request.getRequestDispatcher("/Manager.jsp").forward(request, response);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				response.getWriter().print(JsonPars.toJson("",new Result("  Server  Error ",""), 500));
			}
	}
	public void init() throws ServletException {
	}

}
