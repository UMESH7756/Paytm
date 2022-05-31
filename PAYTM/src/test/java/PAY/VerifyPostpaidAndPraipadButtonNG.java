package PAY;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import broswer.Base;
import pompaytm.MobileRechargePage;
import pompaytm.PaytmHomePage;
import utils.Utility;

public class VerifyPostpaidAndPraipadButtonNG {

	WebDriver driver;
	MobileRechargePage mobilerechargepage;
	PaytmHomePage paytmhomepage;
	SoftAssert soft;
	String text;
	int Row=1;
	int testID;
	@Parameters ("browserName")
	
	@BeforeTest
	public void launchBrowser(String browser)
	
	{	
		if(browser.equals("Chrome"))
	   {
		driver=Base.openChromebrowser();
	   }
	   if(browser.equals("Edge"))
	   {
		driver=Base.openMicrosoftEdge();
	   }
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  
	}
	@BeforeClass
	public void objectOfPomClasses()
	{
		 paytmhomepage=new PaytmHomePage(driver);
		 mobilerechargepage=new MobileRechargePage(driver);
	}
	
	@BeforeMethod
	public void ClickOnApplication() throws InterruptedException
	{
		driver.get("https://www.paytm.com/");
		driver.manage().window().maximize();
	    Thread.sleep(2000);
	}
	@Test
	public void verifyRechargeModuleTab() throws InterruptedException
	{   
		 testID=1111;
		 soft=new SoftAssert();
		
		 paytmhomepage.rechargemodule();
		 Thread.sleep(2000);
		 String url=driver.getCurrentUrl();
		 String title=driver.getTitle();
		 Assert.assertEquals("https://paytm.com/recharg", url);
		 soft.assertEquals("Online Recharge - Online Mobile Recharge & Prepaid Recharge Plans", title);
		 soft.assertAll();
//		if(url.equals("https://paytm.com/recharge")&& title.equals("Online Recharge - Online Mobile Recharge & Prepaid Recharge Plans"))    
//		{
//			System.out.println("Test case 1 pass");
//		}
//		else
//		{
//			System.out.println("Test case 1 fail");
//		}
			
	}
	@Test(invocationCount = 2)
	public void verifyRechargeMudulePrepaiProceeddButton() throws InterruptedException, EncryptedDocumentException, IOException
	{    
		testID=2222;
		soft=new SoftAssert();
		paytmhomepage.rechargemodule();
		
		text=mobilerechargepage.gettextfrombutton();
		
		Assert.assertEquals("Proceed to Recharge", text); ////////////verify text present on proceed button 
		
		String data=Utility.getDataFromExcelSheet("Sheet1",Row,0); 
		                                            /////////fetch data from ex
		mobilerechargepage.rechargemoduleprepaid(data);
		
		Thread.sleep(2000);
		String url1=driver.getCurrentUrl();
		String title1=driver.getTitle();
		
		Assert.assertEquals("https://paytm.com/recharge", url1); 
		soft.assertEquals("Online Recharge - Online Mobile Recharge & Prepaid Recharge Plans", title1);
		soft.assertAll();
//		if(url1.equals("https://paytm.com/recharge")&& title1.equals("Online Recharge - Online Mobile Recharge & Prepaid Recharge Plans"))    
//		{
//			System.out.println("Test case 1 pass");
//		}
//		else
//		{
//			System.out.println("Test case 1 fail");
//		}
		mobilerechargepage.crossbuttonclick();
		Thread.sleep(1000);
		mobilerechargepage.prePostButtonRechargeTab();
		Thread.sleep(1000);
		mobilerechargepage.postpaidradio();
		Thread.sleep(1000);
		data=Utility.getDataFromExcelSheet("Sheet1",Row,0);
		mobilerechargepage.rechargemodulepostpaid(data);
		Thread.sleep(1000);
		mobilerechargepage.crossbuttonclick();
		String url4=driver.getCurrentUrl();
		String title4=driver.getTitle();
		 
		 Assert.assertEquals("https://paytm.com/recharge", url4);
		 soft.assertEquals("Online Bill Payment - Postpaid Mobile Bill Payment @ Paytm.com", title4);
		 soft.assertAll();
//		if(url4.equals("https://paytm.com/recharge")&& title4.equals("Online Bill Payment - Postpaid Mobile Bill Payment @ Paytm.com"))    
//		{
//			System.out.println("Test case 1 pass");
//		}
//		else
//		{
//			System.out.println("Test case 1 fail");
//		}
//		
		Row++;
	}
	
	
	@AfterMethod
	public void logOutFromApplication(ITestResult result) throws IOException, InterruptedException 
	{
		
		if(ITestResult.FAILURE==result.getStatus())
		{
			Utility.captureScreenShot(driver,testID);
		}	
	}
		
	@AfterClass
	public void browserClose()
	{
		paytmhomepage=null;
		mobilerechargepage=null;
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();	
		driver=null;
		System.gc(); 
	}
	
	
}
