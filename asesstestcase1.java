
package assessments;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class asesstestcase1 {

    public static void main(String[] args) throws IOException, InterruptedException {

        // Read data from properties file
    	FileInputStream fis = new FileInputStream(
    	        "./src/test/resources/testcase1.properties");

        Properties p = new Properties();
        p.load(fis);

        String browser = p.getProperty("browser");
        String url = p.getProperty("url");
        String email = p.getProperty("email");
        String pwd = p.getProperty("password");

        // Close properties file
        fis.close();

        WebDriver driver = null;

        // Launch browser
        switch (browser.toLowerCase()) {

        case "chrome":
            driver = new ChromeDriver();
            break;

        case "edge":
            driver = new EdgeDriver();
            break;

        case "firefox":
            driver = new FirefoxDriver();
            break;

        default:
            System.out.println("Invalid browser name: " + browser);
            return;
        }

        // Maximize browser window
        driver.manage().window().maximize();

        // Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        // Navigate to application
        driver.get(url);

        // Click Login
        driver.findElement(By.xpath("//a[text()='Log in']")).click();

        // Enter Email
        driver.findElement(By.xpath("//input[@name='Email']")).sendKeys(email);

        // Enter Password
        driver.findElement(By.xpath("//input[@name='Password']")).sendKeys(pwd);

        // Click Login button
        driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();

        // Verify login
        WebElement logout = driver.findElement(By.linkText("Log out"));

        if (logout.isDisplayed()) {
            System.out.println("Login successful");
        } else {
            System.out.println("Login failed");
        }

        // Wait for 2 seconds
        Thread.sleep(2000);

        // Close browser
        driver.quit();
    }
}

