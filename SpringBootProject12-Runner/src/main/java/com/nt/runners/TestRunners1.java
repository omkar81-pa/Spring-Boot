package com.nt.runners;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestRunners1 implements CommandLineRunner {

    public TestRunners1() {
        System.out.println("TestRunners1::0-param constructor");
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("TestRunners1.run()");
        System.out.println("The args are:: " + Arrays.toString(args));
        
        System.out.println("____________________________");
    }
}
