package com.nt.sbeans;

import java.util.Random;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration("ssBat")
@Lazy
public class SSBat implements ICriketBat {

	public SSBat() {
		System.out.println("SSBat:: 0-param constructor");
	}

	@Override
	public int scoreRuns() {
		System.out.println("SSBat.scoreRuns()");
		return  new Random().nextInt(300);
	}
}
