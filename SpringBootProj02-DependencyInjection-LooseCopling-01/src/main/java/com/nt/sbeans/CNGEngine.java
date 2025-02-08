package com.nt.sbeans;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration("cEngine")
@Lazy
public class CNGEngine implements IEngine {
	
	public CNGEngine() {
		System.out.println("CNGEngine:: 0-param constructor");
	}

	@Override
	public void startEngine() {
		System.out.println("CNGEngine:: startEngine()");
	}

	@Override
	public void stopEngine() {
		System.out.println("CNGEngine:: stopEngine()");
	}

}
