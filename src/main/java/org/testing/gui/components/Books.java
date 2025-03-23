package org.testing.gui.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testing.gui.common.BooksBase;

public class Books extends BooksBase {

//    @FindBy(id = "")

    public Books(WebDriver driver) {
        super(driver);
    }

    public Books(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
}
