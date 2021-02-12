package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YourAddressesPage {
	WebDriver driver;
	WebElement addressInputField;
	WebElement cityInputField;
	WebElement stateDropDownList;
	WebElement zipCodeInputField;
	WebElement homePhoneInputField;
	WebElement countryOption;
	WebElement aliasInputField;
	WebElement saveBtn;

	public YourAddressesPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getAddressInputField() {
		return driver.findElement(By.id("address1"));
	}
	public WebElement getCityInputField() {
		return driver.findElement(By.id("city"));
	}
	public WebElement getStateDropDownList() {
		return driver.findElement(By.id("id_state"));
	}
	public WebElement getZipCodeInputField() {
		return driver.findElement(By.id("postcode"));
	}
	public WebElement getHomePhoneInputField() {
		return driver.findElement(By.id("phone"));
	}
	public WebElement getCountryOption() {
		return driver.findElement(By.cssSelector("option[value='1']"));
	}
	public WebElement getAliasInputField() {
		return driver.findElement(By.id("alias"));
	}
	public WebElement getSaveBtn() {
		return driver.findElement(By.id("submitAddress"));
	}
	
	public void insertAddress(String address) {
		this.getAddressInputField().clear();
		this.getAddressInputField().sendKeys(address);
	}
	public void insertCity(String city) {
		this.getCityInputField().clear();
		this.getCityInputField().sendKeys(city);
	}
	public void chooseCountry() throws InterruptedException {
		this.getStateDropDownList().click();
		Thread.sleep(2000);
		this.getCountryOption().click();
	}
	public void insertZipCode(String zip) {
		this.getZipCodeInputField().clear();
		this.getZipCodeInputField().sendKeys(zip);
	}
	public void insertHomePhone(String phone) {
		this.getHomePhoneInputField().clear();
		this.getHomePhoneInputField().sendKeys(phone);
	}
	public void insertAlias(String alias) {
		this.getAliasInputField().clear();
		this.getAliasInputField().sendKeys(alias);
	}
	public void saveBtnClick() {
		this.getSaveBtn().click();
	}
}
