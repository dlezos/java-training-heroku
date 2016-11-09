package com.accenture.training.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.accenture.training.domain.Question;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
	
    @OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	Player player;
	Prize prize;


	int currentQuestion;
	Assists assists;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	List<Question> questions = null;
	//Question[] questionsArray = new Question[10];
	
	public Game(){
		
	}
	public Game(Player player, List<Question> questions){
		this.player = player;
		this.questions = new ArrayList<Question>(10);
		this.questions.addAll(questions);
		this.prize = prize.step0;
		this.currentQuestion = 0;
	}
	
	public void addQuestions(List<Question> newQuestions){
		if(questions == null){
			questions = new ArrayList<Question>(10);
		}
		questions.clear();
		questions.addAll(newQuestions);
	}
	
	public void appendQuestion(Question question){
		questions.add(question);
	}
	
	public Question getCurrentQuestion(){
		return questions.get(currentQuestion);
	}
	
	public void generateQuestions(){
	}

	public void printAllQuestions(){
		for(int i=0; i<questions.size(); i++){
			System.out.println(questions.get(i).getQuestion());
		}
		for(Question q: questions){
			System.out.println(q.getQuestion());
		}
		Iterator<Question> iter = questions.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next().getQuestion());
		}
	}
	
	public void correctAnswer(){
		if(currentQuestion >= 9){
			this.prize = Prize.step200000;
			throw new RuntimeException("You won!");
		}
		this.currentQuestion++;
		this.prize = Prize.getPrize(prize.getStep()+1);
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public Prize getPrize() {
		return prize;
	}
	public void setPrize(Prize prize) {
		this.prize = prize;
	}
	public Assists getAssists() {
		return assists;
	}
	public void setAssists(Assists assists) {
		this.assists = assists;
	}
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	public void setCurrentQuestion(int currentQuestion) {
		this.currentQuestion = currentQuestion;
	}
	
}
