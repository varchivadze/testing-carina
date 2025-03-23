package org.testing.gui.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testing.gui.common.FooterBase;

public class Footer extends FooterBase {

    @FindBy(className = "navFooterVerticalColumn navAccessibility")
    private ExtendedWebElement infoFooter;

    @FindBy(className = "navFooterLine navFooterLinkLine navFooterDescLine")
    private FooterNav navFooter;

    public Footer(WebDriver driver) {
        super(driver);
    }

    public Footer(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public FooterNav getFooterNav(){
        return navFooter;
    }

}
