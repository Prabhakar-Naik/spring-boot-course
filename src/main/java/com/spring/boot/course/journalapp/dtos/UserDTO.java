package com.spring.boot.course.journalapp.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class UserDTO {

    //@NotEmpty
    //@Schema(description = "The user's username")
    private String userName;
    private String email;
    private boolean sentimentAnalysis;
   // @NotEmpty
    private String password;

    public UserDTO(){
        super();
    }
    public UserDTO(String userName, String email, boolean sentimentAnalysis, String password) {
        super();
        this.userName = userName;
        this.email = email;
        this.sentimentAnalysis = sentimentAnalysis;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isSentimentAnalysis() {
        return sentimentAnalysis;
    }

    public void setSentimentAnalysis(boolean sentimentAnalysis) {
        this.sentimentAnalysis = sentimentAnalysis;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}