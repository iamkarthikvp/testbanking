package com.testbanking.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.testbanking.PageObjetcs.AddCustomerPage;
import com.testbanking.PageObjetcs.loginpage;
import com.testbanking.utilities.XLUtils;

public class addnewcutomer_004 extends Baseclass{
	
	@Parameters("Browser")
	@Test
	public void addnewcutomer() throws IOException, InterruptedException
 	{
		loginpage lp=new loginpage(driver);
		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Passsword is provided");
		lp.clicksubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust12=new AddCustomerPage(driver);
		
		addcust12.clickAddNewCustomer();
		
		logger.info("providing customer details....");
		
		
		try
		{
String path=System.getProperty("user.dir")+"/src/test/java/com/testbanking/testData/LoginData.xlsx";
		
		String sheet ="Addnewcustomer";
		int rownum= 0;
		rownum =XLUtils.getRowCount(path, sheet);	
		for(int i=1  ;i<=rownum;i++) 
		{
	
		String Cust_name = XLUtils.getCellData(path, sheet, i,0) ;
		addcust12.custName(Cust_name);
		logger.info("Cutomer name entered");
		
		String gender =XLUtils.getCellData(path, sheet, i,1);
		addcust12.custgender(gender);
		logger.info("Gender is entered");
		
		String CustDob =XLUtils.getCellData(path, sheet, i,2);
		addcust12.custdobDDT(CustDob);
		Thread.sleep(5000);
		String address = XLUtils.getCellData(path, sheet, i,3);
		addcust12.custaddress(address); 
		String City =XLUtils.getCellData(path, sheet, i,4);
		addcust12.custcity(City);
		String state =XLUtils.getCellData(path, sheet, i,5);
		addcust12.custstate(state);
		 String PIN = XLUtils.getCellData(path, sheet, i,6);
		 addcust12.custpinno(PIN);
		 String MobNo =XLUtils.getCellData(path, sheet, i,7);
		 addcust12.custtelephoneno(MobNo);
		String email= XLUtils.getCellData(path, sheet, i,8);
		addcust12.custemailid(email);
		String password = XLUtils.getCellData(path, sheet, i,9);
		addcust12.custpassword(password);
		addcust12.custsubmit();
		}
 	}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
		Thread.sleep(3000);
		
		logger.info("validation started....");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			captureScreen(driver,"addNewCustomer_004");
			Assert.assertTrue(false);
			
		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"addNewCustomer_004");
			Assert.assertTrue(false);
		}
			
	}
	}
