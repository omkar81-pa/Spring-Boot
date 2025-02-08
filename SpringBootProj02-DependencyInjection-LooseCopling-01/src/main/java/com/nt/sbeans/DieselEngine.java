package com.nt.sbeans;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration("dEngine")
@Lazy
public class DieselEngine implements IEngine {

	public DieselEngine() {
		System.out.println("DieselEngine:: 0-param constructor");
	}
	@Override
	public void startEngine() {
		System.out.println("DieselEngine:: startEngine()");
	}

	@Override
	public void stopEngine() {
		System.out.println("DieselEngine:: stopEngine()");
	}

}
