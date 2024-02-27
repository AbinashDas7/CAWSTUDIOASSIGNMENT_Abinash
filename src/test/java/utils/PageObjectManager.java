package utils;


import org.openqa.selenium.WebDriver;

import Code.pagesCodes;

public class PageObjectManager {
private WebDriver driver;
private static ThreadLocal<PageObjectManager> pageObjectManager = new ThreadLocal<>();
private pagesCodes mainCodepage;

public PageObjectManager(WebDriver driver) {
    this.driver = driver;
}

public pagesCodes mainCodePage() {
    return (mainCodepage == null) ? mainCodepage = new pagesCodes(driver) : mainCodepage;
}

public void set(PageObjectManager pageObjectManager2) {
	// TODO Auto-generated method stub
	
}

}
