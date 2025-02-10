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

    

    */
}
