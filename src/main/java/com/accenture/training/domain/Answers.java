package com.accenture.training.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Answers implements Serializable, Cloneable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
		
	String answerA="";
	String answerB="";
	String answerC="";
	String answerD="";

	public Answers(){
	}
	
	public Answers(String answerA, String answerB, String answerC, String answerD){
		this.answerA = answerA;
		this.answerB = answerB;
		this.answerC = answerC;
		this.answerD = answerD;
	}
	
	public String getAnswerA() {
		return answerA;
	}

	public void setAnswerA(String answerA) {
		this.answerA = answerA;
	}
	
	public String getAnswerB() {
		return answerB;
	}

	public void setAnswerB(String answerB) {
		this.answerB = answerB;
	}
	public String getAnswerC() {
		return answerC;
	}

	public void setAnswerC(String answerC) {
		this.answerC = answerC;
	}
	public String getAnswerD() {
		return answerD;
	}

	public void setAnswerD(String answerD) {
		this.answerD = answerD;
	}

	@Override
	public String toString() {
		return "Answers [answerA=" + answerA + ", answerB=" + answerB + ",n answerC=" + answerC + ", answerD=" + answerD
				+ "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public Object clone(){
		return new Answers(answerA, answerB, answerC, answerD);
	}
}

