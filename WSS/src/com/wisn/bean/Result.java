package com.wisn.bean;

public class Result {
	private String msg;
	private String reason;

	public Result() {
		super();
	}

	public Result(String msg, String reason) {
		super();
		this.msg = msg;
		this.reason = reason;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public String toString() {
		return "Result [msg=" + msg + ", reason=" + reason + "]";
	}

}
