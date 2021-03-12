package com.sysionng.numbertowords;

import java.io.OutputStream;
import java.lang.String;
//import java.util.HashMap;
//import java.util.HashSet;
import com.sysionng.numbertowords.Number2WordsUtility;


public class Number2Words {

	private long numInput = -1;

	public Number2Words(long numInput) {
		this.numInput = numInput;
	}

	protected String ConvertNumber2Words() {
		String num2words = "";
		int numLength = String.valueOf(numInput).length();
		//int numLength = (int) Math.log10(numInput) + 1;

		//HashMap<Integer, String> numDict = Number2WordsUtility.mNumberDict();
		//Set<Integer> numDictKey = new HashSet<>(); 
		//numDictKey = numDict.keySet();

		switch (numLength) {
			default:
			case 1:
				num2words = Number2WordsUtility.mNumberDict(numInput);
				break;
			case 2:
				num2words = TwoDigitsNumber();
				break;
			case 3:
				num2words = ThreeDigitsNumber();
				break;
			case 4:
			case 5:
			case 6:
				num2words = Four2SixDigitsNumber();
				break;
			case 7:
			case 8:
			case 9:
				//num2words = Seven2NineDigitsNumber();
				break;
			case 10:
			case 11:
			case 12:
				//num2words = Ten2TwelveDigitsNumber();
				break;
			case 13:
				//num2words = Number2WordsUtility.mNumberDict(numInput);
				break;
		}

		/*switch (numInput) {
			case (numInput >= numDict.get()):
		}*/

		//return String.valueOf(numInput);		//testing
		return num2words;
	}

	private String TwoDigitsNumber(){
		String number2words = "";

		if (numInput >= 10L && numInput <=20L){
			number2words = Number2WordsUtility.mNumberDict(numInput);
		}
		else if (numInput > 20L && numInput < 100L){
			if (numInput == 30L || numInput == 40L || numInput == 50L || 
							numInput == 60L || numInput == 70L || numInput == 80L || numInput == 90L) {
				number2words = Number2WordsUtility.mNumberDict(numInput);
			}
			else {
				long unitDigit = numInput % 10L;
				long tensDigit = numInput / 10L;
				tensDigit = 10 * tensDigit;
				number2words = Number2WordsUtility.mNumberDict(tensDigit) + " " + Number2WordsUtility.mNumberDict(unitDigit);
			}
		}

		return number2words;
	}

	private String ThreeDigitsNumber(){
		String number2words = "";
		long hundred = 100L;
		String joinNumber = "and";

		if (numInput >= 100L && numInput < 1000L){
			if (numInput == 100L){ 
				long hundredDigit = numInput / 100L;
				number2words = Number2WordsUtility.mNumberDict(hundredDigit) + " " + Number2WordsUtility.mNumberDict(hundred);
			}
			else {
				long hundredDigit = numInput / 100L;
				long twoDigits = numInput - (hundredDigit * 100);
				long unitDigit = twoDigits % 10L;
				long tensDigit = twoDigits - unitDigit;

				number2words = Number2WordsUtility.mNumberDict(hundredDigit) + " " 
								+ Number2WordsUtility.mNumberDict(hundred) + " " 
								+ joinNumber + " " 
								+ Number2WordsUtility.mNumberDict(tensDigit) + " " 
								+ Number2WordsUtility.mNumberDict(unitDigit);
			}
		}

		return number2words;
	}

	private String Four2SixDigitsNumber(){
		String number2words = "";
		long hundred = 100L;
		long thousand = 1000L;
		String joinNumber = "and";
		long thousandDigit = 0L;
		long threeDigit = 0L;
		long hundredDigit = 0L;
		long twoDigits = 0L;
		long unitDigit = 0L;
		long tensDigit = 0L;

		if (numInput >= 1000L && numInput < 1000000L){
			if (numInput == 1000L){ 
				thousandDigit = numInput / 1000L;
				number2words = Number2WordsUtility.mNumberDict(thousandDigit) + " " + Number2WordsUtility.mNumberDict(thousand);
			}
			else {
				thousandDigit = numInput / 1000L;
				threeDigit = numInput - (thousandDigit * 1000);
				hundredDigit = threeDigit / 100L;
				twoDigits = threeDigit - (hundredDigit * 100);
				unitDigit = twoDigits % 10L;
				tensDigit = twoDigits - unitDigit;

				int thousandLen = (int) Math.log10(thousandDigit) + 1;

				if (thousandLen == 1){
					number2words = Number2WordsUtility.mNumberDict(thousandDigit) + " " + Number2WordsUtility.mNumberDict(thousand) + ", ";
				}
				else if (thousandLen == 2){
					if (thousandDigit >= 10L && thousandDigit <=20L){
						number2words = Number2WordsUtility.mNumberDict(thousandDigit) + " " + Number2WordsUtility.mNumberDict(thousand) + ", ";
					}
					else if (thousandDigit > 20L && thousandDigit < 100L){
						hundredDigit = thousandDigit / 100L;
						twoDigits = thousandDigit - (hundredDigit * 100);
						unitDigit = twoDigits % 10L;
						tensDigit = twoDigits - unitDigit;

						number2words = number2words + Number2WordsUtility.mNumberDict(hundredDigit) + " " 
									+ Number2WordsUtility.mNumberDict(hundred) + " " 
									+ joinNumber + " " 
									+ Number2WordsUtility.mNumberDict(tensDigit) + " " 
									+ Number2WordsUtility.mNumberDict(unitDigit) + " " 
									+ Number2WordsUtility.mNumberDict(thousand) + ", ";
					}
				}
				else if (thousandLen == 3){
					if (thousandDigit >= 100L && thousandDigit < 1000L){
						if (thousandDigit == 100L){ 
							hundredDigit = numInput / 100L;
							number2words = Number2WordsUtility.mNumberDict(hundredDigit) + " " 
											+ Number2WordsUtility.mNumberDict(hundred) + " " 
											+ Number2WordsUtility.mNumberDict(thousand) + ", ";
						}
						else {
							hundredDigit = thousandDigit / 100L;
							twoDigits = thousandDigit - (hundredDigit * 100);
							unitDigit = twoDigits % 10L;
							tensDigit = twoDigits - unitDigit;

							number2words = Number2WordsUtility.mNumberDict(hundredDigit) + " " 
											+ Number2WordsUtility.mNumberDict(hundred) + " " 
											+ joinNumber + " " 
											+ Number2WordsUtility.mNumberDict(tensDigit) + " " 
											+ Number2WordsUtility.mNumberDict(unitDigit) + " " 
											+ Number2WordsUtility.mNumberDict(thousand) + ", ";
						}
					}

				}

				System.out.println("thousandDigit = "+thousandDigit);
				System.out.println("hundredDigit = "+hundredDigit);
				System.out.println("tensDigit = "+tensDigit);
				System.out.println("unitDigit = "+unitDigit);

				number2words = number2words + Number2WordsUtility.mNumberDict(hundredDigit) + " " 
								+ Number2WordsUtility.mNumberDict(hundred) + " " 
								+ joinNumber + " " 
								+ Number2WordsUtility.mNumberDict(tensDigit) + " " 
								+ Number2WordsUtility.mNumberDict(unitDigit);
			}
		}

		return number2words;
	}

}//