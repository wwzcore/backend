package com.jxmall.jxmall.modle;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name = "user_info")
// @JsonIgnoreProperties({"userName"})
public class UserInfo {

    @Id
    private Integer userId;

    private String userName;

    private String userPassword;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() { return userPassword; }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public UserInfo() {

    }
}
