package com.trinhthianh.pages;

import com.trinhthianh.helpers.PropertiesHelper;
import com.trinhthianh.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class InboxPage extends CommonPage{
     private By menuToday = By.xpath("(//android.widget.TextView[@text='Today'])[1]");
    private By titleToday = By.xpath("//android.widget.TextView[@text='Today']");
    private By menuSearch = By.xpath("//android.widget.TextView[@text='Search']");
    private By inputSearch = By.xpath("//android.widget.EditText[@text='Find tasks, projects, and more']");
    private By searchResult = By.xpath("//android.widget.TextView[@resource-id='android:id/title']/following-sibling::*");
    private By messageSearchNoResult = By.xpath("//android.widget.TextView[@resource-id='com.todoist:id/empty_title']");
    private By buttonAddTask = By.xpath("//android.widget.ImageButton[@resource-id='com.todoist:id/fab']");
    private By inputTaskName = By.xpath("//android.widget.EditText[@resource-id='android:id/message']");
    private By inputTaskDescription = By.xpath("//android.widget.EditText[@resource-id='com.todoist:id/description']");
    private By buttonSetDate = By.xpath("//android.widget.TextView[@resource-id='com.todoist:id/schedule']");
    private By buttonPriority = By.xpath("//android.widget.TextView[@resource-id='com.todoist:id/priority']");

    private By dropdownSelectProject = By.xpath("//android.widget.TextView[@resource-id='com.todoist:id/project']");
    private By closeEditTask = By.xpath("//android.view.View[@resource-id='com.todoist:id/item_parent_container']");
    private By buttonSubmitAddTask= By.xpath("//android.widget.ImageView[@resource-id='android:id/button1']");
    private By outsidePanel = By.xpath("//android.view.View[@resource-id='com.todoist:id/touch_outside']");
    private By iconDate = By.xpath("//android.view.View[@content-desc='Date']");
    private By buttonDateTime = By.xpath("//android.widget.EditText[@resource-id='com.todoist:id/scheduler_input']");
    private By submitDateTime = By.xpath("//android.widget.ImageButton[@resource-id='com.todoist:id/scheduler_input_submit']");


    private By panelTaskName = By.xpath("//android.widget.EditText[@resource-id='com.todoist:id/item_content']");
    private By panelTaskDescription = By.xpath("//android.widget.EditText[@resource-id='com.todoist:id/item_description']");
    private By panelButtonSelectProject = By.xpath("//android.view.View[@resource-id='com.todoist:id/item_parent_container']");
    private By panelDateTime = By.xpath("//android.view.View[@content-desc='Date']/following-sibling::*");
    private By buttonSaveEditTaskName = By.xpath("//android.widget.Button[@resource-id='com.todoist:id/item_submit']");
    private By buttonAddSubTask = By.xpath("//android.widget.TextView[@resource-id='android:id/text1' and @text='Add sub-task']");
    private By outsidePanelSubTask = By.xpath("//android.view.ViewGroup[@resource-id='com.todoist:id/quick_add_item']");

    private By buttonComment = By.xpath("//android.widget.TextView[@text='Add a comment']");
    private By inputComment = By.xpath("//android.widget.EditText[@resource-id='com.todoist:id/input']");
    private By buttonSaveComment = By.xpath("//android.widget.ImageButton[@resource-id='com.todoist:id/submit_button']");
    private By swipeButton = By.xpath("//android.widget.FrameLayout[@resource-id='com.todoist:id/drag_handle']");

    private By buttonCloseTask = By.xpath("//button[@aria-label='Close task']");
    private By notiAddSuccessful = By.xpath("//div[@aria-live='polite']");
    private By notiCompleteTask = By.xpath("//div[@aria-live='polite']");
    private By notiVerifyEmail = By.xpath("//div[@role='alert']");
    private By buttonCloseNotiVerifyEmail = By.xpath("//button[@aria-label='Close']");
    private By inputSearchProjectName = By.xpath("//input[@placeholder='Type a project name']");
    private By inputDateTime = By.xpath("//input[@placeholder='Type a due date']");
    private By buttonMoreActionTask = By.xpath("//android.widget.ImageView[@content-desc='Tùy chọn khác']");
    private By buttonFlowActionTask = By.xpath("//android.widget.ImageView[@resource-id='com.todoist:id/item_overflow']");
    private By buttonDeleteTask = By.xpath("//android.widget.TextView[@resource-id='com.todoist:id/delete']");
    private By buttonConfirmDeleteTask = By.xpath("//android.widget.Button[@resource-id='android:id/button1']");
    private By buttonCheckCompleteTask = By.xpath("//android.widget.CheckBox[@resource-id='com.todoist:id/item_checkmark']");
    private By buttonCheckAfterCompleteTask = By.xpath("//android.widget.CheckBox[@resource-id='com.todoist:id/checkmark']");
    private By searchCompleteTask = By.xpath("//android.widget.Button[@resource-id='com.todoist:id/empty_action']");





    public void addNewTask(String TASK_NAME, String TASK_DESCRIPTION,String PROJECT_NAME, String TIME) {
//        if(WebUI.countProject(notiVerifyEmail) >0) {
//            WebUI.clickElement(buttonCloseNotiVerifyEmail);
//        }
        WebUI.clickElement(menuToday);
        WebUI.sleep(1);
        WebUI.clickElement(buttonAddTask);
        WebUI.sleep(1);
        WebUI.NotClickable(buttonSubmitAddTask);
        WebUI.setText(inputTaskName,TASK_NAME);
        WebUI.sleep(1);
        WebUI.setText(inputTaskDescription,TASK_DESCRIPTION);
        WebUI.sleep(1);
        WebUI.clickElement(buttonSetDate);
        WebUI.sleep(1);
        WebUI.clickElement(buttonDateTime);
       // WebUI.NotClickable(submitDateTime);
        WebUI.setText(buttonDateTime,TIME);
        WebUI.clickElement(submitDateTime);

        WebUI.clickElement(buttonPriority);
        WebUI.sleep(1);
        WebUI.clickElement(buttonPriority);
        WebUI.sleep(1);
        WebUI.clickElement(dropdownSelectProject);
        WebUI.sleep(1);
        WebUI.clickElement(dropdownSelectProject);
        WebUI.sleep(1);
        WebUI.clickElement(buttonSubmitAddTask);
        WebUI.sleep(1);

        WebUI.clickElement(buttonMoreActionTask);
//        WebUI.verifyAssertTrueIsDisplayed(notiAddSuccessful,"Fail. Don't display notification Add Task successful");
//        WebUI.sleep(2);

    }

    public void searchTask(String TASK_NAME) {
        WebUI.clickElement(menuSearch);
        WebUI.sleep(1);
        WebUI.clickElement(inputSearch);
        WebUI.sleep(1);
        WebUI.setText(inputSearch, TASK_NAME);
        WebUI.sleep(2);
        WebUI.keydownEnter(inputSearch);
        WebUI.hoverElement(searchResult);
       // WebUI.verifyAssertTrueEqual(searchResult,TASK_NAME,"Fail. Task name tìm được khác với kết quả");
        WebUI.sleep(1);
    }

    public void verifyTaskDetail(String TASK_NAME, String TASK_DESCRIPTION,String PROJECT_NAME, String TIME){
        WebUI.clickElement(searchResult);
        WebUI.sleep(2);
        // WebUI.hoverElementWithHightLight(panelTaskName);
        WebUI.verifyAssertTrueEqual(panelTaskName,TASK_NAME,"Fail. Task name khác với lúc tạo");
        WebUI.verifyAssertTrueEqual(panelTaskDescription,TASK_DESCRIPTION,"Fail. Task description khác với lúc tạo");
        WebUI.verifyAssertTrueEqual(panelDateTime,TIME,"Fail. Time khác với lúc tạo");
        WebUI.sleep(2);
    //    WebUI.clickElement(outsidePanel);
    }

    public void editTask(String UPDATE_TASK_NAME,String UPDATE_TASK_DESCRIPTION,String PROJECT_NAME,String UPDATE_TIME) {

        WebUI.clickElement(panelTaskName);
        WebUI.setText(panelTaskName, UPDATE_TASK_NAME);
        WebUI.sleep(1);
        WebUI.clickElement(panelTaskDescription);
        WebUI.setText(panelTaskDescription, UPDATE_TASK_DESCRIPTION);
        WebUI.sleep(1);
        WebUI.clickElement(buttonSaveEditTaskName);

        WebUI.clickElement(iconDate);
        WebUI.sleep(1);
        WebUI.clickElement(buttonDateTime);
        // WebUI.NotClickable(submitDateTime);
        WebUI.setText(buttonDateTime,UPDATE_TIME);
        WebUI.clickElement(submitDateTime);

        WebUI.sleep(2);
        WebUI.clickElement(buttonAddSubTask);
        WebUI.sleep(1);
        WebUI.NotClickable(buttonSubmitAddTask);
        WebUI.NotClickable(buttonSubmitAddTask);
        WebUI.setText(inputTaskName,"Sub task name");
        WebUI.sleep(1);
        WebUI.setText(inputTaskDescription,"Đây là description của sub task");
        WebUI.sleep(1);
        WebUI.clickElement(buttonSetDate);
        WebUI.sleep(1);
        WebUI.clickElement(buttonDateTime);
        // WebUI.NotClickable(submitDateTime);
        WebUI.setText(buttonDateTime,UPDATE_TIME);
        WebUI.clickElement(submitDateTime);
        WebUI.clickElement(buttonSubmitAddTask);
        WebUI.clickElement(outsidePanelSubTask);

//        WebUI.sleep(1);
//        WebUI.clickElement(buttonComment);
//        WebUI.sleep(1);
//        WebUI.NotClickable(buttonSaveComment);
//        WebUI.clickElement(inputComment);
//        WebUI.setText(inputComment,"Đây là comment");
//        WebUI.clickElement(buttonSaveComment);
//        WebUI.sleep(1);
//        WebUI.swipeDown(swipeButton);
        WebUI.sleep(2);
        WebUI.clickElement(closeEditTask);


    }


    public void checkCompleteTask(String TASK_NAME) {
        WebUI.clickElement(searchResult);
        WebUI.clickElement(buttonCheckCompleteTask);
        WebUI.sleep(2);
        WebUI.clickElement(searchCompleteTask);
        WebUI.sleep(3);
        WebUI.verifyAssertTrueAttribute(buttonCheckAfterCompleteTask,"checked","true","Fail. Button false, vẫn chưa check hoàn thành.");
        WebUI.sleep(2);

    }
    public void checkUndoCompleteTask() {
        WebUI.sleep(2);
        WebUI.clickElement(buttonCheckAfterCompleteTask);
        WebUI.sleep(2);
        WebUI.verifyAssertTrueAttribute(buttonCheckAfterCompleteTask,"checked","false","Fail. Button false, vẫn chưa check hoàn thành.");
        WebUI.sleep(2);

    }

    public void deleteTask() {
        WebUI.hoverElementWithHightLight(searchResult);
        WebUI.clickElement(searchResult);
        WebUI.sleep(1);
        WebUI.clickElement(buttonFlowActionTask);
        WebUI.sleep(1);
        WebUI.clickElement(buttonDeleteTask);
        WebUI.sleep(1);
        WebUI.clickElement(buttonConfirmDeleteTask);
        WebUI.sleep(3);
        WebUI.verifyAssertTrueIsDisplayed(messageSearchNoResult,"Fail. Chưa hiển thị message No search result.");


    }

}
