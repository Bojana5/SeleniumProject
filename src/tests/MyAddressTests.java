package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyAddressTests extends TestBase{
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		driver.navigate().to("http://automationpractice.com/index.php");
		Thread.sleep(2000);
	}
	
	@Test (priority = 0)
	public void updateAddress() throws InterruptedException {
		String address = excelReader.getData("Update addresses", 6, 7);
		navigateToMyAddress();
		
/*		if (myAddressPage.getAddresses().size() == 0) {
			this.addAddress();
		}
*/		
		update(address);
		super.assertText("Update addresses", 6, 7, myAddressPage.getAddressText().getText());
		
		revertInitialValues();
		super.assertText("Update addresses", 7, 4, myAddressPage.getAddressText().getText());
	}
	
	@Test (priority = 5)
	public void addAddress() throws InterruptedException {
		String address = excelReader.getData("Update addresses", 19, 7);
		String city = excelReader.getData("Update addresses", 20, 7);
		String zip = excelReader.getData("Update addresses", 22, 7);
		String phone = excelReader.getData("Update addresses", 23, 7);
		String alias = excelReader.getData("Update addresses", 24, 7);
		
		navigateToMyAddress();
		
		int numberOfAddresses = myAddressPage.getAddresses().size();
		System.out.println(numberOfAddresses);
		
		myAddressPage.addAddressBtnClick();
		Thread.sleep(2000);
		yourAddressesPage.insertAddress(address);
		Thread.sleep(2000);
		yourAddressesPage.insertCity(city);
		Thread.sleep(2000);
		yourAddressesPage.chooseCountry();
		Thread.sleep(2000);
		yourAddressesPage.insertZipCode(zip);
		Thread.sleep(2000);
		yourAddressesPage.insertHomePhone(phone);
		Thread.sleep(2000);
		yourAddressesPage.insertAlias(alias);
		Thread.sleep(2000);
		yourAddressesPage.saveBtnClick();

		System.out.println("Currently, there are " + myAddressPage.getAddresses().size() + " addresses added.");
		Assert.assertEquals(myAddressPage.getAddresses().size(), (numberOfAddresses + 1));
		
		int indexOfAddresse = myAddressPage.getAddresses().size() - 1;
		super.assertText("Update addresses", 24, 7, myAddressPage.lastElementText(indexOfAddresse).getText());
	}
	
	@Test (priority = 10)
	public void deleteAddress() throws InterruptedException {
		navigateToMyAddress();
		int numberOfAddresses = myAddressPage.getAddresses().size();
		
/*		if (myAddressPage.getAddresses().size() == 0) {
			this.addAddress();
		}
*/		
		myAddressPage.deleteBtnClick();
		Thread.sleep(2000);
		myAddressPage.alertMessages();
		Thread.sleep(2000);
		
		Assert.assertEquals(myAddressPage.getAddresses().size(), (numberOfAddresses - 1));
	}
	
	
	
	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
	
	public void update(String address) throws InterruptedException {
		myAddressPage.updateBtnClick();
		Thread.sleep(2000);
		yourAddressesPage.insertAddress(address);
		Thread.sleep(2000);
		yourAddressesPage.saveBtnClick();
	}
	
	public void revertInitialValues() throws InterruptedException {
		String address = excelReader.getData("Update addresses", 7, 4);
		update(address);	
	}
	
	public void navigateToMyAddress() throws InterruptedException {
		super.login();
		Thread.sleep(2000);
		myAccountPage.myAddressesClick();
		Thread.sleep(2000);
	}
}
