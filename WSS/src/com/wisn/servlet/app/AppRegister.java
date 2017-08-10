package com.wisn.servlet.app;

import com.wisn.bean.DeviceInformation;
import com.wisn.bean.Result;
import com.wisn.bean.User;
import com.wisn.code.JsonPars;
import com.wisn.core.IDS;
import com.wisn.servlet.BaseServlet;
import com.wisn.utils.LogUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

/***
 * 
 * @author Wisn
 * 2016年9月30日   上午9:26:14
 *
 */
@WebServlet("/app/register")
public class AppRegister extends BaseServlet {
	private static final long serialVersionUID = 5507001835503546202L;
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String jsonResponse="";
			try {
				LogUtils.d(request.getRemoteAddr());
				String requestContent=acceptJSON(request);
				//添加验证码验证
				if(requestContent==null||"".equals(requestContent)){
					jsonResponse=JsonPars.toJsonMessage("",new Result(" Lack of necessary parameters ",""), 500);
				}else{
					DeviceInformation loginParamter = JsonPars.fromJson(requestContent, DeviceInformation.class);
					//验证身份
					long userid=(long)new Random().nextDouble()*1000;
					IDS.addId(userid);
					User user=new User(userid,loginParamter.getUserName(),loginParamter.getPassWord());
					if(user==null){
						jsonResponse=JsonPars.toJsonMessage("",new Result(" ERROR Incorrect username or password  ",null), 500);
					}else{
						jsonResponse=JsonPars.toJsonMessage(user,null, 200);
					}
				}
			} catch (Exception e) {
				jsonResponse=JsonPars.toJsonMessage("",new Result("  Server  Error ",e.getMessage()), 500);
			}finally {
				responseJson(response,jsonResponse);
			}
	}
	public void init() throws ServletException {
	}

}
