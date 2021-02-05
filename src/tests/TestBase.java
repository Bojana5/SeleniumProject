package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {
	WebDriver driver;
	
	@BeforeClass
	public void preKlase() throws IOException {
		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver");
		
		this.driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void pposleKlase() throws IOException {
		driver.close();
	}

}
