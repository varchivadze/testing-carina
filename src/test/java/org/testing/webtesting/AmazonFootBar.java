package org.testing.webtesting;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.testing.gui.common.AmazonMusicBase;
import org.testing.gui.common.FooterBase;
import org.testing.gui.common.HomePageBase;
import org.testing.gui.components.FooterNav;
import org.testing.gui.pages.HomePage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Scanner;

public class AmazonFootBar implements IAbstractTest {

    @Test
    public void testAmazonFootBarOpening() throws InterruptedException {
        HomePageBase homePage = new HomePage(getDriver());
        homePage.open();
        pause(10);
        homePage.setPageOpeningStrategy(PageOpeningStrategy.BY_URL_AND_ELEMENT); // what vals it take and where from?

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(homePage.isPageOpened(), "Page is not opened");

        FooterBase footer = homePage.getFooter();
        FooterNav footerNav = footer.getFooterNav();
        AmazonMusicBase amMusic = footerNav.openAmazoneMusicPage();
        softAssert.assertTrue(amMusic.isPageOpened(), "No AmMusic page is opened");
        softAssert.assertAll();

    }
}
