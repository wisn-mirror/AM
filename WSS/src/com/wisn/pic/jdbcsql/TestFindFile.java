package com.wisn.pic.jdbcsql;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

public class TestFindFile {
//	@Test
//	public void test1(){
//		 print(0);
//	}
	public static void main(String[] args) {
//		 print(0);
//		listFile(new File("d://"));
		//findFile(new File("D:\\XiaoQing"),"java");
		listFile(new File("D:\\XiaoQing"),"java");
	}

	/**
	 * 用队列遍历文件
	 * @param file
	 */
	public static void listFile(File  file ,String type){
		Queue<File>  queue=new LinkedList<File>();
		queue.offer(file);//入队
		while(!queue.isEmpty()){
			File  fileout=queue.poll();//出队
			if(fileout.isFile()){
				System.out.println(fileout.getAbsolutePath());
			}else{
				File[]  files=fileout.listFiles();
				if(files!=null){
					for (File fileone : files) {
						if(fileone.isFile()){
							if(fileone.getName().contains(type))
							System.out.println(fileone.getAbsolutePath());
						}else{
							queue.offer(fileone);
						}
					}
				}
			}
		}
		System.out.println("遍历查找完成");
	}
	/**
	 * 用递归遍历文件
	 * @param file
	 * @param type
	 */
	public static void findFile(File  file,String type){
		File[]  filelist=file.listFiles();
		if(filelist!=null){
			for (File fileone : filelist) {
				if(fileone.isFile()){
					if(fileone.getName().contains(type))
					System.out.println(fileone.getAbsolutePath());
				}else{
					findFile(fileone , type);
				}
			}
		}
	}
}
