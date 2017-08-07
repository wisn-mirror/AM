package com.wisn.servlet;

import com.wisn.utils.LogUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaseServlet extends HttpServlet {
    public BaseServlet() {
        super();
        LogUtils.d(this.getClass().getName());
    }

    @Override
    public void init() throws ServletException {
        super.init();
        LogUtils.d("Init:"+this.getClass().getName());
    }

    @Override
    public void destroy() {
        super.destroy();
        LogUtils.d("destroy:"+this.getClass().getName());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }

    @Override
    protected void doHead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doHead(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    public void responseJson(HttpServletResponse response, String responseContent) {
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            response.getWriter().print(responseContent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String acceptJSON(HttpServletRequest request) {
        String acceptjson = "";
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "utf-8"));
            StringBuffer sb = new StringBuffer("");
            String temp;
            while ((temp = br.readLine()) != null) {
                sb.append(temp);
            }
            br.close();
            acceptjson = sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return acceptjson;
    }
}
