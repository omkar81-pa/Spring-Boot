package com.nt.sbeans;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration("eEngine")
@Lazy
public class ElectricEngine implements IEngine {

	public ElectricEngine() {
		System.out.println("ElectricEngine:: 0-param constructor");
	}
	@Override
	public void startEngine() {
		System.out.println("ElectricEngine:: startEngine()");
	}

	@Override
	public void stopEngine() {
		System.out.println("ElectricEngine:: stopEngine()");
	}

}
