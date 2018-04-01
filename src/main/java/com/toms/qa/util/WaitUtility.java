package com.toms.qa.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.toms.qa.base.TestBase;

public class WaitUtility extends TestBase {
	public Alert alert;
	public WebElement waitForTheWebElementToBeClickable(WebElement element,
			WebDriver driver, long time) {

		WebDriverWait wait = new WebDriverWait(driver, time);

		return wait.until(ExpectedConditions.elementToBeClickable(element));

	}
	public WebElement waitForTheWebElementToBeVisible(WebElement element,
			WebDriver driver, long time) {

		WebDriverWait wait = new WebDriverWait(driver, time);

		return wait.until(ExpectedConditions.visibilityOf(element));

	}

	public WebElement waitForTheWebElementWithPoolingInterval(
			WebElement element, WebDriver driver, long time) {

		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.pollingEvery(5, TimeUnit.SECONDS);
		wait.ignoring(NoSuchElementException.class);

		return wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public static void implicitWait(long time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	
	public static void sleep() throws InterruptedException{
		Thread.sleep(3000);
	}

}
