package com.jxmall.jxmall.service;


import com.jxmall.jxmall.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jxmall.jxmall.modle.User;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userDao;

    public List<User> findAll(){return userDao.findAll();}
    public User save(User user){return userDao.save(user);}
    public void delete(User user){userDao.delete(user);}
    public User getUserByUserId(Integer userId){return userDao.getOne(userId); }



}
