package com.codingtest.SpeakingClock.convertRestAPI;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingtest.SpeakingClock.service.HumanReadableDateService;

@RestController
public class HumanReadableController {

	@GetMapping(path = "/api/humanfriendlytext", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getTime(@RequestParam(required = false) String time) {
		// Get data from service layer into entityList.

		String data = StringUtils.EMPTY;
		if (time != null) {
			String[] timedata = { time };
			data = HumanReadableDateService.validateThenConvertBasedOnInput(timedata);

		} else {
			data = HumanReadableDateService.validateThenConvertBasedOnInput(new String[0]);
		}
		return ResponseEntity.status(HttpStatus.OK).body(Map.of("Human readableDate", data));

	}
}
