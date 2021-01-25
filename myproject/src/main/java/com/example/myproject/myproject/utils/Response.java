package com.example.myproject.myproject.utils;

import java.util.List;

import com.example.myproject.myproject.domain.Data;

public class Response {
	boolean status;
	String msg;
	List<Data> data;
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<Data> getData() {
		return data;
	}
	public void setData(List<Data> data) {
		this.data = data;
	}
	
}
