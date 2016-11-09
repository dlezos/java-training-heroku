package com.accenture.training.domain;

public enum Prize {
	step0(0,0),
	step100(1,100),
	step200(2,200),
	step500(3,500),
	step1000(4,1000),
	step2000(5,2000),
	step5000(6,5000),
	step10000(7,10000),
	step20000(8,20000),
	step50000(9,50000),
	step200000(10,200000);
	private int step;
	private int value;
	
	public int getStep() {
		return step;
	}
	
	public int getValue(){
		return value;
	}

	private Prize(int step, int value) {
		this.step=step;
		this.value = value;
	}
	
	static public Prize getPrize(int step){
		for(Prize prize: Prize.values()){
			if(prize.step == step){
				return prize;
			}
		}
		return Prize.step0;
	}
}
