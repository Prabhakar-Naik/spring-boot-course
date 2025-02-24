package com.spring.boot.course.content;

public class SpringBootProfilesRun {

    /*
    To set spring profile in the application you must choose only one default file like
    application.properties   or application.yml
     how many way we can run spring boot application using different port number

     1. Using application.properties or application.yml
        application.properties ==> server.port=8081

        application.yml
                server:
                    port: 8081
     2. Using Command-Line Arguments
        java -jar your-application.jar --server.port=8081

     3.  Using SpringApplication.setDefaultProperties()
     @SpringBootApplication
     public class MyApplication {
        public static void main(String[] args) {
        Map<String, Object> properties = new HashMap<>();
        properties.put("server.port", 8081);

        SpringApplication app = new SpringApplication(MyApplication.class);
        app.setDefaultProperties(properties);
        app.run(args);
        }
      }

      4. Using Environment Variables
        export SERVER_PORT=8081
        java -jar your-application.jar

      5. Using Profiles
        application-dev.properties   ==> server.port=8081

        application-prod.properties  ==> server.port=9090

        When running the application, specify the active profile:
        1. java -jar your-application.jar --spring.profiles.active=dev
        2. java -jar your-application.jar --spring.profiles.active=prod

     6. Using @Value or @ConfigurationProperties
     @Configuration
     public class WebServerConfig {
        @Value("${server.port:8081}") // Default to 8081 if not set
        private int port;

        @Bean
        public ServletWebServerFactory webServerFactory() {
            ConfigurableServletWebServerFactory factory = new ConfigurableServletWebServerFactory();
            factory.setPort(port);
            return factory;
        }
    }

    priority: 1. command line arguments  or intellij param argument --server.port=9092
              2. .properties
              3. .yml


    */
}
