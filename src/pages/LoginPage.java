package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	WebDriver driver;
	WebElement emailInputField;
	WebElement passwordInputField;
	WebElement signInBtn;
	WebElement errorText;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getEmailInputField() {
		return driver.findElement(By.id("email"));
	}

	public WebElement getPasswordInputField() {
		return driver.findElement(By.id("passwd"));
	}

	public WebElement getSignInBtn() {
		return driver.findElement(By.id("SubmitLogin"));
	}
	
	public WebElement getErrorText() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li"));
	}

	public void insertEmail(String email) {
		this.getEmailInputField().clear();
		this.getEmailInputField().sendKeys(email);
	}
	
	public void insertPassword(String password) {
		this.getPasswordInputField().clear();
		this.getPasswordInputField().sendKeys(password);
	}
	
	public void signInBtnClick() {
		this.getSignInBtn().click();
	}

}
