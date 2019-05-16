package com.techm.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.techm.Base.TestBase;

public class BankManagerLoginTest extends TestBase{

	@Test
	public void loginAsBankManager() throws InterruptedException
	{
		log.debug("Inside LoginTest");
		driver.findElement(By.cssSelector(OR.getProperty("bmlgnbtn"))).click();
		Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("addCustBtn"))),"lOGIN IS NOT SUCCESSFUL");
		Thread.sleep(2000);
	}
}
