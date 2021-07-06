package com.training.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebBrowserCommands {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "https://dantri.com.vn";
        driver.get(url);
        String title = driver.getTitle();
        System.out.println("Title: " + title);
        String newUrl = "https://vnexpress.net";
        driver.navigate().to(newUrl);
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);
        driver.navigate().forward();
        Thread.sleep(3000);
        driver.navigate().refresh();
        Thread.sleep(3000);
        driver.close();

        // smart wait (timeout): nó thấy element thì script tương tác luôn với element đó mà không phải đợi hết timeout
    }
}
