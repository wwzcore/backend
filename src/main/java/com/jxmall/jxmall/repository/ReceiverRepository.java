package com.jxmall.jxmall.repository;

import com.jxmall.jxmall.modle.Receiver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReceiverRepository extends JpaRepository<Receiver,Integer> {
     List<Receiver> findAllByUserId(Integer userId);

}
