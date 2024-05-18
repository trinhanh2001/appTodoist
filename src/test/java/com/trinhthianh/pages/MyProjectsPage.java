package com.trinhthianh.pages;

import com.trinhthianh.drivers.DriverManager;
import com.trinhthianh.helpers.PropertiesHelper;
import com.trinhthianh.keywords.WebUI;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class MyProjectsPage extends CommonPage{
    private String nameProjectVerify;
    private By menuMyProjectsBrowse = By.xpath("//android.widget.TextView[@text='Browse']");
    private By menuSearch = By.xpath("//android.widget.TextView[@text='Search']");
    private By titleTodayPage = By.xpath("//android.widget.TextView[@text='Today']");
    private By buttonPlusAddProject = By.xpath("//android.view.View[@content-desc='Add']");
    private By addNewProject = By.xpath("//android.widget.TextView[@text='Add project']");
    private By inputNameProject = By.xpath("//android.widget.EditText[@resource-id='com.todoist:id/name']");
    private By dropdownColor = By.xpath("//android.widget.TextView[@text='Color']");
    private By optionYellowColor = By.xpath("//android.widget.TextView[@text='Yellow']");
    private By optionTealColor = By.xpath("//android.widget.TextView[@text='Teal']");
    private By toggleAddFavorites = By.xpath("//android.widget.Switch[@resource-id='com.todoist:id/favorite']");
    private By buttonSubmitAddProject = By.xpath("//android.widget.Button[@resource-id='com.todoist:id/menu_form_submit']");
    private By messageNameRequired = By.xpath("//android.widget.TextView[@text='Name is required.']");
    private By titleAfterCreateProject = By.xpath("//android.widget.TextView[@resource-id='com.todoist:id/empty_title']");
    private By inputSearch= By.xpath("//android.widget.EditText[@text='Find tasks, projects, and more']");
    private By searchResult= By.xpath("//android.widget.TextView[@resource-id='android:id/title']/following-sibling::*");

    private By projectMoreAction = By.xpath("//android.widget.ImageView[@content-desc='Tùy chọn khác']");
    private By buttonEditProject = By.xpath("//android.widget.TextView[@text='Edit']");
    private By ProjectName = By.xpath("//android.view.ViewGroup[@resource-id='com.todoist:id/toolbar']//android.widget.TextView");
    private By buttonSubmitEditProject = By.xpath("//android.widget.Button[@resource-id='com.todoist:id/menu_form_submit']");
    private By buttonDeleteProject = By.xpath("//android.widget.TextView[@text='Delete']");
    private By buttonConfirmDeleteProject = By.xpath("//android.widget.Button[@resource-id='android:id/button1']");
    private By usedLimitProject = By.xpath("//android.widget.TextView[@text ='My Projects']/following-sibling::*[1]");
    private By addProjectLock = By.xpath("//android.view.View[@content-desc='Add']");
    private By addProject = By.xpath("//android.widget.TextView[@text='Add project']");
    private By panelLimitProject = By.xpath("//android.widget.ImageView[@content-desc='Promotional image']");
    private By cancelAddLimitProject  = By.xpath("//android.widget.Button[@text='CANCEL']");





    public void addNewProject(String PROJECT_NAME) {
        WebUI.clickElement(menuMyProjectsBrowse);
        WebUI.sleep(1);
        WebUI.clickElement(buttonPlusAddProject);
        WebUI.clickElement(addNewProject);
        WebUI.clickElement(buttonSubmitAddProject);
        WebUI.verifyAssertTrueIsDisplayed(messageNameRequired, "Error Message project name required không xuất hiện.");
        WebUI.verifyEquals(WebUI.getElementText(messageNameRequired), "Name is required.", "Nội dung của message không đúng.");
        WebUI.clickElement(inputNameProject);
        WebUI.setText(inputNameProject, PROJECT_NAME);
        WebUI.sleep(1);
        WebUI.clickElement(dropdownColor);
        WebUI.sleep(1);
        WebUI.clickElement(optionYellowColor);
        WebUI.sleep(1);
        WebUI.clickElement(toggleAddFavorites);
        WebUI.sleep(1);
        WebUI.clickElement(buttonSubmitAddProject);
        WebUI.sleep(2);
        WebUI.verifyAssertTrueIsDisplayed(titleAfterCreateProject, "Error. Message title after create project không xuất hiện.");
        WebUI.verifyEquals(WebUI.getElementText(titleAfterCreateProject), "Start small (or dream big)…", "Nội dung của title không đúng.");
        WebUI.sleep(1);
        WebUI.hoverElementWithHightLight(ProjectName);
        WebUI.sleep(1);
        nameProjectVerify = WebUI.getElementText(ProjectName);
        WebUI.verifyEquals(nameProjectVerify,PROJECT_NAME,"Fail.Tên Project name khác với tên Project vừa tạo");

    }

    public void addNewProjectWithExitName(String PROJECT_NAME_1,String PROJECT_NAME_2) {
        addNewProject(PROJECT_NAME_1);
        WebUI.clickElement(menuMyProjectsBrowse);
        WebUI.sleep(1);
        WebUI.clickElement(buttonPlusAddProject);
        WebUI.clickElement(addNewProject);
        WebUI.setText(inputNameProject, PROJECT_NAME_2);
        WebUI.verifyNotEquals(PROJECT_NAME_1,PROJECT_NAME_2,"Fail. Tên project bị trùng nhau.");
        WebUI.sleep(1);
        WebUI.clickElement(dropdownColor);
        WebUI.sleep(1);
        WebUI.clickElement(optionTealColor);
        WebUI.sleep(1);
        WebUI.clickElement(toggleAddFavorites);
        WebUI.sleep(1);
        WebUI.clickElement(buttonSubmitAddProject);
        WebUI.verifyCurrentURLContains("active","Fail. Vẫn chưa chuyển đến trang Project vừa tạo");
        WebUI.sleep(2);
        WebUI.hoverElementWithHightLight(ProjectName);
        WebUI.sleep(2);
        nameProjectVerify = WebUI.getElementText(ProjectName);
        WebUI.verifyEquals(nameProjectVerify,PROJECT_NAME_2,"Fail.Tên Project name khác với tên Project vừa tạo");

    }

    public void addMoreThanFiveProject(String PROJECT_NAME) {
        WebUI.clickElement(menuMyProjectsBrowse);
        WebUI.sleep(1);
        String usedProjectText = WebUI.getElementText(usedLimitProject);
        if (usedProjectText.equals("USED: 5/5")){
            WebUI.clickElement(addProjectLock);
            WebUI.clickElement(addProject);
            WebUI.verifyElementVisible(panelLimitProject, "Fail. Vượt quá limit 5 projects nhưng không hiện dialog.");
            WebUI.clickElement(cancelAddLimitProject);
            WebUI.sleep(1);


        } else {
            while (!usedProjectText.equals("USED: 5/5")){
                WebUI.clickElement(addProjectLock);
                WebUI.clickElement(addProject);
                WebUI.clickElement(buttonSubmitAddProject);
                WebUI.verifyAssertTrueIsDisplayed(messageNameRequired, "Error Message project name required không xuất hiện.");
                WebUI.verifyEquals(WebUI.getElementText(messageNameRequired), "Name is required.", "Nội dung của message không đúng.");
                WebUI.clickElement(inputNameProject);
                WebUI.setText(inputNameProject, PROJECT_NAME);
                WebUI.sleep(1);
                WebUI.clickElement(dropdownColor);
                WebUI.sleep(1);
                WebUI.clickElement(optionYellowColor);
                WebUI.sleep(1);
                WebUI.clickElement(toggleAddFavorites);
                WebUI.sleep(1);
                WebUI.clickElement(buttonSubmitAddProject);
                WebUI.sleep(2);
                WebUI.verifyAssertTrueIsDisplayed(titleAfterCreateProject, "Error. Message title after create project không xuất hiện.");
                WebUI.verifyEquals(WebUI.getElementText(titleAfterCreateProject), "Start small (or dream big)…", "Nội dung của title không đúng.");
                WebUI.sleep(1);
                WebUI.hoverElementWithHightLight(ProjectName);
                WebUI.sleep(1);
                nameProjectVerify = WebUI.getElementText(ProjectName);
                WebUI.verifyEquals(nameProjectVerify,PROJECT_NAME,"Fail.Tên Project name khác với tên Project vừa tạo");
                WebUI.sleep(2);
                WebUI.clickElement(menuMyProjectsBrowse);
                WebUI.sleep(1);
                usedProjectText = WebUI.getElementText(usedLimitProject);
            }
            WebUI.clickElement(addProjectLock);
            WebUI.clickElement(addProject);
            WebUI.verifyElementVisible(panelLimitProject, "Fail. Vượt quá limit 5 projects nhưng không hiện dialog.");
            WebUI.clickElement(cancelAddLimitProject);
            WebUI.sleep(1);

        }


    }

    public void searchProject(String PROJECT_NAME){
        WebUI.clickElement(menuSearch);
        WebUI.sleep(2);
        WebUI.clickElement(inputSearch);
        WebUI.sleep(1);
        WebUI.setText(inputSearch, PROJECT_NAME);
        WebUI.sleep(2);
        WebUI.keydownEnter(inputSearch);
        WebUI.hoverElement(searchResult);

    }

//    public void verifyProjectDetail(String PROJECT_NAME){
//        WebUI.clickElement(firstProjectButtonMoreAction);
//        WebUI.sleep(1);
//        WebUI.clickElement(buttonEditProject);
//        WebUI.verifyAssertTrueAttribute(inputNameProject,"value",PROJECT_NAME,"Tên Project không đúng");
//        WebUI.sleep(1);
//    }

    public void editProject(String UPDATE_PROJECT_NAME) {
        WebUI.clickElement(searchResult);
        WebUI.clickElement(projectMoreAction);
        WebUI.sleep(1);
        WebUI.clickElement(buttonEditProject);
        WebUI.setText(inputNameProject, UPDATE_PROJECT_NAME);
        WebUI.sleep(1);
        WebUI.clickElement(dropdownColor);
        WebUI.sleep(1);
        WebUI.clickElement(optionTealColor);
        WebUI.sleep(1);
        WebUI.clickElement(toggleAddFavorites);
        WebUI.sleep(1);
        WebUI.clickElement(buttonSubmitEditProject);
        WebUI.sleep(1);
        WebUI.hoverElementWithHightLight(ProjectName);
        WebUI.sleep(2);
        nameProjectVerify = WebUI.getElementText(ProjectName);
        WebUI.verifyEquals(nameProjectVerify,UPDATE_PROJECT_NAME,"Fail.Tên Project name khác với tên Project vừa update");

    }

    public void deleteProject() {
        WebUI.clickElement(searchResult);
        WebUI.clickElement(projectMoreAction);
        WebUI.sleep(1);
        WebUI.clickElement(buttonDeleteProject);
        WebUI.sleep(1);
        WebUI.clickElement(buttonConfirmDeleteProject);
        WebUI.sleep(3);
        WebUI.verifyAssertTrueIsDisplayed(titleTodayPage,"Fail. Chưa trở về trang Today");

    }

}
