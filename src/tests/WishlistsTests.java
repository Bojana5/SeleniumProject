package tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WishlistsTests extends TestBase{
	@BeforeMethod
	public void setup() throws InterruptedException {
		driver.navigate().to("http://automationpractice.com/index.php");
		Thread.sleep(2000);
	}
	
	@Test(priority = 0)
	public void addWishlist() throws InterruptedException {
		String wishlistName = excelReader.getData("Wishlist", 5, 6);
		navigateToMyWishlists();
		addWishlist(wishlistName);
		
		Assert.assertEquals(myWishlistsPage.getWishlistTable().isDisplayed(), true);
	}
	
	@Test(priority = 5)
	public void addTwoWishlists() throws InterruptedException {
		String wishlistName1 = excelReader.getData("Wishlist", 6, 6);
		String wishlistName2 = excelReader.getData("Wishlist", 7, 6);
		navigateToMyWishlists();
		
		int numberOfWishlists = myWishlistsPage.getWishlistTableRows().size();
		
		addWishlist(wishlistName1);
		addWishlist(wishlistName2);
		
		Assert.assertEquals(myWishlistsPage.getWishlistTable().isDisplayed(), true);
		Assert.assertEquals(myWishlistsPage.getWishlistTableRows().size(), (numberOfWishlists + 2));
	}
	
	@Test(priority = 10)
	public void deleteWishlists() throws InterruptedException {
		navigateToMyWishlists();
		
		if (myWishlistsPage.isElementPresent() == false) {
			myAccountPage.signOutBtnClick();
			Thread.sleep(2000);
			addWishlist();
			Thread.sleep(2000);
		}
		
		
		List<WebElement> deleteWishlist = myWishlistsPage.getWishlistDeleteBtn();
		for (int i = 0; i < deleteWishlist.size(); i++) {
			deleteWishlist.get(i).click();
			super.alertMessagesAccept();
			Thread.sleep(2000);
		}
		
		driver.navigate().refresh();
		Thread.sleep(2000);
		Assert.assertEquals(myWishlistsPage.isElementPresent(), false);
	}
	
	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
	
	public void navigateToMyWishlists() throws InterruptedException {
		super.login();
		Thread.sleep(2000);
		myAccountPage.myWishlistsClick();
		Thread.sleep(2000);
	}
	public void addWishlist(String name) throws InterruptedException {
		myWishlistsPage.insertWishlistName(name);
		Thread.sleep(2000);
		myWishlistsPage.saveBtnClick();
		Thread.sleep(2000);	
	}
}
