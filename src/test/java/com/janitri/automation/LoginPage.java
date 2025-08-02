package com.janitri.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private final WebDriver driver;


    private final By userIDField = By.id("formEmail");
    private final By passwordField = By.id("formPassword");
    private final By loginButton = By.xpath("//button[@type='submit']");
    private final By passwordVisibilityToggle = By.xpath("//div[@class='password-input-container']//i");
    private final By errorMessage = By.className("auth-error-message");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to enter User ID
    public void enterUserID(String userID) {
        driver.findElement(userIDField).sendKeys(userID);
    }


    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }


    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    // Method to toggle password visibility
    public void togglePasswordVisibility() {
        driver.findElement(passwordVisibilityToggle).click();
    }


    public boolean isLoginButtonEnabled() {
        return driver.findElement(loginButton).isEnabled();
    }


    public String getPasswordInputType() {
        return driver.findElement(passwordField).getAttribute("type");
    }


    public String getErrorMessageText() {
        try {
            return driver.findElement(errorMessage).getText();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return null; // Return null if the error message element is not found
        }
    }


    public boolean isUserIDFieldDisplayed() {
        try {
            return driver.findElement(userIDField).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    // Method to check if Password field is displayed
    public boolean isPasswordFieldDisplayed() {
        try {
            return driver.findElement(passwordField).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }


    public boolean isPasswordToggleDisplayed() {
        try {
            return driver.findElement(passwordVisibilityToggle).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
}