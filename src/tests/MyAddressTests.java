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
		String address = excelReader.getData("MyAddresses", 6, 7);
		navigateToMyAddress();	
		update(address);
		
		super.assertText("MyAddresses", 6, 7, myAddressPage.getAddressText().getText());
		
		revertInitialValues();
		super.assertText("MyAddresses", 7, 4, myAddressPage.getAddressText().getText());
	}
	
	@Test (priority = 5)
	public void addAddress() throws InterruptedException {
		String address = excelReader.getData("MyAddresses", 19, 7);
		String city = excelReader.getData("MyAddresses", 20, 7);
		String zip = excelReader.getData("MyAddresses", 22, 7);
		String phone = excelReader.getData("MyAddresses", 23, 7);
		String alias = excelReader.getData("MyAddresses", 24, 7);
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
		super.assertText("MyAddresses", 24, 7, myAddressPage.lastElementText(indexOfAddresse).getText());
	}
	
	@Test (priority = 10)
	public void deleteAddress() throws InterruptedException {
		navigateToMyAddress();
		int numberOfAddresses = myAddressPage.getAddresses().size();
		myAddressPage.deleteBtnClick();
		Thread.sleep(2000);
		super.alertMessagesAccept();
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
		String address = excelReader.getData("MyAddresses", 7, 4);
		update(address);	
	}
	public void navigateToMyAddress() throws InterruptedException {
		super.login();
		Thread.sleep(2000);
		myAccountPage.myAddressesClick();
		Thread.sleep(2000);
	}
}
