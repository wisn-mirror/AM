package com.wisn.core;

import com.wisn.bean.CacheUser;
import com.wisn.bean.SessionClient;

import java.util.LinkedHashMap;


/***
 * 
 * @author Wisn
 * 2016年9月30日   上午9:24:05
 *
 */
public class SessionFactory {
	private LinkedHashMap<Long, CacheUser> sessionQueue = null;
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
			synchronized (MessageQueueFactory.class) {
				if (sessionQueue == null) {
					sessionQueue = new LinkedHashMap<>();
					return this;
				}
			}
		}
		return this;
	}

	public LinkedHashMap<Long, CacheUser> getSessionQueue() {
		return sessionQueue;
	}


	/**
	 * getUser
	 * @param id
	 * @return
	 */
	public CacheUser getUser(long  id){
		return sessionQueue.get(id);
	}

	/**
	 * removeUser
	 * @param id
	 * @return
	 */
	public CacheUser removeUser(long  id){
		 return sessionQueue.remove(id) ;
	}

	/**
	 *
	 * @param id
	 * @param cacheUser
	 * @return
	 */
	public CacheUser addUser(long id, CacheUser cacheUser){
		sessionQueue.put(id, cacheUser);
		return cacheUser;
	}

	/**
	 * addSession
	 * @param id
	 * @param session
	 * @return
	 */
	public CacheUser addSession(long  id, SessionClient session){
		CacheUser session1 = getUser(id);
		if(!session1.sessionClientList.contains(session)){
			session1.sessionClientList.add(session);
		}
		return  session1;
	}
	public static void main(String[] args) {
		/*LogUtils.d("时间："+System.currentTimeMillis());
		SessionFactory init = SessionFactory.getInstance().init();
		long  currentID=0;
		for(int i=0;i<100000000;i++){
			long  id=System.currentTimeMillis();
//			init.addSession(id, new  testSession());
			if(i==9){
				currentID=id;
			}
		}
		LogUtils.d("时间："+System.currentTimeMillis());
		SessionClient dichotomySearch = init.getUser(currentID);
		LogUtils.d("时间："+System.currentTimeMillis()+ "  "+dichotomySearch);*/
	}

}
