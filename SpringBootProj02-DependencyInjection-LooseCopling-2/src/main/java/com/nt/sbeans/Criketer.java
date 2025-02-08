package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration("criket")
@Lazy
public class Criketer {

	@Autowired
	@Qualifier("motor")
	private ICriketBat criketBat;

	public Criketer() {
		System.out.println("Criketer:: 0-param constructor");
	}

	public String batting() {
		System.out.println("Criketer.batting()");
		
		int runs = criketBat.scoreRuns();
		
		return "Criketer has scored "+runs+" runs";
	}
}
