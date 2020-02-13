package test_cases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automation.assignment.common.GenericPage;
import automation.assignment.pages.WallethubLoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyWalletHubReviewFun {
	private static WebDriver driver = null;
	WallethubLoginPage wallethubLoginPage;
	GenericPage genericPage;

	@BeforeMethod
	@BeforeClass(alwaysRun = true)
	public void setUp() {
		 WebDriverManager.chromedriver().setup(); 
		 driver = new ChromeDriver();
		 wallethubLoginPage = new WallethubLoginPage(driver);
		 genericPage = new GenericPage(driver);
		 driver.get("https://wallethub.com/join/light");
		 
	}

	@Test(alwaysRun = false)
	public void wallethubSignUpWithoutGetFreeCredit() {
		System.out.println(wallethubLoginPage.txtEmailAddress);
		genericPage.setTextValue(wallethubLoginPage.txtEmailAddress, "snjsingh19@gmail.com");
		genericPage.setTextValue(wallethubLoginPage.txtPassword, "Pass_123");
		genericPage.setTextValue(wallethubLoginPage.txtConfPassword, "Pass_123");
		genericPage.deselectCheckBox(wallethubLoginPage.chkGetFreeCredit);
		AssertJUnit.assertEquals(genericPage.isSelected(wallethubLoginPage.chkGetFreeCredit), false);
		genericPage.clickOnButton(wallethubLoginPage.btnJoin);
	}

	@Test
	@Parameters({ "whUsername", "whPassword", "whReviewURL", "sampleTxt"})
	public void verifyReviewFunctionality(String whUsername, String whPassword, String whReviewURL, String sampleTxt) {
		wallethubLoginPage.login(whUsername, whPassword);
		genericPage.navigateToURL(whReviewURL);
		genericPage.pageScroll(wallethubLoginPage.pnlReviewAction);
		genericPage.mouseHoverAndClick(wallethubLoginPage.FourthOfReviewStar);
		genericPage.clickByAction(wallethubLoginPage.ddlPolicyCategory);
		genericPage.mouseHoverAndClick(wallethubLoginPage.ddlHealthInsurance);
		genericPage.setTextValue(wallethubLoginPage.txtReviewContent, sampleTxt);
		genericPage.clickByAction(wallethubLoginPage.btnSubmitReview);
	}

	@AfterClass
	public void clenUp() {
		driver.close();
	}
}
