package assessments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FacebookTestCase1{
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            driver.get("https://www.facebook.com/");
            WebElement createAccount = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'Create new account')]")));
            createAccount.click();
            WebElement firstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("R_1cl2p4jikacppb6amH1")));
            WebElement surname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("_r_a_")));
            Point firstNameLocation = firstName.getLocation();
            Point surnameLocation = surname.getLocation();
            int firstNameY = firstNameLocation.getY();
            int surnameY = surnameLocation.getY();
            if (Math.abs(firstNameY - surnameY) <= 5) {
                System.out.println("TEST CASE PASSED");
            } else {
                System.out.println("TEST CASE FAILED");
            }
        } catch (Exception e) {
            System.out.println("TEST CASE FAILED");
        }
    }
}