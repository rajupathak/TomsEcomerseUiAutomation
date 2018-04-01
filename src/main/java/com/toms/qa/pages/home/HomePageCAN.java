package com.toms.qa.pages.home;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.toms.qa.base.TestBase;

public class HomePageCAN extends TestBase {

	@FindBy(xpath = ".//*[@id='bx-close-inside-587447']")
	WebElement crossIcon;
 
	
	@FindBy(tagName = "a")
	List<WebElement> allAncheorTagLink;
 
	@FindBy(tagName = "img")
	List<WebElement> allImageTagLink;
 

	// Initializing the Page Objects:
	public HomePageCAN() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomepageTitle() {
		return driver.getTitle();
	}

	public void closeThePopUpWindow() {
		if (crossIcon.isDisplayed()) {
			crossIcon.click();
		}
	}

	public  List<WebElement> getAllHomePageLink(){
		boolean totalLink=allAncheorTagLink.addAll(allImageTagLink);
		return allAncheorTagLink;
		
	}
}
