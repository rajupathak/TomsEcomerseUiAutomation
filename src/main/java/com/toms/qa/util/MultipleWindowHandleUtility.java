package com.toms.qa.util;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;

import com.toms.qa.base.TestBase;

public class MultipleWindowHandleUtility extends TestBase {
	public String parentWindow = driver.getWindowHandle();

	public static void switchToWindow(WebElement element) {

		String parentWindow = driver.getWindowHandle();

		element.click();

		Set<String> windows = driver.getWindowHandles();

		Iterator<String> window = windows.iterator();

		while (window.hasNext()) {
			String childWindow = window.next();

			if (!parentWindow.equals(childWindow)) {
				driver.switchTo().window(childWindow);
			}
		}
      
	}

}
