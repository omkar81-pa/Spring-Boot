package com.nt.sbeans;

import java.util.Random;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration("sgBat")
@Lazy
public class SGBat implements ICriketBat {

	public SGBat() {
		System.out.println("SGBat:: 0-param constroctor");
	}

	@Override
	public int scoreRuns() {
		System.out.println("SGBat.scoreRuns()");
		int score = new Random().nextInt(300);
		return score;
	}

}
