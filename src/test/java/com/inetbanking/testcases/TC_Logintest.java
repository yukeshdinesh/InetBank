package com.inetbanking.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobject.LoginPageObjects;

public class TC_Logintest extends BaseClass {

	@Test
	public void test1() throws IOException {
		
		driver.get(url);
		logger.info("URL opened");
		LoginPageObjects lp = new LoginPageObjects(driver);
		lp.setusername(username);
		logger.info("Username entered");
		lp.SetPassword(password);
		logger.info("Password entered");
		lp.signin();
		logger.info("Sign in clicked");
		
		if(driver.getTitle().equalsIgnoreCase("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("testcase pass");
			capturescreen(driver, "Login passed");
		}
		else {
			Assert.assertTrue(false);
			logger.info("testcase fail");
			capturescreen(driver, "Login failed");
		}
		
	}

}
