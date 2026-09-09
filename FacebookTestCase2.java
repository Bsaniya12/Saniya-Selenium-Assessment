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
		email.sendKeys("saniya07@gmail.com");
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
package WebDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FacebookApplication2 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        WebElement createAccount = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'Create new account')]")));
        System.out.println("Create New Account LocationX: " + createAccount.getLocation().getX());
        System.out.println("Create New Account LocationY: " + createAccount.getLocation().getY());
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
        System.out.println("DOM Attribute Before: " + emailField.getDomAttribute("value"));
        System.out.println("DOM Property Before: " + emailField.getDomProperty("value"));
        emailField.sendKeys("saniii950i@gmail.com@gmail.com");
        System.out.println("DOM Attribute After: " + emailField.getDomAttribute("value"));
        System.out.println("DOM Property After: " + emailField.getDomProperty("value"));
        createAccount.click();
        WebElement submitButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='dialog']//button"+ " | //div[@role='dialog']//input[@type='submit']"+ " | //div[@role='dialog']//div[@role='button']")));
        System.out.println("Submit Button Width: " + submitButton.getSize().getWidth());
        System.out.println("Submit Button Height: " + submitButton.getSize().getHeight());
        System.out.println("background-color: " + submitButton.getCssValue("background-color"));
        System.out.println("color: " + submitButton.getCssValue("color"));
        System.out.println("font-size: " + submitButton.getCssValue("font-size"));
        System.out.println("font-weight: " + submitButton.getCssValue("font-weight"));
    }
}
