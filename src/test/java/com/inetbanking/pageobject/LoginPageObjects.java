package com.inetbanking.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects {	
	
	public LoginPageObjects(WebDriver rdriver) {
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name="uid")
	@CacheLookup
	WebElement txtusername;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtpassword;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement Submitbutton;
	
	@FindBy(xpath="//a[@href='Logout.php']")
	@CacheLookup
	WebElement logoutbutton;
	
	public void setusername(String email) {
		txtusername.sendKeys(email);
	}
	
	public void SetPassword(String pwd) {
		txtpassword.sendKeys(pwd);
	}
	
	public void signin() {
		Submitbutton.click();
	}
	
	public void logout() {
		logoutbutton.click();
	}
	

}
