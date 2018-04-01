package com.toms.qa.commonobjectrepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.toms.qa.base.TestBase;
import com.toms.qa.util.WaitUtility;

public class HomePageReusableWebElement extends TestBase {

	@FindBy(tagName = "a")
	List<WebElement> allAncheorTagLink;

	@FindBy(tagName = "img")
	List<WebElement> allImageTagLink;

	// Top menue bar

	// 1.Shop//nav[@class='meganav clearfix']//ul[@id='main-nav-bar']/li[3]/span
	//(//a[contains(@class,'topMainNav nav-top-link')])[1]
	
	@FindBy(xpath = ".//*[@id='main-nav-bar']/li[3]/span")
	
	
	WebElement shopMenue;

	// 2.How we Give
	@FindBy(xpath = "//nav[@class='meganav clearfix']//ul[@id='main-nav-bar']/li[4]/span")
	WebElement hoWeGiveMenue;

	// 3. Passport Rewards
	@FindBy(xpath = "//nav[@class='meganav clearfix']//ul[@id='main-nav-bar']/li[5]/span")
	WebElement passportRewardsMenue;

	// Women Section
	@FindBy(xpath = "(//ul[contains(@class,'clearfix sub-nav-full-width mega-sub-nav')]//li[contains(@class,'left')])[2]/ul/li/a")
	List<WebElement> womenSectionProductList;
	// Men Section
	@FindBy(xpath = "(//ul[contains(@class,'clearfix sub-nav-full-width mega-sub-nav')]//li[contains(@class,'left')])[3]/ul/li/a")
	List<WebElement> menSectionProductList;
	// Kids Section
	@FindBy(xpath = "(//ul[contains(@class,'clearfix sub-nav-full-width mega-sub-nav')]//li[contains(@class,'left')])[4]/ul/li/a")
	List<WebElement> kidsSectionProductList;

	// Select Shoes to buy
	@FindBy(xpath = "(//div[contains(@class,'search-results-grid-copy')]//span[contains(@class,'radius label product-state-1')])")
	WebElement newArrival;

	//
	@FindBy(xpath = "(//div[contains(@class,'search-results-grid-copy')]//span[contains(@class,'radius label product-state-1')])[1]")
	WebElement newArrivalBag;

	
	// After click Zoom the product||Mouse Hover

	@FindBy(xpath = "//img[contains(@id,'current-product')]")
	WebElement zoomProduct;

	// verify initially Cart is empty ||Mouse Hover

	@FindBy(xpath = "//a[@id='cart-num']")
	WebElement moveToCart;

	// Verify cart Number || Assert

	@FindBy(xpath = "//a[@id='cart-num']//span[1]")
	WebElement cartNumber;

	// Select The product Colour dropDown

	@FindBy(xpath = "(//div[contains(@class,'product-styles')]//div[@role='listbox'])[1]")
	WebElement dropDwonForColour;

	// List Of Colour

	@FindBy(xpath = "//div[contains(@class,'product-styles')]//div[contains(@role,'listbox')]//ul[@id='drop']/li")
	List<WebElement> listOfColour;
	
	// Select The product size Dropdon

	@FindBy(xpath = "(//div[contains(@class,'product-styles')]//div[@role='listbox'])[2]")
	WebElement dropDwonForSize;
	
	// Size Of product
	@FindBy(xpath = "//div[contains(@class,'product-styles')]//div[contains(@role,'listbox')]//ul[@id='drop2']/li")
	List<WebElement> sizeofproduct;

	
	//Drop Down For Quantity
	
	@FindBy(xpath = "//div[contains(@class,'small-3 columns qty_dropdown_new')]/a[@class='button dropdown large expand']")
	WebElement dropDwonForQuantity;
	
	// Quantity Of product
	@FindBy(xpath = "//div[contains(@class,'product-styles')]//div[contains(@role,'listbox')]//ul[@id='drop3']/li")
	List<WebElement> quantityOfProduct;
	
	//Click on Add to Cart
	@FindBy(xpath = "//a[contains(@id,'add_to_bag')][contains(@class,'btn green')]")
	WebElement addToCart;
	
	//Again veriy the Cart
	
	//Now Click on Check Out Button
	
	@FindBy(xpath = "//a[@class='btn green'][contains(@role,'button')][1]")
	WebElement checkOutButton;
	
	// Initializing the Page Objects:
	public HomePageReusableWebElement() {
		PageFactory.initElements(driver, this);
	}

	
	public String verifyHomepageTitle() {
		return driver.getTitle();
	}
	
	public List<WebElement> getAllHomePageLink() {
		allAncheorTagLink.addAll(allImageTagLink);
		return allAncheorTagLink;

	}

	// Fetching all the Top Menue Bar
	public WebElement getShopMenubar() {
		return shopMenue;
	}

	public WebElement getHowWeGiveMenubar() {
		return hoWeGiveMenue;
	}

	public WebElement getPassportRewardsMenubar() {
		return passportRewardsMenue;
	}

	// Fetching all the Product List from Women Section
	public List<WebElement> getwomenSectionProductList() {
		return womenSectionProductList;
	}

	public List<WebElement> getMenSectionProductList() {
		return menSectionProductList;
	}

	public List<WebElement> getKidsSectionProductList() {
		return kidsSectionProductList;

	}

	public WebElement  clickOnproDuctToBuy(){
		
		return newArrival;
	}
	
	public WebElement clickOnWomenBagToBuy(){
		return newArrivalBag;
	}
	
	
	public void zoomSelectedProduct(){
		TestBase.mouseHover(driver,zoomProduct);
		TestBase.highLightElement(driver, zoomProduct);
		
	}
	
	public void moveToCart() throws InterruptedException{
		TestBase.mouseHover(driver,moveToCart);
	     WaitUtility.sleep();
		TestBase.highLightElement(driver, moveToCart);
		
	}
	
	public String verifyCartItem(){
		return cartNumber.getText();
	}
	
	public void  clickOnColourDropDown(){
		TestBase.highLightElement(driver, dropDwonForColour);
		dropDwonForColour.click();
	}
	
	public void selectProductColour(String colour){
		List<WebElement>listOfColours=listOfColour;
		for(WebElement colours:listOfColours){
			String colourText=colours.getText();
			if(colourText.equalsIgnoreCase(colour)){
				colours.click();
				break;
			}
			listOfColours=listOfColour;
		}
		
	}
	
	public void  clickOnSizeDropDown(){
		TestBase.highLightElement(driver, dropDwonForSize);
		dropDwonForSize.click();
	}
	
	public void selectProductSize(String ProductSize){
		List<WebElement>listOFSize=sizeofproduct;
		for(WebElement sizeList:listOFSize){
			String size=sizeList.getText();
			if(size.equalsIgnoreCase(ProductSize)){
				sizeList.click();
				break;
			}
			listOFSize=sizeofproduct;
		}
		
	}
	
	
	
	
	public void  clickOnQuantitytDropDown(){
		TestBase.highLightElement(driver, dropDwonForQuantity);
		dropDwonForQuantity.click();
	}
	
	public void selectProductQuantity(String  quantity){
		for(WebElement quantityList:quantityOfProduct){
			String productQuantity=quantityList.getText();
			if(productQuantity.equalsIgnoreCase(quantity)){
				quantityList.click();
				break;
			}
		}
		
	}
	
	public void clickOnAddToCartButton(){
		TestBase.highLightElement(driver, addToCart);
		addToCart.click();
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void clickOnCheckOutButton(){
		//moveToCart();
		checkOutButton.click();
	}
	
	
}
