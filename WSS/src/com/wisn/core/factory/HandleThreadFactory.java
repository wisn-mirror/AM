package com.wisn.core.factory;

import com.wisn.core.Config;
import com.wisn.core.Message;
import com.wisn.core.MessageHandingThread;
import com.wisn.core.OnHandleMessageCallBack;
import com.wisn.utils.LogUtils;

import java.util.Vector;
/**
 * 
 * @author Wisn
 * 2016年9月30日   上午9:23:32
 *
 */
public class HandleThreadFactory {
	private Vector<MessageHandingThread> threadlist = null;
	public  static  int  currentThreadCount= Config.initMaxHandleThread / 2;
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

	private HandleThreadFactory(){}

	public  HandleThreadFactory init() {
		if (threadlist == null) {
			synchronized (MessageQueueFactory.class) {
				if (threadlist == null) {
					threadlist = new Vector<>();
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
				thread.setOnHandleMessageCallBack(new OnHandleMessageCallBack() {
					@Override
					public void handMessageSuccess(Message message) {
						LogUtils.d("handMessageSuccess:"+message.toString());
					}

					@Override
					public void handMessageError(Message message) {
						LogUtils.d("handMessageError:"+message.toString());
					}

					@Override
					public void handMessageStore(Message message) {
						LogUtils.d("handMessageStore:"+message.toString());

					}
				});
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
