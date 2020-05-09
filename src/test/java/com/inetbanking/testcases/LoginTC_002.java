package com.inetbanking.testcases;

import java.io.IOException;

import org.testng.Assert;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageobject.LoginPageObjects;
import com.inetbanking.utilities.Xmlutility;

public class LoginTC_002 extends BaseClass{
	
	@Test(dataProvider="login data")
	public void loginddt(String usr, String pwd) throws InterruptedException {
		LoginPageObjects lp = new LoginPageObjects(driver);
		driver.get(url);
		logger.info("url opened");
		lp.setusername(usr);
		logger.info("Username entered");
		lp.SetPassword(pwd);
		logger.info("password entered");
		lp.signin();
		logger.info("signin button clicked");
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login failed");
			Thread.sleep(2000);
		}
		else {
			Assert.assertTrue(true);
			Thread.sleep(3000);
			lp.logout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.info("login passed");
			Thread.sleep(2000);
		}
		
	}
	
	
	@DataProvider(name="login data")
	public String[][] dataset() throws IOException {
		String path = System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testdata/TestData.xls";
		int rowcount=Xmlutility.getRowCount(path,"Sheet1");
		int colcount=Xmlutility.getCellCount(path, "Sheet1", 1);
		
		String[][] logindata=new String[rowcount][colcount];
		
		for(int i=1;i<=rowcount;i++) {
			for(int j=0;j<colcount;j++) {
				logindata[i-1][j]=Xmlutility.getCellData(path, "Sheet1", i, j);
			}
		}
		
		return logindata;
	}

}
