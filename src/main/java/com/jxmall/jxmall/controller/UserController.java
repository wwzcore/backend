package com.jxmall.jxmall.controller;


import com.jxmall.jxmall.modle.User;
import com.jxmall.jxmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    // 根据userId得到用户名userName
    @GetMapping(value = "/getUserName/userId={userId}")
    public String getUserName(@PathVariable("userId") Integer userId) {
        return userService.getUserByUserId(userId).getUserName();
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

        if (userService.getUserByUserName(user.getUserName()) != null) {
            System.out.println(userService.getUserByUserName(user.getUserName()));
            return "userName false";
        } else if (userService.getUserByUserPhone(user.getUserPhone()) != null) {
            return "userPhone false";
        } else if (userService.getUserByUserMallName(user.getUserMallName()) != null) {
            return "userMallName false";
        } else {
            userService.save(user);
            return "Success";
        }
    }

    // 上传头像
    @PostMapping(value = "/upload")
    public String uploadFile(@RequestParam("uploadImage") MultipartFile file) {
        String url;
        System.out.print("上传文件===" + "\n");
        //判断文件是否为空
        if (file.isEmpty()) {
            return "上传文件不可为空";
        }


        // 获取文件名
        String fileName = file.getOriginalFilename();
//        System.out.print("上传的文件名为: "+fileName+"\n");

        fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + fileName;
        System.out.print("（加个时间戳，尽量避免文件名称重复）保存的文件名为: " + fileName + "\n");


        //加个时间戳，尽量避免文件名称重复
        String path = "E:/fileUpload/" + fileName;
        //String path = "E:/fileUpload/" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + fileName;
        //文件绝对路径
        System.out.print("保存文件绝对路径" + path + "\n");

        //创建文件路径
        File dest = new File(path);

        //判断文件是否已经存在
        if (dest.exists()) {
            return "文件已经存在";
        }

        //判断文件父目录是否存在
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdir();
        }

        try {
            //上传文件
            file.transferTo(dest); //保存文件
            System.out.print("保存文件路径" + path + "\n");
            url = "http://localhost:8082/images/" + fileName;
/*            int jieguo= shiPinService.insertUrl(fileName,path,url);
            System.out.print("插入结果"+jieguo+"\n");
            System.out.print("保存的完整url===="+url+"\n");*/

        } catch (IOException e) {
            return "上传失败";
        }

        return url;
    }

    //对头像的url地址进行转换
    @Configuration
    public class WebMvcConfig extends WebMvcConfigurationSupport  {

        @Override
        @RequestMapping("/images*")
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/images/**").addResourceLocations("file:E:/fileUpload/");
            super.addResourceHandlers(registry);
        }
    }


            @PutMapping(value = "/updateUser/")
            @ResponseBody
            public User updateUser (@RequestBody User user)
            {

                User update_user = userService.getUserByUserId(user.getUserId());

                System.out.print("UserID "+user.getUserId()+update_user.getUserId()+"\n");

                update_user.setUserName(user.getUserName());
                update_user.setUserEmail(user.getUserEmail());
                update_user.setUserPhone(user.getUserPhone());
                update_user.setUserSex(user.getUserSex());
                update_user.setUserRealName(user.getUserRealName());
                update_user.setUserMallName(user.getUserMallName());
                update_user.setUserAddress(user.getUserAddress());
                update_user.setImgUrl(user.getImgUrl());
                System.out.print("update imgURL "+update_user.getImgUrl()+"\n");
                return userService.save(update_user);
            }

        }
