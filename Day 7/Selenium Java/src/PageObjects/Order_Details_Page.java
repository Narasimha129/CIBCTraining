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
public class Order_Details_Page extends PageObjectBase{
@FindBy(how= How.ID, using = "OrderNumber_label")
	public static WebElement OrderNumber_label;

public void verify_OrderNumber_label(String data){
		Assert.assertEquals(OrderNumber_label,OrderNumber_label);
}

public void verify_OrderNumber_label_Status(String data){
		//Verifies the Status of the OrderNumber_label
		if(!data.contentEquals("Dont care")){
			switch(data){
			case "ENABLED":
				Assert.assertTrue(OrderNumber_label.isEnabled());
				break;
			case "VISIBLE":
				Assert.assertTrue(OrderNumber_label.isDisplayed());
				break;
			case "HIDDEN":
				Assert.assertFalse(!OrderNumber_label.isDisplayed());
				break;
			case "DISABLED":
				Assert.assertFalse(!OrderNumber_label.isEnabled());
				break;
			default:
				break;
			}
		}
	}
@FindBy(how= How.ID, using = "QTY_label")
	public static WebElement QTY_label;

public void verify_QTY_label(String data){
		Assert.assertEquals(QTY_label,QTY_label);
}

public void verify_QTY_label_Status(String data){
		//Verifies the Status of the QTY_label
		if(!data.contentEquals("Dont care")){
			switch(data){
			case "ENABLED":
				Assert.assertTrue(QTY_label.isEnabled());
				break;
			case "VISIBLE":
				Assert.assertTrue(QTY_label.isDisplayed());
				break;
			case "HIDDEN":
				Assert.assertFalse(!QTY_label.isDisplayed());
				break;
			case "DISABLED":
				Assert.assertFalse(!QTY_label.isEnabled());
				break;
			default:
				break;
			}
		}
	}
@FindBy(how= How.ID, using = "Ordered_Number_textbox")
	public static WebElement Ordered_Number_textbox;

public void verify_Ordered_Number_textbox(String data){
		if(!data.contentEquals("Dont care")){
		Assert.assertEquals(Ordered_Number_textbox.getAttribute("value"),data);
	}

}

public void verify_Ordered_Number_textbox_Status(String data){
		//Verifies the Status of the Ordered_Number_textbox
		if(!data.contentEquals("Dont care")){
			switch(data){
			case "ENABLED":
				Assert.assertTrue(Ordered_Number_textbox.isEnabled());
				break;
			case "VISIBLE":
				Assert.assertTrue(Ordered_Number_textbox.isDisplayed());
				break;
			case "HIDDEN":
				Assert.assertFalse(!Ordered_Number_textbox.isDisplayed());
				break;
			case "DISABLED":
				Assert.assertFalse(!Ordered_Number_textbox.isEnabled());
				break;
			default:
				break;
			}
		}
	}
public void set_Ordered_Number_textbox(String data){
		Ordered_Number_textbox.clear();
		Ordered_Number_textbox.sendKeys(data);
}

public static void verify_Text(String data){
	Assert.assertTrue(driver.getPageSource().contains(data));
}
}