package com.jxmall.jxmall.modle;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "receiver")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Receiver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer receiverId;

    private Integer userId;

    private String receiverName;

    private String receiverPhone;

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

