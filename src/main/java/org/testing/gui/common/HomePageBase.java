package org.testing.gui.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.testing.gui.components.desktop.CardsLayout;
import org.testing.gui.components.desktop.MainShopNavBar;
import org.testing.gui.components.desktop.FooterNav;

public abstract class HomePageBase extends AbstractPage {

    public HomePageBase(WebDriver webDriver) {
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
