package org.testing.webtesting;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.testing.gui.components.MainShopNavBar;
import org.testing.gui.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;


public class AmazonMainNavigationBarTest implements IAbstractTest {

    @Test
    public void testMainNavigation() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        pause(8);

        SoftAssert softAssert = new SoftAssert();
        MainShopNavBar mainShopNavBar = homePage.getMainShopNavbar();
        List<ExtendedWebElement> listOfLinks = mainShopNavBar.getLinks();
        Assert.assertFalse(listOfLinks.isEmpty(), "The list of links is empty!!!");
        System.out.println("Test-------");
        listOfLinks.
                stream().peek(e -> System.out.println("Element name ->" + e.getText() + " - " + e.getAttribute("href"))).
                forEach(e -> {
                    softAssert.assertFalse(e.getText().isEmpty(), "Link text is empty");
                    softAssert.assertFalse(e.getAttribute("href").isEmpty(), "No link presents under the text");         });
        softAssert.assertAll();
    }
}
