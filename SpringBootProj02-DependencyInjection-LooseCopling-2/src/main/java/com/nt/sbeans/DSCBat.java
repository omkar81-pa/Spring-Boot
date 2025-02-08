package com.nt.sbeans;

import java.util.Random;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration("ddscBat")
@Lazy
public class DSCBat implements ICriketBat {

	public DSCBat() {
		System.out.println("DSCBat:: 0-param constructor");
	}
	@Override
	public int scoreRuns() {
		System.out.println("DSCBat.scoreRuns()");
		return new Random().nextInt(300);
	}

}
