package com.wisn.service;

import java.util.Vector;

import com.wisn.core.Message;

/**
 * 
 * @author Wisn
 * 2016年9月30日   上午11:11:46
 *
 */
public interface  OperationMessageService {
	/**
	 * 保存单个消息
	 * @param operationMessage
	 * @return
	 */
	boolean saveOperationOne(Message operationMessage);
	/**
	 * 保存消息列队中的消息
	 * @param allList
	 * @return
	 */
	boolean saveAllOperationMessage(Vector<Message> allList);
	/**
	 * 读取本地保存的历史未执行的消息
	 * @param OperationCode
	 * @return
	 */
	Vector<Message>  getAllOperationMessageFromLocal(int OperationCode);
}
