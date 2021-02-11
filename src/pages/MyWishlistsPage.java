package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyWishlistsPage {
	WebDriver driver;
	WebElement wishlistNameInputField;
	WebElement saveBtn;
	WebElement wishlistTable;
	WebElement removeIcon;

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
		return driver.findElement(By.className("icon"));
		//class="icon"
		//*[@id=\"wishlist_28212\"]/td[6]/a
	//	/html/body/div/div[2]/div/div[3]/div[2]/div/div[1]/table/tbody/tr/td[6]/a
	}

	public void insertWishlistName(String name) {
		this.getwishlistNameInputField().clear();
		this.getwishlistNameInputField().sendKeys(name);
	}
	
	public void removeIconClick() {
		this.getSaveBtn().click();
	}
	
	public void saveBtnClick() {
		this.getRemoveIcon().click();
	}
}
