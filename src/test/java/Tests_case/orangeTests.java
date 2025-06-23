package Tests_case;
import config.env_target;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class orangeTests extends env_target {
    @Test
    public void main() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseTests);
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait (driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[class='oxd-button', contains(text(),'Login') ]")));
        driver.findElement(By.xpath("//input[class='oxd-input', contains(text(), 'Username')']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[class='oxd-input', contains(text(), 'Password')']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[class='oxd-button', contains(text(),'Login')]")).click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[class='oxd-text', contains(text(), 'Dashboard')]"))
        );

    }
}
