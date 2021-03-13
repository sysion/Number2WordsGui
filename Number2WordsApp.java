package com.sysionng.numbertowords;

import java.io.OutputStream;
import com.sysionng.numbertowords.Number2Words;
import com.sysionng.numbertowords.Number2WordsUtility;


public class Number2WordsApp {

	public static void main(String[] args) {

		Number2Words mNumber2Words = new Number2Words(Number2WordsUtility.GetNumber());
		String mNumberInWords = mNumber2Words.ConvertNumber2Words();

		System.out.println(mNumberInWords);
	}


}