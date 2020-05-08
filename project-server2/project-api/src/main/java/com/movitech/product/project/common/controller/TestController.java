package com.movitech.product.project.common.controller;

import com.movitech.generics.common.json.GsonUtils;
import com.movitech.generics.framework.exception.BusinessException;
import com.movitech.generics.module.base.admin.facade.model.sendmessage.MessageInModel;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/messagecenter")
public class TestController {
    @RequestMapping(method = RequestMethod.POST, value = "/saveMessage")
    MessageInModel  saveMessage(@RequestBody MessageInModel messageInModel, HttpServletRequest request){
        String auth = request.getHeader("Auth");

        System.out.println(GsonUtils.toJsonString(messageInModel));
        MessageInModel model = new MessageInModel();
        model.setExtend("success");
//        throw new BusinessException("ss");
        return model;
    }
}
