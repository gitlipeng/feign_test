package com.movitech.product.project.common.controller;

import com.movitech.generics.common.json.GsonUtils;
import com.movitech.generics.module.base.admin.facade.model.sendmessage.MessageInModel;
import com.movitech.product.project.remote.mc.McFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messagecenter")
public class TestController {
    @Autowired
    McFeignService mcFeignService;
    @RequestMapping(method = RequestMethod.GET, value = "/test")
    String saveMessage(){
        MessageInModel messageInModel = new MessageInModel();
        messageInModel.setExtend("extend");
        MessageInModel messageInModel1 = mcFeignService.saveMessage(messageInModel,"lipeng");

        return "success";
    }


    @RequestMapping(method = RequestMethod.GET, value = "/test2")
    String saveMessage2(){
        MessageInModel messageInModel = new MessageInModel();
        messageInModel.setExtend("extend");
        MessageInModel messageInModel1 = mcFeignService.saveMessage2(messageInModel,"lipeng2");

        return "success";
    }

}
