package tests;

import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.MyAddressesPage;
import pages.MyStorePage;
import pages.MyWishlistsPage;
import pages.PersonalInfoPage;
import pages.YourAddressesPage;

public class TestBase {
	WebDriver driver;
	JavascriptExecutor js;
	ExcelReader excelReader;
	
	//pages
	MyStorePage myStorePage;
	LoginPage loginPage;
	MyAccountPage myAccountPage;
	MyAddressesPage myAddressPage;
	YourAddressesPage yourAddressesPage;
	PersonalInfoPage personalInfoPage;
	MyWishlistsPage myWishlistsPage;
	
	@BeforeClass
	public void beforeClass() throws IOException {
		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver");
		this.driver = new ChromeDriver();
		this.js = (JavascriptExecutor) driver;
		this.excelReader = new ExcelReader("data/test plan.xlsx");
		this.myStorePage = new MyStorePage(driver);
		this.loginPage = new LoginPage(driver);
		this.myAccountPage = new MyAccountPage(driver);
		this.myAddressPage = new MyAddressesPage(driver);
		this.yourAddressesPage = new YourAddressesPage(driver);
		this.personalInfoPage = new PersonalInfoPage(driver);
		this.myWishlistsPage = new MyWishlistsPage(driver);
		driver.manage().window().maximize();
	}
	
//	@AfterClass
	public void afterClass() throws IOException {
		driver.close();
		excelReader.fis.close();
	}
	
	public void assertText(String sheetName, int columne, int row, String textFromSite) {
		String textFromTable = excelReader.getData(sheetName, columne, row); 
		Assert.assertEquals(textFromSite, textFromTable);
		System.out.println("Successful assert.");
	}
	
	public void login() throws InterruptedException {
		String email = excelReader.getData("LogIn", 5, 6);
		String password = excelReader.getData("LogIn", 6, 6);
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
