package com.qa.demo.base;

import com.microsoft.playwright.Page;
import com.qa.demo.factory.PlaywrightFactory;
import com.qa.demo.pages.BrowserPage;
import com.qa.demo.pages.TextboxPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.Properties;

public class BaseTest {

    PlaywrightFactory playwrightFactory;
    Page page;
    protected Properties properties;
    protected TextboxPage textboxPage;
    protected BrowserPage browserPage;

    @Parameters({ "browser" })
    @BeforeTest
    public void setUp(String browserName){
        playwrightFactory = new PlaywrightFactory();
        properties = playwrightFactory.initProperties();
        if (browserName != null) {
            properties.setProperty("browser", browserName);
        }
        page = playwrightFactory.initBrowser(properties);
        textboxPage = new TextboxPage(page);
    }

    @AfterTest
    public void tearDown(){
        page.context().browser().close();
    }


}
