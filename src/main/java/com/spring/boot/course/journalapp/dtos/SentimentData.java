package com.spring.boot.course.journalapp.dtos;


public class SentimentData {
    private String email;
    private String sentiment;

    public SentimentData() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSentiment() {
        return sentiment;
    }

    public void setSentiment(String sentiment) {
        this.sentiment = sentiment;
    }
}