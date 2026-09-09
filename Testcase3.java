package assessments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Testcase3 {

    public static void main(String[] args) throws InterruptedException, IOException {

        WebDriver d = new ChromeDriver();

        d.manage().window().maximize();

        d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        d.get("https://demowebshop.tricentis.com/");

        WebElement addCart = d.findElement(
                By.xpath("//a[normalize-space(text())='14.1-inch Laptop']" +
                        "/ancestor::div[@class='product-item']" +
                        "//input[contains(@value,'Add to cart')]")
        );

        System.out.println("Size of add cart button : " + addCart.getSize());

        addCart.click();

        Thread.sleep(5000);

        WebElement cartLink = d.findElement(
                By.xpath("//span[text()='Shopping cart']")
        );

        cartLink.click();

        Thread.sleep(3000);

        WebElement rb = d.findElement(
                By.xpath("//input[@type='checkbox' and @name='removefromcart']")
        );

        System.out.println("Checking the status of CheckBox : "
                + rb.isSelected());

        System.out.println("----------Rect details---------");

        System.out.println("X value : " + rb.getRect().getX());

        System.out.println("Y value : " + rb.getRect().getY());

        System.out.println("Height : " + rb.getRect().getHeight());

        System.out.println("Width : " + rb.getRect().getWidth());

        System.out.println("------------Before clicking on add coupon--------");

        try {

            WebElement msgBefore = d.findElement(
                    By.xpath("//div[@class='message']")
            );

            System.out.println("Alert message is displayed : "
                    + msgBefore.isDisplayed());

        } catch (Exception e) {

            System.out.println("Alert message is not displayed");

        }

        System.out.println("----------After clicking on add coupon-------");

        WebElement addcoupon = d.findElement(
                By.xpath("//input[@type='submit' and " +
                        "contains(@class,'apply-discount-coupon-code-button')]")
        );

        addcoupon.click();

        Thread.sleep(3000);

        try {

            WebElement msg = d.findElement(
                    By.xpath("//div[@class='message']")
            );

            System.out.println("Is displayed : "
                    + msg.isDisplayed());

        } catch (Exception e) {

            System.out.println("Alert message is not displayed");

        }

        Thread.sleep(2000);

        TakesScreenshot ts = (TakesScreenshot) d;

        File src = ts.getScreenshotAs(OutputType.FILE);

        File dest = new File(
                System.getProperty("user.dir")
                        + "\\screensht\\laptop.png"
        );

        dest.getParentFile().mkdirs();

        FileHandler.copy(src, dest);

        System.out.println("--------------------------------");
        System.out.println("Screenshot taken successfully");
        System.out.println("Screenshot saved at:");
        System.out.println(dest.getAbsolutePath());
        System.out.println("--------------------------------");

        Thread.sleep(3000);

        d.quit();
    }
}