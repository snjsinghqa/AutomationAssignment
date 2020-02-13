package automation.assignment.common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class GenericPage {
WebDriver driver = null;
int TimeOut = 60;

	public GenericPage(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * Initialized wait
	 * @return
	 * @author Sanjay.Panwar
	 */
	public WebDriverWait waitTime() {
		WebDriverWait wait = new WebDriverWait(driver,TimeOut);
		return wait;
	}

	/**
	 * Wait till WebElement is not visible
	 * @param element
	 * @author Sanjay.Panwar
	 */
	public void visibilityOfElement(WebElement element) {
		waitTime().until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * WaitTill WebElement is not clickable 
	 * @param element
	 * @author Sanjay.Panwar
	 */
	public void elementToBeClickable(WebElement element) {
		waitTime().until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * Wait till WebElement is loaded in DOM
	 * @param locator
	 * @author Sanjay.Panwar
	 */
	public void presenceOfElementLocated(By locator) {
		waitTime().until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	/**
	 * To check WebElement is clicable or not
	 * @param element
	 * @return
	 * @author Sanjay.Panwar
	 */
	public boolean isElementClickable(WebElement element) {
		visibilityOfElement(element);
		return element.isSelected();
	}

	/**
	 * To Wait and Check WebElement is displayed or not
	 * @param element
	 * @return
	 * @author Sanjay.Panwar
	 */
	public boolean isDisplayed(WebElement element) {
		visibilityOfElement(element);
		return element.isDisplayed();
	}

	/**
	 * To check CheckBox is reltaed or not
	 * @param element
	 * @return
	 * @author Sanjay.Panwar
	 */
	public boolean isSelected(WebElement element) {
		visibilityOfElement(element);
		return element.isSelected();
	}

	/** 
	 * Enter the text
	 * @param txtValue
	 * @param element
	 * @author Sanjay.Panwar
	 */
	public void setTextValue(WebElement element, String txtValue) {
		visibilityOfElement(element);
		element.clear();
		element.sendKeys(txtValue);
	}

	/** 
	 * To click on button or link
	 * @param element
	 * @author Sanjay.Panwar
	 */
	public void clickOnButton(WebElement element) {
		elementToBeClickable(element);
		element.click();
	}

	/**
	 * Uncheck the alredy checked Check Box
	 * @param element
	 * @author Sanjay.Panwar
	 */
	public void deselectCheckBox(WebElement element) {
		visibilityOfElement(element);
		if (!isSelected(element)) {
			clickByAction(element);
		}
	}

	/**
	 * To perform click with the help of JavaScript click
	 * @param element
	 * @author Sanjay.Panwar
	 */
	public void jsClick(WebElement element) {
		String js = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";
		((JavascriptExecutor) driver).executeScript(js, element);
		element.click();
	}

	/**
	 * To Scroll the page untill element is visible
	 * @param element
	 * @author Sanjay.Panwar
	 */
	public void pageScroll(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//This will scroll the page till the element is found		
        js.executeScript("arguments[0].scrollIntoView();", element);
	}

	/**
	 * Click on button and link with the help Action class
	 * @param element
	 * @author Sanjay.Panwar
	 */
	public void clickByAction(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();
	}
	
	/**
	 * Navigate to URL
	 * @param url
	 * @author Sanjay.Panwar
	 */
	public void navigateToURL(String url) {
		driver.get(url);
	}

	/**
	 * Perform Mouse hover action and click action on link and button
	 * @param element
	 */
	public void mouseHoverAndClick(WebElement element) {
		Actions actions = new Actions(driver);
		visibilityOfElement(element);
		actions.moveToElement(element).click().build().perform();;
	}
}
