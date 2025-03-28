package org.testing.gui.common;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class FooterNavMobileBase extends AbstractUIObject {

    public FooterNavMobileBase(WebDriver driver) {
        super(driver);
    }

    public FooterNavMobileBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract void openAmazonCom();

    public abstract void openYourList();
}
