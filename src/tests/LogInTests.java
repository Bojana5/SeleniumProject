package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInTests extends TestBase{
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		driver.navigate().to("http://automationpractice.com/index.php");
		Thread.sleep(2000);
	}
	
	@Test (priority = 0)
	public void loginValidCredentials() throws InterruptedException {
		super.login();
		Assert.assertEquals(true, myAccountPage.getSignOutBtn().isDisplayed());
	}
	
	@Test (priority = 5)
	public void loginInvalidEmail() throws InterruptedException {
		String email = excelReader.getData("LogIn", 12, 6);
		String password = excelReader.getData("LogIn", 13, 6);
		signIn(email, password);
		
		super.assertText("LogIn", 14, 9, loginPage.getErrorText().getText());
	}
	
	@Test (priority = 10)
	public void loginInvalidPassword() throws InterruptedException {
		String email = excelReader.getData("LogIn", 19, 6);
		String password = excelReader.getData("LogIn", 20, 6);
		signIn(email, password);
		
		super.assertText("LogIn", 21, 9, loginPage.getErrorText().getText());
	}
	
	@Test (priority = 15)
	public void loginInvalidCredentials() throws InterruptedException {
		String email = excelReader.getData("LogIn", 26, 6);
		String password = excelReader.getData("LogIn", 27, 6);
		signIn(email, password);
		
		super.assertText("LogIn", 28, 9, loginPage.getErrorText().getText());
	}
	
	@Test (priority = 15)
	public void loginEmptyCredentials() throws InterruptedException {		
		String email = excelReader.getData("LogIn", 33, 6);
		String password = excelReader.getData("LogIn", 34, 6);
		signIn(email, password);
		
		super.assertText("LogIn", 35, 9, loginPage.getErrorText().getText());
	}
	
	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
	
	public void signIn(String email, String password) throws InterruptedException {
		myStorePage.signInBtnClick();
		Thread.sleep(2000);
		loginPage.insertEmail(email);
		Thread.sleep(2000);
		loginPage.insertPassword(password);
		Thread.sleep(2000);
		loginPage.signInBtnClick();
		Thread.sleep(2000);	
	}
}
