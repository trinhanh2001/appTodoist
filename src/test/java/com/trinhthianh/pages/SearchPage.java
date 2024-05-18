package com.trinhthianh.pages;

import com.trinhthianh.helpers.PropertiesHelper;
import com.trinhthianh.keywords.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;

public class SearchPage extends CommonPage {
    private By menuSearch = By.xpath("//android.widget.TextView[@text='Search']");

    private By inputSearch= By.xpath("//android.widget.EditText[@text='Find tasks, projects, and more']");
    private By searchResult= By.xpath("//android.widget.TextView[@resource-id='android:id/title']/following-sibling::*");
    private By projectNameResulte = By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']/following-sibling::android.widget.TextView");
    private By taskNameResulte = By.xpath("//android.widget.EditText[@resource-id='com.todoist:id/item_content']");
    private By taskDescriptionResulte = By.xpath("//android.widget.EditText[@resource-id='com.todoist:id/item_description']");
    private By messageSearchNoResult = By.xpath("//android.widget.TextView[@resource-id='com.todoist:id/empty_title']");
    private By markGoToComplete = By.xpath("//span[contains(.,'Go to Completed')]");
    private By firstResultComplete = By.xpath("(//li[@class='event'])[1]");
    private By completedATask = By.xpath("(//div[contains(text(),'completed a task:')])[1]");



    public void searchProjectName(String PROJECT_NAME) {
        WebUI.clickElement(menuSearch);
        WebUI.sleep(1);
        WebUI.clickElement(inputSearch);
        WebUI.sleep(1);
        WebUI.setText(inputSearch,PROJECT_NAME);
        WebUI.sleep(2);
        WebUI.keydownEnter(inputSearch);
        WebUI.hoverElement(searchResult);
        WebUI.sleep(1);
        WebUI.clickElement(searchResult);
        WebUI.verifyAssertTrueEqual(projectNameResulte,PROJECT_NAME,"Fail. Kết quả tìm được khác với tên Project vừa nhập.Hoặc không tìm thấy tên Project để so sánh với tên vừa nhập");

    }

    public void searchTaskName(String TASK_NAME) {
        WebUI.clickElement(menuSearch);
        WebUI.sleep(1);
        WebUI.clickElement(inputSearch);
        WebUI.sleep(1);
        WebUI.setText(inputSearch,TASK_NAME);
        WebUI.sleep(2);
        WebUI.keydownEnter(inputSearch);
        WebUI.hoverElement(searchResult);
        WebUI.sleep(1);
        WebUI.clickElement(searchResult);
        WebUI.verifyAssertTrueEqual(taskNameResulte,TASK_NAME,"Fail. Kết quả tìm được khác với tên Project vừa nhập.Hoặc không tìm thấy tên Project để so sánh với tên vừa nhập");

    }

    public void searchTaskDescription(String TASK_DESCRIPTION) {
        WebUI.clickElement(menuSearch);
        WebUI.sleep(1);
        WebUI.clickElement(inputSearch);
        WebUI.sleep(1);
        WebUI.setText(inputSearch,TASK_DESCRIPTION);
        WebUI.sleep(2);
        WebUI.keydownEnter(inputSearch);
        WebUI.hoverElement(searchResult);
        WebUI.sleep(1);
        WebUI.clickElement(searchResult);
        WebUI.verifyAssertTrueEqual(taskDescriptionResulte,TASK_DESCRIPTION,"Fail. Kết quả tìm được khác với tên Project vừa nhập.Hoặc không tìm thấy tên Project để so sánh với tên vừa nhập");

    }

    public void searchWithNoExitKeyword(String KEYWORD) {

        WebUI.clickElement(menuSearch);
        WebUI.sleep(1);
        WebUI.clickElement(inputSearch);
        WebUI.sleep(1);
        WebUI.setText(inputSearch,KEYWORD);
        WebUI.sleep(2);
        WebUI.keydownEnter(inputSearch);
        WebUI.sleep(3);
        WebUI.verifyAssertTrueIsDisplayed(messageSearchNoResult,"Fail.Không hiện thông báo No matching result.");

    }

//    public void searchCompleted(String KEYWORD) {
//        WebUI.clickElement(menuButtonSearch);
//        WebUI.sleep(1);
//        WebUI.clickElement(inputSearch);
//        WebUI.sleep(1);
//        WebUI.setText(inputSearch,KEYWORD); //Keyword: Go to Completed
//        WebUI.sleep(1);
//        WebUI.clickElement(markGoToComplete);
//        WebUI.sleep(3);
//        WebUI.waitForPageLoaded();
//        WebUI.verifyElementVisible(firstResultComplete,"Fail.Chưa hiển thị kết quả Completed task.");
//        WebUI.verifyElementVisible(completedATask,"Fail. Result Chưa hiển thị text You completed a task:");
//    }

}


