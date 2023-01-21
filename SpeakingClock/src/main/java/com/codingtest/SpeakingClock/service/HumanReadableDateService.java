package com.codingtest.SpeakingClock.service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.lang3.StringUtils;

import com.codingtest.SpeakingClock.execeptionhandling.InvalidTimeException;

public class HumanReadableDateService {

	static Logger logger = Logger.getLogger(HumanReadableDateService.class.getName());

	private static final String ERROR_MESSAGE_1 = "Please enter correct format of time";
	private static final String ERROR_MESSAGE_2 = "The minute data was entered wrong";
	private static final String HALF_PAST = "Half past ";
	private static final String O_CLOCK = " O' Clock";
	private static final String TO = " to ";
	private static final String PAST = " past ";
	private static final String HHMM_FORMAT = "^(2[0-3]|[01]?[0-9]):([0-5]?[0-9])$";
	private static final String HH_MM = "HH:mm";

	public static void main(String[] args) {

		String time = validateThenConvertBasedOnInput(args);
		System.out.println(time);
		logger.log(Level.INFO, "Human Readable time is " + time);
	}

	public static String validateThenConvertBasedOnInput(String[] args) throws InvalidTimeException
	{
		String timeYouLike = StringUtils.EMPTY;
		
		if (args.length > 0) {
			// first validate user input
			if (userInputisValid(args)) {
				// this means that time is passed as argument
				timeYouLike = convertTimeToHumanReadableFormat(args[0]);
			} else {
				logger.log(Level.WARNING, ERROR_MESSAGE_1);
			}
		} else {
			// this means that time is not passed as argument
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern(HH_MM);
			timeYouLike = convertTimeToHumanReadableFormat(dtf.format(LocalTime.now()).toString());
		}
		String time = StringUtils.capitalize(timeYouLike);
		System.out.println(time);
		return time;
	}

	private static boolean userInputisValid(String[] args) throws InvalidTimeException{
		boolean isinputvalid = false;
		String input = args[0];
		logger.log(Level.INFO, "Arguments Passed are " + input);
		if (input.matches(HHMM_FORMAT)) {
			isinputvalid = true;
		}
		return isinputvalid;
	}

	private static String convertTimeToHumanReadableFormat(String argument) throws InvalidTimeException{
		
		if(StringUtils.isBlank(argument)) { 
			throw new InvalidTimeException("Argument is not to be blank");
		}
		
		String[] splittime = argument.split(":");
		int hour = Integer.parseInt(splittime[0]);
		int minute = Integer.parseInt(splittime[1]);

		if ((minute > 1) && (minute < 30)) {
			return WordFromNumbersEnum.getHumanMinutesFromString(splittime[1]) + PAST
					+ WordFromNumbersEnum.getHumanHoursFromString(splittime[0]);
		} else if ((minute > 30) && (minute < 59)) {
			int minutestocomplete = 60 - minute;
			int hourtocomplete = hour + 1;
			return WordFromNumbersEnum.getHumanMinutesFromString(Integer.toString(minutestocomplete)) + TO
					+ WordFromNumbersEnum.getHumanHoursFromString(Integer.toString(hourtocomplete));
		} else if ((minute == 30)) {
			return HALF_PAST + WordFromNumbersEnum.getHumanHoursFromString(splittime[0]);
		} else if ((minute == 0)) {
			return WordFromNumbersEnum.getHumanHoursFromString(splittime[0]) + O_CLOCK;
		} else {
			return ERROR_MESSAGE_2;
		}
	}

	public enum WordFromNumbersEnum {
		ONE("one"), TWO("two"), THREE("three"), FOUR("four"), FIVE("five"), SIX("six"), SEVEN("seven"), EIGHT("eight"),
		NINE("nine"), TEN("ten"), ELEVEN("eleven"), TWELVE("twelve"),

		THIRTEEN("thirteen"), FORTEEN("forteen"), FIFTEEN("fifteen"), SIXTEEN("sixteen"), SEVENTEEN("seventeen"),
		EIGHTEEN("eighteen"), NINETEEN("nineteen"), TWENTY("twenty"), TWENTYNINE("twentynine"), TWENTYONE("twentyone"),
		TWENTYTWO("twentytwo"), TWENTYTHREE("twentythree"), TWENTYFOUR("twentyfour"), TWENTYFIVE("twentyfive"),
		TWENTYSIX("twentysix"), TWENTYSEVEN("twentyseven"), TWENTYEIGHT("twentyeight");

		private final String numberInWords;

		WordFromNumbersEnum(String humanMinute) {
			this.numberInWords = humanMinute;
		}

		public String getInWords() {
			return numberInWords;
		}

		public static String getHumanMinutesFromString(String minutes) {
			switch (minutes) {
			case "01":
				return WordFromNumbersEnum.ONE.getInWords();
			case "02":
				return WordFromNumbersEnum.TWO.getInWords();
			case "03":
				return WordFromNumbersEnum.THREE.getInWords();
			case "04":
				return WordFromNumbersEnum.FOUR.getInWords();
			case "05":
				return WordFromNumbersEnum.FIVE.getInWords();
			case "06":
				return WordFromNumbersEnum.SIX.getInWords();
			case "07":
				return WordFromNumbersEnum.SEVEN.getInWords();
			case "08":
				return WordFromNumbersEnum.EIGHT.getInWords();
			case "09":
				return WordFromNumbersEnum.NINE.getInWords();
			case "10":
				return WordFromNumbersEnum.TEN.getInWords();
			case "11":
				return WordFromNumbersEnum.ELEVEN.getInWords();
			case "12":
				return WordFromNumbersEnum.TWELVE.getInWords();
			case "13":
				return WordFromNumbersEnum.THIRTEEN.getInWords();
			case "14":
				return WordFromNumbersEnum.FORTEEN.getInWords();
			case "15":
				return WordFromNumbersEnum.FIFTEEN.getInWords();
			case "16":
				return WordFromNumbersEnum.SIXTEEN.getInWords();
			case "17":
				return WordFromNumbersEnum.SEVENTEEN.getInWords();
			case "18":
				return WordFromNumbersEnum.EIGHTEEN.getInWords();
			case "19":
				return WordFromNumbersEnum.NINETEEN.getInWords();
			case "20":
				return WordFromNumbersEnum.TWENTY.getInWords();
			case "21":
				return WordFromNumbersEnum.TWENTYONE.getInWords();
			case "22":
				return WordFromNumbersEnum.TWENTYTWO.getInWords();
			case "23":
				return WordFromNumbersEnum.TWENTYTHREE.getInWords();
			case "24":
				return WordFromNumbersEnum.TWENTYFOUR.getInWords();
			case "25":
				return WordFromNumbersEnum.TWENTYFIVE.getInWords();
			case "26":
				return WordFromNumbersEnum.TWENTYSIX.getInWords();
			case "27":
				return WordFromNumbersEnum.TWENTYSEVEN.getInWords();

			case "28":
				return WordFromNumbersEnum.TWENTYEIGHT.getInWords();
			case "29":
				return WordFromNumbersEnum.TWENTYNINE.getInWords();

			}
			return null;
		}

		public static String getHumanHoursFromString(String minutes) {
			switch (minutes) {
			case "01":
			case "13":
				return WordFromNumbersEnum.ONE.getInWords();
			case "02":
			case "14":
				return WordFromNumbersEnum.TWO.getInWords();
			case "03":
			case "15":
				return WordFromNumbersEnum.THREE.getInWords();
			case "04":
			case "16":
				return WordFromNumbersEnum.FOUR.getInWords();
			case "05":
			case "17":
				return WordFromNumbersEnum.FIVE.getInWords();
			case "06":
			case "18":
				return WordFromNumbersEnum.SIX.getInWords();
			case "07":
			case "19":
				return WordFromNumbersEnum.SEVEN.getInWords();
			case "08":
			case "20":
				return WordFromNumbersEnum.EIGHT.getInWords();
			case "09":
			case "21":
				return WordFromNumbersEnum.NINE.getInWords();
			case "10":
			case "22":
				return WordFromNumbersEnum.TEN.getInWords();
			case "11":
			case "23":
				return WordFromNumbersEnum.ELEVEN.getInWords();
			case "12":
			case "00":
				return WordFromNumbersEnum.TWELVE.getInWords();
			}
			return null;
		}

	}

}
