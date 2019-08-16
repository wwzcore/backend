package com.jxmall.jxmall.controller;


import com.jxmall.jxmall.modle.Receiver;
import com.jxmall.jxmall.modle.User;
import com.jxmall.jxmall.service.ReceiverService;
import com.jxmall.jxmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/receiver")
public class ReceiverController {
    @Autowired
    ReceiverService receiverService;

    @Autowired
    UserService userService;

    @GetMapping(value = "/list/userName={userName}")
    public List<Receiver> getReceiverList(@PathVariable("userName") String userName){
        User user = userService.getUserByUserName(userName);
        return receiverService.findAllByUserId(user.getUserId());
    }


    @PostMapping(value = "/add/userName={userName}")
    public Receiver addReceiver(@PathVariable("userName") String userName,
                                @RequestBody Receiver receiver)
    {
        User user = userService.getUserByUserName(userName);
        receiver.setUserId(user.getUserId());
        return receiverService.save(receiver);
    }

    @PutMapping(value = "/updReceiver")
    public Receiver updateReceiver(@RequestBody Receiver receiver)
    {
        Receiver new_receiver = receiverService.getReceiverOne(receiver.getUserId(), receiver.getReceiverId());
        new_receiver.setReceiverName(receiver.getReceiverName());
        new_receiver.setReceiverPhone(receiver.getReceiverPhone());
        new_receiver.setReceiverAddressInfo(receiver.getReceiverAddressInfo());
        return receiverService.save(new_receiver);
    }

    @DeleteMapping(value = "/delReceiver/userName={userName}&receiverId={receiverId}")
    public void deleteReceiver(@PathVariable("userName") String userName,
                               @PathVariable("receiverId") Integer receiverId)
    {
        User user = userService.getUserByUserName(userName);
        Receiver receiver = new Receiver();
        receiver = receiverService.getReceiverOne(user.getUserId(), receiverId);
        receiverService.delete(receiver);
    }
}
