package com.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {

    private WebDriver driver;

    // Object Repository
    private final String TB_USER_NAME = "//input[@name='uid']";
    private final String TB_USER_PASSWORD = "//input[@name='password']";
    private final String BT_LOGIN = "//input[@name='btnLogin']";

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    // Methods which interact web elements

    public void inputUserName(String userName) {
        WebElement tbUserName = this.driver.findElement(By.xpath(TB_USER_NAME));
        tbUserName.sendKeys(userName);
    }

    public void inputUserPassword(String userPassword) {
        WebElement tbUserPassword = this.driver.findElement(By.xpath(TB_USER_PASSWORD));
        tbUserPassword.sendKeys(userPassword);
    }

    public void clickLoginButton() {
        WebElement btLogin = this.driver.findElement(By.xpath(BT_LOGIN));
        btLogin.click();
    }

    public Manager loginWith(String userName, String userPassword) {
        this.inputUserName(userName);
        this.inputUserPassword(userPassword);
        this.clickLoginButton();
        return new Manager(this.driver);
    }
}
