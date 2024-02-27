package Code;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ExtentReportUtils;
import utils.Screenshots;

public class BasePageObject {
	

	public pagesCodes mc;
protected String captureScreenshot(String testCaseName,WebDriver driver) {
	    try {
	        TakesScreenshot ts = (TakesScreenshot) driver;
	        File source = ts.getScreenshotAs(OutputType.FILE);
	        File file = new File(System.getProperty("user.dir")+"//reports//"+ testCaseName +".png");
	        FileUtils.copyFile(source,file);
	        return System.getProperty("user.dir")+"//reports//"+ testCaseName +".png";
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }}
	public WebDriver driver;
	 String browserDetails;
	 String url;
	 String chromeeDriverPath;
	 String msEdgeDriverPath;
	 ExtentReportUtils extentReportUtils;
	public WebDriver initializeBrowser() {
		Properties prop = new Properties();
		try {
			//load a properties file from class path, inside static method
			prop.load(new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/resource/userDetails.properties"));
			
			//get the property value and print it out
			//printing browser details
			browserDetails = prop.getProperty("browser");
			System.out.println(browserDetails);
			if (browserDetails.equals("Firefox")) {
				WebDriverManager.firefoxdriver().setup(); 
				driver = new FirefoxDriver();
				driver = new FirefoxDriver();
	         }
			else if (browserDetails.equals("chrome")) {
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-notifications");
				driver = new ChromeDriver();			
	         }
			 else {
	             throw new RuntimeException("Browser type unsupported");
	         }
			driver.manage().window().maximize();

		} 
		catch (IOException ex) {
			System.err.print("failing inside propertiesFileRead");
			ex.printStackTrace();
		}
		return driver;
	}
	
	@BeforeMethod
	public pagesCodes launchApplication() throws FileNotFoundException, IOException {
		driver = initializeBrowser();
		Properties prop = new Properties();
		prop.load(new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/resource/userDetails.properties"));
		
		//get the property value and print it out
		//printing browser details
		url = prop.getProperty("url");
		mc = new pagesCodes(driver);
		mc.goTo(url);
		return mc;
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
}
