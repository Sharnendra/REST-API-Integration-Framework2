package com.service.proxy.testcontroller;

import java.io.File;
import java.io.IOException;

import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.service.proxy.utility.ValidationUtils;

@RestController
public class TestController {
	
	@GetMapping("/validateJson")
	public String data() throws ProcessingException, IOException{
		
		File schemaFile = ResourceUtils.getFile("classpath:input-schema/schema.json");
	    String jsonFile = "{\r\n" + 
	    		"    \"id\": 1,\r\n" + 
	    		"    \"name\": \"A green door\",\r\n" + 
	    		"    \"price\": 12.50,\r\n" + 
	    		"    \"tags\": [\"home\", \"green\"]\r\n" + 
	    		"}";
	    	
	    if (ValidationUtils.isJsonValid(schemaFile, jsonFile)){
	    	System.out.println("Valid!");
	    	return "Valid!";
	    }else{
	    	System.out.println("NOT valid!");
	    	return "NOT valid!";
	    }
    }
}
