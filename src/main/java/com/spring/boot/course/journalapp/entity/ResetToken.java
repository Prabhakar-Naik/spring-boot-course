package com.spring.boot.course.journalapp.entity;

import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

/**
 * @author prabhakar, @Date 26-02-2025
 */

@Document
public class ResetToken {

    @Id
    private String id;
    @Indexed(unique = true)
    @NonNull
    private String token;
    @DBRef
    private User user;

    public ResetToken() {
        super();
    }

    public ResetToken(String token, User user) {
        this.token = token;
        this.user = user;
    }

    public String getId() {
        return UUID.randomUUID().toString();
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

}
