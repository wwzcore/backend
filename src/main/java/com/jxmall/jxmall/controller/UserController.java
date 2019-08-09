package com.jxmall.jxmall.controller;


import com.jxmall.jxmall.modle.User;
import com.jxmall.jxmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(value = "/getOne/{userId}")
    @ResponseBody
    public User getUserByUserId(@PathVariable("userId") Integer userId)
    {

        return userService.getUserByUserId(userId);
    }


    @PutMapping(value = "/updUser/{userId}")
    public User updateUser(@PathVariable("userId") Integer userId,
                           @RequestParam("userEmail") String userEmail,
                           @RequestParam("userPhone") String userPhone,
                           @RequestParam("userSex") String userSex,
                           @RequestParam("userRealName") String userRealName,
                           @RequestParam("userMallName") String userMallName,
                           @RequestParam("userAddress") String userAddress)
    {

        User user = new User();
        user = userService.getUserByUserId(userId);
        user.setUserId(userId);
        user.setUserEmail(userEmail);
        user.setUserPhone(userPhone);
        user.setUserSex(userSex);
        user.setUserRealName(userRealName);
        user.setUserMallName(userMallName);
        user.setUserAddress(userAddress);

        return userService.save(user);
    }





}
