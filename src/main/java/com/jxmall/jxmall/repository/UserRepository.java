package com.jxmall.jxmall.repository;


import com.jxmall.jxmall.modle.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
