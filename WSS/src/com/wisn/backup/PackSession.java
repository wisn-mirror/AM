package com.wisn.backup;

import javax.websocket.Session;
public class PackSession {
	private long  sessionId;
	private Session  session;
	
	public PackSession(long sessionId, Session session) {
		super();
		this.sessionId = sessionId;
		this.session = session;
	}
	public long getSessionId() {
		return sessionId;
	}
	public void setSessionId(long sessionId) {
		this.sessionId = sessionId;
	}
	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
	
	

}
