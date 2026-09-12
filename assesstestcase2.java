package assessments;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class assesstestcase2 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {

		//fetch data from excel file
		FileInputStream fis = new FileInputStream("./src/test/resources/exceltestcase2.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		
		String browser = wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue().toString();
		String url = wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue().toString();
		String un = wb.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue().toString();
		String pwd = wb.getSheet("Sheet1").getRow(1).getCell(3).getStringCellValue().toString();
		
		WebDriver driver = null;
		
		//launch the browser
		switch(browser)
			{
			case("chrome"):
			{
				driver = new ChromeDriver();
				break;
			}
			case("edge"):
			{
				driver = new EdgeDriver();
				break;
			}
			case("firefox"):
			{
				driver = new FirefoxDriver();
				break;
			}
		}
		
		//maximize the window
		driver.manage().window().maximize();
		
		//implicit wait time
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//navigate to application
		driver.get(url);
		
		//locate username text field
		driver.findElement(By.name("username")).sendKeys(un);
		
		//locate password text field
		driver.findElement(By.name("password")).sendKeys(pwd);
	
		//locate login button
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	
		//verify
		WebElement text = driver.findElement(By.xpath("//h6[text()='Dashboard']"));
	
		if(text.isDisplayed())
			System.out.println("login successful");
		else
			System.out.println("not login");
		
		//close the browser
		Thread.sleep(2000);
		driver.quit();
	}

}