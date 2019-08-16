package com.jxmall.jxmall.repository;

import com.jxmall.jxmall.modle.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findUserByUserName(String userName);
    User findUserByUserPhone(String userPhone);
    User findUserByUserMallName(String userMallName);
}
