package com.jxmall.jxmall.modle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity(name = "user_info")
// @JsonIgnoreProperties({"name"})
public class UserInfo {

    @Id
    private Integer userId;

    @Column(name = "user_name")
    private String name;

    private String userPassword;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public UserInfo() {

    }
}
