package tests;

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
//		String name = excelReader.getData("", , );
		super.login();
		Thread.sleep(2000);
		addWishlist("lista1");
		
		Assert.assertEquals(true, myWishlistsPage.getWishlistTable().isDisplayed());
	}
	
	@Test(priority = 15)
	public void deleteWishlist() throws InterruptedException {
//		String name = excelReader.getData("", , );
		super.login();
		Thread.sleep(2000);
		myAccountPage.myWishlistsClick();
		Thread.sleep(2000);
		
		if (myWishlistsPage.getWishlistTable().isDisplayed() == false) {
			driver.manage().deleteAllCookies();
			addWishlist();
			Thread.sleep(2000);
		}
		myWishlistsPage.removeIconClick();
		Thread.sleep(2000);
		
		Assert.assertEquals(false, myWishlistsPage.getWishlistTable().isDisplayed());
	}
	
//	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
	
	public void addWishlist(String name) throws InterruptedException {
		myAccountPage.myWishlistsClick();
		Thread.sleep(2000);
		myWishlistsPage.insertWishlistName(name);
		Thread.sleep(2000);
		myWishlistsPage.saveBtnClick();
		Thread.sleep(2000);
		
	}

}
