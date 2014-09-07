package com.tnc.utils;

import java.io.UnsupportedEncodingException;

public class SqlUtils 
{

	public SqlUtils() {
	}
	
	public static String getString(String aVal) {
        if (aVal != null) {
        	aVal = aVal.trim();
        } else {
        	aVal = "";
        }

        return aVal;
    }

	public static char getChar(String str) {
        String tmp = getString(str);

        if (tmp.length() == 0) {
            return (char)0;
        } else {
            return tmp.toCharArray()[0];
        }
    }
	
	public static String enCode(String value) {
		String result = null;
		try {
			result = new String(value.getBytes("ISO8859-1"), "MS874");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}
}
