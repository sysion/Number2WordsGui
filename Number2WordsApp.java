package com.sysionng.numbertowordsgui;

import java.io.OutputStream;
import com.sysionng.numbertowordsgui.Number2WordsAppGui;
import com.sysionng.numbertowordsgui.Number2WordsUtility;


public class Number2WordsApp {

	public static void main(String[] args) {

		/*//moved to GUI i.e. Number2WordsAppGui
		Number2Words mNumber2Words = new Number2Words(Number2WordsUtility.GetNumber());
		String mNumberInWords = mNumber2Words.ConvertNumber2Words();

		System.out.println(mNumberInWords);*/

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Number2WordsAppGui();
			}
		});



	}


}