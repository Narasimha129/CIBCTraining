package PageObjects;
import org.testng.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import utilities.WebController;
import utilities.PageObjectBase;
@SuppressWarnings("deprecation")
public class Login_Page extends PageObjectBase{
@FindBy(how= How.XPATH, using = ",//*[@id='userid']")
	public static WebElement Username_textbox;

public void verify_Username_textbox(String data){
		if(!data.contentEquals("Dont care")){
		Assert.assertEquals(Username_textbox.getAttribute("value"),data);
	}

}

public void verify_Username_textbox_Status(String data){
		//Verifies the Status of the Username_textbox
		if(!data.contentEquals("Dont care")){
			switch(data){
			case "ENABLED":
				Assert.assertTrue(Username_textbox.isEnabled());
				break;
			case "VISIBLE":
				Assert.assertTrue(Username_textbox.isDisplayed());
				break;
			case "HIDDEN":
				Assert.assertFalse(!Username_textbox.isDisplayed());
				break;
			case "DISABLED":
				Assert.assertFalse(!Username_textbox.isEnabled());
				break;
			default:
				break;
			}
		}
	}
public void set_Username_textbox(String data){
		Username_textbox.clear();
		Username_textbox.sendKeys(data);
}

@FindBy(how= How.ID, using = "Password_textbox")
	public static WebElement Password_textbox;

public void verify_Password_textbox(String data){
		if(!data.contentEquals("Dont care")){
		Assert.assertEquals(Password_textbox.getAttribute("value"),data);
	}

}

public void verify_Password_textbox_Status(String data){
		//Verifies the Status of the Password_textbox
		if(!data.contentEquals("Dont care")){
			switch(data){
			case "ENABLED":
				Assert.assertTrue(Password_textbox.isEnabled());
				break;
			case "VISIBLE":
				Assert.assertTrue(Password_textbox.isDisplayed());
				break;
			case "HIDDEN":
				Assert.assertFalse(!Password_textbox.isDisplayed());
				break;
			case "DISABLED":
				Assert.assertFalse(!Password_textbox.isEnabled());
				break;
			default:
				break;
			}
		}
	}
public void set_Password_textbox(String data){
		Password_textbox.clear();
		Password_textbox.sendKeys(data);
}

public static void verify_Text(String data){
	Assert.assertTrue(driver.getPageSource().contains(data));
}
}