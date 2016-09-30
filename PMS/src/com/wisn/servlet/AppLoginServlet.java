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
import com.wisn.utils.LogUtils;
/***
 * 
 * @author Wisn
 * 2016年9月30日   上午9:26:14
 *
 */
@WebServlet("/appLogin")
public class AppLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 5507001835503546202L;
	public AppLoginServlet() {
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
				String  requestContent=request.getParameter("requestContent");
				//添加验证码验证
				if(requestContent==null||"".equals(requestContent)){
					response.getWriter().print(JsonPars.toJson("",new Result(" Lack of necessary parameters ",""), 500));
				}else{
					DeviceInformation loginParamter = JsonPars.fromJson(requestContent, DeviceInformation.class);
					//验证身份
					AuthServiceImpl   auth=new  AuthServiceImpl();
					//loginParamter 
					Admin appLogin = auth.DeviceLogin(loginParamter.getUserName(),loginParamter.getPassWord());
					if(appLogin==null){
						response.getWriter().print(JsonPars.toJson("",new Result(" ERROR Incorrect username or password  ",null), 500));
					}else{
						//检测和添加设备信息
						DeviceInfoServiceImpl  deviceService=new  DeviceInfoServiceImpl();
						DeviceInformation appInfo = deviceService.checkDeviceInformation(loginParamter);
						if(appInfo==null){
							appInfo= deviceService.addDeviceInformation(loginParamter);
						} 
						IDS.addId(appInfo.getId());
						response.getWriter().print(JsonPars.toJson(appInfo,null, 200));
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				LogUtils.e("AppLoginServlet:"+e.toString());
				response.getWriter().print(JsonPars.toJson("",new Result("  Server  Error ",""), 500));
			}
	}
	public void init() throws ServletException {
	}

}
