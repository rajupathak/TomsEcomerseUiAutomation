package com.toms.qa.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.toms.qa.base.TestBase;

public class BrokenLinksUtility extends TestBase{

	
	public  void verifyBrokenLink(String homePageURL,List<WebElement>totalLinks) {
		// TODO Auto-generated method stub
		String url = "";
		HttpURLConnection huc = null;
		int respCode = 200;

		List<WebElement> links = totalLinks;

		Iterator<WebElement> it = links.iterator();

		while (it.hasNext()) {

			url = it.next().getAttribute("href");

			System.out.println(url);

			if (url == null || url.isEmpty()) {
				System.out
						.println("URL is either not configured for anchor tag or it is empty");
				continue;
			}

			if (url.startsWith("javascript")) {
				System.out
						.println("URL contains javascriprt not a valid URL.");
				continue;
			}
			if (url.startsWith("tel://0-800-070-6175")) {
				System.out
						.println("URL contains telephone number");
				continue;
			}

			try {
				if((url != null) && !url.startsWith("javascript")){
					
				
				huc = (HttpURLConnection) (new URL(url).openConnection());

				huc.setRequestMethod("HEAD");

				huc.connect();

				respCode = huc.getResponseCode();

				if (respCode >= 400) {
					System.out.println(url + " is a broken link");
				} else {
					System.out.println(url + " is a valid link");
				}

			}} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		

	}
}

