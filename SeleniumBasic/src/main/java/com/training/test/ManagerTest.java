package com.training.test;

import com.training.pages.Login;
import com.training.pages.Manager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ManagerTest {
    Login objLogin;
    Manager objManager;

    private static WebDriver driver;

    public final static String URL = "http://demo.guru99.com/v4";

    @BeforeTest
    public void Setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(URL);
        System.out.println("Navigated to " + URL + " done");
        Thread.sleep(5000);
    }

    @Test
    public void TC01_ShowManagerIDAfterLoginSuccessfully() throws InterruptedException {
        objLogin = new Login(driver);
        objManager = objLogin.loginWith("mgr123", "mgr!23");
        assertTrue(objManager.shouldBeToShowManagerIDAs("Manger Id : mgr123"));
        Thread.sleep(5000);
    }

    @AfterTest
    public void TearDown() {
        driver.close();
    }
}
