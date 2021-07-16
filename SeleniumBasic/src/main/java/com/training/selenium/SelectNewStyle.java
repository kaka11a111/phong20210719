package com.training.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectNewStyle {
    public final static String URL = "https://demoqa.com/select-menu";
    public final static String DDL_SELECT_VALUE = "//*[@id=\"react-select-2-input\"]";
    public final  static String VALUE_SELECT = "//*[@id=\"withOptGroup\"]/div[2]";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\SeleniumBasic\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(URL);
        System.out.println("Navigated to " + URL + " done");
        Thread.sleep(5000);

        WebElement value_select_text = driver.findElement(By.xpath(DDL_SELECT_VALUE));
        value_select_text.sendKeys("a root option");
        Thread.sleep(5000);

        WebElement value_select = driver.findElement(By.xpath(VALUE_SELECT));
        value_select.click();
        Thread.sleep(5000);

        value_select_text.sendKeys("group 1, option 2");
        Thread.sleep(5000);
        value_select = driver.findElement(By.xpath(VALUE_SELECT));
        value_select.click();

        Thread.sleep(5000);
        driver.close();
    }
}
