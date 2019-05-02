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
	public String Validate() throws ProcessingException, IOException
	{
		File schemaFile = ResourceUtils.getFile("classpath:input-schema/schema.json");
	    File jsonFile = ResourceUtils.getFile("classpath:input-schema/data.json");
	    	
	    if (ValidationUtils.isJsonValid(schemaFile, jsonFile)){
	    	System.out.println("Valid!");
	    	return "Valid!";
	    }else{
	    	System.out.println("NOT valid!");
	    	return "NOT valid!";
	    }
	}

}
