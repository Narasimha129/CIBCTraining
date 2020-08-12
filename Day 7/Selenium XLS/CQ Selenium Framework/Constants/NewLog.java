package Constants;

import org.apache.log4j.Logger;

public class NewLog {
	private static Logger logger = Logger.getLogger(NewLog.class.getName());//
	
	public static Logger getLogger(){
		return logger;
	}
	
	public static void startTestCase(String sTestCaseName){
		logger.info("****************************************************************************************");
		logger.info("****************************************************************************************");
		logger.info("$$$$$$$$$$$$$$$$$$$$$                 "+sTestCaseName+ "       $$$$$$$$$$$$$$$$$$$$$$$$$");
		logger.info("****************************************************************************************");
		logger.info("****************************************************************************************");
		System.out.println();
	}

	//This is to print log for the ending of the test case
	public static void endTestCase(String sTestCaseName){
		logger.info("XXXXXXXXXXXXXXXXXXXXXXX             "+"-E---N---D-"+"             XXXXXXXXXXXXXXXXXXXXXX");
		logger.info("X");
		logger.info("X");
		logger.info("X");
		logger.info("X");
   }

}
