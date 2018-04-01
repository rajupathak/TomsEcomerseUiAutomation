package com.selenium.qa.homepage.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.toms.qa.base.TestBase;
import com.toms.qa.checkoutpage.CheckOutAsGuest;
import com.toms.qa.checkoutpage.CheckOutReusableWebElements;
import com.toms.qa.commonobjectrepository.HomePageReusableWebElement;
import com.toms.qa.pages.home.HomePageAustria;
import com.toms.qa.pages.productdetail.ProductDetailAustria;
import com.toms.qa.util.BrokenLinksUtility;
import com.toms.qa.util.CheckOutUtility;
import com.toms.qa.util.MultipleWindowHandleUtility;
import com.toms.qa.util.ScreenShotUtility;
import com.toms.qa.util.SelectProductCategeoryUtility;
import com.toms.qa.util.WaitUtility;

public class HomePageAustraiTest extends TestBase {
	HomePageAustria homePageObject;
	BrokenLinksUtility brokenLinkObj;
	HomePageReusableWebElement reusableObject;
	SelectProductCategeoryUtility productSelectUtil;
	ProductDetailAustria productDetailObject;
	ScreenShotUtility screenshotutil;
	CheckOutUtility checkOutUtil;
	CheckOutReusableWebElements checkOutObject;
	WaitUtility waitObject;
	MultipleWindowHandleUtility windowUtility;
	CheckOutAsGuest checkoutGuestObject;

	public HomePageAustraiTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		driver.get(prop.getProperty("ausUrl"));
		homePageObject = new HomePageAustria();
		brokenLinkObj = new BrokenLinksUtility();
		reusableObject = new HomePageReusableWebElement();
		productDetailObject = new ProductDetailAustria();
		screenshotutil = new ScreenShotUtility();
		productSelectUtil = new SelectProductCategeoryUtility();
		checkOutUtil = new CheckOutUtility();
		checkOutObject = new CheckOutReusableWebElements();
		waitObject = new WaitUtility();
		windowUtility = new MultipleWindowHandleUtility();
		checkoutGuestObject = new CheckOutAsGuest();
	}

	/*
	 * @Test(priority=1) public void verifyHomePageTitleTest() throws
	 * InterruptedException { homePageObject.acceptCookie();
	 * 
	 * homePageObject.emailSignup_close();
	 * screenshotutil.getScreenShot("homepagescreen"); String homePageTitle =
	 * reusableObject.verifyHomepageTitle();
	 * 
	 * Assert.assertEquals(homePageTitle,
	 * "TOMS® Official Site | The One for One® Company");
	 * 
	 * }
	 * 
	 * @Test(priority=2) public void verifyHomePageLinkTest(){
	 * homePageObject.acceptCookie(); homePageObject.emailSignup_close();
	 * System.out.println("Total Active Link Pressent in the Home Page ==="
	 * +reusableObject.getAllHomePageLink().size()); //Checking for broken Link
	 * brokenLinkObj.verifyBrokenLink(prop.getProperty("ausUrl"),
	 * reusableObject.getAllHomePageLink()); }
	 */

	@Test(priority = 3)
	public void sanity_GuestUserCheckOutFlowTest() throws InterruptedException {
		homePageObject.acceptCookie();
		homePageObject.emailSignup_close();

		// Verify Cart before Adding the product

		reusableObject.moveToCart();
		screenshotutil.getScreenShot("Cart ");

		// Verify Cart product Size
		int initialQuantity = Integer.valueOf(reusableObject.verifyCartItem());

		Assert.assertEquals(initialQuantity, 0);

		// Select Shoes From Women Category

		checkOutUtil.selectShoesToBuy("Schuhe",
				reusableObject.clickOnproDuctToBuy(), "40", "Navy Stripe", "1");

		// Now verify Cart after adding Product

		reusableObject.moveToCart();
		screenshotutil.getScreenShot("Cart ");
		int afterAddingShoesProductQuantity = Integer.valueOf(reusableObject
				.verifyCartItem());

		Assert.assertEquals(afterAddingShoesProductQuantity, 1);

		// Select Bag From Women Category

		checkOutUtil.selectBagToBuy("Taschen",
				reusableObject.clickOnWomenBagToBuy(), "Black", "2");

		// Now verify Cart after adding Product

		reusableObject.moveToCart();
		screenshotutil.getScreenShot("Cart ");
		int afterAddingBagProductQuantity = Integer.valueOf(reusableObject
				.verifyCartItem());
		
		Assert.assertEquals(afterAddingBagProductQuantity, 3);

		// Click on Checkout Button
		reusableObject.clickOnCheckOutButton();
		screenshotutil.getScreenShot("CheckOutPage");

		// Verify Forgot password Link

		checkOutObject.verifyforgotPasswordLink().click();
		screenshotutil.getScreenShot("ForgotPassowrdJourneyPage");

		waitObject.sleep();
		Assert.assertTrue(checkOutObject.verifyForgotPassowrdText()
				.isDisplayed());

		driver.navigate().back();

		waitObject.sleep();

		// Verify createAnAccount Link
		checkOutObject.verifycreateAnAccountLink().click();

		screenshotutil.getScreenShot("CreateNewAccountJourneyPage");
		Assert.assertTrue(checkOutObject.verifyCreateAnAccountHeader()
				.isDisplayed());

		driver.navigate().back();
		waitObject.sleep();

		// Verify checkOutAsAGuest Link
		checkOutObject.verifycheckOutAsGuestLink().click();

		screenshotutil.getScreenShot("GuestUserJourneyPage");
		Assert.assertTrue(checkOutObject.verifyShippingAddressHeader()
				.isDisplayed());

		driver.navigate().back();

		// Verify LiveChat Button CLick

		MultipleWindowHandleUtility.switchToWindow(checkOutObject
				.verifyLiveChatBuutonClick());
		screenshotutil.getScreenShot("LiveChatPage");
		Assert.assertTrue(checkOutObject.verifyLiveChatPageHeader()
				.isDisplayed());

		driver.switchTo().window(windowUtility.parentWindow);

		// CheckOut As A Guest
		
		checkOutObject.verifycheckOutAsGuestLink().click();
		checkoutGuestObject.enterShippingAddress("Rajesh", "Pathak", "MBP",
				"243A", "560054", "Bangalore", "rajupthk@gmail.com",
				"8792698696");
		

	}

	@AfterMethod
	public void tearDown() {
		// driver.close();
	}

}
