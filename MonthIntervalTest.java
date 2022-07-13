package org.ama.assessment;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.time.LocalDate;

import org.junit.Test;


public class MonthIntervalTest {
	@Test
	public void testJanuary2017ToMarch2017ReturnsJanuaryThroughMarch() {
		LocalDate january2017= LocalDate.parse("2017-01-01");
		LocalDate march2017 = LocalDate.parse("2017-03-01");
        String[] expectedMonthNames = new String[] {"January", "February", "March"};

		String[] monthNames = MonthInterval.generateMonthsInInterval(january2017, march2017);
        for (String monthName : monthNames) {
            System.out.println(monthName);
        }
        System.out.println();

		assertEquals(expectedMonthNames, monthNames);
	}

	@Test
	public void testDecember2017ToJanuary2018ReturnsDecemberThroughJanuary() {
		LocalDate december2017= LocalDate.parse("2017-12-01");
		LocalDate january2018 = LocalDate.parse("2018-01-01");
        String[] expectedMonthNames = new String[] {"January", "December"};

		String[] monthNames = MonthInterval.generateMonthsInInterval(december2017, january2018);
        for (String monthName : monthNames) {
            System.out.println(monthName);
        }
        System.out.println();

		assertEquals(expectedMonthNames, monthNames);
	}

	@Test
	public void testJanuary2017ToJanuary2018ReturnsJanuaryThroughDecember() {
		LocalDate january2017= LocalDate.parse("2017-01-01");
		LocalDate january2018 = LocalDate.parse("2018-03-01");
        String[] expectedMonthNames = new String[] {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };

		String[] monthNames = MonthInterval.generateMonthsInInterval(january2017, january2018);
        for (String monthName : monthNames) {
            System.out.println(monthName);
        }
        System.out.println();

		assertEquals(expectedMonthNames, monthNames);
	}
	
	// Nikhil Trivedi's test starting
	
	// Write a test that checks same starting and ending day. There 
	@Test
	public void testJanuary2017ToJanuary2017ReturnsJustJanuary() {
		LocalDate january2017= LocalDate.parse("2017-01-23");
        String[] expectedMonthNames = new String[] {
        	"January"
        };
        
		String[] monthNames = MonthInterval.generateMonthsInInterval(january2017, january2017);
        for (String monthName : monthNames) {
            System.out.println(monthName);
        }
        System.out.println();

		assertEquals(expectedMonthNames, monthNames);
	}
	
	// Write a test that checks 15 days apart within the same month
	@Test
	public void testMarch2019ToMarch2019ReturnsJustMarch() {
		LocalDate date1 = LocalDate.parse("2019-03-10");
		LocalDate date2 = LocalDate.parse("2019-03-25");
        String[] expectedMonthNames = new String[] {
            "March"
        };

		String[] monthNames = MonthInterval.generateMonthsInInterval(date1, date2);
        for (String monthName : monthNames) {
            System.out.println(monthName);
        }
        System.out.println();

		assertEquals(expectedMonthNames, monthNames);
	}
	
	// Write a test that checks a time interval between two months
	@Test
	public void testMarch2020ToApril2020ReturnsJustMarchAndApril() {
		LocalDate date1 = LocalDate.parse("2020-03-03");
		LocalDate date2 = LocalDate.parse("2020-04-25");
        String[] expectedMonthNames = new String[] {
            "March", "April"
        };

		String[] monthNames = MonthInterval.generateMonthsInInterval(date1, date2);
        for (String monthName : monthNames) {
            System.out.println(monthName);
        }
        System.out.println();

		assertEquals(expectedMonthNames, monthNames);
	}
	
	// Write a test that checks 3 months apart within the same year
	// where the day index of the date1 is greater than the date2 day index
	@Test
	public void testJune2020ToAug2021ReturnsJuneThroughAug() {
		LocalDate date1 = LocalDate.parse("2020-06-25");
		LocalDate date2 = LocalDate.parse("2020-08-02");
        String[] expectedMonthNames = new String[] {
            "June", "July", "August"
        };

		String[] monthNames = MonthInterval.generateMonthsInInterval(date1, date2);
        for (String monthName : monthNames) {
            System.out.println(monthName);
        }
        System.out.println();

		assertEquals(expectedMonthNames, monthNames);
	}
	
	// Write a test that checks 9 months apart within the same year
	@Test
	public void testJan2020ToSept2021ReturnsJanThroughDecember() {
		LocalDate date1 = LocalDate.parse("2020-01-23");
		LocalDate date2 = LocalDate.parse("2020-09-04");
        String[] expectedMonthNames = new String[] {
            "January", "February", "March", "April", "May",
            "June", "July", "August", "September"
        };

		String[] monthNames = MonthInterval.generateMonthsInInterval(date1, date2);
        for (String monthName : monthNames) {
            System.out.println(monthName);
        }
        System.out.println();

		assertEquals(expectedMonthNames, monthNames);
	}
		
	// Write a test that checks two dates 9 months apart, between two separate years
	@Test
	public void testMay2020ToFebruary2021ReturnsJanFebAndMayThroughDecember() {
		LocalDate date1 = LocalDate.parse("2020-05-03");
		LocalDate date2 = LocalDate.parse("2021-02-25");
        String[] expectedMonthNames = new String[] {
            "January", "February", "May", "June", "July",
            "August", "September", "October", "November", "December"
        };

		String[] monthNames = MonthInterval.generateMonthsInInterval(date1, date2);
        for (String monthName : monthNames) {
            System.out.println(monthName);
        }
        System.out.println();

		assertEquals(expectedMonthNames, monthNames);
	}
		
	// Write a test that checks the starting and ending day of a year (364 days)
	// within the same year
	@Test
	public void testJan2020ToDec2020ReturnsJanThroughDecember() {
		LocalDate date1 = LocalDate.parse("2020-01-01");
		LocalDate date2 = LocalDate.parse("2020-12-31");
        String[] expectedMonthNames = new String[] {
            "January", "February", "March", "April", "May", "June", "July",
            "August", "September", "October", "November", "December"
        };

		String[] monthNames = MonthInterval.generateMonthsInInterval(date1, date2);
        for (String monthName : monthNames) {
            System.out.println(monthName);
        }
        System.out.println();

		assertEquals(expectedMonthNames, monthNames);
	}
	
	// Write a test that checks dates 1 year apart exactly apart
	@Test
	public void testJuly2020ToJuly2021ReturnsJanThroughDecember() {
		LocalDate date1 = LocalDate.parse("2020-07-13");
		LocalDate date2 = LocalDate.parse("2021-07-13");
        String[] expectedMonthNames = new String[] {
            "January", "February", "March", "April", "May", "June", "July",
            "August", "September", "October", "November", "December"
        };

		String[] monthNames = MonthInterval.generateMonthsInInterval(date1, date2);
        for (String monthName : monthNames) {
            System.out.println(monthName);
        }
        System.out.println();

		assertEquals(expectedMonthNames, monthNames);
	}
	
	// Write a test that checks for large date differences, such as 10 years apart
	@Test
	public void testJuly2020ToJuly2030ReturnsJanThroughDecember() {
		LocalDate date1 = LocalDate.parse("2020-07-13");
		LocalDate date2 = LocalDate.parse("2030-10-18");
        String[] expectedMonthNames = new String[] {
            "January", "February", "March", "April", "May", "June", "July",
            "August", "September", "October", "November", "December"
        };

		String[] monthNames = MonthInterval.generateMonthsInInterval(date1, date2);
        for (String monthName : monthNames) {
            System.out.println(monthName);
        }
        System.out.println();

		assertEquals(expectedMonthNames, monthNames);
	}
		
	// Nikhil Trivedi's test ending
}
