package com.wisn.bean;

public class TestResult {
    public int code;
    public String msg;
    public ResultTest data;

    public TestResult() {
    }

    public TestResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public TestResult(int code, String msg, ResultTest data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultTest getData() {
        return data;
    }

    public void setData(ResultTest data) {
        this.data = data;
    }
}
