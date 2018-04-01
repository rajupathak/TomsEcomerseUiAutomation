package com.toms.qa.pages.home;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.toms.qa.base.TestBase;
import com.toms.qa.commonobjectrepository.HomePageReusableWebElement;

public class HomePageAustria extends TestBase {
	HomePageReusableWebElement object= new HomePageReusableWebElement();
	@FindBy(xpath = "//div[@id='acceptCookies']//footer//div[contains(@class,'button blue accept-cookies lang-default')]")
	WebElement acceptCookiebutton;

	@FindBy(xpath = "//div[@id='overlay-inner']/a[contains(@id,'emailSignup_close')]")
	WebElement emailSignupbutton;
	
	
	// Initializing the Page Objects:
	public HomePageAustria() {
		PageFactory.initElements(driver, this);
	}

	

	public void acceptCookie() {
		if (acceptCookiebutton.isDisplayed()) {
			highLightElement(driver, acceptCookiebutton); 
			acceptCookiebutton.click();
		}
	}
 
	public void emailSignup_close() {
		if (emailSignupbutton.isDisplayed()) {
			highLightElement(driver, emailSignupbutton); 
			emailSignupbutton.click();
		}
	}
	
	
	
}
