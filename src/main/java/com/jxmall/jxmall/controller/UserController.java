package com.jxmall.jxmall.controller;


import com.jxmall.jxmall.modle.User;
import com.jxmall.jxmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    // 根据userId得到用户名userName
    @GetMapping(value = "/getUserName/userId={userId}")
    public String getUserName(@PathVariable("userId") Integer userId)
    {
        return userService.getUserByUserId(userId).getUserName();
    }

    // 根据userName得到用户名userId
    @GetMapping(value = "/getUserId/userName={userName}")
    public Integer getUserId(@PathVariable("userName") String userName)
    {
        return userService.getUserByUserName(userName).getUserId();
    }

    // 用户信息查询,根据userName得到用户名user
    @GetMapping(value = "/getUseOne/userName={userName}")
    @ResponseBody
    public User getUserForLogin(@PathVariable("userName") String userName)
    {
        return userService.getUserByUserName(userName);
    }

    // 用户注册
    @PostMapping(value = "/addUser")
    public String addUser(@RequestBody User user)
    {

        if (userService.getUserByUserName(user.getUserName()) != null) {
            System.out.println(userService.getUserByUserName(user.getUserName()));
            return "userName false";
        }else if(userService.getUserByUserPhone(user.getUserPhone()) != null){
            return "userPhone false";
        }else if(userService.getUserByUserMallName(user.getUserMallName()) != null){
            return "userMallName false";
        }else {
            userService.save(user);
            return "Success";
        }
    }

    @PutMapping(value = "/updateUser/")
    @ResponseBody
    public User updateUser(@RequestBody User user)
    {
        User update_user = userService.getUserByUserId(user.getUserId());
        update_user.setUserName(user.getUserName());
        update_user.setUserEmail(user.getUserEmail());
        update_user.setUserPhone(user.getUserPhone());
        update_user.setUserSex(user.getUserSex());
        update_user.setUserRealName(user.getUserRealName());
        update_user.setUserMallName(user.getUserMallName());
        update_user.setUserAddress(user.getUserAddress());

        return userService.save(update_user);
    }





}
