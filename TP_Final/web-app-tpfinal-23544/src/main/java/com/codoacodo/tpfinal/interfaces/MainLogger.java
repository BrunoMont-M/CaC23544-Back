package com.codoacodo.tpfinal.interfaces;

public class MainLogger {

	public static void main(String[] args) {
		
	ILogger[] loggers = new ILogger[3];
	
	loggers[0] = LoggerManager.getLogger("A");
	loggers[1] = LoggerManager.getLogger("B");
	loggers[2] = LoggerManager.getLogger("C");
	
	for (ILogger iLogger : loggers) {
		iLogger.log();
		}
	}
}
