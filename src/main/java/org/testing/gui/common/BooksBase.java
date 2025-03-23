package org.testing.gui.common;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class BooksBase extends AbstractUIObject {

    public BooksBase(WebDriver driver) {
        super(driver);
    }

    public BooksBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
}
