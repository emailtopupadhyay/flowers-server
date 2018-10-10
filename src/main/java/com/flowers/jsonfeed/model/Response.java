package com.flowers.jsonfeed.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Response {
	
	
	private int numberOfuniqueUserid;
	private List<JSONDataResponse> data;
	public int getNumberOfuniqueUserid() {
		return numberOfuniqueUserid;
	}
	public void setNumberOfuniqueUserid(int numberOfuniqueUserid) {
		this.numberOfuniqueUserid = numberOfuniqueUserid;
	}
	public List<JSONDataResponse> getData() {
		return data;
	}
	public void setData(List<JSONDataResponse> data) {
		this.data = data;
	}
	
	
}
