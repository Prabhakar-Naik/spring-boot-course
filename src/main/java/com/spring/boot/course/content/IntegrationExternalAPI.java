package com.spring.boot.course.content;

public class IntegrationExternalAPI {

    /*
    how can we to integrate external api into spring boot application ?

        Integrating an external API into a Spring Boot application typically involves making
        HTTP requests from your application to the external API.

        We can achieve this using Spring's RestTemplate, WebClient, or even third-party libraries
        like OkHttp.

        I Present some common ways to achieve to integrate the External APIs.

        you can go through how to integrate an external API using RestTemplate and WebClient,
        which are the most commonly used tools in Spring Boot.

        1. Using RestTemplate (Synchronous HTTP Requests)
        RestTemplate is a classic, synchronous HTTP client used for making RESTFUL API calls
        in a Spring Boot application. It’s simpler to use but has been somewhat superseded by
        WebClient in Spring 5 due to better support for reactive programming.

        Steps to Integrate External API Using RestTemplate:
        I.Add Dependencies to pom.xml:
            If you’re using Spring Web, you’ll already have RestTemplate
            available, but if not, make sure the following dependencies are included:

        <dependencies>
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-web</artifactId>
            </dependency>
        </dependencies>

        II.Create a RestTemplate Bean:
            In your Spring Boot application, create a RestTemplate bean to be injected
            where needed:

        @Configuration
        public class RestTemplateConfig {
            @Bean
            public RestTemplate restTemplate(RestTemplateBuilder builder) {
                return builder.build();
            }
        }

        III. Use RestTemplate to Call the External API:
            You can now inject RestTemplate into any service or controller and use
            it to make HTTP requests.
        @Service
        public class ExternalApiService {

            @Autowired
            private RestTemplate restTemplate;

            public String getExternalData() {
                String apiUrl = "https://api.example.com/data";
                String response = restTemplate.getForObject(apiUrl, String.class);
                return response;
            }

            public String postToExternalApi() {
                String apiUrl = "https://api.example.com/data";
                String requestPayload = "{ \"key\": \"value\" }";
                return restTemplate.postForObject(apiUrl, requestPayload, String.class);
            }
        }

        getExternalData() method we can get more customize format like you can pass in request DTO
        as well you can get response in your own customize response DTO.

        IV. Invoke the API in a Controller (Optional):
            You can create a controller to expose the endpoint and call the external API:

        @RestController
        public class ExternalApiController {

            @Autowired
            private ExternalApiService externalApiService;

            @GetMapping("/fetch-external-data")
            public String fetchData() {
                return externalApiService.getExternalData();
            }
        }

        Run and Test: Once the application is running, you can access
        http://localhost:8080/fetch-external-data to call the external API.

        2. Using WebClient (Non-blocking, Asynchronous HTTP Requests)
            WebClient is the modern, non-blocking, reactive alternative to RestTemplate.
            It’s part of the Spring WebFlux module and is better for applications that need
            to handle many concurrent requests in a scalable, asynchronous manner.

        Steps to Integrate External API Using WebClient:
        I. Add Dependencies to pom.xml:
            Make sure you include the spring-boot-starter-webflux dependency for WebClient:
            <dependencies>
                <dependency>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-webflux</artifactId>
                </dependency>
            </dependencies>

        II. Create a WebClient Bean:
            In your configuration class, create a WebClient bean:

            @Configuration
            public class WebClientConfig {

                @Bean
                public WebClient.Builder webClientBuilder() {
                    return WebClient.builder();
                }
            }
        III. Use WebClient to Call the External API:
            Inject WebClient into your service and make asynchronous HTTP calls.

            @Service
            public class ExternalApiService {

                private final WebClient webClient;

                @Autowired
                public ExternalApiService(WebClient.Builder webClientBuilder) {
                    this.webClient = webClientBuilder.baseUrl("https://api.example.com").build();
                }

                public Mono<String> getExternalData() {
                    return webClient.get()
                            .uri("/data")
                            .retrieve()
                            .bodyToMono(String.class);
                }

                public Mono<String> postToExternalApi(String payload) {
                    return webClient.post()
                            .uri("/data")
                            .bodyValue(payload)
                            .retrieve()
                            .bodyToMono(String.class);
                }
            }

            Here also getExternalData() method we can get more customize format like you can pass
            in request DTO as well you can get response in your own customize response DTO.

            IV. Call WebClient API in a Controller (Optional):
                Here’s how you might expose the external API call through a REST endpoint:

            @RestController
            public class ExternalApiController {

                @Autowired
                private ExternalApiService externalApiService;

                @GetMapping("/fetch-external-data")
                public Mono<String> fetchData() {
                    return externalApiService.getExternalData();
                }
            }

            Run and Test: After starting the application,
            visit http://localhost:8080/fetch-external-data. Since WebClient is non-blocking,
            the response will be handled asynchronously.


       3. Error Handling and Retry Logic:
            You should handle errors gracefully when working with external APIs,
            as they may be down or have rate limits.

            For example, with WebClient, you can add error handling like this:
            public Mono<String> getExternalDataWithErrorHandling() {
                return webClient.get()
                        .uri("/data")
                        .retrieve()
                        .onStatus(HttpStatus::is4xxClientError, clientResponse -> Mono.error(new RuntimeException("Client Error")))
                        .onStatus(HttpStatus::is5xxServerError, clientResponse -> Mono.error(new RuntimeException("Server Error")))
                        .bodyToMono(String.class)
                        .onErrorResume(e -> Mono.just("Fallback Response"));
            }


       RestTemplate is simpler and synchronous, ideal for quick integrations with external APIs,
       but WebClient is preferred for reactive, non-blocking use cases (and future-proofing).

       Both tools allow you to make GET, POST, and other HTTP requests to external APIs.

       Always handle errors and edge cases (e.g., timeouts, invalid responses) when integrating
       with external services.


       This is Simple and external api calling using RestTemplate and WebClient if you work with
       organizational product you must secure your sensitive data, credentials, keys and get dynamic
       like
       1.Credentials,
       2. Authentication,
       3. Authorization,
       4. Access the data and protect the data

    */
}
