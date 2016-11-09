package com.accenture.training.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.accenture.training.domain.Answers;
import com.accenture.training.domain.Difficulty;

@Entity
public class Question implements Serializable, Cloneable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Answers answers;
	private Difficulty difficulty;
	private String question;
	private Integer correctAnswer;
	
	public Question(){
		
	}
	
	public int getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(Integer correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public Difficulty getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}

	public Question(String question, Answers answers, Difficulty difficulty, Integer correctAnswer) {
		this.question = question;
		this.answers = answers;
		this.difficulty = difficulty;
		this.correctAnswer = correctAnswer;
	}

	public String getQuestion() {
		return question;
	}

	public Answers getAnswers() {
		return answers;
	}

	public boolean isAnswerCorrect(Integer answer) {
		// TODO Auto-generated method stub
		return correctAnswer == answer;
	}
	@Override
	public String toString() {
//		return "Question [answers=" + answers + ", difficulty=" + difficulty + ", question=" + question
//				+ ", correctAnswer=" + correctAnswer + "]";
		return "Question: " + question + "\nAnswers:" + answers;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setAnswers(Answers answers) {
		this.answers = answers;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	
	public Object clone(){
		Question result = new Question();
		result.setAnswers((Answers)this.getAnswers().clone());
		result.setCorrectAnswer(this.getCorrectAnswer());
		result.setDifficulty(this.getDifficulty());
		result.setQuestion(this.getQuestion());
		return result;
	}
}
