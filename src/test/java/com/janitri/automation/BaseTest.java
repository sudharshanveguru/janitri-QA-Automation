package com.janitri.automation;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    public static WebDriver driver;

    @BeforeTest
    public void setup() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("https://dev-dash.janitri.in");


        Thread.sleep(5000);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}