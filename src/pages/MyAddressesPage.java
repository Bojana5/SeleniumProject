package pages;

import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAddressesPage {
	WebDriver driver;
	WebElement updateBtn;
	WebElement addressText;
	WebElement deleteBtn;
	WebElement noAddressesText;
	WebElement addAddressBtn;
	WebElement addressTitle;
	List<WebElement> addresses;

	public MyAddressesPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getUpdateBtn() {
		return driver.findElement(By.cssSelector("a[title='Update']"));
	}
	
	public WebElement getAddressText() {
		return driver.findElement(By.className("address_address1"));
	}

	public WebElement getDeleteBtn() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div[2]/ul/li[9]/a[2]"));
	}

	public WebElement getNoAddressesText() {
		return driver.findElement(By.className("alert-warning"));
	}

	public WebElement getAddAddressBtn() {
		return driver.findElement(By.cssSelector("a[title='Add an address']"));
	}

	public WebElement getAddressTitle() {
		return driver.findElement(By.className("page-subheading"));
	}
	
	public List<WebElement> getAddresses() {
		List<WebElement> allAddresses = driver.findElements(By.className("address"));
		return allAddresses;
	}

	public void updateBtnClick() {
		this.getUpdateBtn().click();
	}
	
	public void deleteBtnClick() {
		this.getDeleteBtn().click();
	}
	
	public void alertMessages() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public void addAddressBtnClick() {
		this.getAddAddressBtn().click();
	}
	
	public WebElement lastElementText(int indexOfAddresse) {
		WebElement lastAddress = getAddresses().get(indexOfAddresse);
		WebElement lastAddressText = lastAddress.findElement(By.className("page-subheading"));
		return lastAddressText;
	}
}
