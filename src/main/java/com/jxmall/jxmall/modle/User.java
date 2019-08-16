package com.jxmall.jxmall.modle;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity(name = "user")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @NotBlank(message = "用户名不能为空")
    private String userName;

    @Length(max = 50,message = "最大长度为50位")
    @Email(message = "必须是邮箱格式")
    private String userEmail;

//    @Length(min = 11,max = 11,message = "手机号必须是11位")
    private String userPhone;

//    @Length(min = 1,max = 1)
    private String userSex;

    @Length(max = 50,message = "最大长度位50位")
//    @Pattern(regexp = "^[A-Za-z\\u4e00-\\u9fa5]+$",message = "用户姓名必须为中文，字母组成")
    private String userRealName;

    @Length(max = 50,message = "最大长度位50位")
//    @Pattern(regexp = "^[a-zA-Z0-9\\u4e00-\\u9fa5]+$",message = "用户昵称必须为中文，字母，数字组成")
    private String userMallName;

    @Length(max = 1000,message = "最大长度位1000位")
    private String userAddress;

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

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    public String getUserMallName() {
        return userMallName;
    }

    public void setUserMallName(String userMallName) {
        this.userMallName = userMallName;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userRealName='" + userRealName + '\'' +
                ", userMallName='" + userMallName + '\'' +
                ", userAddress='" + userAddress + '\'' +
                '}';
    }
}



