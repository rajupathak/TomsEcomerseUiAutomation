package com.toms.qa.pages.productdetail;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.toms.qa.base.TestBase;

public class ProductDetailAustria extends TestBase{

	@FindBy(xpath="//div[contains(@class,'medium-8 columns hide-for-small')]//span[contains(text(),'Damenschuhe')]")
	WebElement heading;
	
	public ProductDetailAustria(){
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHeading(){
		return heading.getText();
	}
	
	
	
}
