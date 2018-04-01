package com.toms.qa.util;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.toms.qa.base.TestBase;

public class SelectProductCategeoryUtility extends TestBase {

	 Actions action = new Actions(driver);
	 WaitUtility waitObejct= new WaitUtility();

	public  void selectProductFromWomenMenueBar(String productName,
			WebElement topMenueBar, List<WebElement> womenProductLink)
			throws InterruptedException {
		
		waitObejct.waitForTheWebElementToBeVisible(topMenueBar, driver, 20);
		action.moveToElement(topMenueBar).build().perform();
		((JavascriptExecutor) driver).executeScript("arguments[0].focus();",topMenueBar);
		
		TestBase.highLightElement(driver, topMenueBar);
		action.moveToElement(topMenueBar).build().perform();

		for (WebElement link : womenProductLink) {
			String innerHTML = link.getAttribute("innerHTML");

			if (innerHTML.contains(productName)) {
				TestBase.highLightElement(driver, link);
				waitObejct.waitForTheWebElementToBeVisible(link, driver, 20);
				link.click();
				break;
			}

		}
	}

	public void selectProductFromMenMenueBar(String productName,
			WebElement topMenueBar, List<WebElement> menProductLink)
			throws InterruptedException {

		action.moveToElement(topMenueBar).build().perform();
		Thread.sleep(5000);

		for (WebElement link : menProductLink) {
			String innerHTML = link.getAttribute("innerHTML");

			if (innerHTML.contains(productName)) {
				link.click();
				break;
			}

		}

	}

	
	public  void selectProductFromKidsMenueBar(String productName,
			WebElement topMenueBar, List<WebElement>kidsProductLink)
			throws InterruptedException {

		action.moveToElement(topMenueBar).build().perform();
		Thread.sleep(5000);

		for (WebElement link : kidsProductLink) {
			String innerHTML = link.getAttribute("innerHTML");

			if (innerHTML.contains(productName)) {
				link.click();
				break;
			}

		}

	}
}
