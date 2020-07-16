# Spring Boot Application Coding Challenge - ThinkHR

## Built With

* 	[Maven](https://maven.apache.org/) - Dependency Management
* 	[JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Java™ Platform, Standard Edition Development Kit
* 	[Spring Boot](https://spring.io/projects/spring-boot) - Framework to ease the bootstrapping and development of new Spring Applications
* 	[git](https://github.com/) - Free and Open-Source distributed version control system
	[logging] -Logback Spring. check logback-spring.xml under src/main/resources.
	[Java nio] For File Operations have used Java NIO package. The java.nio package was introduced in Java 1.4 and updated in Java 1.7 (NIO.2) with enhanced file operations and an ASynchronousSocketChannel. It provides:
	 With Java Nio package, file operations like reading and writing are much faster and efficient. Below is the detailed list of functionalities added in the nio package.

	1. Buffer – to read chunks of data at a time
	2. CharsetDecoder – for mapping raw bytes to/from readable characters
	3. Channel – for communicating with the outside world
	4. Selector – to enable multiplexing on a SelectableChannel and provide access to any Channels that are ready for I/O non-blocking mode – to read whatever is ready

## External Tools Used

* 	[Postman](https://www.getpostman.com/) - API Development Environment (Testing Docmentation)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.thinkhr.challenge.CodingChallengeApplication` class from your IDE.

* 	Download the zip or clone the Git repository.
* 	Unzip the zip file (if you downloaded one)
* 	Open Command Prompt and Change directory (cd) to folder containing pom.xml
* 	Open Eclipse
	* File -> Import -> Existing Maven Project -> Navigate to the folder where you unzipped the zip
	* Select the project
* 	Choose the Spring Boot Application file (search for @SpringBootApplication)
* 	Right Click on the file and Run as Java Application

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```
## Enhancements 

* Microservices Architecture

	1. Create a microservice which would act as an orchestrator. 
	2. Create another microservice which will be responsible to get a dynamic word from reading this file.
	3. For Future if we need to add any other functionality we can enhance the orchestrator to call multiple microservices and aggregate the response and serve to the client. 

* Caching 

    1. If the data in the file words_alpha.txt does not change between requests, a write back cache can be introduced. 
    2. For every line number we retrieve the value from the file and we store a key,value pair in the cache <LineNumber,Word>, every subsequent requests can be read from the cache.

### Actuator

To monitor and manage your application

|  URL |  Method |
|----------|--------------|
|`http://localhost:8080`| GET |
|`http://localhost:8080/actuator/`| GET |
|`http://localhost:8080/actuator/health`| GET |
|`http://localhost:8080/actuator/info`| GET |


### URLs

|  URL |  Method | Remarks |
|----------|--------------|--------------|
|`http://localhost:8080/`                           | GET | This will redirect call to http://localhost:8080/getRandomWord.|
|`http://localhost:8080/getRandomWord`              | GET | Retrieves a random word from the list of words in words_alpha.txt|


## Test and Coverage 

![Coverage](https://user-images.githubusercontent.com/8183342/87632830-06b17d00-c6ef-11ea-873f-824d4e064c54.jpg)


## Files and Directories

The project (a.k.a. project directory) has a particular directory structure. A representative project is shown below:

```text
.
├── Spring Elements
├── src
│   └── main
│       └── java
│           ├── com.thinkhr.challenge
│           ├── com.thinkhr.challenge.controller
│           ├── com.thinkhr.challenge.reader
│           ├── com.thinkhr.challenge.reader.impl
│           ├── com.thinkhr.challenge.service
│           ├── com.thinkhr.challenge.service.impl
│        
├── src
│   └── main
│       └── resources
│           └── application.properties
│           ├── logback-spring.xml
├           |── words_alpha.txt
│           ├── application.properties
│           ├── banner.txt
│
├── src
│   └── test
│       └── java
├	        |── com.thinkhr.challenge
│           ├── com.thinkhr.challenge.controller
│           ├── com.thinkhr.challenge.reader.impl
│           ├── com.thinkhr.challenge.service.impl
├── JRE System Library
├── Maven Dependencies
├── logs
│   └── application.log
├── src
├── target
│   └──application-0.0.1-SNAPSHOT
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

## packages

* 	`reader` — to hold our reader and reader implementations;
* 	`service` — to hold our business logic implementation;
* 	`controllers` — to listen to the client;
* 	`resources/` - Contains logback-spring.xml and words_alpha.txt file.
* 	`resources/application.properties` - It contains application-wide properties. Spring reads the properties defined in this file to configure your application. You can define server’s default port, server’s context path, database URLs etc, in this file.
* 	`test/` - contains unit and integration tests
* 	`pom.xml` - contains all the project dependencies
