package org.testing.gui.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CardsLayout extends CardsLayoutBase{

//    @FindBy(id = ".//div[starts-with(@id, 'desktop-grid-')]")
//    private List<ExtendedWebElement> cards;

    @FindBy(id = "gw-card-layout')]")
    private ExtendedWebElement cards;

    public CardsLayout(WebDriver driver) {
        super(driver);
    }

    public CardsLayout(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

//    @Override
//    public List<ExtendedWebElement> getCards() {
//        return cards;
//    }

    @Override
    public List<ExtendedWebElement> getCards() {
        List<ExtendedWebElement> cards = new ArrayList<>();
        for (int i = 0; true; i++) {
            ExtendedWebElement newCard = this.cards.findExtendedWebElement(By.id(String.format("desktop-grid-%s", i)));
            if (newCard != null && newCard.isElementPresent()) {
                cards.add(newCard);
            } else {
                break;
            }
        }

        return cards;
    }



}
