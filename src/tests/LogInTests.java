package tests;

import org.testng.annotations.Test;

public class LogInTests extends TestBase{
	
	@Test
	public void loginTest() throws InterruptedException {
		driver.navigate().to("https://www.google.com");
		Thread.sleep(3000);
	}

}
