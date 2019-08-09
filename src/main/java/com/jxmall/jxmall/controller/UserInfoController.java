package com.jxmall.jxmall.controller;


import com.jxmall.jxmall.modle.UserInfo;
import com.jxmall.jxmall.service.UserInfoService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userInfo")
public class UserInfoController {
    @Autowired
    UserInfoService userInfoService;



   //select info from user_info
    @GetMapping(value = "/list")
    @ResponseBody
    public List<UserInfo> getUserList()
    {
        return userInfoService.findAll();
    }

    @GetMapping(value = "/getOne/{id}")
    @ResponseBody
    public UserInfo getUserByUserId(@PathVariable("id") Integer id){return userInfoService.findOne(id);}


    //add user to user_info
    @PostMapping(value = "/addUser")
    public UserInfo addUser(@RequestParam("username") String username,
                            @RequestParam("password") String password)
    {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(username);
        userInfo.setPassword(password);
        return userInfoService.save(userInfo);

    }



    //update user to user_info
    @PutMapping(value = "/updUser/{id}")
    public UserInfo updUser(@PathVariable("id") Integer id,
                            @RequestParam("username") String username,
                            @RequestParam("password") String password)
    {
        UserInfo userInfo = new UserInfo();
        userInfo = userInfoService.findOne(id);
        userInfo.setUsername(username);
        userInfo.setPassword(password);
        return userInfoService.save(userInfo);

    }


    //delete user to user_info
    @DeleteMapping(value = "/delUser/{id}")
    public void delUser(@PathVariable("id") Integer id)
    {
        UserInfo userInfo = new UserInfo();
        userInfo = userInfoService.findOne(id);
        userInfoService.delete(userInfo);
    }



}
