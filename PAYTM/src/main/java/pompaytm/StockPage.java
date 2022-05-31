package pompaytm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StockPage {

	@FindBy(xpath="//span[@class='_1LjveqrX-V3EK6L4WKqnka']")
	private WebElement mutualfundTab;
	
	@FindBy(xpath="(//div[@class='TejjgPUxc0bkp_BLHpqDY'])[1]")
	private WebElement SquareBoxofReturnFund;
	
	@FindBy(xpath="(//div[@class='_15k5ErB4HyX1EVQzgA_4yA']//a)[2]")
	private WebElement BestReturnFunds;
	
	
	
	public StockPage(WebDriver driver)
	{PageFactory.initElements(driver, this);}
	
	public void clickOnMutualfundTab(WebDriver driver) throws InterruptedException 
	{
		 Actions b=new Actions(driver);
		b.moveToElement(SquareBoxofReturnFund).perform();
		Thread.sleep(2000);
//		b.moveToElement(mutualfundTab).perform();
//		Thread.sleep(2000);
//		b.moveToElement(mutualfundTab).click().build().perform();
	
	}
	public void clickOnMutualfundTab1(WebDriver driver) throws InterruptedException 
	{
		 Actions b=new Actions(driver);
		
		
		Thread.sleep(2000);
		b.moveToElement(mutualfundTab).click().build().perform();
	
	}
	
	
	public void clickOnBestReturnFundsTab(WebDriver driver) 
	{
      Actions a=new Actions(driver);
	 a.moveToElement(SquareBoxofReturnFund).perform();
	 a.moveToElement(BestReturnFunds).click().build().perform();
	}
	
	
}
