package com.example.Web_Junit;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class WebJunitSeleniumTest {

    public static WebDriver driver;
    public static Properties properties;

    @BeforeAll
    public static void init() {
        properties = new Properties();
        try {
            properties.load(new FileReader("src/test/resources/selenium.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterAll
    public static void close() {
        driver.quit();
    }

    @org.junit.jupiter.api.Test
    @Order(1)
    public void signupTest() {
        driver.get(properties.getProperty("signUpPage"));
        Assertions.assertEquals("Sign_up", driver.getTitle());
        WebElement username = new WebDriverWait(driver, 3)
                .until(driver -> driver.findElement(By.cssSelector("#login")));
        WebElement password = new WebDriverWait(driver, 3)
                .until(driver -> driver.findElement(By.cssSelector("#password")));
        WebElement submitButton = new WebDriverWait(driver, 3)
                .until(driver -> driver.findElement(By.cssSelector("button[id=submit]")));
        username.sendKeys("nikitty4");
        password.sendKeys("12");
        submitButton.click();
        Assertions.assertEquals("Sign_in", driver.getTitle());
    }

    @Test
    @Order(2)
    public void loginTest() {
        driver.get(properties.getProperty("logInPage"));
        Assertions.assertEquals("Sign_in", driver.getTitle());
        WebElement username = new WebDriverWait(driver, 3)
                .until(driver -> driver.findElement(By.xpath("//input[@name='login']")));
        WebElement password = new WebDriverWait(driver, 3)
                .until(driver -> driver.findElement(By.xpath("html/body/div/form/p[2]/input")));
        WebElement submitButton = new WebDriverWait(driver, 3)
                .until(driver -> driver.findElement(By.xpath("//button[@type='submit']")));
        username.sendKeys("1");
        password.sendKeys("1");
        submitButton.click();
        Assertions.assertEquals("Shop", driver.getTitle());
    }
}
