package org.testing.android;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;

import org.testing.gui.common.HomePageMobileBase;
import org.testing.gui.components.mobile.FooterNav;
import org.testing.gui.components.mobile.HomePage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AmazonFootBarTest implements IAbstractTest {

    @Test
    public void testAmazonFootBarOpening() {
        HomePageMobileBase homePage = new HomePage(getDriver());
        homePage.open();
        homePage.setPageOpeningStrategy(PageOpeningStrategy.BY_URL_AND_ELEMENT);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(homePage.isPageOpened(), "Page is not opened");

        FooterNav footerNav = homePage.getFooter();
        footerNav.openAmazonCom();
        softAssert.assertTrue(getDriver().getCurrentUrl().startsWith("https://www.amazon.com/ap"), "the current URL is " + getDriver().getCurrentUrl());
        pause(5);
        getDriver().navigate().back();
        footerNav.openYourList();

        softAssert.assertTrue(getDriver().getCurrentUrl().startsWith("https://www.amazon.com/ap/"), "the current URL is " + getDriver().getCurrentUrl());
        softAssert.assertAll();
    }
}
