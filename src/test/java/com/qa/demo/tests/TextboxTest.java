package com.qa.demo.tests;

import com.qa.demo.base.BaseTest;
import com.qa.demo.constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TextboxTest extends BaseTest {

    @DataProvider
    public Object[][] getName(){
        return new Object[][]
                {
                        {"Sai"},
                        {"Krishnan"}
        };
    }

    @DataProvider
    public Object[][] getEmail(){
        return new Object[][]
                {
                        {"k@gmail.com"},
                        {"krishnansai99@gmail.com"}
                };
    }

    @DataProvider
    public Object[][] getCurrentAddress(){
        return new Object[][]
                {
                        {"ABC"},
                        {"XYZ"}
                };
    }

    @DataProvider
    public Object[][] getPermanentAddress(){
        return new Object[][]
                {
                        {"ABC"},
                        {"XYZ"}
                };
    }

    @Test(priority = 0 , dataProvider = "getName")
    public void enterFullname(String name){
        textboxPage.enterFullName(name);
    }

    @Test(priority = 1 , dataProvider = "getEmail")
    public void enterEmail(String email){
        textboxPage.enterEmail(email);
    }

    @Test(priority = 2 , dataProvider = "getCurrentAddress")
    public void enterCurrentAddress(String permanentAddress){
        textboxPage.enterCurrentAddress(permanentAddress);
    }

    @Test(priority = 3 , dataProvider = "getPermanentAddress")
    public void enterPermanentAddress(String currentAddress){
        textboxPage.enterPermanentAddress(currentAddress);
    }

    @Test(priority = 4)
    public void clickSubmit(){
        textboxPage.clickSubmit();
    }

    @Test(priority = 5)
    public void verifyEmail(){
        String actualEmail = textboxPage.getEmail();
        Assert.assertEquals(actualEmail,"Email:krishnansai99@gmail.com");
    }

    @Test(priority = 6)
    public void verifyCurrentAddress(){
        String actualCurrentAddress = textboxPage.getCurrentAddress();
        Assert.assertEquals(actualCurrentAddress,"Current Address :XYZ ");
    }

    @Test(priority = 7)
    public void verifyPermanentAddress(){
        String actualPermanentAddress = textboxPage.getPermanentAddress();
        Assert.assertEquals(actualPermanentAddress,"Permananet Address :XYZ");
    }

    @Test(priority = 8)
    public void verifyPageTitle(){
        String title  = textboxPage.getPageTitle();
        Assert.assertEquals(title, AppConstants.PAGE_TITLE);
    }

    @Test(priority = 9)
    public void verifyPageUrl(){
        String url = textboxPage.getPageURL();
        Assert.assertEquals(url,properties.getProperty("url"));
    }

}
