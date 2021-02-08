package tests;

import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.LoginPage;
import pages.MyAccountPage;
import pages.MyStorePage;

public class TestBase {
	WebDriver driver;
	JavascriptExecutor js;
	ExcelReader excelReader;
	MyStorePage myStorePage;
	LoginPage loginPage;
	MyAccountPage myAccountPage;
	
	@BeforeClass
	public void preKlase() throws IOException {
		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver");
		this.driver = new ChromeDriver();
		this.js = (JavascriptExecutor) driver;
		this.excelReader = new ExcelReader("data/test plan.xlsx");
		this.myStorePage = new MyStorePage(driver);
		this.loginPage = new LoginPage(driver);
		this.myAccountPage = new MyAccountPage(driver);
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void pposleKlase() throws IOException {
		driver.close();
		excelReader.fis.close();
	}
}
