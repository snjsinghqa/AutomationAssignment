package automation.assignment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.assignment.common.StartUpPage;


public class WallethubLoginPage  extends StartUpPage{

	public WallethubLoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(css = "input[placeholder='Email Address']")
	public WebElement txtEmailAddress;
	
	@FindBy(css = "input[placeholder='Password']")
	public WebElement txtPassword;
	
	@FindBy(css = "input[placeholder='Confirm Password']")
	public WebElement txtConfPassword;
	
	@FindBy(css = ".track.bf-icon-ok")
	public WebElement chkGetFreeCredit;
	
	@FindBy(css = ".ng-not-empty")
	public WebElement chkGetFreeCreditSelected;
	
	@FindBy(css = ".ng-empty")
	public WebElement chkGetFreeCreditNotSelected;
	
	@FindBy(css = ".btn.blue.touch-element-cl")
	public WebElement btnJoin;

	@FindBy(css = ".toggle>.ng-untouched.ng-valid")
	public WebElement rememberEmail;

	@FindBy(css = "div.review-action")
	public WebElement pnlReviewAction;

	@FindBy(css = "div.review-action div > svg:nth-child(4)")
	public WebElement FourthOfReviewStar;

	@FindBy(css = ".wrev-user-input-box")
	public WebElement inputContainer;

	@FindBy(css = ".dropdown.second.opened ul :nth-child(2)")
	public WebElement ddlHealthInsurance;
	
	@FindBy(css = "div.dropdown:not(.drp-b-darker) span.dropdown-placeholder")
	public WebElement ddlPolicyCategory;

	@FindBy(css = "textarea.wrev-user-input")
	public WebElement txtReviewContent;

	@FindBy(css = "div.sbn-action")
	public WebElement btnSubmitReview;

	/**
	 * Login to WalletHub
	 * @param usernameEmail
	 * @param pass
	 * @author Sanjay.Panwar
	 */
	public void login(String usernameEmail, String pass) {
		genericPage.navigateToURL("https://wallethub.com/join/login");
		genericPage.setTextValue(txtEmailAddress, usernameEmail);
		genericPage.setTextValue(txtPassword, pass);
		genericPage.clickOnButton(btnJoin);
	}

}
