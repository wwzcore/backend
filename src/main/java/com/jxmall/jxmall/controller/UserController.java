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
    public String getUserName(@PathVariable("userId") Integer userId) {
        return userService.getUserByUserId(userId).getName();
    }

    // 根据userName得到用户名userId
    @GetMapping(value = "/getUserId/userName={userName}")
    public Integer getUserId(@PathVariable("userName") String userName) {
        return userService.getUserByUserName(userName).getUserId();
    }

    // 用户信息查询,根据userName得到用户名user
    @GetMapping(value = "/getUseOne/userName={userName}")
    @ResponseBody
    public User getUserForLogin(@PathVariable("userName") String userName) {
        return userService.getUserByUserName(userName);
    }

    // 用户注册
    @PostMapping(value = "/addUser")
    public String addUser(@RequestBody User user) {

        if (userService.getUserByUserName(user.getName()) != null) {
            System.out.println(userService.getUserByUserName(user.getName()));
            return "userName false";
        } else if (userService.getUserByUserPhone(user.getPhone()) != null) {
            return "userPhone false";
        } else if (userService.getUserByUserMallName(user.getMallName()) != null) {
            return "userMallName false";
        } else {
            userService.save(user);
            return "Success";
        }
    }

    @PutMapping(value = "/updateUser/")
    @ResponseBody
    public User updateUser(@RequestBody User user) {
        User update_user = userService.getUserByUserId(user.getUserId());
        update_user.setName(user.getName());
        update_user.setEmail(user.getEmail());
        update_user.setPhone(user.getPhone());
        update_user.setSex(user.getSex());
        update_user.setRealName(user.getRealName());
        update_user.setMallName(user.getMallName());
        update_user.setAddress(user.getAddress());

        return userService.save(update_user);
    }


}
