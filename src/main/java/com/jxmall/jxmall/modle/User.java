package com.jxmall.jxmall.modle;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity(name = "user")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @NotBlank(message = "用户名不能为空")
    @Column(name = "user_name")
    private String name;

    @Length(max = 50, message = "最大长度为50位")
    @Email(message = "必须是邮箱格式")
    @Column(name = "user_email")
    private String email;

    //    @Length(min = 11,max = 11,message = "手机号必须是11位")
    @Column(name = "user_phone")
    private String phone;

    //    @Length(min = 1,max = 1)
    @Column(name = "user_sex")
    private String sex;

    @Length(max = 50, message = "最大长度位50位")
//    @Pattern(regexp = "^[A-Za-z\\u4e00-\\u9fa5]+$",message = "用户姓名必须为中文，字母组成")
    @Column(name = "user_realName")
    private String realName;

    @Length(max = 50, message = "最大长度位50位")
//    @Pattern(regexp = "^[a-zA-Z0-9\\u4e00-\\u9fa5]+$",message = "用户昵称必须为中文，字母，数字组成")
    @Column(name = "user_mallName")
    private String mallName;

    @Length(max = 1000, message = "最大长度位1000位")
    @Column(name = "user_address")
    private String address;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getMallName() {
        return mallName;
    }

    public void setMallName(String MallName) {
        this.mallName = MallName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User() {
    }


}



