package com.poalim.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Utils {


	/**
	 * get the last day of current month/year 
	 * @return
	 */
	public static String getLastDateInCurMonthAndYear() {
		LocalDate currentdate = LocalDate.now();
		LocalDate convertedDate = currentdate.withDayOfMonth(
				currentdate.getMonth().length(currentdate.isLeapYear()));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String dateStr = convertedDate.format(formatter);
		
		return dateStr;
	}
	
	/**
	 * get the first day of current month/year 
	 * @return
	 */

	public static String getFirstDateInCurMonthAndYear() {
		LocalDate currentdate = LocalDate.now();
		LocalDate convertedDate = currentdate.withDayOfMonth(1);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String dateStr = convertedDate.format(formatter);
		
		return dateStr;
	}
	
}
