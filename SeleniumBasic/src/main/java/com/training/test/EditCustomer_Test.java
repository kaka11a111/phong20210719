package com.training.test;

import com.log.LogHelper;
import com.training.data.EditCustomerData;
import com.training.pages.EditCustomer;
import com.training.pages.EditCustomerPage;
import com.training.pages.Login;
import com.training.pages.Manager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

import static org.testng.Assert.assertTrue;


public class EditCustomer_Test {
    EditCustomer objEditCustomer;
    EditCustomerPage objEditCustomerPage;
    Manager objManager;
    Login objLogin;
    private static WebDriver driver;
    Robot robot = new Robot();
    public final static String URL = "http://demo.guru99.com/V4";

    public EditCustomer_Test() throws AWTException {
    }

    @BeforeTest
    public void Setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        System.out.println("Navigated to " + URL + " done");
        Thread.sleep(2000);

        objLogin = new Login(driver);
        objManager = objLogin.loginWith("mngr341788", "EmavyzE");

        objEditCustomer = objManager.clickLinkEditCustomer();
        Thread.sleep(5000);
    }

    @Test
    public void TC01_ShowErrorMessageRequiredInCustomerIDField() throws InterruptedException {
        objEditCustomer = new EditCustomer(driver);
        objEditCustomer.inputCustomerID(EditCustomerData.text_blank);
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(2000);
        assertTrue(objEditCustomer.showErrorMessageCustomerIDField(EditCustomerData.error_message_required));
    }

    @Test
    public void TC02_ShowErrorMessageNotAllowedInCustomerIDField() throws InterruptedException {
        objEditCustomer.inputCustomerID(EditCustomerData.character_1);

        assertTrue(objEditCustomer.showErrorMessageCustomerIDField(EditCustomerData.error_message_character_not_allowed));

        Thread.sleep(2000);

        objEditCustomer.inputCustomerID(EditCustomerData.character_2);

        assertTrue(objEditCustomer.showErrorMessageCustomerIDField(EditCustomerData.error_message_character_not_allowed));
    }

    @Test
    public void TC03_ShowErrorMessageSpecialCharacterNotAllowedInCustomerIDField() throws InterruptedException {
        objEditCustomer.inputCustomerID(EditCustomerData.special_character_1);

        assertTrue(objEditCustomer.showErrorMessageCustomerIDField(EditCustomerData.error_message_special_character_not_allowed));

        Thread.sleep(2000);

        objEditCustomer.inputCustomerID(EditCustomerData.special_character_2);

        assertTrue(objEditCustomer.showErrorMessageCustomerIDField(EditCustomerData.error_message_special_character_not_allowed));
    }

    @Test
    public void TC04_GoToEditCustomerPage() throws InterruptedException {
        objEditCustomer.inputCustomerID(EditCustomerData.customer_ID_correct);
        Thread.sleep(1000);

        objEditCustomerPage = objEditCustomer.clickSubmitButton();

        assertTrue(objEditCustomerPage.is_correct_page());
    }

    @Test
    public void TC05_ShowErrorMessageAreaAddress() throws InterruptedException {
        objEditCustomerPage = new EditCustomerPage(driver);

        objEditCustomerPage.inputDataIntoAddressArea(EditCustomerData.text_blank);
        Thread.sleep(1000);

        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(1000);

        assertTrue(objEditCustomerPage.showErrorMessageAreaAddress(EditCustomerData.error_message_area_address));
    }

    @Test
    public void TC06_ShowErrorMessageRequiredTextBoxCity() throws InterruptedException {

        objEditCustomerPage.inputDataIntoTextBoxCity(EditCustomerData.text_blank);
        Thread.sleep(1000);

        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(1000);

        assertTrue(objEditCustomerPage.showErrorMessageTextBoxCity(EditCustomerData.error_message_text_box_city));
    }

    @Test
    public void TC06_ShowErrorMessageNumberNotAllowedTextBoxCity() throws InterruptedException {

        objEditCustomerPage.inputDataIntoTextBoxCity(EditCustomerData.character_1);
        Thread.sleep(1000);

        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(1000);

        assertTrue(objEditCustomerPage.showErrorMessageTextBoxCity(EditCustomerData.error_message_number_not_allowed_text_box_city));
        Thread.sleep(1000);

        objEditCustomerPage.inputDataIntoTextBoxCity(EditCustomerData.character_2);
        Thread.sleep(1000);

        assertTrue(objEditCustomerPage.showErrorMessageTextBoxCity(EditCustomerData.error_message_number_not_allowed_text_box_city));
    }

    @Test
    public void TC07_ShowErrorMessageSpecialNotAllowedTextBoxCity() throws InterruptedException {

        objEditCustomerPage.inputDataIntoTextBoxCity(EditCustomerData.special_character_1);
        Thread.sleep(1000);

        assertTrue(objEditCustomerPage.showErrorMessageTextBoxCity(EditCustomerData.error_message_special_character_not_allowed));
        Thread.sleep(1000);

        objEditCustomerPage.inputDataIntoTextBoxCity(EditCustomerData.special_character_2);
        Thread.sleep(1000);

        assertTrue(objEditCustomerPage.showErrorMessageTextBoxCity(EditCustomerData.error_message_special_character_not_allowed));
    }

    @Test
    public void TC08_ShowErrorMessageRequiredTextBoxState() throws InterruptedException {

        objEditCustomerPage.inputDataIntoTextBoxState(EditCustomerData.text_blank);
        Thread.sleep(1000);

        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(1000);

        assertTrue(objEditCustomerPage.showErrorMessageTextState(EditCustomerData.error_message_text_box_state));
    }

    @Test
    public void TC09_ShowErrorMessageNumberNotAllowedTextBoxState() throws InterruptedException {

        objEditCustomerPage.inputDataIntoTextBoxState(EditCustomerData.character_1);
        Thread.sleep(1000);

        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(1000);

        assertTrue(objEditCustomerPage.showErrorMessageTextState(EditCustomerData.error_message_number_not_allowed_text_box_city));
        Thread.sleep(1000);

        objEditCustomerPage.inputDataIntoTextBoxState(EditCustomerData.character_2);
        Thread.sleep(1000);

        assertTrue(objEditCustomerPage.showErrorMessageTextState(EditCustomerData.error_message_number_not_allowed_text_box_city));
    }

    @Test
    public void TC10_ShowErrorMessageSpecialNotAllowedTextBoxState() throws InterruptedException {

        objEditCustomerPage.inputDataIntoTextBoxState(EditCustomerData.special_character_1);
        Thread.sleep(1000);

        assertTrue(objEditCustomerPage.showErrorMessageTextState(EditCustomerData.error_message_special_character_not_allowed));
        Thread.sleep(1000);

        objEditCustomerPage.inputDataIntoTextBoxState(EditCustomerData.special_character_2);
        Thread.sleep(1000);

        assertTrue(objEditCustomerPage.showErrorMessageTextState(EditCustomerData.error_message_special_character_not_allowed));
    }

    @Test
    public void TC11_ShowErrorMessageRequiredTextBoxPin() throws InterruptedException {

        objEditCustomerPage.inputDataIntoTextBoxPin(EditCustomerData.text_blank);
        Thread.sleep(1000);

        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(1000);

        assertTrue(objEditCustomerPage.showErrorMessageTextPin(EditCustomerData.error_message_text_box_pin));
    }

    @Test
    public void TC12_ShowErrorMessageNumberNotAllowedTextBoxPin() throws InterruptedException {

        objEditCustomerPage.inputDataIntoTextBoxPin(EditCustomerData.character_1);
        Thread.sleep(1000);

        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(1000);

        assertTrue(objEditCustomerPage.showErrorMessageTextPin(EditCustomerData.error_message_number_not_allowed_text_box_city));
        Thread.sleep(1000);

        objEditCustomerPage.inputDataIntoTextBoxPin(EditCustomerData.character_2);
        Thread.sleep(1000);

        assertTrue(objEditCustomerPage.showErrorMessageTextPin(EditCustomerData.error_message_number_not_allowed_text_box_city));
    }

    @Test
    public void TC13_ShowErrorMessageSpecialNotAllowedTextBoxPin() throws InterruptedException {

        objEditCustomerPage.inputDataIntoTextBoxPin(EditCustomerData.special_character_1);
        Thread.sleep(1000);

        assertTrue(objEditCustomerPage.showErrorMessageTextPin(EditCustomerData.error_message_special_character_not_allowed));
        Thread.sleep(1000);

        objEditCustomerPage.inputDataIntoTextBoxPin(EditCustomerData.special_character_2);
        Thread.sleep(1000);

        assertTrue(objEditCustomerPage.showErrorMessageTextPin(EditCustomerData.error_message_special_character_not_allowed));
    }

    @Test
    public void TC14_ShowErrorMessageRequiredTextBoxPhone() throws InterruptedException {

        objEditCustomerPage.inputDataIntoTextBoxPhone(EditCustomerData.text_blank);
        Thread.sleep(1000);

        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(1000);

        assertTrue(objEditCustomerPage.showErrorMessageTextPhone(EditCustomerData.error_message_text_box_phone));
    }
    @Test
    public void TC15_ShowErrorMessageSpecialNotAllowedTextBoxPhone() throws InterruptedException {

        objEditCustomerPage.inputDataIntoTextBoxPhone(EditCustomerData.special_character_1);
        Thread.sleep(1000);

        assertTrue(objEditCustomerPage.showErrorMessageTextPhone(EditCustomerData.error_message_special_character_not_allowed));
        Thread.sleep(1000);

        objEditCustomerPage.inputDataIntoTextBoxPhone(EditCustomerData.special_character_3);
        Thread.sleep(1000);

        assertTrue(objEditCustomerPage.showErrorMessageTextPhone(EditCustomerData.error_message_special_character_not_allowed));

        objEditCustomerPage.inputDataIntoTextBoxPhone(EditCustomerData.special_character_4);
        Thread.sleep(1000);

        assertTrue(objEditCustomerPage.showErrorMessageTextPhone(EditCustomerData.error_message_special_character_not_allowed));
    }

    @Test
    public void TC16_ShowErrorMessageRequiredTextBoxMail() throws InterruptedException {

        objEditCustomerPage.inputDataIntoTextBoxMail(EditCustomerData.text_blank);
        Thread.sleep(1000);

        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(1000);

        assertTrue(objEditCustomerPage.showErrorMessageTextMail(EditCustomerData.error_message_text_box_mail));
    }

    @Test
    public void TC15_ShowErrorMessageSpecialNotAllowedTextBoxMail() throws InterruptedException {

        objEditCustomerPage.inputDataIntoTextBoxMail(EditCustomerData.special_mail_1);
        Thread.sleep(1000);

        assertTrue(objEditCustomerPage.showErrorMessageTextPhone(EditCustomerData.error_message_number_not_valid_mail));
        Thread.sleep(1000);

        objEditCustomerPage.inputDataIntoTextBoxMail(EditCustomerData.special_mail_2);
        Thread.sleep(1000);

        assertTrue(objEditCustomerPage.showErrorMessageTextPhone(EditCustomerData.error_message_number_not_valid_mail));

        objEditCustomerPage.inputDataIntoTextBoxMail(EditCustomerData.special_mail_3);
        Thread.sleep(1000);

        assertTrue(objEditCustomerPage.showErrorMessageTextPhone(EditCustomerData.error_message_number_not_valid_mail));

        objEditCustomerPage.inputDataIntoTextBoxMail(EditCustomerData.special_mail_4);
        Thread.sleep(1000);

        assertTrue(objEditCustomerPage.showErrorMessageTextPhone(EditCustomerData.error_message_number_not_valid_mail));
    }
    @AfterTest
    public void TearDown() {
        driver.close();
    }
}
