package com.wisn.core;
/**
 * 
 * @author Wisn
 * 2016年9月30日   上午9:23:54
 *
 */
public interface OnHandleMessageCallBack {
	void handMessageSuccess(OperationMessage message);
	void handMessageError(OperationMessage message);
	void handMessageStore(OperationMessage message);
}
