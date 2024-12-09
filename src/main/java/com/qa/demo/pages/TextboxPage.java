package com.qa.demo.pages;

import com.microsoft.playwright.Page;

public class TextboxPage {

    private Page page;
    private String fullName = "input[id='userName']";
    private String email = "input[id='userEmail']";
    private String  currentAddress = "textarea[id='currentAddress']";
    private String permanentAddress = "textarea[id='permanentAddress']";
    private String submit = "button[id='submit']";
    private String verifyEmail = "p[id='email']";
    private String verifyCurrentAddress = "p[id='currentAddress']";
    private String verifyPermanentAddress = "p[id='permanentAddress']";
    private String optionAlertsFrames = "//div[text()='Alerts, Frame & Windows']";
    private String browserOptions = "//span[text()='Browser Windows']";

    public TextboxPage(Page page){
        this.page = page;
    }

    public String getPageTitle(){
        String title = page.title();
        System.out.println("Page title is " + title);
        return title;
    }

    public String getPageURL(){
        String url = page.url();
        System.out.println("Page URL is " + url);
        return url;
    }

    public void enterFullName(String fullName){
        page.fill(this.fullName,fullName);
    }

    public void enterEmail(String email){
        page.fill(this.email,email);
    }

    public void enterCurrentAddress(String currentAddress){
        page.fill(this.currentAddress,currentAddress);
    }

    public void enterPermanentAddress(String permanentAddress){
        page.fill(this.permanentAddress,permanentAddress);
    }

    public void clickSubmit(){
        page.click(submit);
    }

    public String getEmail(){
        return page.locator(verifyEmail).textContent();
    }

    public String getCurrentAddress(){
        return page.locator(verifyCurrentAddress).textContent();
    }

    public String getPermanentAddress(){
        return page.locator(verifyPermanentAddress).textContent();
    }

    public BrowserPage navigateToBroswerPage(){
        page.click(optionAlertsFrames);
        page.click(browserOptions);
        return new BrowserPage(page);
    }

}
