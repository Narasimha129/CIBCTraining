package Library;
import java.io.File;
import java.util.ArrayList;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;

import com.google.common.io.Files;

import Constants.TestReport;
import Constants.NewLog;
import Constants.Constants;

import org.openqa.selenium.support.ui.Select;

public class ActionKeywords {
public static String navigate(WebDriver driver,String object, String data, String locator, TestReport testReport){
               try{
                       NewLog.getLogger().info("Navigating to URL");
                       testReport.fillStepValue("Navigating to URL");
                       driver.get(data);
                       return "PASSED";               }catch(Exception e){
                       NewLog.getLogger().info("Not able to navigate --- " + e.getMessage());
                       driver.quit();
                       return "FAILED";
                       }
               }
public static String click(WebDriver driver,String object, String data, String locator, TestReport testReport){
               try{
                       
                       NewLog.getLogger().info("Clicking on Webelement ");
                       testReport.fillStepValue("Clicking on Webelement ");
                       NewLog.getLogger().info(object  + data  + locator);
                       if(locator.equals("xpath")){
                               driver.findElement(By.xpath(object)).click();   
                       } else if(locator.equals("id")){
                               driver.findElement(By.id(object)).click();
                       }else if(locator.equals("name")){
                               driver.findElement(By.name(object)).click();
                       }else if(locator.equals("classname")){
                               driver.findElement(By.className(object)).click();
                       }else if(locator.equals("csselector")){
                               driver.findElement(By.cssSelector(object)).click();
                       }else if(locator.equals("linktext")){
                               driver.findElement(By.linkText(object)).click();
                       }else if(locator.equals("tagname")){
                               driver.findElement(By.tagName(object)).click();
                       }else{
                               driver.findElement(By.partialLinkText(object)).click();
                       }
                       
                       driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
                       return "PASSED";
                }catch(Exception e){
                       NewLog.getLogger().error("Not able to click --- " + e.getMessage());
                       driver.quit();
                       return "FAILED";
               }
               }
public static String input(WebDriver driver,String object, String data, String locator, TestReport testReport){
               WebElement textbox;
               try{
                       NewLog.getLogger().info("Entering the text");
                       testReport.fillStepValue("Entering the text");
                       //DriverScript.htmlTestInfo("Step Info:Entering the text");
                       
                       if(locator.equals("xpath")){
                                textbox = driver.findElement(By.xpath(object));
                               driver.findElement(By.xpath(object)).clear();
                               driver.findElement(By.xpath(object)).sendKeys(String.valueOf(data));    
                       } else if(locator.equals("id")){
                                textbox = driver.findElement(By.id(object));
                               driver.findElement(By.id(object)).clear();
                               driver.findElement(By.id(object)).sendKeys(String.valueOf(data));
                       }else if(locator.equals("name")){
                                textbox = driver.findElement(By.name(object));
                               driver.findElement(By.name(object)).clear();
                               driver.findElement(By.name(object)).sendKeys(String.valueOf(data));
                       }else if(locator.equals("classname")){
                               driver.findElement(By.className(object)).clear();
                                textbox = driver.findElement(By.className(object));
                               driver.findElement(By.className(object)).sendKeys(String.valueOf(data));
                       }else if(locator.equals("csselector")){
                                textbox = driver.findElement(By.xpath(object));
                               driver.findElement(By.cssSelector(object)).clear();
                               driver.findElement(By.cssSelector(object)).sendKeys(String.valueOf(data));
                       }else if(locator.equals("linktext")){
                                textbox = driver.findElement(By.xpath(object));
                               driver.findElement(By.linkText(object)).clear();
                               driver.findElement(By.linkText(object)).sendKeys(String.valueOf(data));
                       }else if(locator.equals("tagname")){
                                textbox = driver.findElement(By.xpath(object));
                               driver.findElement(By.tagName(object)).clear();
                               driver.findElement(By.tagName(object)).sendKeys(String.valueOf(data));
                       }else{
                                textbox = driver.findElement(By.xpath(object));
                               driver.findElement(By.partialLinkText(object)).clear();
                               driver.findElement(By.partialLinkText(object)).click();
                       }
                       return "PASSED";
                       }catch(Exception e){
                       NewLog.getLogger().error("Not able to Enter  --- " + e.getMessage());
                       driver.quit();
                       return "FAILED";
                       }
               }public static String waitFor(String object, String data, String locator, TestReport testReport) throws Exception{
               try{
                       NewLog.getLogger().info("Wait for 5 seconds");
                       testReport.fillStepValue("Wait for 5 seconds");
                       Thread.sleep(5000);
                       return "PASSED";
                }catch(Exception e){
                        NewLog.getLogger().error("Not able to Wait --- " + e.getMessage());
                       return "FAILED";
               }
               }public static String closeBrowser(WebDriver driver,String object, String data, String locator, TestReport testReport){
               try{
                       NewLog.getLogger().info("Closing the browser");
                       testReport.fillStepValue("Closing the browser");
                       driver.quit();
                       return "PASSED";
                }catch(Exception e){
                        NewLog.getLogger().error("Not able to Close the Browser --- " + e.getMessage());
                       driver.quit();
                       return "FAILED";
               }
               } public static String verifyButtonExists(WebDriver driver,String object,String data, String locator, TestReport testReport){
               try{
                       boolean exists;
                       NewLog.getLogger().info("Verify the object exists in the applicaiton");
                       testReport.fillStepValue("Verify the Button exists in the applicaiton");
                       driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);
                       
                       if(locator.equals("xpath")){
                               exists = driver.findElements( By.xpath(object) ).size() != 0;
                       } else if(locator.equals("id")){
                               exists = driver.findElements( By.id(object) ).size() != 0;
                       }else if(locator.equals("name")){
                               exists = driver.findElements( By.name(object) ).size() != 0;
                       }else if(locator.equals("classname")){
                               exists = driver.findElements( By.className(object) ).size() != 0;
                       }else if(locator.equals("csselector")){
                               exists = driver.findElements( By.cssSelector(object) ).size() != 0;
                       }else if(locator.equals("linktext")){
                               exists = driver.findElements( By.linkText(object) ).size() != 0;
                       }else if(locator.equals("tagname")){
                               exists = driver.findElements( By.tagName(object) ).size() != 0;
                       }else{
                               exists = driver.findElements( By.partialLinkText(object) ).size() != 0;
                       }
                       driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);  
                       if(exists){
                               NewLog.getLogger().info("Button Exists");
                               
                       }else{
                               NewLog.getLogger().info("Button doesn't Exists");
                       }
                       return "PASSED";
               }catch(Exception e){
                       NewLog.getLogger().error(e.getMessage());
                       driver.quit();
                       return "FAILED";
               }
       }
 public static String verifyObjectExist(WebDriver driver,String object,String data, String locator, TestReport testReport) {
                   
                       try{
                               NewLog.getLogger().error("Verify the object exists in the applicaiton");
                               testReport.fillStepValue("Verify the Object exists in the applicaiton");
                       boolean found;
                               if(locator.equals("xpath")){
                                       if(!(driver.findElements( By.xpath(object) ).size() != 0))      
                                               found = false;
                                       else
                                               found = true;
                               } else if(locator.equals("id")){
                                       if(!(driver.findElements( By.id(object) ).size() != 0)) 
                                               found = false;
                                       else
                                               found = true;
                               }else if(locator.equals("name")){
                                       if(!(driver.findElements( By.name(object) ).size() != 0))       
                                               found = false;
                                       else
                                               found = true;
                               }else if(locator.equals("classname")){
                                       if(!(driver.findElements( By.className(object) ).size() != 0))  
                                               found = false;
                                       else
                                               found = true;
                               }else if(locator.equals("csselector")){
                                       if(!(driver.findElements( By.cssSelector(object) ).size() != 0))        
                                               found = false;
                                       else
                                               found = true;
                               }else if(locator.equals("linktext")){
                                       if(!(driver.findElements( By.linkText(object) ).size() != 0))   
                                               found = false;
                                       else
                                               found = true;
                               }else if(locator.equals("tagname")){
                                       if(!(driver.findElements( By.tagName(object) ).size() != 0))    
                                               found = false;
                                       else
                                               found = true;
                               }else{
                                       if(!(driver.findElements( By.partialLinkText(object) ).size() != 0))    
                                               found = false;
                                       else
                                               found = true;
                               }
                       if (found)
                       {
                               NewLog.getLogger().error(" Required object is present in the applicaiton"+ object);
                       } else {
                               //driver.close();
                               NewLog.getLogger().error(" Required object is not present in the applicaiton"+ object);
                       }
                       return "PASSED";
                               
                   } catch (NoSuchElementException e){
                       NewLog.getLogger().error("Not able to locate the element--- " + e.getMessage());
                       driver.quit();
                       return "FAILED";
                   } 
       }
 public static String verifyTextBoxExists(WebDriver driver,String object,String data, String locator, TestReport testReport){
               WebElement textbox = null;
               try{
                       NewLog.getLogger().info("Verify the TextBox exists in the applicaiton");
                       testReport.fillStepValue("Verify the TextBox exists in the applicaiton");
                       driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);
                       if(locator.equals("xpath")){
                               textbox = driver.findElement( By.xpath(object));
                       } else if(locator.equals("id")){
                               textbox = driver.findElement( By.id(object));
                       }else if(locator.equals("name")){
                               textbox = driver.findElement( By.name(object));
                       }else if(locator.equals("classname")){
                               textbox = driver.findElement( By.className(object));
                       }else if(locator.equals("csselector")){
                               textbox = driver.findElement( By.cssSelector(object));
                       }else if(locator.equals("linktext")){
                               textbox = driver.findElement( By.linkText(object));
                       }else if(locator.equals("tagname")){
                               textbox = driver.findElement( By.tagName(object));
                       }else{
                               textbox = driver.findElement( By.partialLinkText(object));
                       }
                       boolean exists = textbox.isDisplayed();
                       driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);  
                       if(exists){
                               NewLog.getLogger().info("TextBox Exists");
                               
                       }else{
                               NewLog.getLogger().info("TextBox doesn't Exists");
                       }
                       return "PASSED";
                       
               }catch(Exception e){
                       NewLog.getLogger().error(e.getMessage());
                       NewLog.getLogger().error("TextBox doesn't Exists");
                       driver.quit();
                       return "FAILED";
               }
       }
      public static String selectCheckBox(WebDriver driver,String object, String data,String locator, TestReport testReport){
                       
                       try{
                               NewLog.getLogger().info("selecting the Check Box of " + object);
                               testReport.fillStepValue("selecting the Check Box ");
                               if(locator.equals("xpath")){
                                               if ( !driver.findElement(By.xpath(object)).isSelected())
                                               {
                                                    driver.findElement(By.xpath(object)).click();
                                                    NewLog.getLogger().info("CheckBox has been selected " + object);
                                                    
                                               }else{
                                                       NewLog.getLogger().info("CheckBox aleardy selected " + object);
                                               }
                               } else if(locator.equals("id")){
                                       if ( !driver.findElement(By.id(object)).isSelected())
                                       {
                                            driver.findElement(By.id(object)).click();
                                            NewLog.getLogger().info("CheckBox has been selected " + object);
                                            
                                       }else{
                                               NewLog.getLogger().info("CheckBox aleardy selected " + object);
                                       }
                       
                                       
                               }else if(locator.equals("name")){
                                       if ( !driver.findElement(By.name(object)).isSelected())
                                       {
                                            driver.findElement(By.name(object)).click();
                                            NewLog.getLogger().info("CheckBox has been selected " + object);
                                            
                                       }else{
                                               NewLog.getLogger().info("CheckBox aleardy selected " + object);
                                       }
                       
                                       
                               }else if(locator.equals("classname")){
                                       if ( !driver.findElement(By.className(object)).isSelected())
                                       {
                                            driver.findElement(By.cssSelector(object)).click();
                                            NewLog.getLogger().info("CheckBox has been selected " + object);
                                            
                                       }else{
                                               NewLog.getLogger().info("CheckBox aleardy selected " + object);
                                       }
                       
                                       
                               }else if(locator.equals("csselector")){
                                       if ( !driver.findElement(By.cssSelector(object)).isSelected())
                                       {
                                            driver.findElement(By.cssSelector(object)).click();
                                            NewLog.getLogger().info("CheckBox has been selected " + object);
                                            
                                       }else{
                                               NewLog.getLogger().info("CheckBox aleardy selected " + object);
                                       }
                       
                                       
                               }else if(locator.equals("linktext")){
                                       if ( !driver.findElement(By.linkText(object)).isSelected())
                                       {
                                            driver.findElement(By.linkText(object)).click();
                                            NewLog.getLogger().info("CheckBox has been selected " + object);
                                            
                                       }else{
                                               NewLog.getLogger().info("CheckBox aleardy selected " + object);
                                       }
                       
                                       
                               }else if(locator.equals("tagname")){
                                       if ( !driver.findElement(By.tagName(object)).isSelected())
                                       {
                                            driver.findElement(By.tagName(object)).click();
                                            NewLog.getLogger().info("CheckBox has been selected " + object);
                                            
                                       }else{
                                               NewLog.getLogger().info("CheckBox aleardy selected " + object);
                                       }
                               }else{
                                       if ( !driver.findElement(By.partialLinkText(object)).isSelected())
                                       {
                                            driver.findElement(By.partialLinkText(object)).click();
                                            NewLog.getLogger().info("CheckBox has been selected " + object);
                                            
                                       }else{
                                               NewLog.getLogger().info("CheckBox aleardy selected " + object);
                                       }
                               }
                               return "PASSED";
                               }catch(Exception e){
                                
                               NewLog.getLogger().error("Not able to select the checkbox --- " + e.getMessage());
                       driver.quit();
                       return "FAILED";
                                
                               }
                       }
public static String deselectCheckBox(WebDriver driver,String object, String data,String locator, TestReport testReport){
               
               try{
                       NewLog.getLogger().info("Deselecting the Check Box of " + object);
                       testReport.fillStepValue("Deselecting the Check Box");
                       if(locator.equals("xpath")){
                                       if ( driver.findElement(By.xpath(object)).isSelected())
                                       {
                                            driver.findElement(By.xpath(object)).click();
                                            NewLog.getLogger().info("CheckBox has been deselected " + object);
                                            
                                       }else{
                                               NewLog.getLogger().info("CheckBox aleardy deselected " + object);
                                       }
                       } else if(locator.equals("id")){
                               if ( driver.findElement(By.id(object)).isSelected())
                               {
                                    driver.findElement(By.id(object)).click();
                                    NewLog.getLogger().info("CheckBox has been deselected " + object);
                                    
                               }else{
                                       NewLog.getLogger().info("CheckBox aleardy deselected " + object);
                               }
               
                               
                       }else if(locator.equals("name")){
                               if ( driver.findElement(By.name(object)).isSelected())
                               {
                                    driver.findElement(By.name(object)).click();
                                    NewLog.getLogger().info("CheckBox has been deselected " + object);
                                    
                               }else{
                                       NewLog.getLogger().info("CheckBox aleardy deselected " + object);
                               }
               
                               
                       }else if(locator.equals("classname")){
                               if ( driver.findElement(By.className(object)).isSelected())
                               {
                                    driver.findElement(By.cssSelector(object)).click();
                                    NewLog.getLogger().info("CheckBox has been deselected " + object);
                                    
                               }else{
                                       NewLog.getLogger().info("CheckBox aleardy deselected " + object);
                               }
               
                               
                       }else if(locator.equals("csselector")){
                               if ( driver.findElement(By.cssSelector(object)).isSelected())
                               {
                                    driver.findElement(By.cssSelector(object)).click();
                                    NewLog.getLogger().info("CheckBox has been deselected " + object);
                                    
                               }else{
                                       NewLog.getLogger().info("CheckBox aleardy deselected " + object);
                               }
               
                               
                       }else if(locator.equals("linktext")){
                               if ( driver.findElement(By.linkText(object)).isSelected())
                               {
                                    driver.findElement(By.linkText(object)).click();
                                    NewLog.getLogger().info("CheckBox has been deselected " + object);
                                    
                               }else{
                                       NewLog.getLogger().info("CheckBox aleardy deselected " + object);
                               }
               
                               
                       }else if(locator.equals("tagname")){
                               if ( driver.findElement(By.tagName(object)).isSelected())
                               {
                                    driver.findElement(By.tagName(object)).click();
                                    NewLog.getLogger().info("CheckBox has been deselected " + object);
                                    
                               }else{
                                       NewLog.getLogger().info("CheckBox aleardy deselected " + object);
                               }
                       }else{
                               if ( driver.findElement(By.partialLinkText(object)).isSelected())
                               {
                                    driver.findElement(By.partialLinkText(object)).click();
                                    NewLog.getLogger().info("CheckBox has been deselected " + object);
                                    
                               }else{
                                       NewLog.getLogger().info("CheckBox aleardy deselected " + object);
                               }
                       }
                       return "PASSED";
                       }catch(Exception e){
                        
                       NewLog.getLogger().error("Not able to deselected the checkbox --- " + e.getMessage());
                       driver.quit();
                       return "FAILED";
                        
                       }
               }
public static String selectByValue(WebDriver driver,String object,String data, String locator, TestReport testReport){
               
               try {
                       NewLog.getLogger().info("Selecting from dropdown values by provided data");
                       testReport.fillStepValue("selecting from dropdown values by provided data");
                       if(locator.equals("xpath")){
                               new Select(driver.findElement(By.xpath(object))).selectByVisibleText(data);
                       }else if(locator.equals("id")){
                               new Select(driver.findElement(By.id(object))).selectByVisibleText(data);
                       }else if(locator.equals("name")){
                               new Select(driver.findElement(By.name(object))).selectByVisibleText(data);
                       }else if(locator.equals("csselector")){
                               new Select(driver.findElement(By.cssSelector(object))).selectByVisibleText(data);
                       }else if(locator.equals("classname")){
                               new Select(driver.findElement(By.className(object))).selectByVisibleText(data);
                       }else if(locator.equals("linktext")){
                               new Select(driver.findElement(By.linkText(object))).selectByVisibleText(data);
                       }else if(locator.equals("tagname")){
                               new Select(driver.findElement(By.tagName(object))).selectByVisibleText(data);
                       }else {
                               new Select(driver.findElement(By.partialLinkText(object))).selectByVisibleText(data);
                       }
                       return "PASSED";
               } catch (Exception e) {
                       NewLog.getLogger().error("Not able to select the dropdown value--- " + e.getMessage());
                       driver.quit();
                       return "FAILED";
               
               }
       }
      public static String selectRadioButton(WebDriver driver,String object,String data, String locator, TestReport testReport){
               try{
                       NewLog.getLogger().info("selecting the radio button of " + object);
                       testReport.fillStepValue("selecting the radio button");
                       if(locator.equals("xpath")){
                                       if ( !driver.findElement(By.xpath(object)).isSelected())
                                       {
                                            driver.findElement(By.xpath(object)).click();
                                            NewLog.getLogger().info("Radio button has been selected " + object);
                                            
                                       }else{
                                               NewLog.getLogger().info("Radio button aleardy selected " + object);
                                       }
                       } else if(locator.equals("id")){
                               if ( !driver.findElement(By.id(object)).isSelected())
                               {
                                    driver.findElement(By.id(object)).click();
                                    NewLog.getLogger().info("Radio button has been selected " + object);
                                    
                               }else{
                                       NewLog.getLogger().info("Radio button aleardy selected " + object);
                               }
               
                               
                       }else if(locator.equals("name")){
                               if ( !driver.findElement(By.name(object)).isSelected())
                               {
                                    driver.findElement(By.name(object)).click();
                                    NewLog.getLogger().info("Radio button has been selected " + object);
                                    
                               }else{
                                       NewLog.getLogger().info("Radio button aleardy selected " + object);
                               }
               
                               
                       }else if(locator.equals("classname")){
                               if ( !driver.findElement(By.className(object)).isSelected())
                               {
                                    driver.findElement(By.className(object)).click();
                                    NewLog.getLogger().info("Radio button has been selected " + object);
                                    
                               }else{
                                       NewLog.getLogger().info("Radio button aleardy selected " + object);
                               }
               
                               
                       }else if(locator.equals("csselector")){
                               if ( !driver.findElement(By.cssSelector(object)).isSelected())
                               {
                                    driver.findElement(By.cssSelector(object)).click();
                                    NewLog.getLogger().info("Radio button has been selected " + object);
                                    
                               }else{
                                       NewLog.getLogger().info("Radio button aleardy selected " + object);
                               }
               
                               
                       }else if(locator.equals("linktext")){
                               if ( !driver.findElement(By.linkText(object)).isSelected())
                               {
                                    driver.findElement(By.linkText(object)).click();
                                    NewLog.getLogger().info("Radio button has been selected " + object);
                                    
                               }else{
                                       NewLog.getLogger().info("Radio button aleardy selected " + object);
                               }
               
                               
                       }else if(locator.equals("tagname")){
                               if ( !driver.findElement(By.tagName(object)).isSelected())
                               {
                                    driver.findElement(By.tagName(object)).click();
                                    NewLog.getLogger().info("Radio button has been selected " + object);
                                    
                               }else{
                                       NewLog.getLogger().info("Radio button aleardy selected " + object);
                               }
                       }else{
                               if ( !driver.findElement(By.partialLinkText(object)).isSelected())
                               {
                                    driver.findElement(By.partialLinkText(object)).click();
                                    NewLog.getLogger().info("Radio button has been selected " + object);
                                    
                               }else{
                                       NewLog.getLogger().info("Radio button aleardy selected " + object);
                               }
                       }
                       return "PASSED" ;
                       }catch(Exception e){
                        
                        NewLog.getLogger().error("Not able to selected radio button --- " + e.getMessage());
                       driver.quit();
                       return "FAILED";
                        
                       }
               }
       public static String dateSelector(WebDriver driver,String object,String data, String locator, TestReport testReport){
               try{
                       testReport.fillStepValue("selecting the date");
                       
                       driver.findElement(By.xpath(object)).sendKeys(data);
                       return "PASSED";
               } catch (NoSuchElementException e){
                               NewLog.getLogger().error("Not able to Select the Data--- " + e.getMessage());
                       driver.quit();
                       return "FAILED";
               }
       }
      public static String pressTab(WebDriver driver,String object,String data, String locator, TestReport testReport){
               NewLog.getLogger().info("Selecting the Tab of " + object);
               testReport.fillStepValue("Selecting the Tab ");
               WebElement tabElement;
               try{
                       if(locator.equals("xpath")){
                               tabElement= driver.findElement(By.xpath(object));
                               
                       } else if(locator.equals("id")){
                               tabElement=driver.findElement(By.id(object));
                       }else if(locator.equals("name")){
                               tabElement=driver.findElement(By.name(object));
                       }else if(locator.equals("classname")){
                               tabElement=driver.findElement(By.className(object));
                       }else if(locator.equals("csselector")){
                               tabElement=driver.findElement(By.cssSelector(object));
                       }else if(locator.equals("linktext")){
                               tabElement=driver.findElement(By.linkText(object));
                       }else if(locator.equals("tagname")){
                               tabElement=driver.findElement(By.tagName(object));
                       }else{
                               tabElement=driver.findElement(By.partialLinkText(object));
                       }
                       tabElement.sendKeys(Keys.TAB);
                       return "PASSED" ;
               }catch(Exception e){
                       NewLog.getLogger().error("Not able to Select the Tab --- " + e.getMessage());
                       driver.quit();
                       return "FAILED";
                       
                       
               }
               
       }
public static String navigateto_NewTab(WebDriver driver,String object,String data, String locator, TestReport testReport){
                       try{
                               NewLog.getLogger().info("Navigate to the next tab");
                               testReport.fillStepValue("Navigate to the nexts tab");
                               
                       ArrayList<String> NewTab = new ArrayList<String> (driver.getWindowHandles());
       
                       driver.switchTo().window(NewTab.get(1));
                       return "PASSED" ;
                       }catch(Exception e){
                               NewLog.getLogger().error("Not able to Select the Tab --- " + e.getMessage());
                       driver.quit();
                       return "FAILED";
                               
                       }
               }
public static String verifyText(WebDriver driver,String object, String data, String locator, TestReport testReport){
               try{
                       boolean exists;
                       exists = driver.getPageSource().contains(data);
                       if(exists){
                       NewLog.getLogger().info("Verify the text "+data+" exists in the page");
                       return "PASSED";
                       }else{
                       NewLog.getLogger().info("Text doesn't Exists");
                       return "FAILED";
               }
                }catch(Exception e){
                        NewLog.getLogger().error("Not able to Verify the text "+data+" exists in the page" + e.getMessage());
                       driver.quit();
                       return "FAILED";
               }
               }
        public static void scShot(WebDriver driver,String testID,String paramName, TestReport testReport) {
               
               byte[] screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
               try {
                       File image = new File(Constants.htmlOutPath+"ScreenShots/");
                       image.mkdirs();
                       Files.write(screenShot, new File(image+"/"+testID+"_"+paramName+".png"));
               } catch (IOException e) {
                       // TODO Auto-generated catch block
                       e.printStackTrace();
               }
               
       }
}