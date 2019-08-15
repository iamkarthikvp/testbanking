package com.testbanking.TestCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.testbanking.PageObjetcs.loginpage;
import com.testbanking.utilities.XLUtils;

import junit.framework.Assert;

public class Logintest_001 extends Baseclass {
	@Parameters("Browser")
	@Test
	public void logintest() throws InterruptedException, IOException
	{
		driver.get(baseURL);
		logger.info("URL is Opened");
		loginpage lp = new loginpage(driver);
		lp.setUserName(username);
		logger.info("Entered Username");
		Thread.sleep(2000);
		lp.setPassword(password);
		logger.info("Entered Password");
		lp.clicksubmit();
		logger.info("Submit button is clicked");
		
		if(driver.getTitle().equalsIgnoreCase("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("login Test passed");
		}
		else
		{
			captureScreen(driver,"logintest");
			Assert.assertTrue(false);
			logger.info("login Test Failed");
		}
	}
}
