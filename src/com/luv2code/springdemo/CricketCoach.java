package com.luv2code.springdemo;

public class CricketCoach implements Coach {

	private FortuneService fortuneService;	
	private String emailAddress;
	private String team;
	
	//create no-arg constructor
	public CricketCoach(){
		System.out.println("CricketCoach: inside no-arg cons");
	}
	
	//setter
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: inside setter method setFortuneService");
		this.fortuneService = fortuneService;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("CricketCoach: inside setter method setEmailAddress");
		this.emailAddress = emailAddress;
	}

	public void setTeam(String team) {
		System.out.println("CricketCoach: inside setter method setTeam");
		this.team = team;
	}

	@Override
	public String getDailyWorkout() {
		return "Practise fast bowl for 15 mins";
	}

	@Override
	public String getDailyFortune() {
		return "Cricket :"+fortuneService.getFortune();
	}

}
