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

          http.authorizeHttpRequests:
            This tells Spring Security to start authorizing the requests.

          http.requestMatchers("/public/**").permitAll():
            This part specifies that HTTP request matching the path "/public/** should be permitted
            (allowed) for all users, whether they are authenticated or not.

          http.anyRequest().authenticated():
            This is more general matcher that specifies any request (not already matched by previous
            matchers) should be authenticated, meaning users have to provide valid credentials to
            access those endpoints.

            you can access the "/public/**" endpoints without any authentication. However, if you
            try to access another endpoint, you will be redirected to a login form.

          http.and();
            This is a method to join several configurations. It helps to continue the configuration
            from the root(HttpSecurity).

          http.formLogin():
            This enables form-based authentication. By default, it will provide a form for the user
            to enter their username and password. If the user is not authenticated, and they try to
            access a secured endpoint, they'll be redirected to the default login form.

            when we use the .formLogin() method in our security configuration without specifying
            .loginPage("/custom-path"), the default login page becomes active.

    */


    /*
     --> Spring Security provides an in-built controller class that handle the /login path.
         This Controller is responsible for rendering the default login form when a GET
         request is made to /login

         By default, Spring Security also provides logout functionality. when .logout() is
         configured, a POST request to /logout will log the user out and invalidate their session.

         Basic Authentication, by its design, is stateless

         some applications do mix Basic Authentication with Session management for various reasons.
         This is not standard behaviour and requires additional setup and logic.

         In such scenarios, once the user's credentials verified via Basic Authentication,
         a session might be established, and the client is provided a session cookie.

         This way, the client won't need to send the authorization header with every request, and the
         server can rely on the session cookie to identify the authenticated user.

     ==> when you log in with Spring security, it manages your authentication across multiple
         requests, despite HTTP being stateless

         1. Session Creation:
                After successful authentication, an HTTP session if formed. Your authentication
                details are stored in this session.
         2. Session Cookie:
                A JSESSIONID cookie is sent to your browser, which gets sent back with subsequent
                requests, helping the server recognize your session.
         3. Security Context:
                Using the JSESSIONID, Spring Security fetches your authentication details for
                each request.
         4. Session Timeout:
                Session have a limited life. If you are inactive past this limit, you're logged out.
         5. Logout:
                When logging out, your session ends, and the related cookie is removed.
         6. Remember-Me:
                Spring Security can remember you even after the session ends using a different
                persistent cookie (typically have a longer lifespan).

     --> In essence, Spring Security leverages sessions and cookie, mainly JSESSIONID, to ensure
         you remain authenticated across requests.

     We want our Spring Boot application to authenticate users based on their credentials stored
     in a MongoDB database.

     This means that users and their password(hashed) will be stored in MongoDB, and when a user
     tries to log in, the system should check the provided credentials against what's stored in
     the database.

     We want our Spring Boot application to authenticate users based on their credentials stored
     in a MongoDB database.

     steps:
     1. A User entity to represent the user data model.
     2. A repository UserRepository to interact with MongoDB.
     3. UserDetailService implementation to fetch user details.
     4. A Configuration SecurityConfig to integrate everything with Spring Security.



    */
}
