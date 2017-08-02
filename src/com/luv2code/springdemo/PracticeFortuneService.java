package com.luv2code.springdemo;

public class PracticeFortuneService implements FortuneService {

	private String fortune[]={"Fortune1","Fortune2","Fortune3"};
	@Override
	public String getFortune() {
		return fortune[1];
	}

}
