package com.spring.boot.course.journalapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author prabhakar, @Date 22-02-2025
 */

@Data
@AllArgsConstructor
@Builder
public class UserLoginRequest {
    private String userName;
    private String password;

    public UserLoginRequest() {
        super();
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}
