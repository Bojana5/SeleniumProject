package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyWishlistsPage {
	WebDriver driver;
	WebElement wishlistNameInputField;
	WebElement saveBtn;
	WebElement wishlistTable;
	WebElement removeIcon;
	List<WebElement> wishlistTableRows;	

	public MyWishlistsPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getwishlistNameInputField() {
		return driver.findElement(By.id("name"));
	}
	public WebElement getSaveBtn() {
		return driver.findElement(By.id("submitWishlist"));
	}
	public WebElement getWishlistTable() {
		return driver.findElement(By.className("table"));
	}
	public WebElement getRemoveIcon() {
		return driver.findElement(By.className("wishlist_delete"));
	}
	public List<WebElement> getWishlistTableRows() {
		List<WebElement> allWishlists = driver.findElements(By.cssSelector("tr[id^='wishlist']"));
		return allWishlists;
	}
	public void insertWishlistName(String name) {
		this.getwishlistNameInputField().clear();
		this.getwishlistNameInputField().sendKeys(name);
	}
	
	public void removeIconClick() {
		this.getRemoveIcon().click();
	}
	
	public void saveBtnClick() {
		this.getSaveBtn().click();
	}
	
	public WebElement element(int i) {
		WebElement element = getWishlistTableRows().get(i).findElement(By.className("icon-remove"));
		return element;
	}
	
	public boolean isElementPresent() {
	    try {
	    	getWishlistTable();
	        return true;
	    } catch (org.openqa.selenium.NoSuchElementException e) {
	        return false;
	    }
	}
}
