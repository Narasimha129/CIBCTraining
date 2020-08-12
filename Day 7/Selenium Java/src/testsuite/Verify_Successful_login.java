package testsuite;
import org.testng.annotations.Test;
import PageObjects.*;
import utilities.PageObjectBase;
import org.openqa.selenium.support.PageFactory;
import utilities.Configurations;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import java.util.HashMap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import utilities.TestReport;
import java.io.IOException;
import org.testng.Reporter;
import utilities.DataUtil;


/** Conformiq generated test case
	Verify_Successful_login
*/
public class Verify_Successful_login extends PageObjectBase
{

	public Verify_Successful_login()
	{
	}

	private TestReport testReport= new TestReport();


	private StringBuilder overallTestData= new StringBuilder();


	@Test(dataProvider="TestData")
	public void test(final String Step_2_Username_textbox_TEXTBOX, final String Step_2_Password_textbox_TEXTBOX) throws Exception

	{

	Login_Page login_page_init=PageFactory.initElements(driver, Login_Page.class);

	Home_Page home_page_init=PageFactory.initElements(driver, Home_Page.class);

	Order_Details_Page order_details_page_init=PageFactory.initElements(driver, Order_Details_Page.class);
	testReport.createTesthtmlHeader(overallTestData);

	testReport.createHead(overallTestData);

	testReport.putLogo(overallTestData);

	float ne = (float) 0.0;

	testReport.generateGeneralInfo(overallTestData, "Verify_Successful_login", "TC_Verify_Successful_login", "",ne);

	testReport.createStepHeader();

	//External Circumstances


	Reporter.log("Step - 1- verify Login screen");

	testReport.fillTableStep("Step 1", "verify Login screen");

	getScreenshot(driver,Configurations.screenshotLocation , "Verify_Successful_login","Step_1");

	Reporter.log("Step - 2- Fill Login form Login screen");

	testReport.fillTableStep("Step 2", "Fill Login form Login screen");

	login_page_init.set_Username_textbox(Step_2_Username_textbox_TEXTBOX);
	login_page_init.set_Password_textbox(Step_2_Password_textbox_TEXTBOX);
	getScreenshot(driver,Configurations.screenshotLocation , "Verify_Successful_login","Step_2");

	Reporter.log("Step - 3- verify Home screen");

	testReport.fillTableStep("Step 3", "verify Home screen");

	getScreenshot(driver,Configurations.screenshotLocation , "Verify_Successful_login","Step_3");

	Reporter.log("Step - 4- click Order 12345 hyperlink Home screen");

	testReport.fillTableStep("Step 4", "click Order 12345 hyperlink Home screen");

	home_page_init.click_Order_12345_hyperlink();
	getScreenshot(driver,Configurations.screenshotLocation , "Verify_Successful_login","Step_4");

	Reporter.log("Step - 5- verify Order Details screen");

	testReport.fillTableStep("Step 5", "verify Order Details screen");

	getScreenshot(driver,Configurations.screenshotLocation , "Verify_Successful_login","Step_5");
	}
	@DataProvider(name = "TestData")
	public Object[][] getData() {
	return DataUtil.getDataFromSpreadSheet("TestData.xlsx", "TCID_3");
}
	@AfterTest
	public void export(){
		testReport.appendtestData(overallTestData);
		testReport.closeStepTable();
		testReport.closeTestHTML(overallTestData);
		driver.close();
		try {
			testReport.writeTestReporthtml(overallTestData, "Verify_Successful_login");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
