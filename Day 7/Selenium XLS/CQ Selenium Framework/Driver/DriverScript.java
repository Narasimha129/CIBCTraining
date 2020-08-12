package Driver;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.conformiq.rallyupload.RallyProperties;
import com.conformiq.rallyupload.RallyUpload;
import com.sun.jna.Library;

import Constants.Constants;
import Constants.ExcelUtils;
import Constants.NewLog;
import Constants.OverviewReport;
import Constants.TestReport;
import Library.ActionKeywords;
import Library.LibrayKeyword;

@SuppressWarnings("unused")
public class DriverScript {
	private static RallyUpload rallyupload;
	public ActionKeywords actionKeywords;
	public LibrayKeyword libraryKeywords;
	public Method method[];
	public Method method1[];
	public static String teststeps="";
	public static int countTestpassed, countTestFailed,countTestNotExecuted;
	private Map<Integer, String> status = new HashMap<Integer, String>();
	
	private final static HashMap<String, String> defaultProperties = new HashMap<String, String>();
    static {
        try {
			defaultProperties.put(RallyProperties.RALLY_HOST_NAME, ExcelUtils.getTestCellData(1, 1, Constants.Sheet_RallySettings));
			defaultProperties.put(RallyProperties.USER_NAME, ExcelUtils.getTestCellData(2, 1, Constants.Sheet_RallySettings));
	        defaultProperties.put(RallyProperties.PASSWORD, ExcelUtils.getTestCellData(3, 1, Constants.Sheet_RallySettings));
	        defaultProperties.put(RallyProperties.WORKSPACE, ExcelUtils.getTestCellData(4, 1, Constants.Sheet_RallySettings));
	        defaultProperties.put(RallyProperties.PROJECT, ExcelUtils.getTestCellData(5, 1, Constants.Sheet_RallySettings));
	        defaultProperties.put(RallyProperties.CONNECT_THROUGH_RPOXY, ExcelUtils.getTestCellData(6, 1, Constants.Sheet_RallySettings));
	        defaultProperties.put(RallyProperties.HTTP_PROXY_HOST, ExcelUtils.getTestCellData(7, 1, Constants.Sheet_RallySettings));
	        defaultProperties.put(RallyProperties.HTTP_PROXY_PORT, ExcelUtils.getTestCellData(8, 1, Constants.Sheet_RallySettings));
	        defaultProperties.put(RallyProperties.HTTP_PROXY_USERNAME, ExcelUtils.getTestCellData(9, 1, Constants.Sheet_RallySettings));
	        defaultProperties.put(RallyProperties.HTTP_PROXY_PASSWORD, ExcelUtils.getTestCellData(10, 1, Constants.Sheet_RallySettings));
	        defaultProperties.put(RallyProperties.HTTP_PROXY_COMPUTERNAME, ExcelUtils.getTestCellData(11, 1, Constants.Sheet_RallySettings));
	        defaultProperties.put(RallyProperties.HTTP_PROXY_DOMAINNAME, ExcelUtils.getTestCellData(12, 1, Constants.Sheet_RallySettings));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
      

    }

	public DriverScript() throws NoSuchMethodException, SecurityException{
		actionKeywords = new ActionKeywords();
		libraryKeywords = new LibrayKeyword();
		method = actionKeywords.getClass().getMethods();
		method1 = libraryKeywords.getClass().getMethods();

	}
	public static void main(String[] args) throws Exception {
		rallyupload = new RallyUpload();
		RallyUpload.setproperties(defaultProperties);
		DOMConfigurator.configure("log4j.xml");
		ExcelUtils.setTestExcelFile(Constants.Path_TestExecution);
		int SettingsCount = ExcelUtils.getTestRowCount(Constants.Sheet_Settings);
		int iTotalTestCases = ExcelUtils.getTestRowCount(Constants.Sheet_TestCases);
		DriverScript startEngine = new DriverScript();
		for(int i=1;i<=SettingsCount;i++){
			String browserName = ExcelUtils.getTestCellData(i, 0, Constants.Sheet_Settings);
			String isChoosen = ExcelUtils.getTestCellData(i, 1, Constants.Sheet_Settings);
			String driverPath = ExcelUtils.getTestCellData(i, 2, Constants.Sheet_Settings);
			String executionType = ExcelUtils.getTestCellData(i, 3, Constants.Sheet_Settings);
			if(isChoosen.equals("Yes")){
				if(executionType.equals("Yes")){
					startEngine.execute_Parallel_Tests(iTotalTestCases, browserName);
				}else{
					startEngine.execute_sequential_Tests(iTotalTestCases, browserName);
				}
			}
		}
		OverviewReport.createIndexFile(iTotalTestCases);
	}
	private void execute_Parallel_Tests(int iTotalTestCases, String browserName) throws Exception {
		
		for(int iTestcase=1;iTestcase<iTotalTestCases;iTestcase++){
			String sRunMode = ExcelUtils.getTestCellData(iTestcase, Constants.Col_RunMode,Constants.Sheet_TestCases);
			if(sRunMode.equals("N")){
				String sTestCaseID = ExcelUtils.getTestCellData(iTestcase, Constants.Col_TestCaseID, Constants.Sheet_TestCases);
				String sTestCaseName =ExcelUtils.getTestCellData(iTestcase, Constants.Col_TestCaseName, Constants.Sheet_TestCases);
				TestReport testReport = new TestReport();
				StringBuilder overallTestData = new StringBuilder();
				testReport.createTesthtmlHeader(overallTestData);
				testReport.createHead(overallTestData);
				testReport.putLogo(overallTestData);
				float ne = (float) 0.0;
				ExcelUtils.setTestCaseResult("NOT_EXECUTED", iTestcase, Constants.Col_TestResult, Constants.Sheet_TestCases);
				String Result =ExcelUtils.getTestCellData(iTestcase, 5,Constants.Sheet_TestCases);
				testReport.generateGeneralInfo(overallTestData, sTestCaseName, sTestCaseID, "NOT_EXECUTED",ne);
				testReport.appendtestData(overallTestData);
				testReport.filltableDetails(overallTestData);

				testReport.closeTestHTML(overallTestData);
				testReport.writeTestReporthtml(overallTestData, sTestCaseID);
				countTestNotExecuted++;
			}
			else{
				RunnableDemo demo = new RunnableDemo(iTestcase, browserName);
				demo.start();
			}

		}
	}
	private void execute_sequential_Tests(int iTotalTestCase, String browserName) throws Exception {
		
		for(int iTestcase=1;iTestcase<iTotalTestCase;iTestcase++){
			String sRunMode = ExcelUtils.getTestCellData(iTestcase, Constants.Col_RunMode,Constants.Sheet_TestCases);
			if(sRunMode.equals("N")){
				String sTestCaseID = ExcelUtils.getTestCellData(iTestcase, Constants.Col_TestCaseID, Constants.Sheet_TestCases);
				String sTestCaseName =ExcelUtils.getTestCellData(iTestcase, Constants.Col_TestCaseName, Constants.Sheet_TestCases);
				TestReport testReport = new TestReport();
				StringBuilder overallTestData = new StringBuilder();
				//testReport.createtesthtmlHeader(reportBuilder);
				testReport.createTesthtmlHeader(overallTestData);
				testReport.createHead(overallTestData);
				testReport.putLogo(overallTestData);
				float ne = (float) 0.0;
				ExcelUtils.setTestCaseResult("NOT_EXECUTED", iTestcase, Constants.Col_TestResult, Constants.Sheet_TestCases);
				testReport.generateGeneralInfo(overallTestData, sTestCaseName, sTestCaseID, "NOT_EXECUTED",ne);
				testReport.appendtestData(overallTestData);
				testReport.filltableDetails(overallTestData);

				testReport.closeTestHTML(overallTestData);
				testReport.writeTestReporthtml(overallTestData, sTestCaseID);
				countTestNotExecuted++;
			}
			if (sRunMode.equals("Y")){
				executetest(iTestcase, browserName);
			}
		}
	}

	private void executetest(int iTestcase, String browserName) throws Exception{
		teststeps="";
		TestReport testReport = new TestReport();
		StringBuilder overallTestData = new StringBuilder();
		testReport.createTesthtmlHeader(overallTestData);
		testReport.createHead(overallTestData);
		testReport.putLogo(overallTestData);
		long startingTime = System.currentTimeMillis();
		boolean bResult = true;
		String sTestCaseID = ExcelUtils.getTestCellData(iTestcase, Constants.Col_TestCaseID, Constants.Sheet_TestCases);
		String sTestCaseName =ExcelUtils.getTestCellData(iTestcase, Constants.Col_TestCaseName, Constants.Sheet_TestCases);
		String sRunMode = ExcelUtils.getTestCellData(iTestcase, Constants.Col_RunMode,Constants.Sheet_TestCases);
		String Result = "";
		
		if (sRunMode.equals("Y")){

			NewLog.startTestCase(sTestCaseID);
			String status = execute_TestSteps(sTestCaseID, testReport,browserName );
			if(status.equals("PASSED")){
				ExcelUtils.setTestCaseResult(Constants.KEYWORD_PASS, iTestcase, 5, Constants.Sheet_TestCases);

				Result =ExcelUtils.getTestCellData(iTestcase, 5,Constants.Sheet_TestCases);
				
			}else{
				
				int dialogButton = JOptionPane.YES_NO_OPTION;
                
				int value = JOptionPane.showConfirmDialog(null, "Would you like to file a Defect for " +sTestCaseID+" test execution failure in Rally?");
				if(value == 0){
					RallyUpload.uploaddefect(sTestCaseName, teststeps);
					countTestpassed++;
				}
				countTestFailed++;
				ExcelUtils.setTestCaseResult(Constants.KEYWORD_FAIL, iTestcase, 5, Constants.Sheet_TestCases);
				Result =ExcelUtils.getTestCellData(iTestcase, 5,Constants.Sheet_TestCases);
				
			}
		}
		long endTime = System.currentTimeMillis();
		long exeTime = (System.currentTimeMillis()-startingTime)/1000L;
		System.out.println("executionTime "+exeTime);
		testReport.generateGeneralInfo(overallTestData, sTestCaseName, sTestCaseID, Result, exeTime);
		testReport.appendtestData(overallTestData);
		testReport.filltableDetails(overallTestData);
		testReport.closeTestHTML(overallTestData);
		testReport.writeTestReporthtml(overallTestData, sTestCaseID);
		status.put(iTestcase, "completed");
	}
	private String execute_TestSteps(String sTestCaseID, TestReport testReport, String browserName) throws Exception{
		teststeps= "";
		String status = "NOT_EXECUTED";
		ExcelUtils.setTestDataExcel(Constants.Path_TestCase);
		int noofSteps = ExcelUtils.getTestStepsCount(sTestCaseID);
		testReport.createStepHeader();
		WebDriver driver = null;
		for (int iTestStep=1;iTestStep<noofSteps;iTestStep++){
			
			if(iTestStep == 1){
				testReport.beginStep();

				String sFnName = ExcelUtils.getStepData(iTestStep, Constants.Col_FnName,sTestCaseID);
				testReport.fillStepHeader(sFnName);
				String sParamVale = ExcelUtils.getStepData(iTestStep, Constants.Col_ParamValue,sTestCaseID);
				if(browserName.equals("")){
					driver = openBrowser("Mozilla",testReport);
				}
				else{
					driver = openBrowser(browserName,testReport);
				}
				testReport.endStep();
			}
			else{
				String sFnName1 = ExcelUtils.getStepData(iTestStep, Constants.Col_FnName,sTestCaseID);
				System.out.println("Fn Nam: "+ sFnName1);
				testReport.beginStep();
				testReport.fillStepHeader(sFnName1);
				int noOfParamters = ExcelUtils.getParameterNofromLibrarySheet(Constants.Path_LibraryMapping,Constants.Sheet_LibraryMapping,sFnName1);
				
				String sFnName = ExcelUtils.getStepData(iTestStep, Constants.Col_FnName,sTestCaseID);
				String sParamName = ExcelUtils.getStepData(iTestStep, Constants.Col_Paramname,sTestCaseID);
				String sParamVale = ExcelUtils.getStepData(iTestStep, Constants.Col_ParamValue,sTestCaseID);
				String sSkipStep = ExcelUtils.getStepData(iTestStep, 2,sTestCaseID);
				String sScreenShot = ExcelUtils.getStepData(iTestStep, 5,sTestCaseID);
				teststeps = teststeps + "\r\n"+sFnName + ":" + sParamName + ":" + sParamVale;
				if(sSkipStep.equals("Y")){
					if(sScreenShot.equals("Y")){
					try{
						ActionKeywords.scShot(driver, sTestCaseID,sParamName, testReport);
					}
					catch (Exception e) {
						return "FAILED";
					}
					}
					try{
						String newString = access_Harness(driver, sFnName, sParamName, sParamVale, sScreenShot, testReport, sTestCaseID,iTestStep,sTestCaseID);
						if(!status.equals("FAILED"))
							status = newString;
					}
					catch (Exception e) {
						return "FAILED";
					}
				}else{

					testReport.fillskippedStatus("SKIPPED", sTestCaseID, sParamName, sScreenShot);
				}
				iTestStep = iTestStep+noOfParamters;
			testReport.endStep();
			}
		}
		testReport.closeStepTable();
		return status;

	}

	private String access_Harness(WebDriver driver, String sFnName, String sParamName, String sParamVale, String sScreenShot, TestReport testReport, String sTestCaseID, int iTestStep, String sTestCaseID2) throws Exception {
		ExcelUtils.setHarnessExcel(Constants.Path_TestHarness);
		int harnessSteps = ExcelUtils.getHarnessStepsCount(Constants.Sheet_Harness);
		for (int i=1;i<=harnessSteps;i++){
			String hFnName = ExcelUtils.getHarnessData(i, Constants.Col_HFnName,Constants.Sheet_Harness);
			String hObjName = ExcelUtils.getHarnessData(i, Constants.Col_HobjIdentifier,Constants.Sheet_Harness);
			String hActionWord= ExcelUtils.getHarnessData(i, Constants.Col_HActionkword,Constants.Sheet_Harness);
			String hParamName = ExcelUtils.getHarnessData(i, Constants.Col_HParamName,Constants.Sheet_Harness);
			String isCustomAction = ExcelUtils.getHarnessData(i, Constants.Col_ISYES,Constants.Sheet_Harness);
			if(isCustomAction.contentEquals("Y") && sFnName.equals(hFnName)){
				return map_CustomActions(driver,hFnName, sParamVale, hObjName, hActionWord, sScreenShot, testReport, sTestCaseID,iTestStep,sTestCaseID);
			}else{
				if (sFnName.equals(hFnName) && sParamName.equals(hParamName) ){
				
					return map_Objects(driver,sParamName, sParamVale, hObjName, hActionWord, sScreenShot, testReport, sTestCaseID);	
				
			}
			}
		}
		return "NOT_EXECUTED";
	}

	private String map_Objects(WebDriver driver, String sParamName, String sParamVale, String hObjName, String hActionWord, String sScreenShot, TestReport testReport, String sTestCaseID) throws Exception {
		String status = "NOT_EXECUTED";
		int MappingSteps = ExcelUtils.getHarnessStepsCount(Constants.Sheet_ORMapping);
		for (int i=1;i<=MappingSteps;i++){
			String mObjIdentifier = ExcelUtils.getHarnessData(i, Constants.Col_MObj,Constants.Sheet_ORMapping);
			String mRealObjects = ExcelUtils.getHarnessData(i, Constants.Col_MRealObj,Constants.Sheet_ORMapping);
			String locator = ExcelUtils.getHarnessData(i, Constants.Col_locator,Constants.Sheet_ORMapping);
			if(hObjName.equals(mObjIdentifier)){
				String newStatString = execute_Actions(driver,sParamName, sParamVale, mRealObjects, hActionWord, locator, sScreenShot, testReport, sTestCaseID);
				if(!status.equals("FAILED"))
					status = newStatString;
				else
					return status;
			}
		}
		return status;
	}
	
	private String map_CustomActions(WebDriver driver, String functionName, String sParamVale, String hObjName, String hActionWord, String sScreenShot, TestReport testReport, String sTestCaseID, int iTestStep, String sTestCaseID2) throws Exception {
		String status1 = "NOT_EXECUTED";
		
		try{
		Class<?> libraryClass =  LibrayKeyword.class;
		Method[] methods = libraryClass.getDeclaredMethods();
		Object currentObj = libraryClass.newInstance();
		int siz = methods.length;
		ArrayList<String> parameterValues = new ArrayList<>();
		int noOfParamters = ExcelUtils.getParameterNofromLibrarySheet(Constants.Path_LibraryMapping,Constants.Sheet_LibraryMapping,functionName);
		
		parameterValues = ExcelUtils.getParameterValues(sTestCaseID,iTestStep,noOfParamters);
		String excelLibraryKeywordName = ExcelUtils.getMethodNamefromLibrarySheet(Constants.Path_LibraryMapping,Constants.Sheet_LibraryMapping,functionName);
		Method libraryMethod = getLibraryMethod(excelLibraryKeywordName);
		int paramNo= 2+ parameterValues.size();
		Object[] actualParams = new Object[paramNo];
		actualParams[0] = driver;
		actualParams[1] = testReport;
		for(int i=0;i<parameterValues.size();i++){
			actualParams[2+(i)] = parameterValues.get(i);
			
		}
			
		libraryMethod.invoke(currentObj,actualParams );
		}catch(Exception e){
			e.getLocalizedMessage();
		}
		return status1;
	}
	
	private String execute_Actions(WebDriver driver,String sParamaName, String sParamVale, String mRealObjects, String hActionWord, String locator, String sScreenShot, TestReport testReport, String sTestCaseID) throws Exception {
		String status = "NOT_EXECUTED";
		Method method =getMethod(hActionWord);
		if(method != null){
			Object value = method.invoke(hActionWord, driver, mRealObjects,sParamVale,locator, testReport);
			if(value != null){
				if(value.toString().equals("PASSED")){
					testReport.fillStatus("PASSED", sScreenShot, sParamaName, sTestCaseID);
					status = "PASSED";
				}
				else{
					testReport.fillFailStatus("FAILED", sScreenShot, sParamaName, sTestCaseID);
					status = "FAILED";
				}
			}
			else{
				testReport.fillFailStatus("FAILED", sScreenShot, sParamaName, sTestCaseID);
				status = "FAILED";
			}
		}
		return status;
	}

	private Method getMethod(String methodName) {
		for(int i=0;i<method.length;i++){
			
			try {
				if(method[i].getName().equals(methodName)){
					return method[i];
				}
			}
			catch(Exception e){

			}
		}
		return null;
	}
	
	private Method getLibraryMethod(String methodName) {
		for(int i=0;i<method1.length;i++){
			try {
				if(method1[i].getName().equals(methodName)){
					return method1[i];
				}
			}
			catch(Exception e){

			}
		}
		return null;
	}
	
	public WebDriver openBrowser(String data,TestReport testReport){		
		WebDriver driver = null;
		NewLog.getLogger().info("Opening Browser");

		try{				
			if(data.equals("Mozilla")){
				driver=new FirefoxDriver();
				driver.manage().window().maximize();
				NewLog.getLogger().info("Mozilla browser started");
				testReport.fillStepValue("Mozilla browser started");
			}
			else if(data.equals("IE")){
				System.setProperty("webdriver.ie.driver",System.getProperty("user.dir") + "\\IEDriverServer.exe");
				driver=new InternetExplorerDriver();
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				NewLog.getLogger().info("IE browser started");
				testReport.fillStepValue("IE browser started");
				
			}
			else if(data.equals("Chrome")){
				System.setProperty("webdriver.chrome.driver", ExcelUtils.getTestCellData(2, 2, Constants.Sheet_Settings));
				driver=new ChromeDriver();
				driver.manage().window().maximize();
				NewLog.getLogger().info("Chrome browser started");
				testReport.fillStepValue("Chrome browser started");
				
			}
			int implicitWaitTime=(10);
			testReport.fillStatus("PASSED", "", "", "");
			driver.manage().timeouts().implicitlyWait(implicitWaitTime, TimeUnit.SECONDS);
			
		}catch (Exception e){
			e.printStackTrace();
			NewLog.getLogger().info("Not able to open the Browser --- " + e.getMessage());
			
		}

		return driver;
	}

	private class RunnableDemo implements Runnable{

		private Thread t;
		private int value;
		private String browserName;

		public RunnableDemo(int iTestcase, String browserName) {
			this.value = iTestcase;
			this.browserName = browserName;
		}

		@Override
		public void run() {
			try {
				executetest(value, browserName);
				System.out.println("starting" + value);
				while(status.get(value).equals("not")){
					System.out.println(status.get(value));
					Thread.sleep(500);
				}
				System.out.println("completed" + value);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public void start (){
			System.out.println("Starting " +  value );
			if (t == null){
				t = new Thread (this);
				t.start ();
			}
		}
		
	}

}
