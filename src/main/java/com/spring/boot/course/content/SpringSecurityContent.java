package com.spring.boot.course.content;

public class SpringSecurityContent {

    // What is Spring Security ?

    /*
     --> Spring Security is a powerful and highly customizable security framework that
         is often used in Spring Boot Application to handle authentication an authorization.

     Authentication:
         The process of verifying a user's identity (e.g., username and password)

     Authorization:
         The process of granting or denying access to specific resources or actions based
         on the authenticated user's roles and permissions.

     Configuration we must do on custom protected security
     add the dependency.

     Once the dependency is added, Spring Boot's auto_configuration features will
     automatically apply security to the application.

     By default, Spring Security uses HTTP Basic Authentication.

     Basic Authentication:
         The Client sends an Authorization header Authorization: Basic <encoded-string>
         The server decodes the string, extracts the username and password, and verifies them.
         If they correct, access is granted. Otherwise, an Unauthorized response is sent back.

         Encoding Credentials are combined into a string like username:password which is then
         encoded using Base64

         By default, all endpoints will be secured. Spring Security will generate a default user
         with a random password that is printed in the console logs on startup.

     Customizing Authentication:
         we must create a configuration class for customization that's like SecurityConfig
         inside the class we can found 2 annotations like @Configuration and @EnableWebSecurity

         @Configuration:
            annotation is used to mark a class as a source of bean definitions.
            It's a core annotation from the Spring Framework, not specific to Spring Boot.

            The @Configuration annotation indicates that a class declares one or more @Bean methods,
            which define beans that will be managed by the Spring IoC container.

            Alternative to XML configuration

            @Configuration classes are typically used in conjunction with @ComponentScan
            to automatically scan for and register other beans in your application.

         @EnableWebSecurity:
            This annotation signals Spring to enable its web security support.
            This is what makes your application secured. It's used in conjunction with @Configuration.

            Spring Boot Auto Configuration:
                If you include Spring Boot Starter Security, @EnableWebSecurity is automatically
                applied.
            Security Policies:
                You can customize security policies within your configuration class using methods
                like authorizeRequests, formLogin, httpBasic, etc.
            Authentication:
                You can configure different authentication mechanisms like in-memory, JDBC, or
                LDAP.
            Authorization:
                You can define authorization rules to control access to different parts of your
                application.

          WebSecurityConfigurerAdapter is a utility class in the Spring Security framework that
          provides default configurations and allows customization of certain features.
          By extending it, you can configure and customize spring security for your application
          needs.

     
     --> Spring Security

    */
}
