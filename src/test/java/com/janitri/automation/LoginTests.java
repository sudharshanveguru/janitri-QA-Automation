package com.janitri.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class LoginTests extends BaseTest {

    public static WebDriver driver;

    @BeforeTest
    public void setup() throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");


        WebDriverManager.chromedriver().setup();


        driver = new ChromeDriver(options);


        driver.manage().window().maximize();


        driver.get("https://dev-dash.janitri.in");


        Thread.sleep(5000);


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterTest
    public void teardown() {

        if (driver != null) {
            driver.quit();
        }
    }
}