Spring:
 -> Framework to build Java Applications.
 -> alternative to J2ee.
 -> Ligtweight
 -> Provides large number of helper classes.
 
 Goals of Spring:
 ----------------
 
 promotes loose coupling by Dependency Injection.
 Removes Boilerplate code -> Provides more helper classes
 Declarative programming with AOP.
 Lightweight Development with Java POJOS.
 
 Core Container: For creating beans and making it available.
 AOP, Aspects -> Add functionality to your objects Declaratively.
 Data Access/Integration -> To communicate with the DB. JDBC, ORM JMS etc..
 Web -> Spring MVC for Building Web applications.
 Test -> Supports TDD. Mock Objects etc..
 
 Ioc:
  Process of Externalizing the construction and management of objects.
 
 Spring Container:
 ------------------

Primary functions:
  Create and manage Objects (Inversion of control)
  Inject object dependencies (Dependency Injection)

Configuring Spring Container:
------------------------------

1) XML
2) Java Annotations
3) Java Source Code.

Spring Development process:

1) Configure Spring beans.
2) Create Spring container. - Generally known as Application Context.
3) Retrieve Beans from Spring container.

Dependency Injection:
---------------------
Process of outsourcing the constrction and injection of objects to a external entity.

Constructor Injection : 
<constructor-arg ref="refBean"/>  

Setter Injection: 
1)Calls the no arg constructor before calling the setter method.
2)<property name="fortuneService" ref="myFortune" />
 <!-- inject lierals -->
<property name="emailAddress" value="renga.venkat@gmail.com" />

Loading properties from properties file:
-----------------------------------------
Create the property file and load like the below.
<context:property-placeholder location="classpath:sport.properties"/>
Syntax: ${propertyName}
<property name="emailAddress" value="${foo.email}" />

Bean scope :
------------
Refers to the life cycle of a bean.

Singleton:
1) Default scope of a bean.
2) Spring container creates only one instance of a bean.
3) Creates one bean instances and shares it with all bean req.

Prototype: new object for each bean.

Bean Life cycle:
------------------

container starts -> Beans are instanited -> Dependencies injected -> Some Internal Spring processing -> Our own custom init method
-> beans are ready for use -> custom destroy method.

We can add custom logic during bean intialization and bean destruction.

init-method="method name" (Public void method)
destroy-method="method name" (Public Void method)

When you are defining init and destroy methods should follow these rules:

1)The methods should be public void
2)The methods should be no-arg, meaning they shouldn't accept any method arguments.

Spring Configuration with Annotations:
--------------------------------------------

Annotations : provides meta-data about the class.

Spring will scan Java Classes for Special Annotations.
Automatically Register the beans in the spring container.

Default bean id: Make the classname with first letter in lower case. That makes a default bean.

Spring Auto Wiring:
-----------------------
For DI spring can use Auto wiring.
Spring will look for a class that matches the property. matches by type : class or interface.
Spring will inject automatically. 

AutoWiring injection types:
----------------------------

Constructor Inject: 

Spring will scan if FortuneService is implemented by any class. If so it injects.

The implementing class should be a bean and hence should be annotated with @component scan.

	@Autowired
	public TennisCoach(FortuneService theFortuneService){
		fortuneService=theFortuneService;
	}

Setter Inject:

    @Autowired 
	public void setHappyFortuneService(FortuneService theFortuneService) {
		this.fortuneService = theFortuneService;
	}


Method injection:

Any method annotated with @AutoWired.

    @Autowired
	public void doSomeStuff(FortuneService theFortuneService) {
		System.out.println("Inside doSomeStuff");
		this.fortuneService = theFortuneService;
	}
	
Field injection:

	@Autowired
	private FortuneService fortuneService;

Injection is done internally by java reflections.


Which of the above to use? 

Ans: Anything. All provide same functionality. Choose one and be consistent on that.


@Qualifier:
-----------

In the case if the interface that is injected is implemented by more than one bean which bean will spring choose?

For that @Qualifier annotation is used. 

@Autowired
@Qualifier("databaseFortuneService")
private FortuneService fortuneService;

Tips:
-------

Annotations - Default Bean Names ... and the Special Case

In general, when using Annotations, for the default bean name, Spring uses the following rule.

If the annotation's value doesn't indicate a bean name, an appropriate name will be built based on the short name of the class (with the first letter lower-cased).

For example:

HappyFortuneService --> happyFortuneService

---

However, for the special case of when BOTH the first and second characters of the class name are upper case, then the name is NOT converted.

For the case of RESTFortuneService

RESTFortuneService --> RESTFortuneService

No conversion since the first two characters are upper case.

Behind the scenes, Spring uses the Java Beans Introspector to generate the default bean name.

@Qualifier with Constructors:
----------------------------------

You have to place the @Qualifier annotation inside of the constructor arguments. 

@Autowired
public TennisCoach(@Qualifier("randomFortuneService") FortuneService theFortuneService) {
    System.out.println(">> TennisCoach: inside constructor using @autowired and @qualifier");        
    fortuneService = theFortuneService;
}

@PreDestroy and @PostConstruct -> Annotations for life cycle bean methods.

3) Spring With Java Configuration:
-------------------------------------
@Configuration -> At class level.
@ComponentScan -> to scan annotations. Similar to above sterotype annotations.

@Bean -> 
To Define a bean. Here no component Scan.
The method name will act as the beanID.
