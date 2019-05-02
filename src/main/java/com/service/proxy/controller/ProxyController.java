package com.service.proxy.controller;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProxyController {
	
	@RequestMapping("/header")
	public String checkHeader(@RequestHeader(value="service_type",required=true) String service_type) {
		return "Hearder Requred";
		
	}

}
