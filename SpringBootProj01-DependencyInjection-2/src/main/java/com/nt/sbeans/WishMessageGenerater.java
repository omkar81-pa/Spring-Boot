package com.nt.sbeans;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wmg")
public class WishMessageGenerater {

	@Autowired
	private LocalDateTime lDateTime;

	public String generatMessage(String user1, String user2) {
		int hour = lDateTime.getHour();

		String greeting;
		String reply;

		if (hour >= 6 && hour < 12) {
			greeting = "Good Morning " + user1;
			reply = "Good Morning! " + user2 + " Have a great day!";
		} else if (hour >= 12 && hour < 17) {
			greeting = "Good Afternoon " + user1;
			reply = "Good Afternoon! " + user2 + " Hope you're doing well!";
		} else if (hour >= 17 && hour < 21) {
			greeting = "Good Evening " + user1;
			reply = "Good Evening! " + user2 + " How was your day?";
		} else {
			greeting = "Good Night " + user1;
			reply = "Good Night! " + user2 + " Sweet dreams!";
		}

		return greeting + "\n" + reply;
	}
}
