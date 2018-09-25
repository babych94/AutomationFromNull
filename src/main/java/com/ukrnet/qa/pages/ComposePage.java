package com.ukrnet.qa.pages;

import com.ukrnet.qa.base.TestBase;
import org.openqa.selenium.support.PageFactory;

public class ComposePage extends TestBase {

    public ComposePage(){
        PageFactory.initElements(driver, this);
    }



}
