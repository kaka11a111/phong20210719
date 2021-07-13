package com.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Manager {

    private WebDriver driver;

    // Object Repository
    private final String LB_MANAGER_ID = "//td[normalize-space()='Manger Id : mgr123']";

    public Manager(WebDriver driver) {
        this.driver = driver;
    }

    // Methods which interact web elements

    public boolean shouldBeToShowManagerIDAs(String managerId) {
        WebElement lbManagerId = driver.findElement(By.xpath(LB_MANAGER_ID));
        String actualManagerId = lbManagerId.getText().trim();
        if(actualManagerId.equals(managerId)) {
            return true;
        }
        return false;
    }
}
