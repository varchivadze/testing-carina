package org.testing.gui.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class CardsLayoutBase extends AbstractUIObject {

    public CardsLayoutBase(WebDriver driver) {
        super(driver);
    }

    public CardsLayoutBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract List<ExtendedWebElement> getCards();
}
