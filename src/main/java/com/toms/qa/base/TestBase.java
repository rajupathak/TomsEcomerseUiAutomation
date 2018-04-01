package com.toms.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.toms.qa.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public static long PAGE_LOAD_TIMEOUT = 80;
	public static long IMPLICIT_WAIT = 60;
	public static JavascriptExecutor js;
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream browser = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/toms/qa/config/config.BrowserProperties");
			
			FileInputStream fileInputAus = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/toms/qa/config/config.CountryAustriaURLProperties");
			
			FileInputStream fileInputCan = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/toms/qa/config/config.CountryCANURLProperties");
			FileInputStream fileInputFrance = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/toms/qa/config/config.CountryFranceURLProperties");
			
			FileInputStream fileInputGer = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/toms/qa/config/config.CountryGermanyURLProperties");
			FileInputStream fileInputIre = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/toms/qa/config/config.CountryIrelandURLProperties");
			
			FileInputStream fileInputNeth = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/toms/qa/config/config.CountryNetherlandURLProperties");
			FileInputStream fileInputUk = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/toms/qa/config/config.CountryUKURLProperties");
			FileInputStream fileInputUsa = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/toms/qa/config/config.CountryUSAURLProperties");
			prop.load(browser);
			prop.load(fileInputAus);
			prop.load(fileInputCan);
			prop.load(fileInputFrance);
			prop.load(fileInputGer);
			prop.load(fileInputIre);
			prop.load(fileInputNeth);
			prop.load(fileInputUk);
			prop.load(fileInputUsa);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void initialization(){
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers1/chromedriver.exe");	
			driver = new ChromeDriver(); 
		}
		else if(browserName.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/Drivers1/geckodriver.exe");	
			driver = new FirefoxDriver(); 
		}
		
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
		
	}
	
	
	
	public static void highLightElement(WebDriver driver, WebElement element)
	{
	 js=(JavascriptExecutor)driver; 
	 
	js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
	 
	try 
	{
	Thread.sleep(500);
	} 
	catch (InterruptedException e) {
	 
	System.out.println(e.getMessage());
	} 
	 
	js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element); 
	 
	}
	 
	public static void mouseHover(WebDriver driver,WebElement element){
		Actions action= new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	
	public static void mouseHoverAndClick(WebDriver driver,WebElement element){
		Actions action= new Actions(driver);
		action.moveToElement(element).click().build().perform();
	}
	
	public static void scroolTheWidnow() {
		js.executeScript("scroll(0,1200)");
	}
	
	

}
