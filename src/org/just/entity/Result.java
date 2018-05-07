package org.just.entity;

import java.io.Serializable;

public class Result implements Serializable{
	
	/**
	 * 这是一个用于数据库查询数据后使用的实体类 以string:int格式获取
	 */
	private static final long serialVersionUID = 1L;
	private String thekey;
	private int value;
	public String getThekey() {
		return thekey;
	}
	public void setThekey(String thekey) {
		this.thekey = thekey;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}


}
