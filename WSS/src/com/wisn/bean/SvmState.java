package com.wisn.bean;

import java.util.List;

/**
 * <b>Create Date:</b> 2016/10/25<br>
 * <b>Author:</b> Wisn(吴贻顺)<br>
 * <b>Description:</b>
 * <p>
 * <br>
 */

public class SvmState {
	public String device_id;
	public String faultCode;
	public List<Integer> temperature;
	public String lightState;
	public boolean isDoorOpen;
	public boolean isLeakChange_5jiao;
	public boolean isLeakChange_1yuan;
	public boolean isSaleStop;
	public double latitude;
	public double longitude;

	public SvmState() {
	}

	public SvmState(String device_id, String faultCode,
			List<Integer> temperature, String lightState, boolean isDoorOpen,
			boolean isLeakChange_5jiao, boolean isLeakChange_1yuan,
			boolean isSaleStop, double latitude, double longitude) {
		super();
		this.device_id = device_id;
		this.faultCode = faultCode;
		this.temperature = temperature;
		this.lightState = lightState;
		this.isDoorOpen = isDoorOpen;
		this.isLeakChange_5jiao = isLeakChange_5jiao;
		this.isLeakChange_1yuan = isLeakChange_1yuan;
		this.isSaleStop = isSaleStop;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getDevice_id() {
		return device_id;
	}

	public void setDevice_id(String device_id) {
		this.device_id = device_id;
	}

	public String getFaultCode() {
		return faultCode;
	}

	public void setFaultCode(String faultCode) {
		this.faultCode = faultCode;
	}

	public List<Integer> getTemperature() {
		return temperature;
	}

	public void setTemperature(List<Integer> temperature) {
		this.temperature = temperature;
	}

	public String getLightState() {
		return lightState;
	}

	public void setLightState(String lightState) {
		this.lightState = lightState;
	}

	public boolean isDoorOpen() {
		return isDoorOpen;
	}

	public void setDoorOpen(boolean isDoorOpen) {
		this.isDoorOpen = isDoorOpen;
	}

	public boolean isLeakChange_5jiao() {
		return isLeakChange_5jiao;
	}

	public void setLeakChange_5jiao(boolean isLeakChange_5jiao) {
		this.isLeakChange_5jiao = isLeakChange_5jiao;
	}

	public boolean isLeakChange_1yuan() {
		return isLeakChange_1yuan;
	}

	public void setLeakChange_1yuan(boolean isLeakChange_1yuan) {
		this.isLeakChange_1yuan = isLeakChange_1yuan;
	}

	public boolean isSaleStop() {
		return isSaleStop;
	}

	public void setSaleStop(boolean isSaleStop) {
		this.isSaleStop = isSaleStop;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	


}
