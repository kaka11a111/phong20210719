package com.training.pages;

import com.log.LogHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.slf4j.Logger;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class EditCustomerPage {
    protected static final Logger log = LogHelper.getLogger();
    public static final String URL_PAGE = "http://demo.guru99.com/V4/manager/editCustomerPage.php";

    private WebDriver driver;

    // Object Repository
    public final static String BT_SUBMIT = "//input[@name='AccSubmit']";
    public final static String ADDRESS_AREA = "//textarea[@name='addr']";
    public final static String LB_ERROR_MSG_ADDRESS = "//label[@id='message3']";
    public final static String TB_CITY = "//input[@name='city']";
    public final static String LB_ERROR_MSG_CITY = "//label[@id='message4']";
    public final static String TB_STATE = "/html/body/table/tbody/tr/td/table/tbody/tr[9]/td[2]/input";
    public final static String LB_MESSAGE_ERROR_STATE = "//label[@id='message5']";
    public final static String TB_PIN = "//input[@name='pinno']";
    public final static String LB_MESSAGE_ERROR_PIN = "//label[@id='message6']";
    public final static String TB_PHONE = "//input[@name='telephoneno']";
    public final static String LB_MESSAGE_ERROR_PHONE = "//label[@id='message7']";
    public final static String TB_EMAIL = "//input[@name='emailid']";
    public final static String LB_MESSAGE_ERROR_EMAIL = "//label[@id='message9']";

    public EditCustomerPage(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        Thread.sleep(2000);
    }

    public boolean is_correct_page() {
        String actual_url_page = driver.getCurrentUrl();
        log.info("Url current: " + actual_url_page);
        return actual_url_page.equals(URL_PAGE);
    }

    public void inputDataIntoArea(String element, String data) throws InterruptedException {

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);

        WebElement value_area = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath(element));
            }
        });

        value_area.clear();
        value_area.sendKeys(data);
        Thread.sleep(1000);
    }

    public void inputDataIntoAddressArea(String data) throws InterruptedException {
        inputDataIntoArea(ADDRESS_AREA, data);
    }

    public void inputDataIntoTextBoxCity(String data) throws InterruptedException {
        inputDataIntoArea(TB_CITY, data);
    }

    public void inputDataIntoTextBoxState(String data) throws InterruptedException {
        inputDataIntoArea(TB_STATE, data);
    }

    public void inputDataIntoTextBoxPin(String data) throws InterruptedException {
        inputDataIntoArea(TB_PIN, data);
    }

    public void inputDataIntoTextBoxPhone(String data) throws InterruptedException {
        inputDataIntoArea(TB_PHONE, data);
    }

    public void inputDataIntoTextBoxMail(String data) throws InterruptedException {
        inputDataIntoArea(TB_EMAIL, data);
    }

    public boolean verifyMessageError(String error, String name_element){
        WebElement lb_error = driver.findElement(By.xpath(name_element));
        String actual_error_message = lb_error.getText();

        log.info(actual_error_message);
        if (!actual_error_message.equals(error)){
            log.info(actual_error_message + " not equal " + error);
            return false;
        }
        return true;
    }


    public boolean showErrorMessageAreaAddress(String error_message) {
        WebElement lb_error = driver.findElement(By.xpath(LB_ERROR_MSG_ADDRESS));
        String actual_error_message = lb_error.getText();

        log.info(actual_error_message);
        if (!actual_error_message.equals(error_message)){
            log.info(actual_error_message + " not equal " + error_message);
            return false;
        }
        return true;
    }

    public boolean showErrorMessageTextBoxCity(String error_message) {
        WebElement lb_error = driver.findElement(By.xpath(LB_ERROR_MSG_CITY));
        String actual_error_message = lb_error.getText();

        log.info(actual_error_message);
        if (!actual_error_message.equals(error_message)){
            log.info(actual_error_message + " not equal " + error_message);
            return false;
        }
        return true;
    }

    public boolean showErrorMessageTextState(String error_message) {
        return verifyMessageError(error_message, LB_MESSAGE_ERROR_STATE);
    }

    public boolean showErrorMessageTextPin(String error_message) {
        return verifyMessageError(error_message, LB_MESSAGE_ERROR_PIN);
    }

    public boolean showErrorMessageTextPhone(String error_message) {
        return verifyMessageError(error_message, LB_MESSAGE_ERROR_PHONE);
    }

    public boolean showErrorMessageTextMail(String error_message) {
        return verifyMessageError(error_message, LB_MESSAGE_ERROR_EMAIL);
    }
}
