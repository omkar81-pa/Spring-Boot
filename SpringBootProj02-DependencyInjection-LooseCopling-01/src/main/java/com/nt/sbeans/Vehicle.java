package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

@Configuration("vehicle")
public class Vehicle {

	@Autowired
	@Qualifier("motor")
	private IEngine engine;
	
	 public String journey(String start, String end) {
	        engine.startEngine();
	        
	        String journeyDetails = "Journey started from " + start + "\n" +
	                                "Journey on going\n" +
	                                "Journey stopped in " + end;
	        
	        engine.stopEngine();
	        return journeyDetails;
	        
	    }
}
