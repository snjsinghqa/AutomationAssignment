package automation.assignment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.assignment.common.StartUpPage;

public class FaceBookLogInPage extends StartUpPage {
	
	public FaceBookLogInPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(id = "email")
	public WebElement txtUserName;
	
	@FindBy(id = "pass")
	public WebElement txtPassword;
	
	@FindBy(css = "input[value= 'Log In']")
	public WebElement btnLogIn;
	
	@FindBy(id = "feedx_sprouts_container")
	public WebElement containerCreatePost;

	@FindBy(id = "div[aria-label*='Write something here']")
	public WebElement txtCreatePost;
	
	@FindBy(id = "button[data-testid*='post-button']")
	public WebElement btnPost;
	
}
