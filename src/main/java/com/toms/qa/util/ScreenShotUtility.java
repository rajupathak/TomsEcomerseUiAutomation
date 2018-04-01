package com.toms.qa.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.toms.qa.base.TestBase;

public class ScreenShotUtility extends TestBase {
	public String getScreenShot(String screenshotName) {
		if (screenshotName.equals("")) {
			screenshotName = "blank";
		}

		Calendar calender = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

		TakesScreenshot tc = (TakesScreenshot) driver;

		File sourceFile = tc.getScreenshotAs(OutputType.FILE);
		System.out.println(sourceFile);

		try {

			String reportDirectory = new File(System.getProperty("user.dir"))
					.getAbsolutePath()
					+ "/src/main/java/com/toms/qa/passedscreiptscreenshots/screenShots/";
			
			System.out.println("Path:=" + reportDirectory);
			String actaulImageName = reportDirectory + screenshotName + "_"
					+ formater.format(calender.getTime()) + ".png";

			File desFile = new File(actaulImageName);
			FileUtils.copyFile(sourceFile, desFile);

			return actaulImageName;
		} catch (Exception e) {
			System.out.println("Exception is throwing during screen shot"
					+ e.getMessage());
		}
		return screenshotName;

	}

}
