package com.sysionng.numbertowords;

import java.io.OutputStream;
import java.util.Scanner;
import java.util.HashMap;
import java.lang.Long;


public class Number2WordsUtility {
	/*
	//this is not working
	public static HashMap<Integer, String> mNumberDict = new HashMap<Integer, String>();

	mNumberDict.put(1, "one"); 
	mNumberDict.put(2, "two"); 
	mNumberDict.put(3, "three"); 
	mNumberDict.put(4, "four"); 
	mNumberDict.put(5, "five"); 
	mNumberDict.put(6, "six"); 
	mNumberDict.put(7, "seven");
	mNumberDict.put(8, "eight");
	mNumberDict.put(9, "nine"); 
	mNumberDict.put(10, "ten"); 
	mNumberDict.put(11, "eleven"); 
	mNumberDict.put(12, "twelve"); 
	mNumberDict.put(13, "thirteen"); 
	mNumberDict.put(14, "fourteen");
	mNumberDict.put(15, "fifteen"); 
	mNumberDict.put(16, "sixteen"); 
	mNumberDict.put(17, "seventeen"); 
	mNumberDict.put(18, "eighteen"); 
	mNumberDict.put(19, "nineteen");
	mNumberDict.put(20, "twenty"); 
	mNumberDict.put(30, "thirty"); 
	mNumberDict.put(40, "fourty"); 
	mNumberDict.put(50, "fifty"); 
	mNumberDict.put(60, "sixty"); 
	mNumberDict.put(70, "seventy");
	mNumberDict.put(80, "eighty"); 
	mNumberDict.put(90, "ninety"); 
	mNumberDict.put(100, "hundred"); 
	mNumberDict.put(1000, "thousand"); 
	mNumberDict.put(1000000, "million");
	mNumberDict.put(1000000000, "billion");*/

	//public static HashMap<Integer, String> mNumberDict(int numKey) {
	public static String mNumberDict(long numKey) {
		HashMap<Long, String> numberDict = new HashMap<Long, String>();

		numberDict.put(1L, "one"); 
		numberDict.put(2L, "two"); 
		numberDict.put(3L, "three"); 
		numberDict.put(4L, "four"); 
		numberDict.put(5L, "five"); 
		numberDict.put(6L, "six"); 
		numberDict.put(7L, "seven");
		numberDict.put(8L, "eight");
		numberDict.put(9L, "nine"); 
		numberDict.put(10L, "ten"); 
		numberDict.put(11L, "eleven"); 
		numberDict.put(12L, "twelve"); 
		numberDict.put(13L, "thirteen"); 
		numberDict.put(14L, "fourteen");
		numberDict.put(15L, "fifteen"); 
		numberDict.put(16L, "sixteen"); 
		numberDict.put(17L, "seventeen"); 
		numberDict.put(18L, "eighteen"); 
		numberDict.put(19L, "nineteen");
		numberDict.put(20L, "twenty"); 
		numberDict.put(30L, "thirty"); 
		numberDict.put(40L, "fourty"); 
		numberDict.put(50L, "fifty"); 
		numberDict.put(60L, "sixty"); 
		numberDict.put(70L, "seventy");
		numberDict.put(80L, "eighty"); 
		numberDict.put(90L, "ninety"); 
		numberDict.put(100L, "hundred"); 
		numberDict.put(1000L, "thousand"); 
		numberDict.put(1000000L, "million");
		numberDict.put(1000000000L, "billion");

		if (numberDict.containsKey(numKey))
			return numberDict.get(numKey);
		else
			return numKey + " is outside range of number for this application.";
	}

	public static long GetNumber() {
		long inpNumber = -1;
		String tmpNumber = "";

		Scanner scanner = new Scanner(System.in);
		//inpNumber = scanner.nextLine().trim();

		//System.out.println("Type number, press Enter; type q and press Enter to finish.");
		System.out.println("Type number to convert (or q to exit) and press Enter.");

		//while (! inpNumber.equals("q") && scanner.hasNext()){
		/*//nok
		while (! scanner.hasNext("q")){
			inpNumber = scanner.nextLine().trim();

			//if (inpNumber.equals("q")) break;

			if (inpNumber.equals("")) {
				System.out.println("Input number can not be empty !!!");
				break;
			}

		}*/


		//ok
		while (scanner.hasNext()) {
			tmpNumber = scanner.nextLine().trim();

			if (tmpNumber.equals("q")) {
				break;
			}
			else if (tmpNumber.equals("")) {
				System.out.println("Input number can not be empty !!!");
				break;
			}
			else {
				//Integer.valueOf() returns a new Integer()
				//Integer.parseInt() returns a primitive int

				//inpNumber = Integer.parseInt(tmpNumber);
				//break;
				try {
			        inpNumber = Long.parseLong(tmpNumber);
					break;
			    } catch (NumberFormatException e) {
			        System.out.println("Couldn't parse input to Number format : " + e);
			    }

				

				//while (! inpNumber.isNumeric()){}
			}
		}

		if (inpNumber == -1){
			System.out.println("No valid input, exiting . . .");
			System.exit(0);
		}

		return inpNumber;
	}

}