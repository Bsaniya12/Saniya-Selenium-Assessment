package assessments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zomato {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.zomato.com/bangalore/delivery");
	    driver.findElement(By.cssSelector("[type='button']")).click();
	    //driver.switchTo().frame();
	    
	    WebElement ref = driver.findElement(By.id("auth-login-ui"));
	    driver.switchTo().frame(ref);
	    driver.findElement(By.xpath("//input[@type='number']")).sendKeys("7795525694");
	    Thread.sleep(2000);
	    driver.switchTo().defaultContent();
	    
	    System.out.println(driver.findElement(By.xpath("//div[text()='Delivery']")).getText());
	    driver.quit();
	    
	}

}