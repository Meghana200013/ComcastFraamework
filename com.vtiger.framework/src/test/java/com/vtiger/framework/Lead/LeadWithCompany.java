package com.vtiger.framework.Lead;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtiger.framework.generic.PomUtility.AssertionForLead;
import com.vtiger.framework.generic.PomUtility.Leads;
import com.vtiger.framework.generic.PomUtility.LeadsPluse;
import com.vtiger.framework.generic.WebdriverUtility.WebDriverUtility;

import baseClass_Implementation.BaseClass;

public class LeadWithCompany extends BaseClass{
	public WebDriverUtility WebUt = new WebDriverUtility();
	
	@Test(groups="ST")
	public void leadsWithCompany() throws Throwable, IOException
	{
		Leads ld = new Leads(driver);
		ld.getLeads().click();
		
		LeadsPluse pluse = new LeadsPluse(driver);
		pluse.getLeadsPluse().click();
		
		int Rnum = jUT.getRandomNumber();
		String Company = eUT.getDataFromExcel("leads", 4, 2)+Rnum;
		String LastName =eUT.getDataFromExcel("leads", 4, 3)+Rnum;
		pluse.lastAndCompany(LastName, Company);
		pluse.getSaveBn().click();	
		
		AssertionForLead lead = new AssertionForLead(driver);
		String headerInfo = lead.getHeaderInfo();
		Assert.assertTrue(headerInfo.contains(LastName));
	}
	@Test(groups="RT")
	public void leadwithSource() throws Throwable, IOException
	{
	Leads ld = new Leads(driver);
		ld.getLeads().click();
		
		LeadsPluse pluse = new LeadsPluse(driver);
		pluse.getLeadsPluse().click();
		
		int Rnum = jUT.getRandomNumber();
		String Company = eUT.getDataFromExcel("leads", 4, 2)+Rnum;
		String LastName =eUT.getDataFromExcel("leads", 4, 3)+Rnum;
		String Source = eUT.getDataFromExcel("leads",7,4);
		
		pluse.lastAndCompany(LastName, Company);
		
		pluse.selectLeadSource(WebUt, Source);
		
		pluse.getSaveBn().click();
		
		
		
		
		
		
		
		
	
		
		
		
	}
}


	
	
