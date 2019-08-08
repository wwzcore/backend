package com.jxmall.jxmall.service;


import com.jxmall.jxmall.modle.Receiver;
import com.jxmall.jxmall.modle.User;
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

    public List<Receiver> getReceiverList(){return receiverDao.findAll();}
    public Receiver getReceiverByReceiverId(Integer receiverId){return receiverDao.getOne(receiverId);}
    public Receiver save(Receiver receiver){return  receiverDao.save(receiver);}
    public void delete(Receiver receiver){receiverDao.delete(receiver);}
    public List<Receiver> findAllByUserId(Integer userId)
    {

        return receiverDao.findAllByUserId(userId);
    }

}
