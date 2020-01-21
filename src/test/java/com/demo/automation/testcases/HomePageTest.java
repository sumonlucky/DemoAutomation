package com.demo.automation.testcases;

import com.demo.automation.base.BasePage;
import com.demo.automation.pages.HomePage;
import com.demo.automation.util.Constants;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class HomePageTest {

    WebDriver driver;
    BasePage basePage;
    Properties prop;
    HomePage homePage;


    @Before
    public void setUp(){
        basePage = new BasePage();
        prop = basePage.initProperties();
        driver = basePage.initDriver(prop);
        homePage = new HomePage(driver);
    }

    @Test
    public void homePageTitleTest(){
        String title = homePage.getHomePageTitle();
        System.out.println("Home page title is: "+title);
        Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
    }

    @Test
    public void verifyLoginLinkTest(){
        Assert.assertTrue(homePage.isLoginLinkExists());
    }

    @Test
    public void doLoginTest(){
        homePage.popUpHandle();
        homePage.doLogin(prop.getProperty("userName"),prop.getProperty("passWord"));
    }






    @After
    public void quitBrowser(){
        driver.quit();
    }



}
