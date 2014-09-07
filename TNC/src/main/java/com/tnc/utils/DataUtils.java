package com.tnc.utils;

public class DataUtils 
{
    public static String convertThaiAscii2Unicode(String inputStr)
    {
    	if (inputStr == null) return "";
		String outputStr = "";
		char c;
		for (int i=0; i<inputStr.length(); i++)
		{
			c = inputStr.charAt(i);
			if (c > 160) c = (char)(c + 0xE00 - 160);
			outputStr += c;
		}
		return outputStr;
    }
}
