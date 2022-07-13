package org.ama.assessment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.time.Period;

public class MonthInterval {
	public static String[] generateMonthsInInterval(LocalDate startDate, LocalDate endDate) {
        String[] monthNames = null;
        
        // Nikhil Trivedi's code starting
                
        // I started by reading the project description and looking at the test cases. I have
        // refactored this assignment a couple times until I got the code as concise as possible.
        // I initially solved it via hard coding (ie: create an array with ["Sep09", "Oct10", ...]
        // But figured a more elegant solution would be to use the LocalDate functionality without 
        // hard coding 
        
        // Regarding the test "testDecember2017ToJanuary2018ReturnsDecemberThroughJanuary",
        // I was initially failing this test, and then realized that the order ought to be
        // sequential by month for this test to pass (ie: even though the date is from
        // December 2017 to January 2018, the interval in order by time is {December, January},
        // the order by sequence of months it is {January, December}). I have added the code 
        // to order by sequence of months
        
        // Regarding the test "testJanuary2017ToJanuary2018ReturnsJanuaryThroughDecember", the
        // dates it passes are 2017-01-01 to 2018-03-01, meaning we repeat three months (January, 
        // February and March). The test data didn't have this, so I assumed in all cases, if there
        // ever is a repeat in months (ie: dates more than a year apart), then do not repeat months
        // in the returned array
        
        // Based on these assumptions, I have written several additional test cases
        
        // Since we only care about the months inclusive and not the days in between,
        // set both dates to the same day (ie: 1). This ensures we cover all months
        // and don't fail edge cases in which the startDate day is after the endDate day.
        // In that edge case, the month is one less than we want
        startDate = startDate.withDayOfMonth(1);
        endDate = endDate.withDayOfMonth(1);
        
        // Use an array list, since we need dynamic adding
        ArrayList<String> monthsArrayList = new ArrayList<String>();
         
        // Calculate the difference between the dates
        Period period = Period.between(startDate, endDate);
        
        // If the difference between the dates is greater than 1 year, then we can
        // simply loop through all months starting with January (ie: iterate up to index 11 from index 0). 
        // If the difference between the dates is less than a year, the later months may be excluded. 
        // This cutoff of where we stop is just the number of months in the calculated difference
        // between the dates

        // All of this can be covered with the statement below
        
        int idx = (period.getYears() > 0) ? 11 : period.getMonths();
        
        for(int i = 0; i <= idx; i++) {
        	String startDateString = startDate.getMonth().toString();
        	
        	// This line converts the all capitalized string to just the first letter being capitalized 
        	monthsArrayList.add(startDateString.substring(0, 1) + startDateString.toLowerCase().substring(1, startDateString.length()));
        	
        	// This line increments the month to the next one
        	// The loop expires when we need to stop (ie: when our calculated idx value is hit)
        	startDate = startDate.plusMonths(1);
        }

        // We now have an array, we just need to sort it sequentially 
        Collections.sort(monthsArrayList,  new Comparator<String>() {
            public int compare(String o1, String o2) {
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("MMM");
                    return sdf.parse(o1).compareTo(sdf.parse(o2));
                } catch (ParseException ex) {
                    return o1.compareTo(o2);
                }
            }
        });
                
        // Last step
        // Since the the method returns a string array, convert my 
        // array list to a string array and return this
        monthNames = new String[monthsArrayList.size()];
        for (int i = 0; i < monthsArrayList.size(); i++) {
        	monthNames[i] = monthsArrayList.get(i);
        }
             
		// Nikhil Trivedi's code ending

        return monthNames;
	 }
}
