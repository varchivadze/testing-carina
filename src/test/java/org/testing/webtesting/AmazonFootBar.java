package org.testing.webtesting;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.testing.gui.common.AmazonMusicBase;

import org.testing.gui.common.HomePageBase;
import org.testing.gui.footer.FooterNavBase;
import org.testing.gui.pages.HomePage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AmazonFootBar implements IAbstractTest {

    @Test
    public void testAmazonFootBarOpening() {
        HomePageBase homePage = new HomePage(getDriver());
        homePage.open();
        pause(8);
        homePage.setPageOpeningStrategy(PageOpeningStrategy.BY_URL_AND_ELEMENT); // what vals it take and where from?

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(homePage.isPageOpened(), "Page is not opened");

        FooterNavBase footerNav = homePage.getFooter();
        AmazonMusicBase amMusic = footerNav.openAmazonMusicPage();
        softAssert.assertTrue(amMusic.isPageOpened(), "No AmMusic page is opened");
        getDriver().navigate().back();
        footerNav.openAmazonBusiness();
        softAssert.assertTrue(getDriver().getCurrentUrl().startsWith("https://www.amazon.com/business/"));
        softAssert.assertAll();
    }
}
