package com.training.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckboxAndRadioButton {
    public final static String URL = "https://demoqa.com/checkbox";
    public final static String BT_HOME_TOOGLE = "//div[@id='tree-node']/ol[1]/li[1]/span[@class='rct-text']/button";
    public final static String LB_FOLDER_NAME = "//span[@class='rct-title']";
    public final static String CB_INPUT_FOLDER_NAME = "//input[contains(@id,'tree-node')]";
    public final static String CB_SPAN_FOLDER_NAME = "//span[@class='rct-checkbox']";

    public final static String FOLDER_NAME = "Documents";


    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(URL);
        System.out.println("Navigated to " + URL + " done");
        Thread.sleep(5000);
        driver.findElement(By.xpath(BT_HOME_TOOGLE)).click();
        System.out.println("Clicked " + BT_HOME_TOOGLE + " done");
        Thread.sleep(2000);
        List<WebElement> lbFolderName = driver.findElements(By.xpath(LB_FOLDER_NAME));
        List<WebElement> cbInputFolderName = driver.findElements(By.xpath(CB_INPUT_FOLDER_NAME));
        List<WebElement> cbSpanFolderName = driver.findElements(By.xpath((CB_SPAN_FOLDER_NAME)));

        for(int i = 0; i < lbFolderName.size(); i++) {
            String actualFolderName = lbFolderName.get(i).getText().trim();
            if(actualFolderName.equals(FOLDER_NAME)) {
                if(cbInputFolderName.get(i).isDisplayed() == true) {
                    System.out.println("Clicking " + CB_INPUT_FOLDER_NAME);
                    cbInputFolderName.get(i).click();
                    System.out.println("Clicked " + CB_INPUT_FOLDER_NAME + " done");
                    Thread.sleep(3000);
                }
                cbSpanFolderName.get(i).click();
                System.out.println("Clicked " + CB_SPAN_FOLDER_NAME + " done");
                Thread.sleep(3000);
            }
        }

        driver.close();
    }
}
