package com.techm.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.techm.Base.TestBase;

public class LoginTest extends TestBase{

	@Test
	public void loginAsBankManager() throws InterruptedException
	{
		log.debug("Inside LoginTest");
		driver.findElement(By.cssSelector(OR.getProperty("bmlgnbtn"))).click();
		log.debug("Clicked on Bank Manager Login Button");
		Thread.sleep(2000);
	}
}
