package com.techm.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.techm.Base.TestBase;


public class AddCustomerTest extends TestBase{

	
	
	@Test(dataProvider="getData")
	public void addCustomerTest(String firstName, String lastName, String postCode) {
		
		driver.findElement(By.xpath(OR.getProperty("addCustBtn"))).click();
		log.debug("Clicked on Add Customer Button");
		driver.findElement(By.xpath(OR.getProperty("fname"))).sendKeys(firstName);
		driver.findElement(By.xpath(OR.getProperty("lname"))).sendKeys(lastName);
		driver.findElement(By.xpath(OR.getProperty("postcode"))).sendKeys(postCode);
		driver.findElement(By.xpath(OR.getProperty("addctmrbtn"))).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	@DataProvider
	public Object[][] getData()
	{
		String sheetName = "AddCustomerTest";
		 int rows = excel.getRowCount(sheetName);
		 int cols = excel.getColumnCount(sheetName);
		 
		 Object[][] data = new Object[rows-1][cols];
		 
		 for(int rowNum =2; rowNum<=rows;rowNum++)
		 {
			 for(int colNum=0;colNum<cols;colNum++) {
				 data[rowNum -2 ][colNum] = excel.getCellData(sheetName, colNum, rowNum);
			 }
		 }
		 return data;
	}
	
	
}



