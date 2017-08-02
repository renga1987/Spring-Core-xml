package com.luv2code.springdemo;

public class BaseballCoach implements Coach{
	
	//private field for dependency.
	private FortuneService fortuneService;
	
	public BaseballCoach(){
		System.out.println("BaseballCoach: inside no-arg cons");
	}
	//constructor dependency injection.
	public BaseballCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout(){
		return "Spend 30 mins in batting practice";
	}

	@Override
	public String getDailyFortune() {
	 // use a fortune service to get fortune
		return "BaseBall"+fortuneService.getFortune();
	}

}
