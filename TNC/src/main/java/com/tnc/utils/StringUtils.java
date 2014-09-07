package com.tnc.utils;

import java.io.FileInputStream;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Properties;

public class StringUtils {

	public static String getThai(String str)
	{
		String ostr = "";
		
		if (str == null) return "";
		try 
		{
			ostr = new String(str.getBytes("MS874"),"ISO8859_1");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ostr;		
/*		String ostr="";
		if(str!=null)
		{
		try
		{
			byte[] test=str.getBytes();
			for(int i=0;i<test.length;i++)
			{
				System.out.printf("%H\n", test[i]);
				if(test[i]==63)
				{
					ostr=new String(str.getBytes("ISO8859_1"),"MS874");
					return ostr;
				}
			}
			
		}
		catch (Exception e)
		{
			//
		}
		}
		return str;*/
	}
	
	public static String removeControlString(String str)
	   {
		   StringBuilder ostr = new StringBuilder();
		   for (int i=0;i<str.length();i++)
		   {
			   char ch = str.charAt(i);
			  if (!Character.isISOControl(ch) 
				  && (((int) ch) != 0)  // NULL CHAR
				  )
			  {
				  ostr.append(ch);
			  }
		   }
		   return ostr.toString();
	   }
	
	public static String getThai(String str, String enc1, String enc2)
	{
		String ostr = "";
		
		if (str == null) return "";
		try 
		{
			ostr = new String(str.getBytes(enc1),enc2);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ostr;		
/*		String ostr="";
		if(str!=null)
		{
		try
		{
			byte[] test=str.getBytes();
			for(int i=0;i<test.length;i++)
			{
				System.out.printf("%H\n", test[i]);
				if(test[i]==63)
				{
					ostr=new String(str.getBytes("ISO8859_1"),"MS874");
					return ostr;
				}
			}
			
		}
		catch (Exception e)
		{
			//
		}
		}
		return str;*/
	}

	public String formatDate(Date val, String format){
		return formatDateDef(val, format, "");
	}
	
	public String formatDateDef(Date val, String format, String def){
		String buf = "";
		if (val != null){
			DateFormat formatter = new SimpleDateFormat(format, Locale.US);
			buf = formatter.format(val);
		} else if (def != null) {
			buf = def;
		} else {
			buf = "";
		}
		return buf;
	}
	
	public String formatDate(Timestamp val, String format){
		return formatDateDef(val, format, "");
	}
	/*
	public String formatDateDef(Timestamp val, String format, String def){
		//String buf = "";
		if(val != null){
			Date d = new Date(val.getYear(), val.getMonth(), val.getDate());
			return formatDateDef(d, format, def);
		} else if (def != null) {
			return def;
		} else {
			return "";
		}
	}
	*/
	public String formatDate(java.util.Date val, String format) {
		return formatDateDef(val, format, "");
	}
	public String formatDateDef(java.util.Date val, String format, String def){
		String buf = "";
		if (val != null){
			DateFormat formatter = new SimpleDateFormat(format, Locale.US);
			buf = formatter.format(val);
		} else if (def != null) {
			buf = def;
		} else {
			buf = "";
		}
		return buf;
	}
	
	public String getNowDate(){				 
	    Calendar cal = Calendar.getInstance();     
		DateFormat format1 = new SimpleDateFormat( "dd/MM/yyyy", Locale.US );
		String buf =  format1.format(cal.getTime());
		//String buf = cal.toString() ;		
		return buf;
	}		
	
	public Date getNow(){
		Calendar cal = Calendar.getInstance();
		Date d = new Date(cal.getTime().getTime());
		return d;
	}
	
	public Timestamp getNowTimestamp(){
	    Calendar cal = Calendar.getInstance();     
		Timestamp result = new Timestamp(cal.getTime().getTime());
		//String buf = cal.toString() ;		
		return result;
	}
	
	public String stringDef(String val, String def){
		String s = "";
		try {
			if (val != null){
				s = val.trim();
			} else {
				if (def != null){
					s = def.trim();
				} else {
					s = "";
				}
			}
		} catch (Exception e){
			System.out.println(e);
		}
		return s;
	}
	
	public String checkNull(Object val){
		if (val==null)
			return "";
		else
			return String.valueOf(val);
	}	
	
	public String checkNull(String val){
		return stringDef(val, "");
	}

	public String dateToStringDef(Date val, String def){
		if (val == null){
			if (def != null){
				return def;
			} else {
				return "";
			}
		} else {
			return formatDate(val, "dd/MM/yyyy");
		}
	}
	
	public String numToString(double val){
		String s;
		DecimalFormat formatter = new DecimalFormat("#,##0.0"); 
		s = formatter.format(val);
		return s;
	}

	public String formatNum(double val, String format){
		String s;
		DecimalFormat formatter = new DecimalFormat(format); 
		s = formatter.format(val);
		return s;
	}
	
	public boolean strToBool(String s)
	{
		return (!s.trim().toUpperCase().equals(""));
	}

	public String extractNum(String s)
	{
		String sNum = "0123456789";
		String sResult = "";
		int i = 0;
		for (i=0;i < s.length() ; i++){
			if (sNum.indexOf(s.charAt(i)) != -1){
				sResult = sResult + s.charAt(i);
			}
		}
		return sResult;
	}
	
	public String fillLeft(String s, String f, int length){
		String sResult = s;
		while (sResult.length() < length){
			sResult = f + sResult;
		}
		return sResult;
	}
	
	public String fillRight(String s, String f, int length){
		String sResult = s;
		while (sResult.length() < length){
			sResult += f;
		}
		return sResult;
	}
	
	public String insertColon(String s){
		String sResult = extractNum(s);
		return sResult.equals("") || sResult == null ? "" : sResult.substring(0, 2)+":"+sResult.substring(2, 4);
	}
	
	public String formatTel(String s){
		return s.equals("") || s == null ? "" : s.substring(0, 2)+"-"+s.substring(2, 6)+"-"+s.substring(6, 9);
	}
	
    public static String getStringPadding(String aStr, int iLen)
    {
    	String sPadding = aStr;
    	
    	if (sPadding == null) sPadding = "";
    	while (sPadding.length() < iLen)
    	{
    		sPadding += " ";
    	}
    	return sPadding;
    }
    
    public static String getString(String aStr)
    {
    	String sStr = aStr;
    	if (sStr == null) sStr = "";
    	return sStr.replace((char)0x0, ' ');
    }
    
	public static char getChar(String str)
	{		
		String tmp = getString(str);
		if (tmp.length() == 0)
			return (char)0;
		else
			return tmp.toCharArray()[0];
	}

	public static Properties getPropertiesFile(String fileName)
	{
		Properties prop = null;
		try{
			prop = new Properties();
			FileInputStream fi = new FileInputStream(fileName);
			prop.load(fi);
			prop.list(System.out);
		}catch(Exception e){
			e.printStackTrace();
		}
		return prop;
	}
	
	public static void main(String[] args)
	{
		String thai = "เทสเทสเทส";
		 System.out.println(StringUtils.getThai(thai));
	}
	
}
