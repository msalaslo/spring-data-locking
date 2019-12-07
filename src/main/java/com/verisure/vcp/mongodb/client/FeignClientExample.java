package com.verisure.vcp.mongodb.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.verisure.vcp.mongodb.api.dto.ItemDTO;

/**
 * Sample Spring Feign client used as template. <b>Please remove for actual project implementation.</b>
 *
 * @since 3.0.0
 * @author FaaS [faas@securitasdirect.es]
 */
@FeignClient(url="http://localhost:8080", name="feignExample")
public interface FeignClientExample {

	   @RequestMapping("/remote")
	   public List<ItemDTO> getItems();	   

}
