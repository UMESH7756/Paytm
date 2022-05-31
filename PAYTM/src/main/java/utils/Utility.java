package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
    
	
	public static void captureScreenShot(WebDriver driver,int testID) throws IOException, InterruptedException
	{
		
		String timestamp=new SimpleDateFormat(" dd-MM-YYYY hh mm ss").format(new Date());
		TakesScreenshot t=(TakesScreenshot)driver;
		File a=t.getScreenshotAs(OutputType.FILE);
		File dest=new File("test-output\\screenshot\\test-"+testID+" "+timestamp+".jpg");
		FileHandler.copy(a, dest);
		Thread.sleep(1000);
	}
	
	
	public static String getDataFromExcelSheet(String sheetnameint,int Row,int Column) throws EncryptedDocumentException, IOException {
		
		String data;
		
		String path="C:\\Users\\91775\\Desktop\\Book1.xlsx";
		FileInputStream file=new FileInputStream(path);
		Workbook book=WorkbookFactory.create(file);
			
		try {
			
			data=book.getSheet(sheetnameint).getRow(Row).getCell(Column).getStringCellValue();
			
		    }
		catch(IllegalStateException e) {
			
			double value=book.getSheet(sheetnameint).getRow(Row).getCell(Column).getNumericCellValue();
			data=Double.toString(value);	
		    }
		
		return data;	
		
	}
	
	
	
}
