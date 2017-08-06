package com.wisn.core;

import java.util.Vector;

import com.wisn.utils.LogUtils;
/**
 * 
 * @author Wisn
 * 2016年9月30日   上午9:23:32
 *
 */
public class HandleThreadFactory {
	private Vector<MessageHandingThread> threadlist = null;
	public  static  int  currentThreadCount=Config.initMaxHandleThread / 2;
	private  static  HandleThreadFactory  handleThreadFactory=null;
	public static HandleThreadFactory getInstance() {
		if (handleThreadFactory == null) {
			synchronized (HandleThreadFactory.class) {
				if (handleThreadFactory == null) {
					handleThreadFactory = new HandleThreadFactory();
				}
				return handleThreadFactory;
			}
		}
		return handleThreadFactory;
	}
	
	public  HandleThreadFactory init() {
		if (threadlist == null) {
			synchronized (MessageQueue.class) {
				if (threadlist == null) {
					threadlist = new Vector<MessageHandingThread>();
				}
			}
		}
		return handleThreadFactory;
	}
	public  synchronized void startService() {
		for (int i = 0; i < Config.initMaxHandleThread / 2; i++) {
			MessageHandingThread thread = new MessageHandingThread();
			thread.start();
			threadlist.add(thread);
		}
	}
	
	public synchronized void addThread() {
		try{
			if (threadlist.size() < Config.initMaxHandleThread) {
				MessageHandingThread thread = new MessageHandingThread();
				thread.start();
				threadlist.add(thread);
				currentThreadCount++;
			}
		}catch(Exception  e){
			e.printStackTrace();
		}
	}

	public synchronized void removeThread() {
		try{
			if (threadlist.size() > Config.initMaxHandleThread / 2) {
				MessageHandingThread lastThread = threadlist.remove(threadlist
						.size() - 1);
				lastThread.isRuning = false;
				currentThreadCount--;
			}
		}catch(Exception  e){
			e.printStackTrace();
			LogUtils.e("removeThread:"+e.toString());
		}
		
	}
	
	public  synchronized  void removeAllThread(){
		
	}

}
