package com.selenium.qa.homepage.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.toms.qa.base.TestBase;

public class HomePageCANTest extends TestBase {
	
	public HomePageCANTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		
	}

	@Test()
	public void verifyHomePageTitleTest() {
		
           driver.get("http://gmail.com");
	}
	
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}

}
