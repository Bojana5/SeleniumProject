package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PersonalInfoPage {
	WebDriver driver;
	WebElement firstNameInputField;
	WebElement lastNameInputField;
	WebElement currentPasswordInputField;
	WebElement saveBtn;
	WebElement successMessage;
	WebElement accountNameText;
	WebElement backBtn;	

	public PersonalInfoPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getFirstNameInputField() {
		return driver.findElement(By.id("firstname"));
	}
	public WebElement getLastNameInputField() {
		return driver.findElement(By.id("lastname"));
	}
	public WebElement getCurrentPasswordInputField() {
		return driver.findElement(By.id("old_passwd"));
	}
	public WebElement getSaveBtn() {
		return driver.findElement(By.name("submitIdentity"));
	}
	public WebElement getSuccessMessage() {
		return driver.findElement(By.className("alert-success"));
	}

	public WebElement getAccountNameText() {
		return driver.findElement(By.className("account"));
	}

	public WebElement getBackBtn() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/a"));
	}

	public void insertFirstName(String firstName) {
		this.getFirstNameInputField().clear();
		this.getFirstNameInputField().sendKeys(firstName);
	}
	
	public void insertLastName(String lastName) {
		this.getLastNameInputField().clear();
		this.getLastNameInputField().sendKeys(lastName);
	}
	
	public void insertCurrentPassword(String password) {
		this.getCurrentPasswordInputField().clear();
		this.getCurrentPasswordInputField().sendKeys(password);
	}
	
	public void saveBtnClick() {
		this.getSaveBtn().click();
	}
	
	public void backBtnClick() {
		this.getBackBtn().click();
	}
}
