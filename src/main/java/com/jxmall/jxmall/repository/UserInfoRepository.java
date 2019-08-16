package com.jxmall.jxmall.repository;
import com.jxmall.jxmall.modle.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserInfoRepository extends JpaRepository<UserInfo,Integer> {
    UserInfo findByUserNameAndUserPassword(String userName, String userPassword);
    UserInfo findByUserId(Integer userId);
}
