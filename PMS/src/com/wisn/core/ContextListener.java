package com.wisn.core;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.PropertyConfigurator;

import com.wisn.utils.LogUtils;

/**
 * 
 * @author Wisn
 * 2016年9月30日   上午9:23:26
 *
 */
public class ContextListener implements   ServletContextListener{
	 
	@Override
	public void contextInitialized(final ServletContextEvent sc) {
		String file =sc.getServletContext().getRealPath("/WEB-INF/config_user/log4j.properties");
		  if(file != null){
		     PropertyConfigurator.configure(file);
		  }
		  LogUtils.initConfig();
		LogUtils.d("Start  Message  Server!");
		new  Config().intConfig(sc.getServletContext());
		HandleThreadFactory.getInstance().init().startService();
		//初始化数据，加载所有的id到IDS中
		//sc.getServletContext().setAttribute("online", 0);
		Timer  timer=new Timer();
		timer.schedule(new TimerTask(){
			@Override
			public void run() {
				if (MessageQueue.getInstance().init().MessageCount > Config.initEveryThreadMessage) {
					HandleThreadFactory.getInstance().init().addThread();
				} else {
					if (HandleThreadFactory.getInstance().init().currentThreadCount > Config.initHalfHandleThread) {
						HandleThreadFactory.getInstance().init().removeThread();
					}
				}
				LogUtils.d("Thread check ");
			}
			
		}, new Date(),20);
	}
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		LogUtils.d("Stop  Message  Server!");
		//TODO  存储所有消息列队中的消息
		HandleThreadFactory.getInstance().init().removeAllThread();
	}
}
