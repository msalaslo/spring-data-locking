package com.verisure.vcp.mongodb.client;

import java.util.List;

import com.verisure.vcp.mongodb.api.dto.ItemDTO;

/**
 * Sample Spring Rest Template client used as template. <b>Please remove for actual project implementation.</b>
 *
 * @since 3.0.0
 * @author FaaS [faas@securitasdirect.es]
 */
public interface RestTemplateClientExample {
	
	public List<ItemDTO> getItems();

}
