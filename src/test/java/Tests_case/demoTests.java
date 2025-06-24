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
    public void TC01() {
        //login berhasil dengan data yang valid

        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(); // local reference avoids relying on env_target for driver
        driver.manage().window().maximize();
        driver.get(baseURL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("login-button")));


        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='title' and text()='Products']"))
        );
        driver.findElement(By.xpath("//*[contains(@class, 'inventory_item_name') and text()='Sauce Labs Backpack']")).click();
        driver.findElement(By.xpath("//button[contains(text(), 'Add to cart')]")).click();

//        WebElement dropdownElement = driver.findElement(By.xpath("//select[@data-test='product_sort_container']"));
//        Select productSortDropdown = new Select(dropdownElement);
//
//
//        productSortDropdown.selectByVisibleText("Name (A to Z)");
//        productSortDropdown.selectByValue("lohi");


        driver.quit();
    }

    @Test
    public void TC02() {
        // login gagal: menginput dengan password yang salah

        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(); // local reference avoids relying on env_target for driver
        driver.manage().window().maximize();
        driver.get(baseURL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("login-button")));


        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("sauce_glim");
        driver.findElement(By.id("login-button")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(@data-test, 'error') and contains(text(), 'Username and password do not match any user in this service')]")
        ));

        driver.quit();
    }

    @Test
    public void TC03() {
        //login gagal: menginput dengan username yang salah

        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(); // local reference avoids relying on env_target for driver
        driver.manage().window().maximize();
        driver.get(baseURL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("login-button")));


        driver.findElement(By.id("user-name")).sendKeys("123_sauce");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(@data-test, 'error') and contains(text(), 'Username and password do not match any user in this service')]")
        ));

        driver.quit();
    }

    @Test
    public void TC04() {
        //login gagal: tidak menginput username dan password

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
    public void TC05() {
        //login gagal: tidak menginput password

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
    public void TC06() {
        //login gagal: tidak menginput username

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
    public void TC07() {
        //login gagal: menginput username & password dengan huruf kapital

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

    @Test
    public void TC08() {
        //login gagal: menginput username dengan huruf kapital & password

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
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@type='submit' and @data-test='login-button']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(@data-test, 'error') and contains(text(), 'Username and password do not match any user in this service')]")
        ));

        driver.quit();
    }

    @Test
    public void TC09() {
        //login gagal: menginput username & password dengan huruf kapital

        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseURL);
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='submit' and @data-test='login-button']"))
        );
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("SECRET_SAUCE");
        driver.findElement(By.xpath("//input[@type='submit' and @data-test='login-button']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(@data-test, 'error') and contains(text(), 'Username and password do not match any user in this service')]")
        ));

        driver.quit();
    }

    @Test
    public void TC10() {
        //login gagal: menginput username dengan <space> diakhir & password

        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseURL);
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='submit' and @data-test='login-button']"))
        );
        driver.findElement(By.name("user-name")).sendKeys("standard_user ");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@type='submit' and @data-test='login-button']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(@data-test, 'error') and contains(text(), 'Username and password do not match any user in this service')]")
        ));

        driver.quit();
    }

    @Test
    public void TC11() {
        // login gagal: menginput username & password dengan <space> diakhir

        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='login-button']"))
        );
        driver.findElement(By.xpath("//input[@name='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce ");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Username and password do not match any user in this service')]"))
        );
        driver.quit();

    }

    @Test
    public void TC12() {
        // login gagal: menginput username & password dengan simbol '

        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='login-button']"))
        );
        driver.findElement(By.xpath("//input[@name='user-name']")).sendKeys("standard_user'");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce'");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Username and password do not match any user in this service')]"))
        );
        driver.quit();

    }



}
