package com.wisn.servlet;

import com.wisn.dbm.DbExecute;
import com.wisn.dbm.ResultSetCallBack;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;

@WebServlet("/token")
@WebInitParam(name = "timeout", value = "1000")
public class test extends BaseServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }
        response.setStatus(401);
        responseJson(response,"[]");

        /*try {
            insertTest();
        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.e("AdminLoginServlet:"+e.toString());
            //response.getWriter().print(JsonPars.toJson("",new Result("  Server  Error ",""), 500));
            request.getRequestDispatcher("/AdminLogin.jsp").forward(request, response);
        }*/
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        doPost(req,resp);
    }

    public void insertTest(){
        DbExecute db=new DbExecute();
        db.executeInsertOrUpdate("INSERT  into test(contents) VALUE (43243) ", new  ResultSetCallBack() {

            @Override
            public void executeRowCount(int id) {
            }

            @Override
            public void executeResult(ResultSet resultSet) {
                try{
                    boolean exist = resultSet.next();

                }catch(Exception e ){
                    e.printStackTrace();
                }
            }

            @Override
            public void executeGeneratedKeys(ResultSet resultSet) {
            }
        });
        db.executeInsertOrUpdate("update test set  contents=8888 where id=1 ", new  ResultSetCallBack() {
            @Override
            public void executeRowCount(int id) {
            }

            @Override
            public void executeResult(ResultSet resultSet) {
                try{
                    boolean exist = resultSet.next();

                }catch(Exception e ){
                    e.printStackTrace();
                }
            }

            @Override
            public void executeGeneratedKeys(ResultSet resultSet) {
            }
        });

    }

}
