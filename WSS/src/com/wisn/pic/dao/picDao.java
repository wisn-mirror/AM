package com.wisn.pic.dao;

import com.wisn.pic.bean.Picture;
import com.wisn.pic.jdbcsql.JDUtil;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class picDao {
	private picDao(){
	}
	public static  List<Picture> getList(int pageindex, int pagesize, String key) {
		List<Picture> list = null;
		try {
			String sql = "select * from pic limit ?,?";
			Connection connection = JDUtil.getConnection();
			PreparedStatement prepareStatement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			prepareStatement.setInt(1, pageindex*pagesize);
			prepareStatement.setInt(2, pagesize);
			ResultSet executeQuery = prepareStatement.executeQuery();
			if (executeQuery != null) {
				list = new ArrayList<Picture>();
			}
			while (executeQuery.next()) {
				Picture pic = new Picture();
				pic.setId(executeQuery.getInt("id"));
				pic.setName(executeQuery.getString("name"));
				pic.setType(executeQuery.getInt("type"));
				pic.setPath(executeQuery.getString("path"));
				pic.setEnable(executeQuery.getInt("enable"));
				list.add(pic);
			}
			JDUtil.release(connection, prepareStatement, executeQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// select * from tablename limit 5,20;  5从那条开始，查询20条
		return list;
	}

	public static void main(String[] args) {
		picDao p = new picDao();
		// p.getList(0, 0, "");
		p.insert();

	}

	/**
	 * 插入文件属性 // String sql8="insert into bachtest values(5,'33366')";
	 */
	public static  void insert() {
		Connection connection;
		try {
			connection = JDUtil.getConnection();
			Statement createStatement = connection
					.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
			File file = new File("F:/美女图片/图片收集/图片收集");
			Queue<File> queue = new LinkedList<File>();
			queue.offer(file);// 入队
			while (!queue.isEmpty()) {
				File fileout = queue.poll();// 出队
				if (fileout.isFile()) {
					System.out.println(fileout.getAbsolutePath());
				} else {
					File[] files = fileout.listFiles();
					if (files != null) {
						for (File fileone : files) {
							if (fileone.isFile()) {
//								System.out.println("path:"
//										+ fileone.getAbsolutePath());
								String absolutePath = fileone.getAbsolutePath().toString();
								if (absolutePath.toLowerCase().endsWith(".jpg")
										|| absolutePath.toLowerCase().endsWith(
												".png")
										|| absolutePath.toLowerCase().endsWith(
												".gif")
										|| absolutePath.toLowerCase().endsWith(
												".bmp")
										 ) {
									// 添加批处理
									String replace = absolutePath.replace("\\", "\\\\");
									createStatement
											.addBatch("insert into pic (name,type,path,enable) values('图片','1','"
													+ replace + "',0)");
									 System.out.println(fileone.getAbsolutePath());
								}
							} else {
								queue.offer(fileone);
							}
						}
					}
				}
			}
			createStatement.executeBatch();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("遍历查找完成");
	}
}
