package automation.assignment.common;

import org.openqa.selenium.WebDriver;


public class StartUpPage {
	
	public WebDriver driver;
	public GenericPage genericPage;
	
	public StartUpPage(WebDriver driver){
		this.driver = driver;
		genericPage = new GenericPage(driver);
	}

}
