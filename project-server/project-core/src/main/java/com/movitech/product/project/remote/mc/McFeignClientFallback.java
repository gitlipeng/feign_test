package com.movitech.product.project.remote.mc;

import com.movitech.generics.module.base.admin.facade.model.sendmessage.MessageInModel;
import org.springframework.stereotype.Component;

/**
 * Created by Roger.Wang on 2020/1/15
 */
@Component
public class McFeignClientFallback implements McFeignService {
	@Override
	public MessageInModel saveMessage(MessageInModel messageInModel, String auth){
		System.out.println("容错处理类，当调用失败时,sorry,熔断介入");
		MessageInModel messageInModel1 = new MessageInModel();
		messageInModel1.setExtend("error");
		return messageInModel1;
	}

	@Override
	public MessageInModel saveMessage2(MessageInModel messageInModel, String auth) {
		return null;
	}

//	@Override
//	public MessageInModel saveMessage2(MessageInModel messageInModel) {
//		return null;
//	}
}
