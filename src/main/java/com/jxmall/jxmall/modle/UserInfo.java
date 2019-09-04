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

    @Column(name = "user_password")
    private String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserInfo() {

    }
}
