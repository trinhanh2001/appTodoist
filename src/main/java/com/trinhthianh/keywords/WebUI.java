package com.trinhthianh.keywords;

import com.google.common.collect.ImmutableMap;
import com.trinhthianh.drivers.DriverManager;
import com.trinhthianh.helpers.PropertiesHelper;
import com.trinhthianh.reports.AllureManager;
import com.trinhthianh.reports.ExtentTestManager;
import com.trinhthianh.utils.LogUtils;
import com.aventstack.extentreports.Status;
import com.trinhthianh.utils.LogUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
//import io.qameta.allure.Step;
//import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.ElementOption;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class WebUI {
//    private static WebElement<WebDriver> driver = DriverManager.getDriver();
  //  private static TouchAction touchAction = new TouchAction(driver);

    private static Actions action = new Actions(DriverManager.getDriver());
    private final static int TIMEOUT = Integer.parseInt(PropertiesHelper.getValue("TIMEOUT"));
    private final static int STEP_TIME = Integer.parseInt(PropertiesHelper.getValue("STEP_TIME"));
    private final static int PAGE_LOAD_TIMEOUT = Integer.parseInt(PropertiesHelper.getValue("PAGE_LOAD_TIMEOUT"));

    public static void sleep(double second) {
        try {
            Thread.sleep((long) (second * 1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

   @Step("Click element: {0}")
    public static void clickElement(By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(TIMEOUT).getSeconds());
        wait.until(ExpectedConditions.elementToBeClickable(by));
        DriverManager.getDriver().findElement(by).click();
        ExtentTestManager.logMessage(Status.PASS, "Click element: " + by);
        LogUtils.info("Click element: " + by.toString());
    }

    @Step("Set text {1} on {0}")
    public static void setText(By by, String value) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(TIMEOUT).getSeconds());
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        MobileElement element = DriverManager.getDriver().findElement(by);
        element.clear();
        element.sendKeys(value);
        ExtentTestManager.logMessage(Status.PASS, "Set text: " + value + " on element " + by);
       LogUtils.info("Set text: " + value + " on " + by);
    }


//    public static void keydownEnter(By by) {
////        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(TIMEOUT).getSeconds());
////        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
//        MobileElement element = DriverManager.getDriver().findElement(by);
//       // element.clear();
//        element.sendKeys(Keys.ENTER);
//
//        LogUtils.info("Key down Enter");
//        ExtentTestManager.logMessage("Key down Enter");
//    }

    @Step("Set text {1} on {0} and key down enter")
    public static void setTextEnter(By by, String value) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(TIMEOUT).getSeconds());
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        sleep(STEP_TIME);
        highLightElement(by);
        getWebElement(by).sendKeys(value, Keys.ENTER);
        ExtentTestManager.logMessage(Status.PASS, "Set text: " + value + " on element " + by);
        //AllureReportManager.saveTextLog("Set text " + value + " on " + by.toString() + " and key down enter");
        LogUtils.info("Set text " + value + " on " + by.toString() + " and key down enter");
    }


    @Step("Key down Enter")
    public static void keydownEnter(By by) {
        Actions action = new Actions(DriverManager.getDriver());
        action.sendKeys(Keys.ENTER).perform();

        LogUtils.info("Key down Enter");
        ExtentTestManager.logMessage("Key down Enter");
    }

    @Step("Not Clickable : {0}")
    public static void NotClickable(By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(TIMEOUT).getSeconds());
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(by)));

    }

    @Step("Button Clickable : {0}")
    public static void BtnClickable(By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(TIMEOUT).getSeconds());
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        wait.until(ExpectedConditions.elementToBeClickable(by));

    }

    @Step("Verify {0} is disable")
    public static void verifyElementDisable(By by, String message) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(TIMEOUT).getSeconds());
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));

        WebElement element = DriverManager.getDriver().findElement(by);
        String ariaDisabled = element.getAttribute("aria-disabled");
        Assert.assertEquals(ariaDisabled, "true", "Button is not disabled");
        LogUtils.info("Verify " +by +" is disable");
        ExtentTestManager.logMessage(Status.PASS, "Verify " +by +" is disable");
    }

    @Step("Verify {0} is displayed")
    public static void verifyAssertTrueIsDisplayed(By by, String message) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(TIMEOUT).getSeconds());
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        LogUtils.info("Verify " + by + " is displayed");
        Assert.assertTrue(DriverManager.getDriver().findElement(by).isDisplayed(), message);
        //AllureReportManager.saveTextLog("Verify " + by + " is displayed");
        ExtentTestManager.logMessage("Verify " + by + " is displayed");
    }

    @Step("Verify {0} is displayed")
    public static void verifyAssertTrueIsNotDisplayed(By by, String message) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(TIMEOUT).getSeconds());
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        LogUtils.info("Verify " + by + " is displayed");
        Assert.assertFalse(DriverManager.getDriver().findElement(by).isDisplayed(), message);
        //AllureReportManager.saveTextLog("Verify " + by + " is displayed");
        ExtentTestManager.logMessage("Verify " + by + " is displayed");
    }

    @Step("Verify {0} is displayed")
    public static void verifyAssertElementNotDisplayed(By by, String message) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(TIMEOUT).getSeconds());
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
        LogUtils.info("Verify " + by + " is not displayed");
        Assert.assertFalse(DriverManager.getDriver().findElements(by).size() > 0, message);
        //AllureReportManager.saveTextLog("Verify " + by + " is displayed");
        ExtentTestManager.logMessage("Verify " + by + " is not displayed");
    }

    @Step("Verify {1} is display correct on {0}")
    public static void verifyAssertTrueEqual(By by, String verifyText, String message) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(TIMEOUT).getSeconds());
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));

        // Loại bỏ khoảng trắng dư thừa và các ký tự không in được ở cả hai phía
        verifyText = verifyText.trim().replaceAll("[^\\x00-\\x7F]", "");
        String actualText = DriverManager.getDriver().findElement(by).getText().trim().replaceAll("[^\\x00-\\x7F]", "");

        Assert.assertEquals(verifyText, actualText, message);
        LogUtils.info("Verify " + verifyText + " is display correct on " + by.toString());
        //AllureReportManager.saveTextLog("Verify " + verifyText + " is display correct on " + by.toString());
        ExtentTestManager.logMessage(Status.PASS, "Verify " + verifyText + " is display correct on " + by.toString());
    }


    @Step("Verify element visible {0}")
    public static boolean verifyElementVisible(By by, String message) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(TIMEOUT).getSeconds());
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            LogUtils.info("Verify element visible " + by);
            return true;
        } catch (Exception e) {
            if (message.isEmpty() || message == null) {
                LogUtils.error("The element is not visible. " + by);
                Assert.fail("The element is NOT visible. " + by);
            } else {
                LogUtils.error(message + by);
                Assert.fail(message + by);
            }
            return false;
        }
    }

    public static void waitForElementClickable(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(TIMEOUT).getSeconds());
            wait.until(ExpectedConditions.elementToBeClickable(getWebElement(by)));
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for the element ready to click. " + by.toString());
            logConsole("Timeout waiting for the element ready to click. " + by.toString());
        }
    }

    @Step("Wait {0} is presence")
    public static void waitElementPresence(By by, String message) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(TIMEOUT).getSeconds());
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        LogUtils.info("Wait " + by + " is presence");

    }

    @Step("Verify result {1} is correct")
    public static void verifyEquals(Object actual, Object expected) {
       // waitForPageLoaded();
        sleep(STEP_TIME);
        Assert.assertEquals(actual, expected, "Fail, NOT match: " + actual.toString() + " != " + expected.toString());
        ExtentTestManager.logMessage(Status.PASS, "Verify result: " + expected + " is correct");
        AllureManager.saveTextLog("Verify result: " + expected + " is correct");
        LogUtils.info("Verify result: " + expected + " is correct");
    }

    @Step("Verify result {1} is correct")
    public static void verifyEquals(Object actual, Object expected, String message) {
       // waitForPageLoaded();
        sleep(STEP_TIME);
        Assert.assertEquals(actual, expected, message);
        ExtentTestManager.logMessage(Status.PASS, "Verify result: " + expected + " is correct");
        AllureManager.saveTextLog("Verify result: " + expected + " is correct");
        LogUtils.info("Verify result: " + expected + " is correct");
    }

    public static WebElement getWebElement(By by) {
        return DriverManager.getDriver().findElement(by);
    }
    @Step("Wait until the element {0} is visible")
    public static WebElement waitForElementVisible(By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(TIMEOUT).getSeconds());
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        ExtentTestManager.logMessage(Status.PASS, "Wait until the element " + by + " is visible");
        //AllureReportManager.saveTextLog("Wait until the element " + by + " is visible");
        LogUtils.info("Wait until the element " + by + " is visible");
        return getWebElement(by);
    }

    @Step("Verify attribute {1} is contains {2} on {0}")
    public static void verifyAssertTrueAttribute(By by, String attribute, String expectedValue, String message) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(TIMEOUT).getSeconds());
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        LogUtils.info("Verify attribute " + attribute + " is contains " + expectedValue + " on " + by.toString());
        Assert.assertTrue(DriverManager.getDriver().findElement(by).getAttribute(attribute).trim().equals(expectedValue), message);
        //AllureReportManager.saveTextLog("Verify attribute " + attribute + " is contains " + expectedValue + " on " + by.toString());
        ExtentTestManager.logMessage("Verify attribute " + attribute + " is contains " + expectedValue + " on " + by.toString());
    }

    public static String getElementText(By by) {
       // waitForElementVisible(by);
        sleep(STEP_TIME);
        return getWebElement(by).getText(); // trả về 1 giá trị  String
    }

    public static String getAtribute(By by) {
        sleep(STEP_TIME);
        return getWebElement(by).getAttribute("name"); // trả về 1 giá trị  String
    }

    public static void verifyCurrentURLContains(String identifier,String message){
        Assert.assertFalse(DriverManager.getDriver().getCurrentUrl().contains(identifier),message);
    }

    @Step("Verify result {0}{1} is match")
    public static void verifyNotEquals(Object actual, Object expected, String message) {
        sleep(STEP_TIME);
        Assert.assertNotEquals(actual, expected, message);
        ExtentTestManager.logMessage(Status.FAIL, "Verify result: "+actual+" " + expected + " can not match");
        AllureManager.saveTextLog("Verify result: "+actual+" " + expected + " can not match");
        LogUtils.info("Verify result: "+actual+" " + expected + " can not match");
    }
    public static boolean hoverElement(By by) {
        try {
            Actions action = new Actions(DriverManager.getDriver());
            action.moveToElement(getWebElement(by)).perform();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean hoverElementWithHightLight(By by) {
        try {
            Actions action = new Actions(DriverManager.getDriver());
            action.moveToElement(getWebElement(by)).perform();
            highLightElement(by);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Step("swipeDown")
    public static void swipeDown( By by) {
        // Tìm phần tử sử dụng đối tượng By
        WebElement element = DriverManager.getDriver().findElement(by);
        // Lấy tọa độ của phần tử
        int startX = element.getLocation().getX() + element.getSize().getWidth() / 2;
        int startY = element.getLocation().getY() + element.getSize().getHeight() / 2;
        // Tính toán tọa độ kết thúc của swipe
        int endY = DriverManager.getDriver().manage().window().getSize().getHeight() * 3 / 4; // Điểm cuối là 3/4 chiều cao của cửa sổ
        // Thực hiện swipe
        TouchAction<?> touchAction = new TouchAction<>((PerformsTouchActions) DriverManager.getDriver());
        touchAction.press(ElementOption.element(element, startX, startY))
                .moveTo(ElementOption.element(element, startX, endY))
                .release()
                .perform();

        LogUtils.info("swipeDown");
    }

    public static void logConsole(Object message) {
        System.out.println(message);
    }

    public static void waitForPageLoaded() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(PAGE_LOAD_TIMEOUT).getSeconds());
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();

        // wait for Javascript to loaded
        ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor) DriverManager.getDriver()).executeScript("return document.readyState")
                .toString().equals("complete");

        //Get JS is Ready
        boolean jsReady = js.executeScript("return document.readyState").toString().equals("complete");

        //Wait Javascript until it is Ready!
        if (!jsReady) {
            logConsole("Javascript in NOT Ready!");
            //Wait for Javascript to load
            try {
                wait.until(jsLoad);
            } catch (Throwable error) {
                error.printStackTrace();
                Assert.fail("Timeout waiting for page load (Javascript). (" + PAGE_LOAD_TIMEOUT + "s)");
            }
        }
    }



    /**
     * @param by truyền vào đối tượng element dạng By
     * @return Tô màu viền đỏ cho Element trên website
     */
    public static WebElement highLightElement(By by) {
        // Tô màu border ngoài chính element chỉ định - màu đỏ
        if (DriverManager.getDriver() instanceof JavascriptExecutor) {
            ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].style.border='3px solid red'", getWebElement(by));
            sleep(0.5);
        }
        return getWebElement(by);
    }
}
