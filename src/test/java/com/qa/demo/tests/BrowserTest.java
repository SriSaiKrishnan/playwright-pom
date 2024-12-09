package com.qa.demo.tests;

import com.qa.demo.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrowserTest extends BaseTest {

    @Test(priority = 0)
    public void browserPageNavigation(){
        browserPage =  textboxPage.navigateToBroswerPage();
        Assert.assertEquals(browserPage.getPageURL(),"https://demoqa.com/browser-windows");
    }

    @Test(priority = 1)
    public void clickNewTab(){
        browserPage.clickTab();
    }

}
