package test_cases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import automation.assignment.common.GenericPage;
import automation.assignment.pages.FaceBookLogInPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FaceBookLoginTest {

	private static WebDriver driver;
	FaceBookLogInPage faceBookLogin;
	GenericPage genericPage;

	@BeforeMethod
	@BeforeClass
	public void setUp() {
		 WebDriverManager.chromedriver().setup(); 
		 driver = new ChromeDriver();
		 genericPage = new GenericPage(driver);
		 faceBookLogin = new FaceBookLogInPage(driver);
		 driver.manage().window().maximize();
		 driver.get("https://www.facebook.com/");
	}

	@Test
	@Parameters({ "fbUsername", "fbPassword"})
	public void faceBookLoginTest(String fbUsername, String fbPassword) {
		genericPage.setTextValue(faceBookLogin.txtUserName, fbUsername);
		genericPage.setTextValue(faceBookLogin.txtPassword, fbPassword);
		genericPage.clickOnButton(faceBookLogin.btnLogIn);
		genericPage.visibilityOfElement(faceBookLogin.containerCreatePost);
		genericPage.clickOnButton(faceBookLogin.containerCreatePost);
		genericPage.clickByAction(faceBookLogin.txtCreatePost);
		genericPage.setTextValue(faceBookLogin.txtCreatePost, "Hi World");
		genericPage.clickOnButton(faceBookLogin.btnPost);
	}

	@AfterClass
	public void clenUp() {
		driver.close();
	}

}
