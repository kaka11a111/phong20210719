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

public class EditCustomer {
    protected static final Logger log = LogHelper.getLogger();

    private WebDriver driver;

    // Object Repository
    public final static String TB_CUSTOMER_ID = "//input[@name='cusid']";
    public final static String LB_ERROR_MESSAGE = "//label[@id='message14']";
    public final static String BT_SUBMIT = "//input[@name='AccSubmit']";
    public final static String LINK_EDIT_CUSTOMER = "/html/body/div[3]/div/ul/li[3]/a";

    public EditCustomer(WebDriver driver) {
        this.driver = driver;
    }


    // Methods which interact web elements

    public void inputCustomerID(String ID) throws InterruptedException {

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);

        WebElement value_id = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath(TB_CUSTOMER_ID));
            }
        });

        value_id.clear();
        value_id.sendKeys(ID);
        Thread.sleep(1000);
    }

    public boolean showErrorMessageCustomerIDField(String error_message) {
        WebElement lb_error = driver.findElement(By.xpath(LB_ERROR_MESSAGE));
        String actual_error_message = lb_error.getText();

        log.info(actual_error_message);

        if (!actual_error_message.equals(error_message)){
            log.info(actual_error_message + " not equal " + error_message);
            return false;
        }
        return true;
    }

    public EditCustomerPage clickSubmitButton() throws InterruptedException {
        WebElement bt_submit = driver.findElement(By.xpath(BT_SUBMIT));
        bt_submit.click();
        return new EditCustomerPage(driver);
    }

}
