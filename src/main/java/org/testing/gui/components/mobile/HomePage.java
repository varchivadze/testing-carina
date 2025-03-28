package org.testing.gui.components.mobile;

import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testing.gui.components.mobile.FooterNav;

import org.testing.gui.common.HomePageMobileBase;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageMobileBase.class)
public class HomePage extends HomePageMobileBase {

    @FindBy(id = "nav-ftr-links")
    private FooterNav footerNav;

    @FindBy(id = "nav-gwbar")
    private MainShopNavBar navbar;

    @FindBy(id = "gwm-Deck-btf")
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
