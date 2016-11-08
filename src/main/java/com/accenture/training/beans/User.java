package com.accenture.training.beans;

public class User {
	public User(){
		System.out.println("Creating User");
	}
	private String name;

	public String getName() {
		System.out.println("GetName:"+name);
		return name;
	}

	public void setName(String name) {
		System.out.println("SetName:"+name);
		this.name = new String(name);
	}
	
}
