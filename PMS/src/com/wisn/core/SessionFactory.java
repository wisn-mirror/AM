package com.wisn.core;
import java.util.LinkedHashMap;

import javax.websocket.Session;

import com.wisn.test.testSession;
import com.wisn.utils.LogUtils;


/***
 * 
 * @author Wisn
 * 2016年9月30日   上午9:24:05
 *
 */
public class SessionFactory {
	private LinkedHashMap<Long, Session> sessionQueue = null;
	private static SessionFactory sessionFactory = null;

	public static SessionFactory getInstance() {
		if (sessionFactory == null) {
			synchronized (SessionFactory.class) {
				if (sessionFactory == null) {
					sessionFactory = new SessionFactory();
				}
				return sessionFactory;
			}
		}
		return sessionFactory;
	}

	public  SessionFactory init() {
		if (sessionQueue == null) {
			synchronized (MessageQueue.class) {
				if (sessionQueue == null) {
					sessionQueue = new LinkedHashMap<Long, Session>();
					return this;
				}
			}
		}
		return this;
	}

	/**
	 * getSession
	 * @param id
	 * @return
	 */
	public  Session  getSession(long  id){
		return sessionQueue.get(id);
	}
	/**
	 * removeSession
	 * @param id
	 * @return
	 */
	public Session  removeSession(long  id){
		 return sessionQueue.remove(id) ;
	}
	/**
	 * addSession
	 * @param id
	 * @param session
	 * @return
	 */
	public Session  addSession(long  id,Session session){
		return  sessionQueue.put(id, session);
		
	}
	public static void main(String[] args) {
		LogUtils.e("时间："+System.currentTimeMillis());
		SessionFactory init = SessionFactory.getInstance().init();
		long  currentID=0;
		for(int i=0;i<100000000;i++){
			long  id=System.currentTimeMillis();
			init.addSession(id, new  testSession());
			if(i==9){
				currentID=id;
			}
		}
		LogUtils.e("时间："+System.currentTimeMillis());
		Session dichotomySearch = init.getSession(currentID);
		LogUtils.e("时间："+System.currentTimeMillis()+ "  "+dichotomySearch);
	}

}
