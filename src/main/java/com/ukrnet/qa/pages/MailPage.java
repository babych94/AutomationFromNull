package com.ukrnet.qa.pages;

import com.ukrnet.qa.base.TestBase;
import com.ukrnet.qa.com.ukrnet.qa.util.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by babych on 05.09.2018.
 */
public class MailPage extends TestBase {

    ComposePage composePage;

    @FindBy(xpath = "//a[@class='compose-message-link']")
    public WebElement composeMessageBtn;

    @FindBy(xpath = "//div[@class='search-placeholder']")
    public WebElement searchField;





    public MailPage() {
        PageFactory.initElements(driver, this);
    }

    public ComposePage openComposeWindow(){
        composeMessageBtn.click();
        return composePage;
    }

    public boolean checkThatMailingPageIsOpened(){
        TestUtil.waitForElement(composeMessageBtn);
        return composeMessageBtn.isDisplayed();
    }

}
