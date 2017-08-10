package com.wisn.servlet.app;

import com.wisn.bean.CacheUser;
import com.wisn.bean.Result;
import com.wisn.code.JsonPars;
import com.wisn.core.SessionFactory;
import com.wisn.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;

/***
 * 
 * @author Wisn
 * 2016年9月30日   上午9:26:14
 *
 */
@WebServlet("/app/applogin")
public class AppUser extends BaseServlet {
	private static final long serialVersionUID = 5507001835503546202L;

	/**
	 * 获取所有user
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String jsonResponse="";
		try {
			String requestContent=acceptJSON(req);
			//添加验证码验证
			if(requestContent==null||"".equals(requestContent)){
				jsonResponse=JsonPars.toJsonMessage("",new Result(" Lack of necessary parameters ",""), 500);
			}else{
				LinkedHashMap<Long, CacheUser> sessionQueue = SessionFactory.getInstance().getSessionQueue();
				jsonResponse=JsonPars.toJsonMessage(sessionQueue,null, 200);
			}
		} catch (Exception e) {
			jsonResponse=JsonPars.toJsonMessage("",new Result("  Server  Error ",e.getMessage()), 500);
		}finally {
			responseJson(resp,jsonResponse);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String jsonResponse="";
			try {
				jsonResponse=JsonPars.toJsonMessage("",new Result(" Lack of necessary parameters ",""), 500);
			} catch (Exception e) {
				jsonResponse=JsonPars.toJsonMessage("",new Result("  Server  Error ",e.getMessage()), 500);
			}finally {
				responseJson(response,jsonResponse);
			}
	}
}
