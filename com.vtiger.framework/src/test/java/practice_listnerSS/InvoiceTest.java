package practice_listnerSS;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import baseClass_Implementation.BaseClass;
@Listeners(com.vtiger.framework.generic.listenerutility.ListImpClass.class)
public class InvoiceTest extends BaseClass{
	
	@Test
	public void invoice() {
	System.out.println("Execute CreateInvoiceTest");  
    String acttitle = driver.getTitle();  
    Assert.assertEquals(acttitle,"Login");  
    System.out.println("Step-1");  
    System.out.println("Step-2");  
    System.out.println("Step-3");  
    System.out.println("Step-4"); 
	}
	@Test
	public void CreateInvoicewithContactTest() {  
	    System.out.println("Execute CreateInvoicewithContactTest");  
	    System.out.println("Step-1");  
	   // String acttitle = driver.getTitle();  
	//Assert.assertEquals(acttitle,"Login");  
	System.out.println("Step-2");  
	System.out.println("Step-3");  
	System.out.println("Step-4");  
	}
}
