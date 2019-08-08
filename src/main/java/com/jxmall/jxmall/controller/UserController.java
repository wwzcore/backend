package com.jxmall.jxmall.controller;


import com.jxmall.jxmall.modle.User;
import com.jxmall.jxmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(value = "/list/{userId}")
    @ResponseBody
    public User getUserByUserId(@PathVariable Integer userId)
    {

        return userService.getUserByUserId(userId);
    }


    @PutMapping(value = "/updUser/{userId}")
    public User updateUser(@PathVariable Integer userId,
                           @RequestParam String userEmail,
                           @RequestParam String userPhone,
                           @RequestParam String userSex,
                           @RequestParam String userRealName,
                           @RequestParam String userMallName,
                           @RequestParam String userAddress)
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
