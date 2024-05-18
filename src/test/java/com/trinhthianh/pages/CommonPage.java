package com.trinhthianh.pages;

public class CommonPage {
    public LoginPage loginPage;
    public SignUpPage signUpPage;
    public MyProjectsPage myProjectsPage;
    public InboxPage inboxPage;
   public SearchPage searchPage;

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }
    public SignUpPage getSignUpPage() {
        if (signUpPage == null) {
            signUpPage = new SignUpPage();
        }
        return signUpPage;
    }


    public MyProjectsPage getMyProjectsPage() {
        if (myProjectsPage == null) {
            myProjectsPage = new MyProjectsPage();
        }
        return myProjectsPage;
    }
    public InboxPage getInboxPage() {
        if (inboxPage == null) {
            inboxPage = new InboxPage();
        }
        return inboxPage;
    }

    public SearchPage getSearchPage() {
        if (searchPage == null) {
            searchPage = new SearchPage();
        }
        return searchPage;
    }

}
