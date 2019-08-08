package com.jxmall.jxmall.controller;


import com.jxmall.jxmall.modle.Receiver;
import com.jxmall.jxmall.service.ReceiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/receiver")
public class ReceiverController {
    @Autowired
    ReceiverService receiverService;

    @RequestMapping(value = "/list")
    @ResponseBody
    public List<Receiver> getReceiverList(@RequestParam("userId") Integer userId){
        return receiverService.findAllByUserId(userId);
    }


    @RequestMapping(value = "/add")
    public Receiver addReceiver(@RequestParam("userId") Integer userId,
                                @RequestParam("receiverName") String receiverName,
                                @RequestParam("receiverPhone") String receiverPhone,
                                @RequestParam("receiverAddressInfo") String receiverAddressInfo)
    {
        Receiver receiver = new Receiver();
        receiver.setUserId(userId);
        receiver.setReceiverName(receiverName);
        receiver.setReceiverPhone(receiverPhone);
        receiver.setReceiverAddressInfo(receiverAddressInfo);
        return receiverService.save(receiver);

    }

    @PutMapping(value = "/updReceiver/{receiverId}")
    public Receiver updateReceiver(@PathVariable("receiverId") Integer receiverId,
                                   @RequestParam("receiverName") String receiverName,
                                   @RequestParam("receiverPhone") String receiverPhone,
                                   @RequestParam("receiverAddressInfo") String receiverAddressInfo)
    {
        Receiver receiver = new Receiver();
        receiver = receiverService.getReceiverByReceiverId(receiverId);
        receiver.setReceiverName(receiverName);
        receiver.setReceiverPhone(receiverPhone);
        receiver.setReceiverAddressInfo(receiverAddressInfo);
        return receiverService.save(receiver);

    }

    @DeleteMapping(value = "/delReceiver/{receiverId}")
    public void deleteReceiver(@PathVariable("receiverId") Integer receiverId)
    {
        Receiver receiver = new Receiver();
        receiver = receiverService.getReceiverByReceiverId(receiverId);
        receiver.setReceiverId(receiverId);
        receiverService.delete(receiver);
    }
}
