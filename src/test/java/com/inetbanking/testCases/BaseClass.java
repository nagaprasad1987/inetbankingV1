package com.inetbanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readConfig = new ReadConfig();
	
	public String URL = readConfig.getApplicationUrl();
	public String username = readConfig.getUsername();
	public String password = readConfig.getPassword();
	public WebDriver driver;
	public Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String browser)
	{
		try
		{
			logger = Logger.getLogger("ebanking");
			PropertyConfigurator.configure("Log4j.properties");
			
			if(browser.equals("chrome"))
			{
				System.setProperty("webdriver.chrome.driver",readConfig.getChromePath());
				driver = new ChromeDriver();
				driver.manage().window().maximize();
			}
			else if(browser.equals("ie")) 
			{
				System.setProperty("webdriver.ie.driver",readConfig.getIEPath());
				InternetExplorerOptions options = new InternetExplorerOptions().setPageLoadStrategy(PageLoadStrategy.NONE);
				driver = new InternetExplorerDriver(options);
			}
			else if(browser.equals("firefox")) 
			{
				System.setProperty("webdriver.gecko.driver",readConfig.getFirefoxPath());
				driver = new FirefoxDriver();
			}
			
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.get(URL);

		}
		catch(Exception e)
		{
			System.out.println("Exception:"+e.getMessage());
		}
				
	}
	
	
	
	 @AfterClass public void tearDown() { driver.quit(); } 
	 
	 
	  public void captureScreen(WebDriver driver, String tname) throws IOException {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
			FileUtils.copyFile(source, target);
			System.out.println("Screenshot taken");
		}
	 

}
