package pompaytm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MobileRechargePage {
	
	//postpaid
	@FindBy(xpath="//label[@class='']")
    private WebElement radiopostpaidbutton;
	
	//prepaid 
	@FindBy(xpath="//div[@class='_3QlS']//input")
	private WebElement number;
	
	@FindBy(xpath="(//input[@autocomplete='new-password'])[2]")
	private WebElement amount;
	//or select from broser plane
	@FindBy(xpath="(//div[@class='_1aEZ'])[1]")
	private WebElement broswerplanfirstelement;
	@FindBy(xpath="//button[text()='Proceed to Recharge']")
	private WebElement proceedbuttonforprepaid;
	
	@FindBy(xpath="//button[text()='Proceed to Pay Bill']")
	private WebElement proceedbuttonforpostpaid;
	@FindBy(xpath="//a[@class='_2iSj']")
	private WebElement crossbutton;
	
	@FindBy(xpath="//span[text()='Prepaid/Postpaid']")
	private WebElement prepaidpostpaidbutton; 
	
	public MobileRechargePage(WebDriver driver) 
	{PageFactory.initElements(driver, this);}

	public void rechargemoduleprepaid(String testing1) throws InterruptedException ////////excel data 
	{ number.sendKeys(testing1);
	  Thread.sleep(2000);
//	  amount.sendKeys("10");
//	  Thread.sleep(3000);
	broswerplanfirstelement.click();
	Thread.sleep(3000);
	 proceedbuttonforprepaid.click();
	}
	
	public void postpaidradio() 
	{
		radiopostpaidbutton.click();
	}
	
	public void rechargemodulepostpaid(String testing) throws InterruptedException ///////////changed excel 
	{ 
		number.sendKeys(testing);
		Thread.sleep(3000);
		amount.sendKeys(testing);
		Thread.sleep(3000);
		proceedbuttonforpostpaid.click();}
	public void crossbuttonclick() 
	{
		crossbutton.click();
	}
	public void prePostButtonRechargeTab() 
	{prepaidpostpaidbutton.click();}
	
	public String gettextfrombutton() 
	{
		String text=proceedbuttonforprepaid.getText();
		return text;
		
	}
	
	
}
