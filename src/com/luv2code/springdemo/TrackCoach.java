package com.luv2code.springdemo;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;

	public TrackCoach(){
		System.out.println("TrackCoach: inside no-arg cons");

	}
	public TrackCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout(){
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		return "Track"+fortuneService.getFortune();
	}
	
	//add an init Method	
	public void doMyStartupStuff(){
		System.out.println("Track Coach : inside method doMyStartupStuff");
	}

	//add a destroy Method	
	public void doMyCleanupStuff(){
		System.out.println("Track Coach : inside method doMyCleanupStuff");
	}
}
