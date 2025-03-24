package org.testing.gui.pages;

import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testing.gui.common.HomePageBase;
import org.testing.gui.components.CardsLayout;
import org.testing.gui.components.MainShopNavBar;
import org.testing.gui.components.MainShopNavBarBase;
import org.testing.gui.footer.FooterNav;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageBase.class) // where to put DeviceType? Why should we note parentClass if it extended?
public class HomePage extends HomePageBase {

    @FindBy(id = "navFooter")
    private FooterNav footerNav;

    @FindBy(id = "nav-xshop")
    private MainShopNavBar navbar;

//    @FindBy(id = "gw-card-layout")
//    private CardsLayout cardsLayout;

    @FindBy(id = "gw-layout")
    private CardsLayout cardsLayout;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public FooterNav getFooter(){
        return footerNav;
    }

    @Override
    public MainShopNavBar getMainShopNavbar() {
        return navbar;
    }

    @Override
    public CardsLayout getCardsLayout() {
        return cardsLayout;
    }



}
