package com.trinhthianh.pages;

import com.trinhthianh.helpers.PropertiesHelper;
import com.trinhthianh.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage extends CommonPage {
    private By moreOption = By.xpath("//android.widget.Button[@text='Continue with Email']");
    private By logInEmailOption = By.xpath("//android.widget.TextView[@text='Login with Email']");
    private By emailInputElement = By.xpath("//android.widget.EditText[@resource-id='email']");
    private By passwordInputElement = By.xpath("//android.widget.EditText[@resource-id='password']");
    private By logInBtnElement = By.xpath("//android.view.View[@resource-id='auth_button_tag']");
    private By messageRequiredEmail = By.xpath("//android.widget.TextView[@text='Email is required']");
    private By messageRequiredPassword = By.xpath("//android.widget.TextView[@text='Password is required']");

    private By toastInvalidEmail = By.xpath("//android.widget.Toast[contains(@text, 'Invalid email. Please double-check it.')]");
    private By toastCanNotLogIn = By.xpath("//android.widget.Toast[contains(@text, \"Couldn't log in. Please check your credentials and try again.\")]");
    private By titleTodayPage = By.xpath("(//android.widget.TextView[@text='Today'])[1]");




    public void loginFailWithEmailNull() {
        WebUI.clickElement(moreOption);
        WebUI.clickElement(logInEmailOption);
        WebUI.sleep(1);
        WebUI.NotClickable(logInBtnElement);
        WebUI.clickElement(emailInputElement);
        WebUI.clickElement(passwordInputElement);
        WebUI.setText(passwordInputElement, "abc219203");
        WebUI.sleep(2);
        WebUI.NotClickable(logInBtnElement);
        WebUI.sleep(1);
        WebUI.keydownEnter(passwordInputElement);
        WebUI.sleep(2);
        WebUI.verifyAssertTrueIsDisplayed(messageRequiredEmail, "Error Message không xuất hiện.");
        WebUI.verifyEquals(WebUI.getElementText(messageRequiredEmail), "Email is required", "Nội dung của message không đúng.");
        WebUI.sleep(2);
    }




    public void loginFailWithAccDoesNotExist(String email, String password) {
        WebUI.clickElement(moreOption);
        WebUI.clickElement(logInEmailOption);
        WebUI.sleep(1);
        WebUI.NotClickable(logInBtnElement);
        WebUI.clickElement(emailInputElement);
        WebUI.setText(emailInputElement, email);
        WebUI.NotClickable(logInBtnElement);
        WebUI.clickElement(passwordInputElement);
        WebUI.setText(passwordInputElement, password);
        WebUI.BtnClickable(logInBtnElement);
        WebUI.sleep(1);
        WebUI.clickElement(logInBtnElement);
        WebUI.waitElementPresence(toastCanNotLogIn, "Error Message không xuất hiện.");
        WebUI.verifyEquals(WebUI.getElementText(toastCanNotLogIn), "Couldn't log in. Please check your credentials and try again.", "Nội dung của message không đúng.");
        WebUI.sleep(2);


    }

    public void loginFailWithEmailIncorrectFormat(String email, String password) {
        WebUI.clickElement(moreOption);
        WebUI.clickElement(logInEmailOption);
        WebUI.sleep(1);
        WebUI.NotClickable(logInBtnElement);
        WebUI.clickElement(emailInputElement);
        WebUI.setText(emailInputElement, email);
        WebUI.NotClickable(logInBtnElement);
        WebUI.clickElement(passwordInputElement);
        WebUI.setText(passwordInputElement, password);
        WebUI.BtnClickable(logInBtnElement);
        WebUI.sleep(1);
        WebUI.clickElement(logInBtnElement);
        WebUI.sleep(2);
        WebUI.waitElementPresence(toastInvalidEmail, "Error Message không xuất hiện.");
        WebUI.verifyEquals(WebUI.getElementText(toastInvalidEmail), "Invalid email. Please double-check it.", "Nội dung của message không đúng.");
        WebUI.sleep(2);


    }

    public void loginFailWithNullPassword(String email) {
        WebUI.clickElement(moreOption);
        WebUI.clickElement(logInEmailOption);
        WebUI.sleep(1);
        WebUI.NotClickable(logInBtnElement);
        WebUI.clickElement(emailInputElement);
        WebUI.setText(emailInputElement, email);
        WebUI.sleep(1);
        WebUI.keydownEnter(emailInputElement);
        WebUI.NotClickable(logInBtnElement);
        WebUI.keydownEnter(passwordInputElement);
        WebUI.sleep(2);
        WebUI.verifyAssertTrueIsDisplayed(messageRequiredPassword, "Error Message không xuất hiện.");
        WebUI.verifyEquals(WebUI.getElementText(messageRequiredPassword), "Password is required", "Nội dung của message không đúng.");
        WebUI.sleep(2);

    }



    public void loginFailWithIncorrectPassword(String email, String password) {
        WebUI.clickElement(moreOption);
        WebUI.clickElement(logInEmailOption);
        WebUI.sleep(1);
        WebUI.NotClickable(logInBtnElement);
        WebUI.clickElement(emailInputElement);
        WebUI.setText(emailInputElement, email);
        WebUI.NotClickable(logInBtnElement);
        WebUI.clickElement(passwordInputElement);
        WebUI.setText(passwordInputElement, password);
        WebUI.sleep(1);
        WebUI.BtnClickable(logInBtnElement);
        WebUI.clickElement(logInBtnElement);
        WebUI.waitElementPresence(toastCanNotLogIn, "Error Message không xuất hiện.");
        WebUI.verifyEquals(WebUI.getElementText(toastCanNotLogIn), "Couldn't log in. Please check your credentials and try again.", "Nội dung của message không đúng.");
        WebUI.sleep(2);


    }

    public void loginSuccessWithCustomerAccount(String email, String password) {

        WebUI.clickElement(moreOption);
        WebUI.clickElement(logInEmailOption);
        WebUI.sleep(1);
        WebUI.NotClickable(logInBtnElement);
        WebUI.clickElement(emailInputElement);
        WebUI.setText(emailInputElement, email);
        WebUI.NotClickable(logInBtnElement);
        WebUI.setText(passwordInputElement, password);
        WebUI.sleep(1);
        WebUI.clickElement(logInBtnElement);
        WebUI.sleep(5);
        WebUI.verifyAssertTrueIsDisplayed(titleTodayPage, "Today page is NOT displayed.");
        WebUI.verifyEquals(WebUI.getElementText(titleTodayPage), "Today");
    }

    public void loginFailWithEmailPasswordNull() {

        WebUI.clickElement(moreOption);
        WebUI.clickElement(logInEmailOption);
        WebUI.sleep(1);
        WebUI.clickElement(emailInputElement);
        WebUI.clickElement(passwordInputElement);
        WebUI.NotClickable(logInBtnElement);
        WebUI.keydownEnter(passwordInputElement);
        WebUI.verifyAssertTrueIsDisplayed(messageRequiredEmail, "Error Message không xuất hiện.");
        WebUI.verifyEquals(WebUI.getElementText(messageRequiredEmail), "Email is required", "Nội dung của message không đúng.");
        WebUI.sleep(2);
        WebUI.verifyAssertTrueIsDisplayed(messageRequiredPassword, "Error Message không xuất hiện.");
        WebUI.verifyEquals(WebUI.getElementText(messageRequiredPassword), "Password is required", "Nội dung của message không đúng.");
        WebUI.sleep(2);
    }
}


