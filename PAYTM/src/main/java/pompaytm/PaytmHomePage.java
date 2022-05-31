package pompaytm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaytmHomePage {
            
	@FindBy(xpath="(//div[@class='_2EGQY cqA0P'])[1]")
	private WebElement rechargebutton;  
	@FindBy(xpath="(//div[@class='_1qjtX'])[4]")
	private WebElement rechargeDTH; 
	@FindBy(xpath="(//div[@class='_2EGQY'])[7]")
	private WebElement Investstocks; 
	
	
	
	public PaytmHomePage(WebDriver driver)
	{PageFactory.initElements(driver, this);}
	
	
	public void rechargemodule() 
	{rechargebutton.click();}
	
	public void DTHmodule() 
	{rechargeDTH.click();}
	
	public void stocksModule() 
	{Investstocks.click();}
	
}
