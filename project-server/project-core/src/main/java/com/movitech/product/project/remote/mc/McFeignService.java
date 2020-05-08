package com.movitech.product.project.remote.mc;

import com.movitech.generics.framework.config.RemoteFeignConfig;
import com.movitech.generics.module.base.admin.facade.model.sendmessage.MessageInModel;
import feign.Headers;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Roger.Wang on 2020/1/15
 */
@Component
@FeignClient(name="${remoteServer.mcServer.serverName}",
		url = "${remoteServer.mcServer.serverUrl}",
//		fallback = McFeignClientFallback.class,
		fallbackFactory=McFeignClientFallbackFactory.class,
		configuration = RemoteFeignConfig.class)
public interface McFeignService {

    @RequestMapping(method = RequestMethod.POST, value = "/messagecenter/saveMessage",
			produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	MessageInModel saveMessage(@RequestBody MessageInModel messageInModel, @RequestHeader("Auth") String auth);


	@RequestMapping(method = RequestMethod.POST, value = "/messagecenter/saveMessage",
			headers = {"Auth={Auth}"},
			produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	MessageInModel saveMessage2(@RequestBody MessageInModel messageInModel,@RequestParam("Auth") String auth);
}
