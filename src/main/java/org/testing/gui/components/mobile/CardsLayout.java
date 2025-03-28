package org.testing.gui.components.mobile;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testing.gui.common.CardsLayoutBase;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CardsLayoutBase.class)
public class CardsLayout extends CardsLayoutBase {

    @FindBy(xpath = ".//div[starts-with(@data-card-metrics-id, 'data-card-metrics-id')]")
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
