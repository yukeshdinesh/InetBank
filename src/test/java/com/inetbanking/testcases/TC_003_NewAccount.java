package com.inetbanking.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.inetbanking.pageobject.LoginPageObjects;
import com.inetbanking.pageobject.NewUserPage;

import junit.framework.Assert;

public class TC_003_NewAccount extends BaseClass {
	
	@Test
	public void addcustomer() throws InterruptedException, IOException {
		
		LoginPageObjects lp = new LoginPageObjects(driver);
		driver.get(url);
		logger.info("Url opened");
		lp.setusername(username);
		logger.info("Username entered");
		lp.SetPassword(password);
		logger.info("password entered");
		lp.signin();
		logger.info("Login button clicked");
		Thread.sleep(3000);
		
		NewUserPage nu = new NewUserPage(driver);
		nu.clickAddNewUsr();
		logger.info("New user link clicked");
		nu.customername("Yukesh");
		logger.info("customer name entered");
		//nu.gender();
		logger.info("Gender selected");
		nu.dob("10", "20", "1990");
		logger.info("DoB entered");
		Thread.sleep(3000);
		nu.addr("India");
		logger.info("Address entered");
		nu.city("Chennai");
		logger.info("city selected");
		nu.state("TN");
		logger.info("state selected");
		nu.pinno(603103);
		logger.info("pin no entered");
		nu.mobile("90909090");
		logger.info("Mobile no entered");
		String email =randomString()+"@gmail.com";
		Thread.sleep(3000);
		
		nu.email(email);
		logger.info("email entered");
		nu.password("12345");
		logger.info("Password entered");
		capturescreen(driver, "details entered");
		Thread.sleep(2000);
		nu.submitbtn();
		logger.info("Submit button clicked");
		Thread.sleep(2000);
		
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		if (res==true) {
			Assert.assertTrue(true);
			capturescreen(driver, "account created");
			Thread.sleep(2000);
		}
		else {
			Assert.assertTrue(false);
			capturescreen(driver, "account creation failed");
			Thread.sleep(2000);
		}
		
		
	}

}
