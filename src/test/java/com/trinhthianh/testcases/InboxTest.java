package com.trinhthianh.testcases;

import com.trinhthianh.common.BaseTest;
import com.trinhthianh.dataproviders.DataProviderAddTask;
import com.trinhthianh.helpers.ExcelHelper;
import com.trinhthianh.pages.LoginPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class InboxTest extends BaseTest {

    ExcelHelper excelLogin;
    ExcelHelper excelAddTask;

    @Test(priority = 1)
    public void testAddTask() {
        String TASK_NAME ="Task_Meeting";
        String TASK_DESCRIPTION ="Đây là description tạo để test";
        String PROJECT_NAME ="Inbox";
        String TIME ="15 Jul 15:00";

        excelLogin = new ExcelHelper();
        excelLogin.setExcelFile("DataTest/Login.xlsx", "Login");
        LoginPage loginPage = new LoginPage();
        loginPage.loginSuccessWithCustomerAccount(excelLogin.getCellData("email", 4), excelLogin.getCellData("password", 4));
        getInboxPage().addNewTask(TASK_NAME,TASK_DESCRIPTION, PROJECT_NAME,TIME);
        getInboxPage().searchTask(TASK_NAME);
        getInboxPage().verifyTaskDetail(TASK_NAME,TASK_DESCRIPTION, PROJECT_NAME,TIME);
    }



    @Test(priority = 2)
    public void testEditTask() {
        String TASK_NAME ="Task_1";
        String TASK_DESCRIPTION ="Đây là description ";
        String PROJECT_NAME ="Inbox";
        String TIME ="10 Jul 10:00";
        String UPDATE_PROJECT_NAME ="ACBVM_999";
        String UPDATE_TASK_NAME ="TASK_SMART_HOME_UPDATE_NAME";
        String UPDATE_TASK_DESCRIPTION ="TASK_SMART_HOME_DESCRIPTION_UPDATE" ;
        String UPDATE_TIME ="15 Jul 15:00";
        ExcelHelper excel = new ExcelHelper();
        excel.setExcelFile("DataTest/Login.xlsx", "Login");
        LoginPage loginPage = new LoginPage();
        loginPage.loginSuccessWithCustomerAccount(excel.getCellData("email", 4), excel.getCellData("password", 4));
        getInboxPage().addNewTask(TASK_NAME,TASK_DESCRIPTION,PROJECT_NAME,TIME);
        getInboxPage().searchTask(TASK_NAME);
        getInboxPage().verifyTaskDetail(TASK_NAME,TASK_DESCRIPTION,PROJECT_NAME,TIME);
        getInboxPage().editTask(UPDATE_TASK_NAME,UPDATE_TASK_DESCRIPTION,UPDATE_PROJECT_NAME,UPDATE_TIME);
        getInboxPage().searchTask(UPDATE_TASK_NAME);
        getInboxPage().verifyTaskDetail(UPDATE_TASK_NAME,UPDATE_TASK_DESCRIPTION,UPDATE_PROJECT_NAME,UPDATE_TIME);

    }


    @Test(priority = 3)
    public void testDeleteTask() {
        String TASK_NAME ="Task_2";
        String TASK_DESCRIPTION ="Đây là description ";
        String PROJECT_NAME ="Inbox";
        String TIME ="20 Jul 20:00";
        excelLogin = new ExcelHelper();
        excelAddTask = new ExcelHelper();
        excelLogin.setExcelFile("DataTest/Login.xlsx", "Login");
        excelAddTask.setExcelFile("DataTest/AddTask.xlsx", "AddTask");
        LoginPage loginPage = new LoginPage();
        loginPage.loginSuccessWithCustomerAccount(excelLogin.getCellData("email", 4), excelLogin.getCellData("password", 4));
        getInboxPage().addNewTask(TASK_NAME,TASK_DESCRIPTION,PROJECT_NAME,TIME);
        getInboxPage().searchTask(TASK_NAME);
        getInboxPage().deleteTask();

    }
    @Test(priority = 4)
    public void checkCompleteAndUndoTask() {
        String TASK_NAME ="Task_Testcase";
        String TASK_DESCRIPTION ="Đây là description ";
        String PROJECT_NAME ="Inbox";
        String TIME ="18 Jul 17:00";
        excelLogin = new ExcelHelper();
        excelAddTask = new ExcelHelper();
        excelLogin.setExcelFile("DataTest/Login.xlsx", "Login");
        excelAddTask.setExcelFile("DataTest/AddTask.xlsx", "AddTask");
        LoginPage loginPage = new LoginPage();
        loginPage.loginSuccessWithCustomerAccount(excelLogin.getCellData("email", 4), excelLogin.getCellData("password", 4));
        getInboxPage().addNewTask(TASK_NAME,TASK_DESCRIPTION,PROJECT_NAME,TIME);
        getInboxPage().searchTask(TASK_NAME);
        getInboxPage().checkCompleteTask(TASK_NAME);
         getInboxPage().checkUndoCompleteTask();
    }
}
