package com.inetbanking.testcases;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import com.inetbanking.utilities.Readconfig;




public class BaseClass {
	Readconfig rc = new Readconfig();
	
	public static WebDriver driver;
	public String username = rc.username();
	public String password = rc.password();
	public String url = rc.geturl();
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		
		if(br.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", rc.chromepath());
		driver = new ChromeDriver();
		}

		else if(br.equals("ie"))
		{
		System.setProperty("webdriver.ie.driver", rc.iepath());
		driver = new InternetExplorerDriver();
		}

		else if(br.equals("firefox"))
		{
		System.setProperty("webdriver.gecko.driver", rc.firefoxpath());
		driver = new FirefoxDriver();
		}
		
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	
public boolean isAlertPresent() {//to check alert si present or not
	
		
		try {
			driver.switchTo().alert();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return false;
		}
	}
	

	@AfterClass
	public void teardown() {
		driver.quit();
	}
	
	public void capturescreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot tc = (TakesScreenshot)driver;
		File src = tc.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir")+"/Screenshot/"+tname+".png");
		FileUtils.copyFile(src, dest);
		System.out.println("Screenshot taken");
	}
	
	
	public String randomString() {
		String email = RandomStringUtils.randomAlphabetic(5);
		return email;
	}
	
	public String randomnum() {
		String randomnum = RandomStringUtils.randomNumeric(5);
		return randomnum;
	}
}
