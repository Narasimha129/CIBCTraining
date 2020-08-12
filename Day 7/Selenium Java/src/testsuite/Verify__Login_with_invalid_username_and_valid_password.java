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
	Verify__Login_with_invalid_username_and_valid_password
*/
public class Verify__Login_with_invalid_username_and_valid_password extends PageObjectBase
{

	public Verify__Login_with_invalid_username_and_valid_password()
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

	testReport.generateGeneralInfo(overallTestData, "Verify__Login_with_invalid_username_and_valid_password", "TC_Verify__Login_with_invalid_username_and_valid_password", "",ne);

	testReport.createStepHeader();

	//External Circumstances


	Reporter.log("Step - 1- verify Login screen");

	testReport.fillTableStep("Step 1", "verify Login screen");

	getScreenshot(driver,Configurations.screenshotLocation , "Verify__Login_with_invalid_username_and_valid_password","Step_1");

	Reporter.log("Step - 2- Fill Login form Login screen");

	testReport.fillTableStep("Step 2", "Fill Login form Login screen");

	login_page_init.set_Username_textbox(Step_2_Username_textbox_TEXTBOX);
	login_page_init.set_Password_textbox(Step_2_Password_textbox_TEXTBOX);
	getScreenshot(driver,Configurations.screenshotLocation , "Verify__Login_with_invalid_username_and_valid_password","Step_2");

	Reporter.log("Step - 3- verify Login screen");

	testReport.fillTableStep("Step 3", "verify Login screen");

	getScreenshot(driver,Configurations.screenshotLocation , "Verify__Login_with_invalid_username_and_valid_password","Step_3");
	}
	@DataProvider(name = "TestData")
	public Object[][] getData() {
	return DataUtil.getDataFromSpreadSheet("TestData.xlsx", "TCID_1");
}
	@AfterTest
	public void export(){
		testReport.appendtestData(overallTestData);
		testReport.closeStepTable();
		testReport.closeTestHTML(overallTestData);
		driver.close();
		try {
			testReport.writeTestReporthtml(overallTestData, "Verify__Login_with_invalid_username_and_valid_password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
