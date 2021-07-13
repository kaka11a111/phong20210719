package com.training.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {

    public final static String URL = "https://demoqa.com/select-menu";
    public final static String DD_COLORS = "//select[@id='oldSelectMenu']";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(URL);
        System.out.println("Navigated to " + URL + " done");
        Thread.sleep(5000);
        WebElement colorSelect = driver.findElement(By.xpath(DD_COLORS));
        Select oSelect = new Select(colorSelect);
        oSelect.selectByVisibleText("Purple");
        Thread.sleep(3000);
        oSelect.selectByValue("10");
        Thread.sleep(3000);
        oSelect.selectByIndex(0);
        Thread.sleep(3000);
        String firstElementText = oSelect.getFirstSelectedOption().getText();
        System.out.println("Color: " + firstElementText);
        driver.close();
    }
}
