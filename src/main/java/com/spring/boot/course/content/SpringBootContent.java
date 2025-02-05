package com.spring.boot.course.content;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class SpringBootContent {

    // What is Spring Boot ?
    /*
     --> Spring Boot is a framework for building applications in java programming language.

     --> Spring Boot makes easy to create stand-alone, production-grade spring based
         Applications that you can just run.

    */

    // Why Spring Boot ?
    /*
    --> The core Spring framework already reduces boilerplate code and provides a lot of
        helpful features for java applications.

    --> However, Spring Boot take this convenience to the next level by focussing specifically
        on reducing the effort required to set up and configure a Spring application.

    --> While Spring does simplify many tasks like
        1. creating web applications
        2. working with databases
        3. managing transactions and more.

    --> But setting up a Spring project can still involve quite a bit of manual configuration.
    --> This is where Spring Boot steps in.
        1. Auto-Configuration
        2. Standalone Applications

    */

    // Most Relayed

   /*
   // without Spring Boot, setting up a basic RESTFULL API requires manual configuration.

   //This is Controller class

    @RestController
    @RequestMapping("/api")
    public class MyController{

        @GetMapping("/hello")
        public String sayHello(){
            return "Hello World from Spring!";
        }
    }

    // Application Main

    public class SpringApplication {
        public static void main(String[] args) {
            ApplicationContext context = new AnnotationConfigApplicationContext(MyController.class);
        }
    }

    */
    // we need to manually set up the Spring application context in the main method.


    /*
        With Spring Boot, the setup process is greatly simplified.

    @RestController
    @SpringBootApplication
    public class SpringBootApplicationExample{

        @GetMapping("/api/hello")
        public String sayHello(){
            return "Hello from Spring Boot!";
        }

        public static void main(String[] args) {
            SpringApplication.run(SpringBootApplicationExample.class, args);
        }
    }

    */

    /*
     We use @SpringBootApplication annotation on the main class. THis is single
     annotation replaces the need for setting up a manual spring application context.

     we no longer need to explicitly create an application context using
     AnnotationConfigApplicationContext as spring boot handles the behind the scenes.

     We use SpringApplication.run() to start the application, and Spring Boot takes
     care of configuring the embedded web server and other necessary components.

     The @SpringBootApplication annotation alone brings a lot of pre-configuring
     features, including automatic component scanning and embedded server configuration,
     Which would have required more steps in traditional Spring setup.

     */

    // Maven pom.xml
    /*
    Build Lifecycle Basics

     Maven is based around the central concept of a build lifecycle.
     What this means is that the process for building and distributing a particular
     artifact (project) is clearly defined.

     For the person building a project, this means that it is only necessary to
     learn a small set of commands to build any Maven project, and the POM will
     ensure they get the results they desired

     There are three built-in build lifecycles: default, clean and site. The default
     lifecycle handles your project deployment, the clean lifecycle handles project
     cleaning, while the site lifecycle handles the creation of your project's website.

    A Build Lifecycle is Made Up of Phases

    validate - validate the project is correct and all necessary information is
               available

    compile - compile the source code of the project

    test - test the compiled source code using a suitable unit testing framework.
           These tests should not require the code be packaged or deployed.

    package - take the compiled code and package it in its distributable format,
              such as a JAR.

    verify - run any checks on results of integration tests to ensure quality criteria
             are met

    install - install the package into the local repository, for use as a dependency in
              other projects locally

    deploy - done in the build environment, copies the final package to the remote
             repository for sharing with other developers and projects.

    for more: https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html

    The related libraries and dependencies all are in Project Object Model (pom.xml) file.
    External and internal libraries managed by pom.xml

    */

    // @SpringBootApplication Internal Working
    /*
    we will understand the @SpringBootApplication Internal Working flow, but before you
    must have knowledge on below concepts. you will get the clear picture on Spring Boot.

    1. IOC: (Inversion Of Control): / ApplicationContext
            IOC stands for Inversion of Control.

           ==> IOC Container takes the responsibility for creation of object for classes
               which is present in implementation or inside the project package which is
               available under @SpringBootApplication.

           ==> Internally working ApplicationContext inside the Spring module on top of that
               Spring Boot implemented IOC on top of ApplicationContext.
               Internally IOC achieving ApplicationContext.

    2. ComponentScan:
           ==> ComponentScan responsibility to scan all the classes in project from
               available to the @SpringBootApplication package / directory

           ==> After scanning all classes to hand over to IOC / ApplicationContext

           ==> By default all classes are automatically registered as a Spring Bean.

           ==> If you want to create object manually inside the project which is performed
               outside the data you need to mention like @Bean

           ==> @Bean nothing but object for a class. which is scanned by ComponentScan
               the mandatory is you must config your own and mention the Component
               annotation on top of the class which is available for @SpringBootApplication package.

           ==> Inside the SpringBootApplication directory only ComponentScan can be scanned
               why because the ComponentScan has permission limit from @SpringBootApplication.

    3. Dependency Injection:
           ==> when ever we want to use the object to perform the functionality related to
               the data or object. we must need an object creation but the objects are created
               by IOC.
           ==> Then the dependency injection comes to where to use when to use. the memory of
               object as well as usage of object will be handled by DI copy of object.
           ==> using field level, construction level and method level.

    4. SpringBootApplication
           ==> This is the Execution point to the Spring Boot project with the help of
               @SpringBootApplication annotation.
           ==> This Annotation contains three main functional annotations. they are:
               1. @ComponentScan:
                    Scan the classes inside the project respective SpringBootApplication
                    base package respectively otherwise the outside the package does not
                    scan due to @SpringBootApplication limit permit to @ComponentScan.
               2. @EnableAutoConfiguration:
                    It automatically configured itself using properties files or yml files.
                    e.g: database configurations, port numbers, aws usage, third party
                    credentials etc.
               3. @Configuration:
                    It will create Beans inside the project limits will be same.

    */

    /*
    RestController: Special type of components which is http or https request reach
                     to the @RestController class called (front controller)
    Methods inside a controller class should be public sa that can be accessed and invoked
    by the spring framework or external http request.
    
    */

    // REST: Representational State Transfer.
    // API: Application Programing Interface.
    // WWW: World Wide Web.
    // URL: Uniform Resource Locator e.g, http://localhost:8080/health-check
    // HTTP: Hypertext Transfer Protocol
    // HTTPS: Hypertext Transfer Protocol Secure

    // Mappings: Which is related to HTTP or HTTPS method mappings
    // e.g, POST, PUT, GET, PATCH, DELETE, HEAD, OPTIONS

    // Decode URL
    // http://localhost:8080/health-check
    // http or https is a web transfer protocol
    // localhost is an IP Address which is systems or servers or domain
    // 8080 is port number
    // health-check end point

    // https://chatgpt.com/app/9387b50288448c2d
    // https is a secure web transfer protocol
    // chatgpt.com is a domain name
    // app/9387b50288448c2d is an end point

    // HTTP STATUS CODE:
        /*
        An HTTP status code is a three-digit numeric code returns by a web server as
        part of the response to an HTTP request made by a client.

        These status codes are used to convey information about the result or status
        of the requested operation.


        100 - 199  ==> Informational response
        200 - 299  ==> Successful response
        300 - 399  ==> Redirection messages
        400 - 499  ==> Client Error
        500 - 599  ==> Server Error
        */


    /*
    ORM, JPA, and Spring Data JPA
    Object Relational Mapping: (ORM)
        ==> ORM is a technique used to map java objects to database tables.
            It allows developers to work with databases using object-oriented programming
            concepts, making it easier to interact with relational databases.

            [ Consider a Java class User and a database table users.
                ORM frameworks like Hibernate can map the fields in the User class to
                columns in the users table,
              making it easier to insert, update, retrieve and delete records. ]
    Java Persistence API(Application Programing Interface): provide set of rules
        ==> JPA is one of the way to achieve ORM, includes interfaces and annotations
            that you can use in your java classes, requires a persistence provider
            (ORM tools) for implementation.

            [ To use JPA, you need a persistence provider. A persistence provider is a
              specific implementation of the JPA specifications. Examples of JPA
              persistence providers include Hibernate, EclipseLink, and OpenJPA.
              These providers implement the JPA interfaces and provide the underlying
              functionality to interact with database.]

    Spring Data JPA:
        ==> Spring Data JPA is built on top of the JPA(Java Persistence API)
            specification, but it is not a JPA implementation itself. instead,
            it simplifies working with JPA by providing higher level abstractions
            and utilities. However, to use Spring Data JPA effectively, you still
            need a JPA implementation, such as Hibernate, EclipseLink or another
            JPA-compliant provider, to handle actual database interactions.

    MongoDB:
        ==> JPA is primarily designed for working with relational databases,
            where data is stored in tables with predefined schema.

        ==> MongoDB, on the other hand, is a NoSQL database that uses a different
            data models, typically based on collections of documents, which are
            schema-less or have flexible schemas. This fundamental difference in
            data models and storage structures is why JPA is not used with MongoDB.

            dependency:
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-data-mongodb</artifactId>
            </dependency>

        ==> In the case of MongoDB, you don't have a traditional JPA persistence provider.
            MongoDB is a NoSQL database and 'Spring Data MongoDB' serves as the "persistence
            provider" for MongoDB.

            It provides the necessary abstractions and implementations to work with MongoDB
            in Spring Application.

        ==> Query Methods DSL and Criteria API are two different ways to interact with a
            database when using Spring Data JPA for relational databases and Spring Data
            MongoDB for MongoDB databases.

            Spring Data JPA is a part of the Spring Framework that simplifies data access
            in java applications, while Spring Data MongoDB provides similar functionality
            for MongoDB

            Query Methods DSL is simple and convenient way to create queries based on
            method naming conversions, while the Criteria API offers more dynamic and
            programmatic approach for building complex and custom queries.

            DSL (Domain-Specific Language):
                A Domain-Specific Language (DSL) is a type of programming language or
                specification designed to solve problems within a specific domain.
                Unlike general-purpose programming languages like Java or Python,
                DSLs are tailored to a particular set of tasks, offering concise and
                readable syntax for developers working in that domain.

                Key Characteristics:
                    Specificity: Focuses on a specific problem domain.
                    Conciseness: Provides a more compact and expressive syntax
                                 compared to general-purpose languages.
                    Ease of Use: Often easier to read and write for domain experts
                                 who may not be traditional programmers.
                Internal DSL:
                    Built on top of an existing general-purpose programming language.
                    Example: Fluent APIs in Java.
                        External DSL:
                    A completely separate language designed from scratch for a specific purpose.
                        Example: SQL (Structured Query Language).

            Criteria API:
                The Criteria API is part of Java Persistence API (JPA) and is a
                programmatic way to build dynamic database queries in a type-safe
                and flexible manner.
                Key Characteristics:
                    Type-Safe: Errors are caught at compile-time.
                    Dynamic Query Building: Queries can be constructed dynamically
                                            based on user input or application state.
                    No String Concatenation: Unlike raw SQL or JPQL, Criteria API avoids
                                             string concatenation, reducing the risk of
                                             syntax errors and SQL injection.
                How It Works:
                    Create a CriteriaBuilder instance from the EntityManager.
                    Build a CriteriaQuery object.
                    Define query roots and predicates (conditions).

      Comparison: DSL vs. Criteria API
      ______________________________________________________________________________________________________
      |  Aspect	         | DSL	                                  |     Criteria API                        |
      | Purpose	         | Solves domain-specific problems.       | Builds dynamic, type-safe queries.      |
      | Syntax	         | Often concise and expressive.	      | Verbose but flexible.                   |
      | Examples in Java | Fluent APIs, Query Methods in JPA.     | JPA Criteria API.                       |
      | Focus	         | Higher-level abstraction for simplicity| Low-level API for dynamic query building|
      -------------------------------------------------------------------------------------------------------

    */






}
