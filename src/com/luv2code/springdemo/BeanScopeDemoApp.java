package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("beanscope-applicationContext.xml");
		
		Coach coach = context.getBean("trackCoach", Coach.class);
		
		Coach coach1 = context.getBean("trackCoach", Coach.class);
		
		boolean result = (coach == coach1);
		
		System.out.println("Pointing to same object:"+result);
		
		System.out.println("Memory location for coach:"+coach);

		System.out.println("Memory location for coach1:"+coach1);

		context.close();
	}

}
