package com.jxmall.jxmall.service;


import com.jxmall.jxmall.modle.UserInfo;
import com.jxmall.jxmall.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserInfoService {
    @Autowired
    private UserInfoRepository userInfoDao;


    public List<UserInfo> findAll(){return userInfoDao.findAll();}
    public UserInfo save(UserInfo userInfo){return userInfoDao.save(userInfo);}
    public void delete(UserInfo userInfo){userInfoDao.delete(userInfo);}
    public UserInfo findOne(Integer userId){return userInfoDao.getOne(userId);}



}
