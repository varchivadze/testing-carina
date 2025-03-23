package org.testing.gui.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testing.gui.common.MainShopNavBarBase;

public class MainShopNavBar extends MainShopNavBarBase {

//    @FindBy()

    public MainShopNavBar(WebDriver driver) {
        super(driver);
    }

    public MainShopNavBar(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
}
