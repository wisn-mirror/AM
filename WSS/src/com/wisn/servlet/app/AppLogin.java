package com.wisn.servlet.app;

import com.wisn.bean.CacheUser;
import com.wisn.bean.Result;
import com.wisn.bean.User;
import com.wisn.code.JsonPars;
import com.wisn.core.IDS;
import com.wisn.core.SessionFactory;
import com.wisn.servlet.BaseServlet;
import com.wisn.servlet.ConstAPI;
import com.wisn.utils.LogUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/***
 *
 * @author Wisn
 * 2016年9月30日   上午9:26:14
 *
 */
@WebServlet(ConstAPI.APP_LOGIN)
public class AppLogin extends BaseServlet {
    private static final long serialVersionUID = 5507001835503546202L;

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String jsonResponse = "";
        try {
            LogUtils.d(request.getRemoteAddr());
            String requestContent = acceptJSON(request);
            //添加验证码验证
            if (requestContent == null || "".equals(requestContent)) {
                jsonResponse = JsonPars.toJsonMessage("", new Result(" Lack of necessary parameters ", ""), 500);
            } else {
                User user = JsonPars.fromJson(requestContent, User.class);
                LogUtils.d(user.toString());
                //验证身份
                if (IDS.getId(user.getId())) {
                    CacheUser cacheUser = new CacheUser(user.id, user.token, user.name, user.password);
                    SessionFactory.getInstance().addUser(user.getId(), cacheUser);
                    jsonResponse = JsonPars.toJsonMessage(cacheUser, null, 200);
                }else{
                    jsonResponse = JsonPars.toJsonMessage("", new Result(" please register ", ""), 500);
                }
            }
        } catch (Exception e) {
            jsonResponse = JsonPars.toJsonMessage("", new Result("  Server  Error ", e.getMessage()), 500);
        } finally {
            responseJson(response, jsonResponse);
        }
    }
}
