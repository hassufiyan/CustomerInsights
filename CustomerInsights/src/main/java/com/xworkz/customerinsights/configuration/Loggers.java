package com.xworkz.customerinsights.configuration;

import  java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Loggers {
	private static final Logger logger;

	public static Logger getLogger() {
		return logger;
	}

	static {
		logger=Logger.getLogger(Loggers.class.getName());
		try {
			//Creating consoleHandler and fileHandler
			Handler fileHandler = new FileHandler("C:\\Users\\Sufiyan Hasan\\Desktop",true);
			Handler consoleHandler = new ConsoleHandler();
			
			//Assigning handlers to Logger object
			logger.addHandler(consoleHandler);
			logger.addHandler(fileHandler);
			SimpleFormatter simpleFormatter = new SimpleFormatter();
			fileHandler.setFormatter(simpleFormatter);
			
			//Setting levels to handlers and Logger
			consoleHandler.setLevel(Level.ALL);
			fileHandler.setLevel(Level.ALL);
			logger.setLevel(Level.ALL);
			logger.config("Configuration done.");
			
			//Console handler removed
			logger.removeHandler(consoleHandler);
			logger.log(Level.FINE, "Finer logged");
		} catch (IOException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, "Error occured in FileHandler.",e);
		}
		logger.finer("Finest example on Logger handler completed.");
	}

}
