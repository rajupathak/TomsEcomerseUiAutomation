package com.toms.qa.checkoutpage;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.toms.qa.base.TestBase;

public class CheckOutReusableWebElements extends TestBase {

	@FindBy(xpath = "//ul[@id='order_confirm_share']/li")
	List<WebElement> socialNetWorkLinks;

	@FindBy(xpath = "//div[contains(@class,'forgot-pwd')]/a")
	WebElement forgotPasswordLink;

	@FindBy(xpath = "//a[contains(@class,'blutxtlink createNewAccCheckout')]")
	WebElement createAnAccountLink;

	@FindBy(xpath = "//input[contains(@id,'checkout_guest_butto')][contains(@type,'submit')]")
	WebElement checkOutAsGuestLink;

	@FindBy(xpath = "//div[@class='medium-12 columns']/h1")
	WebElement forgotPasswordText;
	
	
	@FindBy(xpath = "//div[@id='header_title']/h1")
	WebElement createAnAccountHeader;
	
	@FindBy(xpath = "//div[@class='medium-8 large-6 columns']/h1")
	WebElement shippingAddessheader;
	
	@FindBy(xpath = "(//a[starts-with(@id,'liveagent')])[4]")
	WebElement liveChatHelpButton;
	
	@FindBy(xpath = "//div[@id='header_title']/h2")
	WebElement liveChatPageHeader;
	
	
	
	public CheckOutReusableWebElements() {
		PageFactory.initElements(driver, this);
	}

	public List<WebElement> verifySocailnetWorkLink() {

		return socialNetWorkLinks;

	}

	public WebElement verifyforgotPasswordLink() {
		TestBase.highLightElement(driver, forgotPasswordLink);
		return forgotPasswordLink;

	}

	public WebElement verifycreateAnAccountLink() {
		TestBase.highLightElement(driver, createAnAccountLink);
		return createAnAccountLink;

	}
    
	public WebElement verifycheckOutAsGuestLink() {
		TestBase.highLightElement(driver, checkOutAsGuestLink);
		return checkOutAsGuestLink;

	}
	
	public WebElement verifyForgotPassowrdText() {
		TestBase.highLightElement(driver, forgotPasswordText);
		return forgotPasswordText;

	} 
	public WebElement verifyCreateAnAccountHeader() {
		TestBase.highLightElement(driver, createAnAccountHeader);
		return createAnAccountHeader;

	} 
	
	public WebElement verifyShippingAddressHeader() {
		TestBase.highLightElement(driver, shippingAddessheader);
		return shippingAddessheader;

	} 
	
	public WebElement verifyLiveChatBuutonClick() {
		TestBase.highLightElement(driver, liveChatHelpButton);
		return liveChatHelpButton;

	} 
	
	public WebElement verifyLiveChatPageHeader() {
		TestBase.highLightElement(driver, liveChatPageHeader);
		return liveChatPageHeader;

	} 
	
}
