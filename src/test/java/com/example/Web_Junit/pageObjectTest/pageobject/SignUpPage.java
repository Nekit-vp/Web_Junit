package com.example.Web_Junit.pageObjectTest.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;

public class SignUpPage {
    private final WebDriver driver;
    private final Properties properties;

    public SignUpPage(WebDriver driver, Properties properties) {
        this.driver = driver;
        this.properties = properties;
    }

    public void enterUsername(String username) {
        WebElement usernameField = new WebDriverWait(driver, 3)
                .until(driver -> driver.findElement(By.cssSelector("#login")));
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passwordField = new WebDriverWait(driver, 3)
                .until(driver -> driver.findElement(By.cssSelector("#password")));
        passwordField.sendKeys(password);
    }

    public boolean isLoginValid() {
        WebElement usernameField = new WebDriverWait(driver, 3)
                .until(driver -> driver.findElement(By.cssSelector("#login")));
        return usernameField.getText() != null && !usernameField.getText().equals("");
    }

    public boolean isPasswordValid() {
        WebElement passwordField = new WebDriverWait(driver, 3)
                .until(driver -> driver.findElement(By.cssSelector("#password")));
        return passwordField.getText() != null && !passwordField.getText().equals("");
    }

    public void submit() {
        WebElement submitButton = new WebDriverWait(driver, 3)
                .until(driver -> driver.findElement(By.cssSelector("button[id=submit]")));
        submitButton.click();
    }

    public void open() {
        driver.get(properties.getProperty("signUpPage"));
    }

    public boolean atPage() {
        return driver.getTitle().equals("Sign_up");
    }
}
