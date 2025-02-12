package com.spring.boot.course.journalapp.service;

import com.spring.boot.course.api.response.WeatherResponse;
import com.spring.boot.course.cache.AppCache;
import com.spring.boot.course.constants.Placeholders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;

    private static final String API = "https://api.weatherstack.com/current?access_key=key&query=city";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AppCache appCache;

//    @Autowired
//    private RedisService redisService;


    public WeatherResponse getWeather(String city) {
        String finalAPI = API.replace("{city}", city).replace("{key}", apiKey);
        ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalAPI, HttpMethod.POST,null, WeatherResponse.class);
        WeatherResponse weatherResponse = response.getBody();
        return weatherResponse;
    }

    /*public WeatherResponse getWeather(String city) {
        WeatherResponse weatherResponse = redisService.get("weather_of_" + city, WeatherResponse.class);
        if (weatherResponse != null) {
            return weatherResponse;
        } else {
            String finalAPI = appCache.appCache.get(AppCache.keys.WEATHER_API.toString()).replace(Placeholders.CITY, city).replace(Placeholders.API_KEY, apiKey);
            ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalAPI, HttpMethod.POST, null, WeatherResponse.class);
            WeatherResponse body = response.getBody();
            if (body != null) {
                redisService.set("weather_of_" + city, body, 300l);
            }
            return body;
        }

    }*/

}