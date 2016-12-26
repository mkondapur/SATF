package com.training.app;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MavenFirstTest {

	WebDriver driver;
	@BeforeClass
	public void setup() throws Exception{
		
		try {
			System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			
			
		} catch (Exception e) {
			
			throw new Exception("FAILED WHILE INTIALIZING BROWSER"+e.getLocalizedMessage());
		}
		
	}
@Test
	public void verify_Test() throws Exception{
		
		try {
			driver.get("https://www.google.co.in/");
			String text = driver.getTitle();
			System.out.println("HomePage title:"+text);
		} catch (Exception e) {
			throw new Exception("Failed while verifying:verify_Test"+e.getLocalizedMessage());
		}
	}

	@AfterClass
	public void tearDown() throws Exception{
		
		try {
			driver.quit();
		} catch (Exception e) {
			throw new Exception("FAILED WHILE TERMINATIONG BROWSER"+e.getLocalizedMessage());
		}
	}
}

