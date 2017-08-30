package com.wisn.pic.servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/**
 * 树形遍历 文件下载
 * @author wisn
 * @time 2015年12月1日下午8:13:08
 *
 */
@WebServlet("/look")
public class picDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public picDownload() {
        super();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	String filepath=request.getParameter("filename");
    	System.out.println("path："+filepath);
//    	filepath=new String(filepath.getBytes("ISO-8859-1"),"UTF-8");
//    	System.out.println("没有转码之后："+filepath);
//    	System.out.println(request.getLocalAddr()+"下载: "+filepath);
//    	//得到文件的类型
//    	String type=getServletContext().getMimeType(filepath);
//    	response.setContentType(type);
//    	int idx=filepath.lastIndexOf("\\");
//    	String filename=filepath.substring(idx+1);
//    	/*判断浏览器的类型
//    	IE  ：URLEncode编码  FireFox：Base64
//    	*/
//    	String agent =request.getHeader("User-Agent");
//    	System.out.println("浏览器类型："+agent);
//    	if(agent.contains("Firefox")){
//    		//火狐的
//    		filename="=?UTF-8?B?"
//					+ new String(Base64.encode(filename
//					.getBytes("UTF-8"))) + "?=";
////    		filename=filename.replace(" ", "");
//    		System.out.println("firefox");
//    	}else{
//    		System.out.println("其他的浏览器");
//    		filename=URLEncoder.encode(filename,"UTF-8");
//    		filename=filename.replace("+", " ");
//    	}
    	//设置第二个头
		
    //	response.setHeader("Content-Disposition", "attachment;filename="+filename );	
		//获取文件输入流
//		String  path=getServletContext().getRealPath("/download");
//		File file=new File(filepath);
		InputStream is=new FileInputStream(filepath);
		//设置文件的大小，支持迅雷
	//	response.setContentLength(is.available());
		OutputStream os=response.getOutputStream();
		int len=0;
		byte[] b=new byte[3145728]; //1024*1025*3
		while((len=is.read(b))!=-1){
			os.write(b,0,len);
		}
//		byte[] b=new byte[is.available()]; 
//		os.write(is.read(b));
		is.close();
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
//	public static String base64EncodeFileName(String fileName) {
//		BASE64EncoderStream base64Encoder = new BASE64Encoder();
//		try {
//			return "=?UTF-8?B?"
//					+ new String(base64Encoder.encode(fileName
//							.getBytes("UTF-8"))) + "?=";
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//			throw new RuntimeException(e);
//		}
//	}

}
