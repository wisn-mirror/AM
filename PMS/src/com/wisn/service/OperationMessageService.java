package com.wisn.service;

import java.util.Vector;

import com.wisn.core.OperationMessage;

public interface  OperationMessageService {
	/**
	 * 保存单个消息
	 * @param operationMessage
	 * @return
	 */
	boolean saveOperationOne(OperationMessage  operationMessage);
	/**
	 * 保存消息列队中的消息
	 * @param allList
	 * @return
	 */
	boolean saveAllOperationMessage(Vector<OperationMessage>  allList);
	/**
	 * 读取本地保存的历史未执行的消息
	 * @param OperationCode
	 * @return
	 */
	Vector<OperationMessage>  getAllOperationMessageFromLocal(int  OperationCode);
}
