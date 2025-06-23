package Tests_case;

import config.env_target;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class demoTests extends env_target {

    @Test
    public void firstTest() {
        // Set up WebDriver
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(); // local reference avoids relying on env_target for driver
        driver.manage().window().maximize();
        driver.get(baseURL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for login button to be visible (not invisible)
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("login-button")));

        // Perform login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Wait for title "Products" to be visible
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='title' and text()='Products']"))
        );
//        WebElement dropdownElement = driver.findElement(By.xpath("//span[@class='active_option', data-test='active-option']"));
//        Select productSortDropdown = new Select(dropdownElement);
//
//        productSortDropdown.selectByContainsVisibleText("Name (A to Z)");
//        productSortDropdown.selectByValue("lohi");


        // Clean up
        driver.quit();
    }
    @Test
    public void notInput() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseURL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//input[@type='submit' and @data-test='login-button']")));
        driver.findElement(By.xpath("//input[@type='submit' and @data-test='login-button']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(@data-test, 'error') and contains(text(), 'Username is required')]")
        ));

        driver.quit();
    }

    @Test
    public void notInputPassword() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseURL);
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='submit' and @data-test='login-button']"))
        );
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@type='submit' and @data-test='login-button']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(@data-test, 'error') and contains(text(), 'Password is required')]")
        ));

        driver.quit();
    }

    @Test
    public void notInputUsername() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseURL);
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='submit' and @data-test='login-button']"))
        );
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@type='submit' and @data-test='login-button']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(@data-test, 'error') and contains(text(), 'Username is required')]")
        ));

        driver.quit();
    }

    @Test
    public void inputKapital() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseURL);
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='submit' and @data-test='login-button']"))
        );
        driver.findElement(By.name("user-name")).sendKeys("STANDARD_USER");
        driver.findElement(By.id("password")).sendKeys("SECRET_SAUCE");
        driver.findElement(By.xpath("//input[@type='submit' and @data-test='login-button']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(@data-test, 'error') and contains(text(), 'Username and password do not match any user in this service')]")
        ));

        driver.quit();
    }

}
