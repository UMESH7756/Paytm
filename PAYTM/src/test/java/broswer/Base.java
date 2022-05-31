package broswer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Base {

	static public WebDriver openChromebrowser()
	{
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\\\91775\\chromedriver.exe");
		 WebDriver driver=new ChromeDriver();
	     return driver;
	}
	static public WebDriver openMicrosoftEdge()
	{
		 System.setProperty("webdriver.edge.driver", "C:\\Users\\91775\\msedgedriver.exe");
		 WebDriver driver=new EdgeDriver();
	     return driver;
	}
}
