package com.trinhthianh.pages;

import com.trinhthianh.drivers.DriverManager;
import com.trinhthianh.helpers.PropertiesHelper;
import com.trinhthianh.keywords.WebUI;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.testng.Assert;

public class SignUpPage extends CommonPage {


    private By moreOption = By.xpath("//android.widget.Button[@text='Continue with Email']");
    private By signUpEmailOption = By.xpath("//android.widget.TextView[@text='Sign up with Email']");
    private By emailInputElement = By.xpath("//android.widget.EditText[@resource-id='email']");
    private By passwordInputElement = By.xpath("//android.widget.EditText[@resource-id='password']");
    private By signUpBtnElement = By.xpath("//android.view.View[@resource-id='auth_button_tag']");
    private By messageRequiredEmail = By.xpath("//android.widget.TextView[@text='Email is required']");
    private By messageRequiredPassword = By.xpath("//android.widget.TextView[@text='Password is required']");
    private By messageEmailInvalid = By.xpath("//android.widget.TextView[@text='Email is invalid']");
    private By messageValidatePassword = By.xpath("//android.widget.TextView[@text='Password must have at least 8 characters']");
    private By toastEmailExits = By.xpath("//android.widget.Toast[contains(@text, 'Email already in use. Please choose a different one.')]");
    private By titlePlanToUseTodoist = By.xpath("//android.widget.TextView[@text='How do you plan to use Todoist?']");



    public void signupFailWithEmailNull() {

        WebUI.clickElement(moreOption);
        WebUI.clickElement(signUpEmailOption);
        WebUI.sleep(1);
        WebUI.NotClickable(signUpBtnElement);
        WebUI.clickElement(passwordInputElement);
        WebUI.setText(passwordInputElement, "abc219203");
        WebUI.sleep(2);
        WebUI.NotClickable(signUpBtnElement);
        WebUI.sleep(1);
        WebUI.keydownEnter(passwordInputElement);
        WebUI.sleep(2);
        WebUI.verifyAssertTrueIsDisplayed(messageRequiredEmail, "Error Message không xuất hiện.");
        WebUI.verifyEquals(WebUI.getElementText(messageRequiredEmail), "Email is required", "Nội dung của message không đúng.");
        WebUI.sleep(2);
    }

    public void signupFailWithEmailPasswordNull() {
        WebUI.clickElement(moreOption);
        WebUI.clickElement(signUpEmailOption);
        WebUI.clickElement(emailInputElement);
        WebUI.clickElement(passwordInputElement);
        WebUI.sleep(1);
        WebUI.NotClickable(signUpBtnElement);
        WebUI.keydownEnter(passwordInputElement);
        WebUI.sleep(2);
        WebUI.verifyAssertTrueIsDisplayed(messageRequiredEmail, "Error Message không xuất hiện.");
        WebUI.verifyEquals(WebUI.getElementText(messageRequiredEmail), "Email is required", "Nội dung của message không đúng.");
        WebUI.sleep(2);
        WebUI.verifyAssertTrueIsDisplayed(messageRequiredPassword, "Error Message không xuất hiện.");
        WebUI.verifyEquals(WebUI.getElementText(messageRequiredPassword), "Password is required", "Nội dung của message không đúng.");
        WebUI.sleep(2);

    }

    public void signupFailWithEmailIncorrectFormat(String email, String password) {
        WebUI.clickElement(moreOption);
        WebUI.clickElement(signUpEmailOption);
        WebUI.sleep(1);
        WebUI.NotClickable(signUpBtnElement);
        WebUI.clickElement(emailInputElement);
        WebUI.setText(emailInputElement, email);
        WebUI.clickElement(passwordInputElement);
        WebUI.setText(passwordInputElement, password);
        WebUI.sleep(2);
        WebUI.clickElement(signUpBtnElement);
        WebUI.verifyAssertTrueIsDisplayed(messageEmailInvalid, "Error Message không xuất hiện.");
        Assert.assertEquals(WebUI.getElementText(messageEmailInvalid), "Email is invalid", "Nội dung của message không đúng.");
    }

    public void signupFailWithEmailUsed(String email, String password) {
        WebUI.clickElement(moreOption);
        WebUI.clickElement(signUpEmailOption);
        WebUI.sleep(1);
        WebUI.NotClickable(signUpBtnElement);
        WebUI.clickElement(emailInputElement);
        WebUI.setText(emailInputElement, email);
        WebUI.sleep(2);
        WebUI.NotClickable(signUpBtnElement);
        WebUI.clickElement(passwordInputElement);
        WebUI.setText(passwordInputElement, password);
        WebUI.sleep(2);
        WebUI.BtnClickable(signUpBtnElement);
        WebUI.clickElement(signUpBtnElement);
        WebUI.waitElementPresence(toastEmailExits, "Error Message không xuất hiện.");
        //Assert.assertEquals(WebUI.getElementText(toastEmailExits), "Email already in use. Please choose a different one.", "Nội dung của message không đúng.");
    }

    public void signupFailWithNullPassword(String email) {
        WebUI.clickElement(moreOption);
        WebUI.clickElement(signUpEmailOption);
        WebUI.sleep(1);
        WebUI.NotClickable(signUpBtnElement);
        WebUI.clickElement(emailInputElement);
        WebUI.setText(emailInputElement, email);
        WebUI.NotClickable(signUpBtnElement);
        WebUI.clickElement(passwordInputElement);
        WebUI.keydownEnter(passwordInputElement);
        WebUI.verifyAssertTrueIsDisplayed(messageRequiredPassword, "Password is NULL but Error Message is NOT displayed.");
        Assert.assertEquals(WebUI.getElementText(messageRequiredPassword), "Password is required", "Nội dung của message không đúng.");
    }

    public void signupFailWithShortPasswordLength(String email, String password) {
        WebUI.clickElement(moreOption);
        WebUI.clickElement(signUpEmailOption);
        WebUI.sleep(1);
        WebUI.NotClickable(signUpBtnElement);
        WebUI.clickElement(emailInputElement);
        WebUI.setText(emailInputElement, email);
        WebUI.sleep(2);
        WebUI.NotClickable(signUpBtnElement);
        WebUI.clickElement(passwordInputElement);
        WebUI.setText(passwordInputElement, password);
        WebUI.sleep(2);
        WebUI.BtnClickable(signUpBtnElement);
        WebUI.clickElement(signUpBtnElement);
        WebUI.sleep(2);
        Assert.assertEquals(WebUI.getElementText(messageValidatePassword), "Password must have at least 8 characters", "Nội dung của message không đúng.");
    }

    public void signupFailWithPasswordOnlyContainsNumber(String email, String password) {
        WebUI.clickElement(moreOption);
        WebUI.clickElement(signUpEmailOption);
        WebUI.sleep(1);
        WebUI.NotClickable(signUpBtnElement);
        WebUI.clickElement(emailInputElement);
        WebUI.setText(emailInputElement, email);
        WebUI.sleep(2);
        WebUI.NotClickable(signUpBtnElement);
        WebUI.clickElement(passwordInputElement);
        WebUI.setText(passwordInputElement, password);
        WebUI.sleep(2);
        WebUI.BtnClickable(signUpBtnElement);
        WebUI.clickElement(signUpBtnElement);
        WebUI.sleep(3);
        WebUI.verifyAssertTrueIsNotDisplayed(titlePlanToUseTodoist, "Fail.Không được tạo tài khoản thành công với mật khẩu chỉ chứa số và chuyển tới trang kế tiếp.");

        WebUI.sleep(2);

   }

    public void signupFailWithPasswordOnlyContainsCharacter(String email, String password) {
        WebUI.clickElement(moreOption);
        WebUI.clickElement(signUpEmailOption);
        WebUI.sleep(1);
        WebUI.NotClickable(signUpBtnElement);
        WebUI.clickElement(emailInputElement);
        WebUI.setText(emailInputElement, email);
        WebUI.sleep(2);
        WebUI.NotClickable(signUpBtnElement);
        WebUI.clickElement(passwordInputElement);
        WebUI.setText(passwordInputElement, password);
        WebUI.sleep(2);
        WebUI.BtnClickable(signUpBtnElement);
        WebUI.clickElement(signUpBtnElement);
        WebUI.sleep(3);
        WebUI.verifyAssertTrueIsNotDisplayed(titlePlanToUseTodoist, "Fail.Không được tạo tài khoản thành công với mật khẩu chỉ chứa ký tự và chuyển tới trang kế tiếp.");

        WebUI.sleep(2);
    }

        public void signupSuccessWithValidEmailPassword(String email, String password){
            WebUI.clickElement(moreOption);
            WebUI.clickElement(signUpEmailOption);
            WebUI.NotClickable(signUpBtnElement);
            WebUI.clickElement(emailInputElement);
            WebUI.setText(emailInputElement, email);
            WebUI.NotClickable(signUpBtnElement);
            WebUI.clickElement(passwordInputElement);
            WebUI.setText(passwordInputElement, password);
            WebUI.BtnClickable(signUpBtnElement);
            WebUI.clickElement(signUpBtnElement);
            WebUI.verifyAssertTrueIsDisplayed(titlePlanToUseTodoist, "Fail.Không tạo được tài khoản thành công và chuyển tới trang kế tiếp.");


        }
    }



