package utils;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext ;		
import org.testng.ITestListener ;		
import org.testng.ITestResult ;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Code.BasePageObject;		

public class Listeners extends BasePageObject implements ITestListener						
{		
	ExtentReports extent = ExtentReportUtils.getReportsObjects();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	ExtentTest test;
    @Override		
    public void onFinish(ITestContext arg0) {					
        // TODO Auto-generated method stub				
        	extent.flush();	
    }		

    @Override		
    public void onStart(ITestContext arg0) {					
        // TODO Auto-generated method stub				
    	
    }		

    @Override		
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

    @Override		
    public void onTestFailure(ITestResult result) {					
        // TODO Auto-generated method stub	   
    	try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		extentTest.get().fail(result.getThrowable());	
    	String filePath;
    	filePath = captureScreenshot(result.getMethod().getMethodName(),driver);
    	test.addScreenCaptureFromPath(filePath,result.getMethod().getMethodName());
    }		

    @Override		
    public void onTestSkipped(ITestResult arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

    @Override		
    public void onTestStart(ITestResult result) {					
        // TODO Auto-generated method stub				
    	test = extent.createTest(result.getMethod().getMethodName());	
    	extentTest.set(test);
    }		

    @Override		
    public void onTestSuccess(ITestResult arg0) {					
        // TODO Auto-generated method stub		
    	test.log(Status.PASS,"Test Passed");
        		
    }		
}	