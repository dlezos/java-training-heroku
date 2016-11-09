package com.accenture.training.domain;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Player {

	@Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
	protected String firstName = null;
	protected String lastName = null;
	protected Integer score;
	
	public Player(){
		
	}
	
	public Player(String firstName, String lastName){
		this.firstName = new String(firstName);
		this.lastName = new String(lastName);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}