package com.qa.demo.pages;

import com.microsoft.playwright.Page;

public class BrowserPage {

    private Page page;
    private String tab = "button[id='tabButton']";

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

    public BrowserPage(Page page){
        this.page = page;
    }

    public void clickTab(){
        page.click(tab);
    }

}
