package utilities;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeClass;
import com.google.common.io.Files;
public class PageObjectBase{
    protected String pageTitle;
    protected String pageUrl;
    protected static WebDriver driver;
    public PageObjectBase(){
    }

  @BeforeClass
    public void getDeviceDriver() throws MalformedURLException, InterruptedException{
        String conf = Configurations.browserType;
if(conf.contentEquals("Mozilla")){
            System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "\\geckodriver.exe");
            driver =new FirefoxDriver();
        }else if(conf.contentEquals("Chrome")){
            System.setProperty("webdriver.chrome.driver3",System.getProperty("user.dir") + "\\chromedriver.exe");
            driver =new ChromeDriver();
        }else if(conf.contentEquals("IE")){
            System.setProperty("webdriver.ie.driver3",System.getProperty("user.dir") +"\\IEDriverServer.exe");
            driver =new InternetExplorerDriver();
        }
    }

  public static void getScreenshot(WebDriver driver,String location, String testId, String stepNo){
        byte[] screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        try {
            File image = new File(location+testId+"/ScreenShots/");
            image.mkdirs();
            Files.write(screenShot, new File(image+"/"+testId+"_"+stepNo+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
