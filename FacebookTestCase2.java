package assessments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookTestCase2 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.facebook.com/");
		
		WebElement btn=driver.findElement(By.xpath("//span[text()='Create new account']"));
		Point loc=btn.getLocation();
		System.out.println("Location of create new Act "+loc);
		
		
		WebElement email=driver.findElement(By.id("R_1h6kqsqppb6amH1"));
		String beforeAttribute=email.getDomAttribute("value");
		String beforeProperty=email.getDomProperty("value");
		System.out.println(beforeAttribute);
		System.out.println(beforeProperty);
		email.sendKeys("mallu123@gmail.com");
		String afterAttribute=email.getDomAttribute("value");
		String afterProperty=email.getDomProperty("value");
		System.out.println(afterAttribute);
		System.out.println(afterProperty);
		
		btn.click();
		Thread.sleep(2000);
		
		WebElement subBtn=driver.findElement(By.xpath("//span[text()='Submit']"));
		System.out.println("Submit size "+subBtn.getSize());
	
		System.out.println("Css properties of submit Button");
		System.out.println(subBtn.getCssValue("font-size"));
		System.out.println(subBtn.getCssValue("background-color"));
		System.out.println(subBtn.getCssValue("color"));
		
	}

}