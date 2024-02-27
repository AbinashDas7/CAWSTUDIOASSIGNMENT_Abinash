package Code;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import AbstractComponents.AbstractComponents;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCode extends BasePageObject{

	@Test
	public void startTest() throws FileNotFoundException, IOException {

	
	pagesCodes mc = new pagesCodes(driver);
//	mc.goTo();
	mc.clickOnTableData();
	mc.addKeysFromJson();
	mc.clickOnRefreshButton();
	mc.validateResults();
}
}
