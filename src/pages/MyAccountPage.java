package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {
	WebDriver driver;
	WebElement signOutBtn;
	
	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getSignOutBtn() {
		return driver.findElement(By.className("logout"));
	}
}
