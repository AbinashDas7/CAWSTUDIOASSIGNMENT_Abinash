package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentReportUtils {
	
	public static ExtentReports getReportsObjects(){
	String path = System.getProperty("user.dir")+"//reports//index.html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	reporter.config().setReportName("Results");
	reporter.config().setDocumentTitle("Test Results");
	
	ExtentReports extent = new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester","Abinash Das");
	extent.createTest(path);
	
	return extent;
}}
//    private static ExtentReports extent;
//    public static ExtentTest test;
//    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
//
//    public static ExtentReports initializeExtentReports() {
//        String reportFilePath = "./src/test/java/Screenshots/extentReport.html";
//        System.out.println("Extent Report stored at: " + new File(reportFilePath).getAbsolutePath());
//        
//        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportFilePath);
//        extent = new ExtentReports();
//        extent.attachReporter(htmlReporter);
//
//        htmlReporter.config().setChartVisibilityOnOpen(true);
//        htmlReporter.config().setDocumentTitle("TestingTable");
//        htmlReporter.config().setReportName("AutomationOn Table");
//        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
//        htmlReporter.config().setTheme(Theme.STANDARD);
//
//        return extent;
//    }
//
//    public static ExtentTest startTest(String testName) {
//        test = extent.createTest(testName);
//        extentTest.set(test);
//        return test;
//    }
//
//    public static void logInfo(String message) {
//        extentTest.get().log(Status.INFO, MarkupHelper.createLabel(message, ExtentColor.BLUE));
//    }
//
//    public static void logPass(String message) {
//        extentTest.get().log(Status.PASS, MarkupHelper.createLabel(message, ExtentColor.GREEN));
//    }
//
//    public static void logFail(String message) {
//        extentTest.get().log(Status.FAIL, MarkupHelper.createLabel(message, ExtentColor.RED));
//    }
//    public static void attachScreenshot() {
//        WebDriver driver = WebDriverManager.getDriver();
//        if (driver != null) {
//            TakesScreenshot screenshot = (TakesScreenshot) driver;
//            File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
//
//            try {
//                String screenshotDir = "./src/test/java/Screenshots/";
//                String screenshotPath = screenshotDir + "screenshot_" +
//                        new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + ".png";
//
//                Files.copy(sourceFile.toPath(), new File(screenshotPath).toPath(), StandardCopyOption.REPLACE_EXISTING);
//                extentTest.get().addScreenCaptureFromPath(screenshotPath);
//            } catch (Exception e) {
//                logFail("Failed to capture or attach screenshot: " + e.getMessage());
//            }
//        } else {
//            logFail("Failed to capture screenshot: WebDriver is null");
//        }
//    }
//
//    public static void flushReport() {
//        extent.flush();
//    }

