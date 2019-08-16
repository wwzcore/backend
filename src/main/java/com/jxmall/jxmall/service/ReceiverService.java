package com.jxmall.jxmall.service;


import com.jxmall.jxmall.modle.Receiver;
import com.jxmall.jxmall.repository.ReceiverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class ReceiverService {
    @Autowired
    private ReceiverRepository receiverDao;

    public Receiver getReceiverOne(Integer userId, Integer receiverId){return receiverDao.findByUserIdAndReceiverId(userId, receiverId);}
    public Receiver save(Receiver receiver){return  receiverDao.save(receiver);}
    public void delete(Receiver receiver){receiverDao.delete(receiver);}
    public List<Receiver> findAllByUserId(Integer userId)
    {

        return receiverDao.findAllByUserId(userId);
    }

}
