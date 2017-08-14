package com.wisn.servlet.app;

import com.wisn.bean.DeviceInformation;
import com.wisn.bean.Result;
import com.wisn.bean.User;
import com.wisn.code.JsonPars;
import com.wisn.core.IDS;
import com.wisn.serviceimpl.DeviceInfoServiceImpl;
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
@WebServlet(ConstAPI.APP_REGISTER)
public class AppRegister extends BaseServlet {
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
                DeviceInformation loginParamter = JsonPars.fromJson(requestContent, DeviceInformation.class);
                //验证身份
                DeviceInfoServiceImpl deviceInfoServiceImpl = new DeviceInfoServiceImpl();
                DeviceInformation deviceInformation = deviceInfoServiceImpl.addDeviceInformation(loginParamter);
                IDS.addId(deviceInformation.getId());
                User user = new User(deviceInformation.getId(), deviceInformation.getUserName(), deviceInformation.getPassWord());
                if (user == null) {
                    jsonResponse = JsonPars.toJsonMessage("", new Result(" ERROR Incorrect username or password  ", null), 500);
                } else {
                    jsonResponse = JsonPars.toJsonMessage(user, null, 200);
                }
            }
        } catch (Exception e) {
            jsonResponse = JsonPars.toJsonMessage("", new Result("  Server  Error ", e.getMessage()), 500);
        } finally {
            responseJson(response, jsonResponse);
        }
    }

    public void init() throws ServletException {
    }

}
