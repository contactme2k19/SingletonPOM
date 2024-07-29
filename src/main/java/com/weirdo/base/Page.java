package com.weirdo.base;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import com.aventstack.extentreports.Status;

import com.weirdo.listeners.ExtentListeners;
import com.weirdo.utilities.ExcelReader;


import io.github.bonigarcia.wdm.WebDriverManager;
public class Page  {
	public static WebDriver driver;
	/*Creating object or invoke the inbuilt class */
	public static Properties config=new Properties();
	public static Properties OR=new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static WebDriverWait wait;
	//public static String fileName;
   // public ExtentTest test;
	public static WebElement dropdown,e;
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "\\src\\test\\resources\\com\\weirdo\\testdata\\testdata.xlsx");
	
	
	
	public static TopMenu tm;
	public Page() {
		if(driver==null)
		{
			   Date d= new Date();
			/*loading log file*/
			System.setProperty("current.date", d.toString().replace(":", "_").replace(" ", "_"));
			PropertyConfigurator.configure(System.getProperty("user.dir")+"\\src\\test\\resources\\com\\weirdo\\properties\\log4j.properties");
			log.debug("Log file loaded");
			/*Property file load Starts */
			try {
				fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\com\\weirdo\\properties\\Config.properties");
			log.debug("Config file loaded");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
				log.debug("exception-->",e);
			}
			try {
				config.load(fis);
				log.debug("Confing property loaded and picks 1 value-->"+config.getProperty("browser"));
				System.out.println(config.getProperty("browser"));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						log.debug("exception-->",e);
						e.printStackTrace();
					}
			
			try {
				fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\com\\weirdo\\properties\\OR.properties");
				log.debug("OR file loaded");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				log.debug("exception-->",e);
				e.printStackTrace();
			}
			try {
				
				OR.load(fis);
				log.info("OR property loaded and picks 1 value-->"+OR.getProperty("loginlink_CSS"));
				System.out.println(OR.getProperty("loginlink_CSS"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				log.debug("exception-->",e);
				e.printStackTrace();
			}
			/*Property file load done */
			try {
				
				if (config.getProperty("browser").equals("chrome")) {
					ChromeOptions chromeOptions = new ChromeOptions();
					WebDriverManager.chromedriver().driverVersion(config.getProperty("driverVersion")).setup();
					Map<String, Object> prefs = new HashMap<String, Object>();
					prefs.put("profile.default_content_setting_values.notifications", 2);
					prefs.put("credentials_enable_service", false);
					prefs.put("profile.password_manager_enabled", false);
					chromeOptions.setExperimentalOption("prefs", prefs);
					chromeOptions.addArguments("--disable-extensions");
					chromeOptions.addArguments("--disable-infobars");
					chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
				
					driver = new ChromeDriver(chromeOptions);
					log.debug("New Driver launched with browser");
				}else {
					System.out.println("Browser name is not matched with property file");
				}
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")), TimeUnit.SECONDS);
				tm=new TopMenu(driver,OR);
		}else {
			System.out.println("Driver session is not a null therfore no new driver is getting created here.....");
		}
	}
	
	public static void reloginWithNewDriverSession() {
		try {
		driver.close();
		driver.quit();
		ChromeOptions chromeOptions = new ChromeOptions();
		WebDriverManager.chromedriver().driverVersion(config.getProperty("driverVersion")).setup();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		chromeOptions.setExperimentalOption("prefs", prefs);
		
		chromeOptions.addArguments("--disable-extensions");
		chromeOptions.addArguments("--disable-infobars");
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		driver = new ChromeDriver(chromeOptions);
		System.out.println("Reinintate driver as new, becuase of case got failed");
	//	ExtentListeners.test.log(Status.INFO, "Reinintate driver as new, becuase of case got failed");
		}catch(Throwable e) {
			System.out.println("Reinit driver got exception as ::"+e);
		}
	}
	
public static void close()
{
	driver.close();}
	public static void quit() {
		driver.quit();
	}
	public static void reload() {
		driver.navigate().refresh();
	}

	public static boolean isElementPresent(String locatorKey,int delay)   {
		wait= new WebDriverWait(driver,delay);
		System.out.println("Delaycont as ::"+delay);


		try {
			if (locatorKey.endsWith("_XPATH")) {
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty(locatorKey))));
			//driver.findElement(By.xpath(OR.getProperty(locatorKey)));
			} else if (locatorKey.endsWith("_CSS")) {
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(OR.getProperty(locatorKey))));
			} else if (locatorKey.endsWith("_ID")) {
				wait.until(ExpectedConditions.elementToBeClickable(By.id(OR.getProperty(locatorKey))));
			}else if(locatorKey.endsWith("_NAME")){
				wait.until(ExpectedConditions.elementToBeClickable(By.name(OR.getProperty(locatorKey))));
			}else {
				return false;
			}
			//log.info("Finding an Element : " + locatorKey);
			ExtentListeners.test.log(Status.INFO, "Finding an Element : " + locatorKey);
		} catch (Throwable e) {
		e.printStackTrace();
           ExtentListeners.test.log(Status.FAIL, "Element not found : " + locatorKey).info(e);
           
			return false;

		}

		
		return true;
	}
public static void verifyAssert(Boolean result,String logStepMessage) 
{
	try {
	Assert.assertTrue(result);
	ExtentListeners.test.log(Status.PASS, logStepMessage);
	
	}catch(Throwable t)
	{
		//ExtentManager.captureScreenshot();
		t.getStackTrace();
		ExtentListeners.test.log(Status.FAIL, logStepMessage+"-- got Exception as ").info(t);
	//	ExtentListeners.test.log(Status.FAIL,MediaEntityBuilder.createScreenCaptureFromPath(ExtentManager.fileName).build());
	}	
}

	/*Commen methods for keyword actions */
	/*For send keys*/

	public static void type(String locatorKey, String value,int delay) {
		try {
			wait= new WebDriverWait(driver,delay);
			System.out.println("Delaycont as ::"+delay);
			if (locatorKey.endsWith("_XPATH")) {
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty(locatorKey)))).sendKeys(value);
			//	driver.findElement(By.xpath(OR.getProperty(locatorKey))).sendKeys(value);
			} else if (locatorKey.endsWith("_CSS")) {
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(OR.getProperty(locatorKey)))).sendKeys(value);
			} else if (locatorKey.endsWith("_ID")) {
				wait.until(ExpectedConditions.elementToBeClickable(By.id(OR.getProperty(locatorKey)))).sendKeys(value);
			}else if(locatorKey.endsWith("_NAME")) {
				wait.until(ExpectedConditions.elementToBeClickable(By.name(OR.getProperty(locatorKey)))).sendKeys(value);
			}
			log.info("typing in an Element : " + locatorKey + " entered the value as : " + value);
			ExtentListeners.test.log(Status.INFO,
					"typing in an Element : " + locatorKey + " entered the value as : " + value);
		} catch (Throwable t) {

			ExtentListeners.test.log(Status.FAIL,
					"Error while typing in an Element : " + locatorKey ).info(t);

		}

	}
	/*For click*/
	public static void click(String locatorKey,int delay) {
		try {
			
			wait= new WebDriverWait(driver,delay);
			System.out.println("Delaycont as ::"+delay);
			if (locatorKey.endsWith("_XPATH")) {
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty(locatorKey)))).click();
				//driver.findElement(By.xpath(OR.getProperty(locatorKey))).click();
			} else if (locatorKey.endsWith("_CSS")) {
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(OR.getProperty(locatorKey)))).click();
			} else if (locatorKey.endsWith("_ID")) {
				wait.until(ExpectedConditions.elementToBeClickable(By.id(OR.getProperty(locatorKey)))).click();
			}else if(locatorKey.endsWith("_NAME")) {
				wait.until(ExpectedConditions.elementToBeClickable(By.name(OR.getProperty(locatorKey)))).click();
			}

			ExtentListeners.test.log(Status.INFO, "Clicking on an Element : " + locatorKey);
		} catch (Throwable t) {

			ExtentListeners.test.log(Status.FAIL,
					"Error while Clicking on an Element : " + locatorKey ).info(t);

		}
	}
	

	/*For select (Need to implement wait)*/
	public boolean selectDropdownoption  (String locatorKeyword,String dropdownValue){
	try {
		if(locatorKeyword.endsWith("_XPATH")) {
		dropdown=	driver.findElement(By.xpath(OR.getProperty(locatorKeyword)));
		}else if(locatorKeyword.endsWith("_ID")) {
			dropdown=driver.findElement(By.id(OR.getProperty(locatorKeyword)));
		}else if(locatorKeyword.endsWith("_CSS")){
			dropdown=driver.findElement(By.cssSelector(OR.getProperty(locatorKeyword)));
		}else if(locatorKeyword.endsWith("_NAME")) {
			dropdown=driver.findElement(By.name(OR.getProperty(locatorKeyword)));
		}
		
		
		Select option= new Select(dropdown);
		option.selectByValue(dropdownValue);
		option.selectByIndex(3);
		log.info("Finding an web element-->"+locatorKeyword);
		ExtentListeners.test.log(Status.INFO, "Finding an web element-->"+locatorKeyword);
		return true;
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		log.info("Element not found-->"+locatorKeyword);
		ExtentListeners.test.log(Status.INFO, "Element not found-->"+locatorKeyword);
		return false;
		
		
	}
	}


	
	



}
