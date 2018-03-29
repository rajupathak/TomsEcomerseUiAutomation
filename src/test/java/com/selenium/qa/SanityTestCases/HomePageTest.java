package com.selenium.qa.SanityTestCases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.toms.qa.base.TestBase;
import com.toms.qa.pages.HomePage;
import com.toms.qa.util.BrokenLinksUtility;

public class HomePageTest extends TestBase {
	HomePage homePageObject;
	BrokenLinksUtility brokenLinkObj;
	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		homePageObject = new HomePage();
		brokenLinkObj= new BrokenLinksUtility();
	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePageObject.verifyHomepageTitle();
		System.out.println("Title="+homePageTitle);
		Assert.assertEquals(homePageTitle, "TOMS® Official Site | The One for One® Company");
		
		homePageObject.closeThePopUpWindow();

	}
	@Test(priority = 2)
	public void verifyTotalLinkTest() throws InterruptedException{
		homePageObject.closeThePopUpWindow();
		List listOfHomePageLink=homePageObject.getAllHomePageLink();
		System.out.println("Total Active Link Pressent in the Home Page ==" +listOfHomePageLink.size());
	}
	
	@Test(priority = 3)
	public void verifyAllHomePageLinkTest(){
		homePageObject.closeThePopUpWindow();
		brokenLinkObj.verifyBrokenLink("http://www.toms.com/", homePageObject.getAllHomePageLink());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
