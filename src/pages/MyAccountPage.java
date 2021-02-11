package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {
	WebDriver driver;
	WebElement signOutBtn;
	WebElement myAddresses;
	WebElement personalInfo;
	WebElement myWishlists;

	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getSignOutBtn() {
		return driver.findElement(By.className("logout"));
	}

	public WebElement getMyAddresses() {
		return driver.findElement(By.cssSelector("a[title='Addresses']"));
	}
	
	public WebElement getPersonalInfo() {
		return driver.findElement(By.cssSelector("a[title='Information']"));
	}

	public WebElement getMyWishlists() {
		return driver.findElement(By.className("lnk_wishlist"));
	}

	public void myAddressesClick() {
		this.getMyAddresses().click();
	}
	
	public void signOutBtnClick() {
		this.getSignOutBtn().click();
	}
	
	public void personalInfoClick() {
		this.getPersonalInfo().click();
	}
	
	public void myWishlistsClick() {
		this.getMyWishlists().click();
	}
	
}
