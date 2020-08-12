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
public class Home_Page extends PageObjectBase{
@FindBy(how= How.ID, using = "Order_Number_textbox")
	public static WebElement Order_Number_textbox;

public void verify_Order_Number_textbox(String data){
		if(!data.contentEquals("Dont care")){
		Assert.assertEquals(Order_Number_textbox.getAttribute("value"),data);
	}

}

public void verify_Order_Number_textbox_Status(String data){
		//Verifies the Status of the Order_Number_textbox
		if(!data.contentEquals("Dont care")){
			switch(data){
			case "ENABLED":
				Assert.assertTrue(Order_Number_textbox.isEnabled());
				break;
			case "VISIBLE":
				Assert.assertTrue(Order_Number_textbox.isDisplayed());
				break;
			case "HIDDEN":
				Assert.assertFalse(!Order_Number_textbox.isDisplayed());
				break;
			case "DISABLED":
				Assert.assertFalse(!Order_Number_textbox.isEnabled());
				break;
			default:
				break;
			}
		}
	}
public void set_Order_Number_textbox(String data){
		Order_Number_textbox.clear();
		Order_Number_textbox.sendKeys(data);
}

@FindBy(how= How.ID, using = "Order_12345_hyperlink")
	public static WebElement Order_12345_hyperlink;

public void verify_Order_12345_hyperlink_Status(String data){
		//Verifies the Status of the Order_12345_hyperlink
		if(!data.contentEquals("Dont care")){
			switch(data){
			case "ENABLED":
				Assert.assertTrue(Order_12345_hyperlink.isEnabled());
				break;
			case "VISIBLE":
				Assert.assertTrue(Order_12345_hyperlink.isDisplayed());
				break;
			case "HIDDEN":
				Assert.assertFalse(!Order_12345_hyperlink.isDisplayed());
				break;
			case "DISABLED":
				Assert.assertFalse(!Order_12345_hyperlink.isEnabled());
				break;
			default:
				break;
			}
		}
	}
public void click_Order_12345_hyperlink(){
		Order_12345_hyperlink.click();
}

@FindBy(how= How.ID, using = "Next_button")
	public static WebElement Next_button;

public void verify_Next_button_Status(String data){
		//Verifies the Status of the Next_button
		if(!data.contentEquals("Dont care")){
			switch(data){
			case "ENABLED":
				Assert.assertTrue(Next_button.isEnabled());
				break;
			case "VISIBLE":
				Assert.assertTrue(Next_button.isDisplayed());
				break;
			case "HIDDEN":
				Assert.assertFalse(!Next_button.isDisplayed());
				break;
			case "DISABLED":
				Assert.assertFalse(!Next_button.isEnabled());
				break;
			default:
				break;
			}
		}
	}
public void click_Next_button(){
		Next_button.click();
}

@FindBy(how= How.ID, using = "Order_Id_textbox")
	public static WebElement Order_Id_textbox;

public void verify_Order_Id_textbox(String data){
		if(!data.contentEquals("Dont care")){
		Assert.assertEquals(Order_Id_textbox.getAttribute("value"),data);
	}

}

public void verify_Order_Id_textbox_Status(String data){
		//Verifies the Status of the Order_Id_textbox
		if(!data.contentEquals("Dont care")){
			switch(data){
			case "ENABLED":
				Assert.assertTrue(Order_Id_textbox.isEnabled());
				break;
			case "VISIBLE":
				Assert.assertTrue(Order_Id_textbox.isDisplayed());
				break;
			case "HIDDEN":
				Assert.assertFalse(!Order_Id_textbox.isDisplayed());
				break;
			case "DISABLED":
				Assert.assertFalse(!Order_Id_textbox.isEnabled());
				break;
			default:
				break;
			}
		}
	}
public void set_Order_Id_textbox(String data){
		Order_Id_textbox.clear();
		Order_Id_textbox.sendKeys(data);
}

public static void verify_Text(String data){
	Assert.assertTrue(driver.getPageSource().contains(data));
}
}