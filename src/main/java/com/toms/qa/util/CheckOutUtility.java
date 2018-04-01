package com.toms.qa.util;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.toms.qa.base.TestBase;
import com.toms.qa.commonobjectrepository.HomePageReusableWebElement;
import com.toms.qa.pages.home.HomePageAustria;
import com.toms.qa.pages.productdetail.ProductDetailAustria;

public class CheckOutUtility extends TestBase{
	HomePageAustria homePageObject=new HomePageAustria();
	BrokenLinksUtility brokenLinkObj= new BrokenLinksUtility();
	HomePageReusableWebElement reusableObject= new HomePageReusableWebElement();
	SelectProductCategeoryUtility productSelectUtil=new SelectProductCategeoryUtility();
	ProductDetailAustria productDetailObject=new ProductDetailAustria();
	ScreenShotUtility screenshotutil= new ScreenShotUtility();
	public void selectShoesToBuy(String productMenuename,WebElement element,String Size,String colour,String quantity) throws InterruptedException{
		productSelectUtil.selectProductFromWomenMenueBar(productMenuename, reusableObject.getShopMenubar(), reusableObject.getwomenSectionProductList());  
		  
	      //Assert.assertEquals(productDetailObject.verifyHeading(), "DAMENSCHUHE");
	      screenshotutil.getScreenShot("homepagescreen");
	      screenshotutil.getScreenShot("productDetail");
	      
	      //Select Shoes to Buy
	      
	      element.click();
	      screenshotutil.getScreenShot("Selected Product");
	      
	      //Zoom Out Selected Product
	      reusableObject.zoomSelectedProduct();
	      screenshotutil.getScreenShot("Selected Product Zoom Out");
	      
	 
	      
	      //Click on Colour Drop Down
	      
	      reusableObject.clickOnColourDropDown();
	      
	      //Select the Colour
	      reusableObject.selectProductColour(colour);
	      screenshotutil.getScreenShot("Selected Colour ");
	     
         //Click on Size Drop Down
	      
	      reusableObject.clickOnSizeDropDown();
	      
	      //Select the Colour
	      reusableObject.selectProductSize(Size);
	      screenshotutil.getScreenShot("Selected Size ");
	      
        //Click on Quantity Drop Down
	      
	      reusableObject.clickOnQuantitytDropDown();
	      
	      //Select the Quantity
	      reusableObject.selectProductQuantity(quantity);
	      screenshotutil.getScreenShot("Selected Quantity ");
	      
	     //Click of AddToCartButton
	      
	      reusableObject.clickOnAddToCartButton();
	     
	}
	
	public void selectBagToBuy(String productMenuename,WebElement element,String colour,String quantity) throws InterruptedException{
		productSelectUtil.selectProductFromWomenMenueBar(productMenuename, reusableObject.getShopMenubar(), reusableObject.getwomenSectionProductList());  
		  
	      //Assert.assertEquals(productDetailObject.verifyHeading(), "DAMENSCHUHE");
	      screenshotutil.getScreenShot("homepagescreen");
	      screenshotutil.getScreenShot("productDetail");
	      
	      //Select Shoes to Buy
	      
	      element.click();
	      screenshotutil.getScreenShot("Selected Product");
	      
	      //Zoom Out Selected Product
	      reusableObject.zoomSelectedProduct();
	      screenshotutil.getScreenShot("Selected Product Zoom Out");
	      
	 
	      
	      //Click on Colour Drop Down
	      
	      reusableObject.clickOnColourDropDown();
	      
	      //Select the Colour
	      reusableObject.selectProductColour(colour);
	      screenshotutil.getScreenShot("Selected Colour ");
	      
        //Click on Quantity Drop Down
	      
	      reusableObject.clickOnQuantitytDropDown();
	      
	      //Select the Quantity
	      reusableObject.selectProductQuantity(quantity);
	      screenshotutil.getScreenShot("Selected Quantity ");
	      
	     //Click of AddToCartButton
	      
	      reusableObject.clickOnAddToCartButton();
	     
	}
	
}
