package com.ms.smoke;

import org.apache.logging.log4j.*;


public class AlphaDemoTest {
	
	public static Logger logObject = LogManager.getLogger(AlphaDemoTest.class.getName());

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		logObject.error("This is error log");
		logObject.fatal("This is fatal error");
		logObject.trace("This is trace message");
		logObject.debug("This is debug message");
		logObject.info("This is info");
		logObject.warn("This is warning");
			
		

	}

}
