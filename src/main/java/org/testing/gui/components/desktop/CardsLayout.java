package org.testing.gui.components.desktop;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testing.gui.common.CardsLayoutBase;

import java.util.List;

public class CardsLayout extends CardsLayoutBase {

    @FindBy(xpath = ".//div[starts-with(@id, 'desktop-grid-')]")
    private List<ExtendedWebElement> cards;


    public CardsLayout(WebDriver driver) {
        super(driver);
    }

    public CardsLayout(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public List<ExtendedWebElement> getCards() {
        return cards;
    }
}
