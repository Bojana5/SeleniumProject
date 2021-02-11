package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PersonalInfoTests extends TestBase{
	@BeforeMethod
	public void setup() throws InterruptedException {
		driver.navigate().to("http://automationpractice.com/index.php");
		Thread.sleep(2000);
	}
	
	@Test (priority = 0)
	public void editName() throws InterruptedException {
		super.login();
		Thread.sleep(2000);
		String firstName = excelReader.getData("Edit personal info", 4, 7);
		String lastName = excelReader.getData("Edit personal info", 5, 7);
		String password = excelReader.getData("Edit personal info", 6, 7);
		editNameMethod(firstName, lastName, password);
		super.assertText("Edit personal info", 7, 10, personalInfoPage.getSuccessMessage().getText());
		super.assertText("Edit personal info", 6, 10, personalInfoPage.getAccountNameText().getText());
		
		revertInitialValues();
		super.assertText("Edit personal info", 5, 10, personalInfoPage.getAccountNameText().getText());
	}
	
	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
	
	public void editNameMethod(String firstName, String lastName, String password) throws InterruptedException {
		
		myAccountPage.personalInfoClick();
		Thread.sleep(2000);
		personalInfoPage.insertFirstName(firstName);
		Thread.sleep(2000);
		personalInfoPage.insertLastName(lastName);
		Thread.sleep(2000);
		personalInfoPage.insertCurrentPassword(password);
		Thread.sleep(2000);
		personalInfoPage.saveBtnClick();
		Thread.sleep(2000);
	}
	
	public void revertInitialValues() throws InterruptedException {
		personalInfoPage.backBtnClick();
		Thread.sleep(2000);
		String firstNameInitial = excelReader.getData("Edit personal info", 6, 4);
		String lastNameInitial = excelReader.getData("Edit personal info", 7, 4);
		String password = excelReader.getData("Edit personal info", 6, 7);
		editNameMethod(firstNameInitial, lastNameInitial, password);
		
	}

}
