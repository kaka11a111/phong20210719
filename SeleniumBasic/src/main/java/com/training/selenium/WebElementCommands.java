package com.training.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementCommands {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "https://demoqa.com/text-box";
        driver.get(url);
        WebElement tb_fullName = driver.findElement(By.id("userName"));
        String fullName = "Hello Kitty";
        tb_fullName.sendKeys(fullName);
        Thread.sleep(3000);
//        driver.findElement(By.id("userName")).sendKeys(fullName);
        tb_fullName.clear();
        Thread.sleep(3000);
        driver.close();
    }
}
