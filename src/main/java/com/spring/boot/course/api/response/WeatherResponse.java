package com.spring.boot.course.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter public class WeatherResponse {

    private Current current;

    @Getter
    @Setter
    public class Current {
        private int temperature;
        @JsonProperty("weather_descriptions")
        private List<String> weatherDescriptions;
        private int feelslike;

        public int getFeelslike() {
            return feelslike;
        }
        public void setFeelslike(int feelslike) {
            this.feelslike = feelslike;
        }

        public int getTemperature() {
            return temperature;
        }
        public void setTemperature(int temperature) {
            this.temperature = temperature;
        }
        public List<String> getWeatherDescriptions() {
            return weatherDescriptions;
        }
        public void setWeatherDescriptions(List<String> weatherDescriptions) {
            this.weatherDescriptions = weatherDescriptions;
        }

    }

    public Current getCurrent() {
        return current;
    }


}