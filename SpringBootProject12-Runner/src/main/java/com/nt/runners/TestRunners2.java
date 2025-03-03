package com.nt.runners;

import java.util.Set;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class TestRunners2 implements ApplicationRunner {

    public TestRunners2() {
        System.out.println("TestRunners2::0-param constructor");
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("TestRunners2.run()");
        System.out.println("Non-option args:: " + args.getNonOptionArgs());
        Set<String> names = args.getOptionNames();
        System.out.println("Option args are");

        for (String name : names) {
            System.out.println(name + "....." + args.getOptionValues(name));
        }
        System.out.println("______________________________");
    }
}
