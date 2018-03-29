package com.toms.qa.pages;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.toms.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = ".//*[@id='bx-close-inside-587447']")
	WebElement crossIcon;


	// Initializing the Page Objects:
	public HomePage() {
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

	public  List<WebElement> getAllHomePageLink() throws InterruptedException {

		List<WebElement> elementList = new ArrayList<WebElement>();
		 
		  elementList = driver.findElements(By.tagName("a"));
	      
		  elementList.addAll(driver.findElements(By.tagName("img")));
	 
		  List<WebElement> finalList = new ArrayList<WebElement>(); ;
	 
		  for (WebElement element : elementList)
	 
		  {
	 
			  if(element.getAttribute("href") != null)
	 
			  {
	 
				  finalList.add(element);
	 
			  }		  
	 
		  }	
	 
		  return finalList;
	}
}
