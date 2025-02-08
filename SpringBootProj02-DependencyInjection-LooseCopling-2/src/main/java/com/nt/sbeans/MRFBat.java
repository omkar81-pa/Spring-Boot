package com.nt.sbeans;

import java.util.Random;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration("mrfBat")
@Lazy
public class MRFBat implements ICriketBat {
	
	public MRFBat() {
		System.out.println("MRFBat:: 0-param constructor");
	}

	@Override
	public int scoreRuns() {
		System.out.println("MRFBat.scoreRuns()");
		int score = new Random().nextInt(300);
		return score;
	}

}
