package com.vtiger.framework.Product;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.framework.generic.PomUtility.AssertionForProduct;
import com.vtiger.framework.generic.PomUtility.HomePage;
import com.vtiger.framework.generic.PomUtility.ProductPluse;


import baseClass_Implementation.BaseClass;
@Listeners(com.vtiger.framework.generic.listenerutility.ListImpClass.class)
public class ProdctName extends BaseClass {
	@Test(groups="RT")
	public void productWithProName() throws Throwable, IOException
	{
		HomePage page = new HomePage(driver);
		page.getProductLink().click();
		
		ProductPluse pluse = new ProductPluse(driver);
		pluse.getProductPluse().click();
		
		int Rnum = jUT.getRandomNumber();
		String ProductName=eUT.getDataFromExcel("product", 1, 2)+Rnum;
		pluse.ProductDetails(ProductName);
		//pluse.getSaveBN().click();
		
	
		AssertionForProduct Pname = new AssertionForProduct(driver);
		String Name = Pname.getProductname();
		Assert.assertEquals(Name,"Login");
	}
	@Test(groups="ST")
	public void productWithvendorName() throws EncryptedDocumentException, IOException, InterruptedException
	{
		HomePage page = new HomePage(driver);
		page.getProductLink().click();
		
		ProductPluse pluse = new ProductPluse(driver);
		pluse.getProductPluse().click();
		
		int Rnum = jUT.getRandomNumber();
		String ProductName=eUT.getDataFromExcel("product", 4, 2)+Rnum;
		String VendorName=eUT.getDataFromExcel("product",4,3)+Rnum;
		
		pluse.ProductDetails(ProductName,VendorName);	
		
		
		AssertionForProduct head = new AssertionForProduct(driver);
		String headerInfo = head.getHeaderInfo();
		Assert.assertTrue(headerInfo.contains(ProductName), "prodcut Creation failed");
	}
}
