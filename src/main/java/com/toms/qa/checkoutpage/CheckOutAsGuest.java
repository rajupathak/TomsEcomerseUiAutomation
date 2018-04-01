package com.toms.qa.checkoutpage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.toms.qa.base.TestBase;

public class CheckOutAsGuest extends TestBase{

	@FindBy(id = "first_name")
	WebElement firstName;

	@FindBy(id = "last_name")
	WebElement lastName;

	@FindBy(id = "address_one")
	WebElement address;

	@FindBy(id = "address_two")
	WebElement apartMent;

	@FindBy(xpath = "//input[starts-with(@id,'address_five')]")
	WebElement zipCode;

	@FindBy(id = "address_three")
	WebElement city;

	@FindBy(id = "email")
	WebElement email;

	@FindBy(id = "phone")
	WebElement phone;

	@FindBy(id = "state")
	WebElement state;

	@FindBy(id = "country")
	WebElement country;

	
	public CheckOutAsGuest(){
		PageFactory.initElements(driver, this);
	}
	public void enterShippingAddress(String FirstName, String LastName,
			String Address, String Aprtment, String ZipCode, String City,
			String Email, String PhoneNumber) {
		TestBase.highLightElement(driver, firstName);
		firstName.sendKeys(FirstName);
		TestBase.highLightElement(driver, lastName);
		lastName.sendKeys(LastName);
		TestBase.highLightElement(driver, address);
		address.sendKeys(Address);
		TestBase.highLightElement(driver, apartMent);
		apartMent.sendKeys(Aprtment);
		TestBase.highLightElement(driver, zipCode);
		zipCode.sendKeys(ZipCode);
		TestBase.highLightElement(driver, city);
		city.sendKeys(City);
		TestBase.highLightElement(driver, email);
		email.sendKeys(Email);
		TestBase.highLightElement(driver, phone);
		phone.sendKeys(PhoneNumber);
	}

}
