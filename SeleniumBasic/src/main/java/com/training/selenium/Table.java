package com.training.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Table {

    public static String URL = "https://demoqa.com/webtables";
    public static String EMAIL_COLUMN = "//div[@class='rt-td'][4]";
    public static String BT_EDIT = "//span[contains(@id,'edit-record-')]";
    public static String BT_BUTTONS = "//div[@class='action-buttons']";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(URL);
        System.out.println("Navigated to " + URL + " done");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        List<WebElement> cellEmails = driver.findElements(By.xpath(EMAIL_COLUMN));
        List<WebElement> btEdits = driver.findElements(By.xpath(BT_EDIT));
        List<WebElement> btButtons = driver.findElements(By.xpath(BT_BUTTONS));

        for(int i = 0; i < cellEmails.size(); i++) {
            String actualEmail = cellEmails.get(i).getText().trim();
            if(actualEmail.equals("alden@example.com")) {
//                btButtons.get(i).click();
                Actions actions = new Actions(driver);
                actions.moveToElement(btButtons.get(i), 25, 0).click().build().perform();
                break;
            }
        }
        Thread.sleep(5000);
        driver.close();
    }
}
