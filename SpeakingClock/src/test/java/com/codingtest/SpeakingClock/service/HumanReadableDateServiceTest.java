package com.codingtest.SpeakingClock.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.codingtest.SpeakingClock.service.HumanReadableDateService;

public class HumanReadableDateServiceTest {
	@Test
	void testTimeTwo() {
		String[] argument = { "14:00" };
		String humanreadableTime = "Two O' Clock";
		assertTrue(HumanReadableDateService.validateThenConvertBasedOnInput(argument).equals(humanreadableTime));
	}

	@Test
	void testTimeTwoThirty() {
		String[] argument = { "14:30" };
		String humanreadableTime = "Half past two";
		assertTrue(HumanReadableDateService.validateThenConvertBasedOnInput(argument).equals(humanreadableTime));
	}

	@Test
	void testTimeTwoFifteen() {
		String[] argument = { "14:15" };
		String humanreadableTime = "Fifteen past two";
		assertTrue(HumanReadableDateService.validateThenConvertBasedOnInput(argument).equals(humanreadableTime));
	}

	@Test
	void testTimeTwoFortyFive() {
		String[] argument = { "14:45" };
		String humanreadableTime = "Fifteen to three";
		assertTrue(HumanReadableDateService.validateThenConvertBasedOnInput(argument).equals(humanreadableTime));
	}
}
