package com.wisn.pic.servlet;

import com.wisn.pic.bean.Data;
import com.wisn.pic.bean.Picture;
import com.wisn.pic.dao.picDao;
import com.wisn.pic.jdbcsql.GoonTool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 返回图片信息数据json
 * @author Wisn
 *
 */
@WebServlet("/getpic")
public class picServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Data data=new  Data();
		try{
			String pageindex = request.getParameter("pageindex");
			String pagesize = request.getParameter("pagesize");
			//String key = request.getParameter("key");
			System.out.println("请求网络返回json 索引："+pageindex+"页面大小"+pagesize);
			List<Picture> list = picDao.getList(Integer.parseInt(pageindex), Integer.parseInt(pagesize), "");
			data.setData(list);
			data.setResult(200);
		}catch(Exception  e){
			e.printStackTrace();
			data.setResult(500);
		}
		//创建Gson对对象
		String json = GoonTool.getInstance().toJson(data);
		//对象转换成字符串
//		response.setHeader("Content-Type", "text/html;charset=UTF-8");// 修改浏览器打开时的编码
//		response.setCharacterEncoding("UTF-8"); // 修改缓冲区的编码
		// 这一句相当于上面两句
		response.setContentType("text/json;charset=UTF-8");// 修改浏览器打开时的编码和缓冲区
		response.getWriter().print(json);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 doGet(request, response);
	}

}
