package com.tnc.utils;

import java.io.*;
import java.util.*;
import java.text.*;

public class WriteLog 
{
	//private boolean debug = false;
	private final String LOG_DIR = "";//th.EnvironmentCtrl.LOG_DIRECTORY_NAME;
	
	private long startTime = 0;
	
	private String logPath = "";
	private String logFile = "";
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.UK);
	private SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.UK);
	
	private void initial()
	{
		if (logPath.length() == 0)
		{
			if (File.separator.equals("\\"))
				logPath = "C:\\data\\applog" + File.separator + LOG_DIR;
			else
				logPath = "/data/applog" + File.separator + LOG_DIR;
//			System.out.println("LogPath=" + logPath);
			File dir = new File(logPath);
			dir.mkdirs();
		}
        Date curDate = new Date();
        String strCurDate = sdf.format(curDate);
        this.logFile = logPath + File.separator + strCurDate + ".log";
	}
	
	public WriteLog()
	{
		startTime = System.currentTimeMillis();
		initial();
	}
	
	public String getLogFile() {
		return logFile;
	}
	
	public String getLogPath() {
		return logPath;
	}
	
	public void setLogFile(String val) {
		this.logFile = val;
	}
	
	public void setLogPath(String val) {
		this.logPath = val;
	}
	
	public void writeLog(String message)
	{
		try
		{
	        Date curDate = new Date();
	        String strCurDate = sdf2.format(curDate);
		    FileOutputStream fout = new FileOutputStream(logFile, true);
		    BufferedOutputStream bout = new BufferedOutputStream(fout);
		    PrintStream pout = new PrintStream(bout);
		    pout.println(strCurDate + " LOG " + message);
		    pout.close();
		    bout.close();
		    fout.close();
		}
		catch (FileNotFoundException fe)
		{
			System.out.println("writeLog:" + fe.toString());
			this.logPath = "";
		}
		catch (Exception e)
		{
			System.out.println("writeLog:" + e.toString());
		}
	}

	public void writeLog(String message, Exception exception)
	{
		try
		{
	        Date curDate = new Date();
	        String strCurDate = sdf2.format(curDate);
		    FileOutputStream fout = new FileOutputStream(logFile, true);
		    BufferedOutputStream bout = new BufferedOutputStream(fout);
		    PrintStream pout = new PrintStream(bout);
		    pout.println(strCurDate + " LOG " + message);
		    exception.printStackTrace(pout);
		    pout.close();
		    bout.close();
		    fout.close();
		}
		catch (FileNotFoundException fe)
		{
			System.out.println("writeLog:" + fe.toString());
			this.logPath = "";
		}
		catch (Exception e)
		{
			System.out.println("writeLog:" + e.toString());
		}
	}
	
	public void writeLogInput(String className, String methodName, String inputStr)
	{
		this.writeLog("[INPUT]:" + startTime + ":" + className + "." + methodName + "():" + inputStr);
	}
	
	public void writeLogOutput(String className, String methodName, String outputStr)
	{
		this.writeLog("[OUTPUT]:" + startTime + ":" + className + "." + methodName + "():" + outputStr);
	}
	
	public void writeLogElapseTime(String className, String methodName)
	{
		long endTime = System.currentTimeMillis();
        this.writeLog("[ELAPSE_TIME]:" + startTime + ":" + className + "." + methodName + "():" + (endTime - startTime));
	}
	
	public void writeLogError(String className, String methodName, String inputStr, Exception e)
	{
		this.writeLog("[ERROR]:" + startTime + ":" + className + "." + methodName + "():" + inputStr, e);
	}
	
	/*
	public static void main(String[] args)
	{
		WriteLog log = new WriteLog();
		System.out.println("Log Path = " + log.getLogPath());
		System.out.println("Log File = " + log.getLogFile());
		log.writeLog("Test write log");
	}
	*/
	
}
