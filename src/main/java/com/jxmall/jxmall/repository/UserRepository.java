package com.jxmall.jxmall.repository;

import com.jxmall.jxmall.modle.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByName(String userName);

    User findUserByPhone(String userPhone);

    User findUserByMallName(String userMallName);
}
