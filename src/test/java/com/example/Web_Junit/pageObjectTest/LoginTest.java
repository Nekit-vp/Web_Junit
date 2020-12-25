package com.example.Web_Junit.pageObjectTest;

import com.example.Web_Junit.pageObjectTest.pageobject.LoginPage;
import com.example.Web_Junit.pageObjectTest.pageobject.MainPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.Properties;
import java.util.concurrent.TimeUnit;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginTest {
    private static ChromeDriver driver;
    private static LoginPage loginPage;
    private static MainPage mainPage;

    @BeforeAll
    static void build() {
        Properties properties = PropertiesReader.getProperties();
        //System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        loginPage = new LoginPage(driver, properties);
        mainPage = new MainPage(driver, properties);
        mainPage.open();
    }

    @AfterAll
    static void destroy() {
        driver.close();
    }

    @Test
    @Order(1)
    void wrongLogin() {
        loginPage.open();
        Assertions.assertTrue(loginPage.atPage());
        loginPage.enterUsername("1");
        loginPage.enterPassword("pas");
        loginPage.submit();
        Assertions.assertTrue(loginPage.atPage());
        Assertions.assertFalse(mainPage.atPage());
    }

    @Test
    @Order(2)
    void success() {
        loginPage.open();
        Assertions.assertTrue(loginPage.atPage());
        loginPage.enterUsername("1");
        loginPage.enterPassword("1");
        loginPage.submit();
        Assertions.assertFalse(loginPage.atPage());
        Assertions.assertTrue(mainPage.atPage());
    }

}
