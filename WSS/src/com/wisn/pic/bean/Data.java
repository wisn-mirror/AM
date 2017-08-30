package com.wisn.pic.bean;

import java.io.Serializable;
import java.util.List;

public class Data  implements  Serializable {
	private   Integer result;
	private List<Picture> data;
	 
	public Integer getResult() {
		return result;
	}
	public void setResult(Integer result) {
		this.result = result;
	}
	public List<Picture> getData() {
		return data;
	}
	public void setData(List<Picture> data) {
		this.data = data;
	}

}
