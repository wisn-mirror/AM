package com.wisn.backup;

import com.wisn.core.MessageQueueFactory;
import com.wisn.test.testSession;
import com.wisn.utils.LogUtils;

import javax.websocket.Session;
import java.util.LinkedList;
 


public class SessionFactoryBackup {
	private LinkedList<PackSession> sessionQueue = null;
	private static SessionFactoryBackup sessionFactory = null;

	public static SessionFactoryBackup getInstance() {
		if (sessionFactory == null) {
			synchronized (SessionFactoryBackup.class) {
				if (sessionFactory == null) {
					sessionFactory = new SessionFactoryBackup();
				}
				return sessionFactory;
			}
		}
		return sessionFactory;
	}

	public  SessionFactoryBackup init() {
		if (sessionQueue == null) {
			synchronized (MessageQueueFactory.class) {
				if (sessionQueue == null) {
					sessionQueue = new LinkedList<PackSession>();
					return this;
				}
			}
		}
		return this;
	}

	/**
	 * getUser
	 * @param id
	 * @return
	 */
	public  Session  getSession(long  id){
	//	return sessionQueue.get(id);
		return dichotomySearch(id);
	}
	/**
	 * removeUser
	 * @param id
	 * @return
	 */
	public boolean  removeSession(long  id){
		 return sessionQueue.remove(getSession(id));
	}
	/**
	 * addSession
	 * @param id
	 * @param session
	 * @return
	 */
	public boolean   addSession(long  id,Session session){
		 return  sessionQueue.add(new PackSession(id, session));
		
	}
	public  static  int count =0;
	public static void main(String[] args) {
		LogUtils.d("时间："+System.currentTimeMillis());
		SessionFactoryBackup init = SessionFactoryBackup.getInstance().init();
		long  currentID=0;
		for(int i=0;i<10000000;i++){
			long  id=System.currentTimeMillis();
			init.addSession(id, new  testSession());
			if(i==9999999){
				currentID=id;
			}
		}
		LogUtils.d("时间："+System.currentTimeMillis());
		Session dichotomySearch = init.dichotomySearch(currentID);
		LogUtils.d("时间："+System.currentTimeMillis()+ "  "+dichotomySearch);
	}
	
	public   Session dichotomySearch(long  id){
		int  head=0;
		int  last=sessionQueue.size();
		int  middle=(head+last)/2;
		if(sessionQueue.get(last-1).getSessionId()<id|sessionQueue.get(head).getSessionId()>id){
			LogUtils.d("查找的数超出范围");
			return  null;
		}
		while(last>head){
			count++;
			PackSession packSession = sessionQueue.get(middle);
			long sessionId = packSession.getSessionId();
			if(id==sessionId)
				return packSession.getSession();
			middle=(head+last)/2;
			if(sessionId>id){
				last=(head+last)/2;
			}else{
				head=(head+last)/2;
			}
		}
		return null;
	}

	
}
