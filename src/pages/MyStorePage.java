package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyStorePage {
	WebDriver driver;
	WebElement signInBtn;
	
	public MyStorePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getSignInBtn() {
		return driver.findElement(By.className("login"));
	}
	
	public void signInBtnClick() {
		this.getSignInBtn().click();
	}
}
