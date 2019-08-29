package com.jxmall.jxmall.controller;

import com.jxmall.jxmall.modle.User;
import com.jxmall.jxmall.modle.UserInfo;
import com.jxmall.jxmall.service.UserInfoService;
import com.jxmall.jxmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static com.jxmall.jxmall.common.WebMvcConfig.SEESION_KEY;

@CrossOrigin
@RestController
@RequestMapping("/userInfo")
public class UserInfoController {
    @Autowired
    public UserInfoService userInfoService;

    @Autowired
    public UserService userService;

    //select info from user_info
    @GetMapping(value = "/list")
    @ResponseBody
    public List<UserInfo> getUserList() {
        return userInfoService.findAll();
    }

    // 用户登录校验
    @PostMapping(value = "/login")
    @ResponseBody
    public String getUserByUserId(@RequestBody UserInfo userInfo) {
        // httpSession.setAttribute("userId", userInfo.getUserId());
        User login_user = userService.getUserByUserName(userInfo.getUserName());
        if (login_user == null) {
            return "No user";
        } else if (!userInfoService.getByUserId(login_user.getUserId()).getUserPassword().equals(userInfo.getUserPassword())) {
            System.out.println(userInfoService.getByUserId(login_user.getUserId()).getUserPassword() + "asdfasfdafsd:" + userInfo.getUserPassword());
            return "Password error";
        } else {
            return "Success";
        }
        // throw new Exception("登录失败！");
    }

    @PostMapping(value = "/loginout")
    @ResponseBody
    public String loginOut(@RequestBody Map map, HttpServletResponse response, HttpSession session) throws IOException {

        if (!map.containsKey("userName")) {
            response.sendError(100, "无效退出,用户名不能为空！");
            return null;
        }
        String userName = map.get("userName").toString();
        User user = userService.getUserByUserName(userName);
        if (user == null) {
            response.sendError(100, "无效退出,用户不存在！");
            return null;
        }
        session.setAttribute(SEESION_KEY, "");
        return "{\"message\":getUseOne\"sucess\"}";

    }


    //add user to user_info
    @PostMapping(value = "/addUser")
    public UserInfo addUser(@RequestBody UserInfo userInfo) {
        User user = userService.getUserByUserName(userInfo.getUserName());
        userInfo.setUserId(user.getUserId());
        userInfo.setUserName(userInfo.getUserName());
        userInfo.setUserPassword(userInfo.getUserPassword());

        return userInfoService.save(userInfo);
    }


    //update user to user_info
    @PutMapping(value = "/updUser/{userId}")
    public UserInfo updUser(@PathVariable("userId") Integer userId,
                            @RequestParam("userName") String userName,
                            @RequestParam("password") String userPassword) {

        UserInfo userInfo = userInfoService.findOne(userId);
        userInfo.setUserName(userName);
        userInfo.setUserPassword(userPassword);
        return userInfoService.save(userInfo);

    }


    //delete user to user_info
    @DeleteMapping(value = "/delUser/{userId}")
    public void delUser(@PathVariable("userId") Integer userId) {
        UserInfo userInfo = userInfoService.findOne(userId);
        userInfoService.delete(userInfo);
    }


}
