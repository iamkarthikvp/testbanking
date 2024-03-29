package com.testbanking.PageObjetcs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage {
	WebDriver ldriver;
	//constructor
	public loginpage(WebDriver rdriver)
	{
		ldriver= rdriver;
		PageFactory.initElements(rdriver, this);
	}
@FindBy(name="uid")
@CacheLookup
WebElement txtUserName;

@FindBy(name="password")
@CacheLookup
WebElement txtPassword;

@FindBy(name="btnLogin")
@CacheLookup
WebElement btnlogin;

@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
@CacheLookup
WebElement lnkLogout;


	public void setUserName(String uname)
	{
		txtUserName.sendKeys(uname);
	}
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	public void clicksubmit()
	{
		btnlogin.click();
	}
	public void clickLogout()
	{
		lnkLogout.click();
	}
}