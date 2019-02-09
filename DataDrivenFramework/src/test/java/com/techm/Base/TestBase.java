package com.techm.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

	
	/*
	 * WebDriver  ---Done
	 * Properties ---Done
	 * Logs		  ---Log4j Jar
	 * ExtentReport	
	 * DB
	 * Excel
	 * Mail
	 * ReportNG,ExtentReports
	 * Jenkins
	 * 
	 */
	public static WebDriver driver;
	public static Properties config  = new Properties();
	public static Properties OR  = new Properties();
	public static FileInputStream fis ;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	
	//before we call any of the testcases at the begginf we need to execute this 
	@BeforeSuite
	public void setUp()
	{
		
		if(driver == null)
		{
			
			try {
				fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			try {
				log.debug("Connfig File Loaded Successfully");
				config.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			try {
				log.debug("OR Property file loaded successfully");
				OR.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			if(config.getProperty("browser").equals("firefox"))
			{
				log.debug("FireFox Launched!!!");
				System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\geckodriver.exe");
				driver = new FirefoxDriver(); 
			}
			else if(config.getProperty("browser").equals("chrome"))
			{
				log.debug("Chrome Launched!!!");
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "\\src\\test\\resources\\executables\\chromedriver.exe");
				driver = new ChromeDriver();
			}
			else if(config.getProperty("browser").equals("IExplorer"))
			{
				System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+ "\\src\\test\\resources\\executables\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
			
			
			driver.get(config.getProperty("testsiteurl"));
			log.debug("Webpage:"+config.getProperty("testsiteurl") + "Is Loaded" );
			
			driver.manage().window().maximize(); 
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")), TimeUnit.SECONDS);

			
			
		}	
		
	}
	
	
	
	//after executing all things quitting things
	//executed after all our testcases
	@AfterSuite
	public void tearDown()
	{
		if(driver!=null)
		{
			driver.quit();
		}
		log.debug("TestExecution Successful");
	}
}
