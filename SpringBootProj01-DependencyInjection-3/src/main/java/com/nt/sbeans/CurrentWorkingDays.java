package com.nt.sbeans;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wmg")
public class CurrentWorkingDays {

    @Autowired
    private LocalDateTime lDateTime;

    public String generateMessage(String user) {
        DayOfWeek day = lDateTime.getDayOfWeek();

        if (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY) {
            return "Enjoy your weekend, " + user;
        } else {
            return "Happy working day, " + user;
        }
    }
}
