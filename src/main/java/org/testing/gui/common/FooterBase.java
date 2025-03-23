package org.testing.gui.common;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.testing.gui.components.FooterNav;

public abstract class FooterBase extends AbstractUIObject {

    public FooterBase(WebDriver driver) {
        super(driver);
    }

    public FooterBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract FooterNav getFooterNav();

}
