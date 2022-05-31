package PAY;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pompaytm.MobileRechargePage;
import pompaytm.PaytmHomePage;
import pompaytm.StockPage;

public class testclassPTM {
	
	
public static void main(String[] args) throws InterruptedException {
	
	
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\91775\\Downloads\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
    driver.get("https://www.paytm.com/");
	driver.manage().window().maximize();
	 Thread.sleep(1000);
	 //test case 1 verify the paytmhomepage recharge tab 
	 PaytmHomePage paytmhomepage=new PaytmHomePage(driver);
	 paytmhomepage.rechargemodule();
	 Thread.sleep(2000);
	 String url=driver.getCurrentUrl();
	 String title=driver.getTitle();
	if(url.equals("https://paytm.com/recharge")&& title.equals("Online Recharge - Online Mobile Recharge & Prepaid Recharge Plans"))    
	{
		System.out.println("Test case 1 pass");
	}
	else
	{
		System.out.println("Test case 1 fail");
	}
	MobileRechargePage mobilerechargepage=new MobileRechargePage(driver);
//	mobilerechargepage.rechargemoduleprepaid();
	Thread.sleep(2000);
	 String url1=driver.getCurrentUrl();
	 String title1=driver.getTitle();
	if(url1.equals("https://paytm.com/recharge")&& title1.equals("Online Recharge - Online Mobile Recharge & Prepaid Recharge Plans"))    
	{
		System.out.println("Test case 1 pass");
	}
	else
	{
		System.out.println("Test case 1 fail");
	}
	mobilerechargepage.crossbuttonclick();
	Thread.sleep(2000);
	mobilerechargepage.prePostButtonRechargeTab();
	Thread.sleep(2000);
	mobilerechargepage.postpaidradio();
	Thread.sleep(2000);
//	mobilerechargepage.rechargemodulepostpaid();
	Thread.sleep(2000);
	mobilerechargepage.crossbuttonclick();
	String url4=driver.getCurrentUrl();
	String title4=driver.getTitle();
	if(url4.equals("https://paytm.com/recharge")&& title4.equals("Online Bill Payment - Postpaid Mobile Bill Payment @ Paytm.com"))    
	{
		System.out.println("Test case 1 pass");
	}
	else
	{
		System.out.println("Test case 1 fail");
	}
	
	
//	 paytmhomepage.stocksModule();
//	 Thread.sleep(3000);
//	 StockPage stockpage=new StockPage(driver);
//	 Thread.sleep(3000);
//	 stockpage.clickOnMutualfundTab(driver);   
//	 Thread.sleep(3000);        
//	 stockpage.clickOnMutualfundTab1(driver);
	
	 int xyz;
	 int d;
	
}
}
