package com.spring.boot.course.content;

public class SpringLogging {

    // What is Logging ?

    /*
    logging is an essential aspect of application development that allows developers to
    monitor and troubleshoot their application.

    Spring Boot supports various logging frameworks, such as Logback, Log4j2 and Java util
    Logging (JUL)

    Logback:
        A popular logging framework that serves as the default in many Spring Boot applications.
        It offers a flexible configuration and good performance.
    Log4j2:
        Another widely used logging framework with features such as asynchronous logging and
        supports for various output formats.
    Java Util Logging(JUL):
        The default logging framework included in java standard edition. while it's less
        feature-rich than some third-party frameworks, it is straightforward is part of the
        Java platform.

    Spring Boot comes with default logging configuration that uses Logback as the default
    logging implementation. It provides a good balance between simplicity and flexibility.

    The default configuration is embedded within the Spring Boot libraries, and it may not be
    visible in your project's source code.

    if you want to customize the logging configuration, you can create your own logback-spring.xml
    or logback.xml file in the src/main/resources directory.
    When Spring Boot detects this file in your project , it will use it instead of the default
    configuration.


    2025-02-10T11:45:24.831+05:30  INFO     21312 --- [spring-boot-course] [  restartedMain] c.s.b.c.SpringBootCourseApplication      : Starting SpringBootCourseApplication using Java 22.0.2 with PID 21312 (C:\MyProjects\DeveloperSpirit\spring-boot-course\target\classes started by prabh in C:\MyProjects\DeveloperSpirit\spring-boot-course)
    This is Date and Time          severity process id  app Name            thread identifier package main application                log                                         java version    PID (Process ID)  location

    These logs are inbuilt by java Community or java developers

    Logging Levels: (logging severity)
        logging levels help in categorized log statements based on their severity.
        The common logging levels are
        1. TRACE, 2. DEBUG, 3. INFO, 4. WARN, 5. ERROR

    We can set the desired logging level for specific packages or classes, allowing them to control
    the amount of information logged at runtime.

    By default, logging is enabled for INFO, WARN, ERROR.
    if you want to enable DEBUG and TRACE you can enable in properties or yml file or logback.xml(custom)
    you want to configure more customization choose with Logback.xml and implement your customizations

    Spring Boot provides annotations like @Slf4j and @Log4j2
    that you can use to automatically inject logger instances into your classes.

    Slf4j  --> we can throw the logs via this framework.
    Spring logging framework for(4) java.       --> this my scenario just for remember purpose

    actual full form is Slf4j  -=-> simple logging Facade for(4) java

    you can get the more detail on logger object creation at UserDetailsServiceImpl
    21 to 28 lines explaining in detail manner of concept.

    Spring allows us to configure logging using properties or YAML files or Logback.xml.

    structure:
    <configuration>
            < Appender and Logger Configurations go here >
    </configuration>

    The configuration element is the root element of the logback.xml file.
    All Logback configuration is enclosed within this element.

    example:
     you first create a logback.xml file in resource directory simple customize your log data like below

     <configuration>
    <appender name="myConsoleAppender" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <pattern>
                %d{yy-MM-dd HH:mm:ss.SSS} [%thread] %-10level %logger{100} - %msg%n
            </pattern>
        </encoder>
    </appender>
    <appender name="myFileAppender" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <file>
            journalApp.log
        </file>
        <rollingPolicy class="ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy">
            <fileNamePattern>journalApp-%d{yy-MM-dd_HH:mm:ss.SSS}.%i.log</fileNamePattern>
            <maxFileSize>10MB</maxFileSize>
            <maxHistory>10</maxHistory>
        </rollingPolicy>
        <encoder>
            <pattern>
                %d{yy-MM-dd HH:mm:ss.SSS} [%thread] %-10level %logger{100} - %msg%n
            </pattern>
        </encoder>
    </appender>
    <root level="INFO">
        <appender-ref ref="myConsoleAppender"/>

        <appender-ref ref="MyFileAppender"/>
    </root>
</configuration>

    This is basic customization you want to go deeper kindly let me know
    I will help you on this concept

    or you can get the xml code using AI models also


<?xml version="1.0" encoding="UTF-8"?>
<configuration>

    <!-- Define the pattern for logging -->
    <property name="LOG_PATTERN" value="%d{yyyy-MM-dd'T'HH:mm:ss.SSSZ} %-5level %thread --- [%logger{36}] [%M] %msg%n"/>

    <!-- Console Appender -->
    <appender name="CONSOLE" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <pattern>${LOG_PATTERN}</pattern>
        </encoder>
    </appender>

    <!-- Root logger configuration -->
    <root level="info">
        <appender-ref ref="CONSOLE"/>
    </root>

    <!-- You can also set the level of specific loggers if needed -->
    <logger name="org.springframework.boot" level="info"/>
    <logger name="org.springframework.web" level="info"/>

</configuration>


    */
}
