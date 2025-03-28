package org.testing.gui.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.testing.gui.components.mobile.CardsLayout;
import org.testing.gui.components.mobile.FooterNav;
import org.testing.gui.components.mobile.MainShopNavBar;

public abstract class HomePageMobileBase extends AbstractPage {

    public HomePageMobileBase(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void open() {
        super.open();
    }

    public abstract FooterNav getFooter();

    public abstract MainShopNavBar getMainShopNavbar();

    public abstract CardsLayout getCardsLayout();
}
