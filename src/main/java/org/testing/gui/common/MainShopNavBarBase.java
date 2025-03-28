package org.testing.gui.common;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class MainShopNavBarBase extends AbstractUIObject {

    public MainShopNavBarBase(WebDriver driver) {
        super(driver);
    }

    public MainShopNavBarBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
}
