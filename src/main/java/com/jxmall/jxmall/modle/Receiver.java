package com.jxmall.jxmall.modle;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;

@Entity(name = "receiver")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Valid
public class Receiver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer receiverId;

    private Integer userId;

    @Length(max = 50,message = "最大长度位50位")
    @Pattern(regexp = "^[A-Za-z\\u4e00-\\u9fa5]+$",message = "用户姓名必须为中文，字母组成")
    private String receiverName;

    @Length(min = 11,max = 11,message = "手机号必须是11位")
    private String receiverPhone;

    @Length(max = 1000, message = "最大长度为1000")
    private String receiverAddressInfo;

    public Integer getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Integer receiverId) {
        this.receiverId = receiverId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public String getReceiverAddressInfo() {
        return receiverAddressInfo;
    }

    public void setReceiverAddressInfo(String receiverAddressInfo) {
        this.receiverAddressInfo = receiverAddressInfo;
    }

    public Receiver() {
    }

    @Override
    public String toString() {
        return "Receiver{" +
                "receiverId=" + receiverId +
                ", userId=" + userId +
                ", receiverName='" + receiverName + '\'' +
                ", receiverPhone='" + receiverPhone + '\'' +
                ", receiverAddressInfo='" + receiverAddressInfo + '\'' +
                '}';
    }
}

