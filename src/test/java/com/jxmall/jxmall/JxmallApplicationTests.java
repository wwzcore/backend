package com.jxmall.jxmall;

import com.jxmall.jxmall.controller.UserInfoController;
import com.jxmall.jxmall.modle.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;


import static java.lang.System.out;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=JxmallApplication.class)
public class JxmallApplicationTests {

@Autowired
UserInfoController userInfoController;

/*    final static ByteArrayOutputStream outContent = new ByteArrayOutputStream();*/
    @Test
    public void contextLoads() {
        List<UserInfo> userInfos = new ArrayList<UserInfo>();
        userInfos = userInfoController.getUserList();
        System.out.println(userInfos);
/*        assertTrue(userInfos.size()>0);*/
/*        UserInfo userInfo = new UserInfo();
        userInfo = userInfoController.getUserByUserId(1);
        System.out.println(userInfo.toString());*/


    }

}
