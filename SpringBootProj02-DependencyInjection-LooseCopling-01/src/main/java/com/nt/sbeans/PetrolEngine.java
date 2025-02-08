package com.nt.sbeans;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration("pEngine")
@Lazy
public class PetrolEngine implements IEngine {

	public PetrolEngine() {
		System.out.println("PetrolEngine:: 0-param constroctor");
	}
	@Override
	public void startEngine() {
		System.out.println("PetrolEngine:: startEngine()");
	}

	@Override
	public void stopEngine() {
		System.out.println("PetrolEngine:: stopEngine()");
	}

}
