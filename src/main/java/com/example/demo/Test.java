package com.example.demo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test {
	public static void main(String args[]) throws ParseException{
//		String oldDate = "2021-07-13";  

//		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//			Calendar cal = Calendar.getInstance();
//			System.out.println("Current Date: "+sdf.format(cal.getTime()));
//			//Adding 1 Day to the current date
//			cal.add(Calendar.DAY_OF_MONTH, 1);  
//			//Date after adding one day to the current date
//			String newDate = sdf.format(cal.getTime());  
//			//Displaying the new Date after addition of 1 Day
//			System.out.println("Incremnted current date by one: "+newDate);
//			  Date parse = sdf.parse(newDate);
//			System.out.println("Incremnted current date by one: "+parse);
//			
//			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
//			String strDate = "2000-01-01";
//			Date date = sdf1.parse(strDate);
//			System.out.println(date);
//			
			 SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
		      Date d1 = sdformat.parse("2021-08-12");
		      Date d2 = sdformat.parse("2021-08-12");
		      System.out.println("The date 1 is: " + sdformat.format(d1));
		      System.out.println("The date 2 is: " + sdformat.format(d2));
		      if(d1.compareTo(d2) > 0) {
		         System.out.println("Date 1 occurs after Date 2");
		      } else if(d1.compareTo(d2) < 0) {
		         System.out.println("Date 1 occurs before Date 2");
		      } else if(d1.compareTo(d2) == 0) {
		         System.out.println("Both dates are equal");
		      }
	}
}
