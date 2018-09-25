package com.ukrnet.qa.pages;

import com.ukrnet.qa.base.TestBase;
import com.ukrnet.qa.com.ukrnet.qa.util.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by babych on 05.09.2018.
 */
public class LoginPage extends TestBase {

    //Page Factory - OR;
    @FindBy(id = "id-l")
    WebElement usernameField;

    @FindBy(id = "id-p")
    WebElement passwordField;

    @FindBy(xpath = "//button[contains(@type, 'submit')]")
    WebElement signInButton;

    @FindBy(xpath = "//p[contains(@class, 'form__error form__error_fail')]")
    WebElement errorMesage;

    @FindBy(xpath = "/html/body/div/div/header/div/div[1]")
    WebElement ukrnetLogo;

    //constuctor of LoginPage
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public String validateLoginPageTitle() {
        return driver.getTitle();
    }

    public boolean validateUkrnetLogo() {
        return ukrnetLogo.isDisplayed();
    }

    public MailPage login(String un, String pwd) {
        usernameField.sendKeys(un);
        passwordField.sendKeys(pwd);
        signInButton.click();
        return new MailPage();
    }

}
