package com.wisn.core;
/**
 * 
 * @author Wisn
 * 2016年9月30日   上午9:23:54
 *
 */
public interface OnHandleMessageCallBack {
	public  void handMessageSuccess(OperationMessage message);
	public  void handMessageError(OperationMessage message);
	public  void handMessageStore(OperationMessage message);
}
