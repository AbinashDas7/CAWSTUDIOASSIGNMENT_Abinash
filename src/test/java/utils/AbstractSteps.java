package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public abstract class AbstractSteps {
    private static ThreadLocal<DriverManager> driverManager = new ThreadLocal<>();
    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static ThreadLocal<PageObjectManager> pageObjectManager = new ThreadLocal<>();

    protected AbstractSteps() {
        initializePageObjectManager();
    }

    private void initializePageObjectManager() {
        WebDriver driver = getDriver();
        if (driver != null) {
            pageObjectManager.set(new PageObjectManager(driver));
        } else {
            throw new IllegalStateException("WebDriver has not been initialized.");
        }
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    public void setDriver(WebDriver driver) {
        AbstractSteps.driver.set(driver);
    }

    public PageObjectManager getPageObjectManager() {
        return pageObjectManager.get();
    }

    public void propertiesFileRead() {
        System.out.println("------------------------Given User details read from propertiesfile--------------------");
        System.out.println("entering into propertiesFileRead");

        Properties prop = new Properties();
        try {
            // Load a properties file from class path, inside static method
            prop.load(new FileInputStream("src\\test\\resources\\resource\\userDetails.properties"));

            // Get the property value and print it out
            // Printing browser details
            String browserDetails = prop.getProperty("browser");
            System.out.println(browserDetails);
            String url = prop.getProperty("url");

            // Printing edge driver path
            String msEdgeDriverPath = prop.getProperty("msEdgeDriverPath");

            // Printing chrome driver path
            String chromeeDriverPath = prop.getProperty("chromeDriverPath");

        } catch (IOException ex) {
            System.err.print("Failing inside propertiesFileRead");
            ex.printStackTrace();
        }
        System.out.println("Exiting propertiesFileRead");
    }
}
