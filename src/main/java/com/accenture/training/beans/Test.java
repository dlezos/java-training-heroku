package com.accenture.training.beans;

import javax.ejb.Stateless;

@Stateless(name="TestBean")
public class Test {
	public String getQuestion(){
		return "TestBean Question";
	}
}
