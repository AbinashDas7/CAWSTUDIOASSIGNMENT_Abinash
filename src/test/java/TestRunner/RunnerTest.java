package TestRunner;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.TestNG;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/feature/tableBrowser.feature", 
glue = "Code",monochrome=true,plugin= {"html:target/cucumber.html"})
	public class RunnerTest extends AbstractTestNGCucumberTests {


}

