package org.testing.gui.components.desktop;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testing.gui.common.MainShopNavBarBase;

import java.util.List;

public class MainShopNavBar extends MainShopNavBarBase {

    @FindBy(className = "nav-li")
    List<ExtendedWebElement> mainNavigator;

    public MainShopNavBar(WebDriver driver) {
        super(driver);
    }

    public MainShopNavBar(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public List<ExtendedWebElement> getLinks() {
        return mainNavigator.stream().
                map(element -> element.findExtendedWebElement(By.tagName("a"))).
                toList();
    }


}
