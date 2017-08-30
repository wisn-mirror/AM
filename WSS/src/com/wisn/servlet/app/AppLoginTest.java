package com.wisn.servlet.app;

import com.wisn.bean.ResultTest;
import com.wisn.bean.TestResult;
import com.wisn.bean.User;
import com.wisn.code.JsonPars;
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
@WebServlet(ConstAPI.APP_TEST)
public class AppLoginTest extends BaseServlet {
    private static final long serialVersionUID = 5507001835503546202L;

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String jsonResponse = "";
        try {
            String requestContent = acceptJSON(request);
            LogUtils.d(request.getRemoteAddr()+requestContent);
            //添加验证码验证
            if (requestContent == null || "".equals(requestContent)) {
                jsonResponse =  JsonPars.toJson(new TestResult(502,"error request"));
            }else{
                User user = JsonPars.fromJson(requestContent, User.class);
                if(user!=null&&user.id!=0&&user.getName()!=null&&!"".equals(user.getName())){
                    jsonResponse =  JsonPars.toJson(new TestResult(200,"success",new ResultTest(String.valueOf(user.id),user.getName())));
                }else{
                    jsonResponse =  JsonPars.toJson(new TestResult(204,"success"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsonResponse =  JsonPars.toJson(new TestResult(500,"error"+e.getMessage()));

        } finally {
            responseJson(response, jsonResponse);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);

    }
}
