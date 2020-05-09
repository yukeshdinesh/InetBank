package com.inetbanking.pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class NewUserPage {

	public NewUserPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@FindBy(how = How.XPATH, using = "//a[text()='New Customer']")
	@CacheLookup
	WebElement AddNewuser;

	@FindBy(how = How.NAME, using = "name")
	@CacheLookup
	WebElement Custname;

	@FindBy(how = How.XPATH, using = "//input[@name='rad1'][1]]")
	@CacheLookup
	WebElement Gender;

	@FindBy(how = How.XPATH, using = "//input[@id='dob']")
	@CacheLookup
	WebElement dob;

	@FindBy(how = How.XPATH, using = "//textarea[@name='addr']")
	@CacheLookup
	WebElement addr;

	@FindBy(how = How.XPATH, using = "//input[@name='city']")
	@CacheLookup
	WebElement city;

	@FindBy(how = How.XPATH, using = "//input[@name='state']")
	@CacheLookup
	WebElement state;

	@FindBy(how = How.NAME, using = "pinno")
	@CacheLookup
	WebElement pinnum;

	@FindBy(how = How.NAME, using = "telephoneno")
	@CacheLookup
	WebElement telephone;

	@FindBy(how = How.NAME, using = "emailid")
	@CacheLookup
	WebElement emailid;

	@FindBy(how = How.NAME, using = "password")
	@CacheLookup
	WebElement password;

	@FindBy(how = How.NAME, using = "sub")
	@CacheLookup
	WebElement submit;
	
	public void clickAddNewUsr() {

		AddNewuser.click();
	}

	public void customername(String custname) {
		Custname.sendKeys(custname);
	}
	
	public void gender() {
		Gender.click();
	}
	
	public void dob(String mm, String dd, String yy) {
		dob.sendKeys(mm);
		dob.sendKeys(dd);
		dob.sendKeys(yy);
	}
	
	public void addr(String address) {
		addr.sendKeys(address);
	}
	
	public void city(String ccity) {
		city.sendKeys(ccity);
	}
	
	public void state(String cstate ) {
		state.sendKeys(cstate);
	}

	public void pinno(int pin) {
		pinnum.sendKeys(String.valueOf(pin));
	}
	
	public void mobile(String mobileno) {
		telephone.sendKeys(mobileno);
	}
	
	public void email(String email) {
		emailid.sendKeys(email);
	}
	
	public void password(String cpassword) {
		password.sendKeys(cpassword);
	}
	
	public void submitbtn() {
		submit.click();
	}
	
	
	
	

}	