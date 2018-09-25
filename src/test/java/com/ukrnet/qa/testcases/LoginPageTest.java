package com.ukrnet.qa.testcases;

import com.ukrnet.qa.base.TestBase;
import com.ukrnet.qa.com.ukrnet.qa.util.TestUtil;
import com.ukrnet.qa.pages.LoginPage;
import com.ukrnet.qa.pages.MailPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.ukrnet.qa.com.ukrnet.qa.util.TestUtil.takeScreenshotOnFailure;

/**
 * Created by babych on 05.09.2018.
 */
public class LoginPageTest extends TestBase {

    LoginPage loginPage;
    MailPage mailPage;

    public LoginPageTest() {
        super();
    }


    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
    }

    @Test(priority = 1)
    public void loginPageTitleTest() {
        String title = loginPage.validateLoginPageTitle();
        Assert.assertEquals(title, "Пошта @ ukr.net - українська електронна пошта • Створи емейл");
    }

    @Test(priority = 2)
    public void ukrnetLogoTest() {
        boolean flag = loginPage.validateUkrnetLogo();
        Assert.assertTrue(flag);
    }

    @Test(priority = 3)
    public void loginTest() {
        mailPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        boolean button = mailPage.checkThatMailingPageIsOpened();

        Assert.assertTrue(button);
    }


    @AfterMethod
    public void tearDown(ITestResult testResult) {
        TestUtil.takeScreenshotOnFailure(testResult);
        driver.quit();
    }


}
