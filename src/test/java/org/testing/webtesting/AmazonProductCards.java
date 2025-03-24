package org.testing.webtesting;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.testing.gui.components.CardsLayout;
import org.testing.gui.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class AmazonProductCards implements IAbstractTest {

    @Test
    public void cardWithPicture() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        pause(8);

        SoftAssert softAssert = new SoftAssert();
        CardsLayout cardsLayout = homePage.getCardsLayout();
        List<ExtendedWebElement> cards = cardsLayout.getCards();
        Assert.assertFalse(cards.isEmpty(), "The list of Cards is empty!!!");
        cards.stream()
                .peek(e -> System.out.println(e.getTagName() + e.getTitle() + e.getAttribute("id")))
                .forEach(e -> {

                    softAssert.assertTrue(e.isPresent(), "The card is not present!");
                    softAssert.assertTrue(e.isClickable(), "The card is not clickable!");

                    ExtendedWebElement header = e.findExtendedWebElement(By.xpath(".//div[@class='a-cardui-header']//h2"));
                    System.out.println("The header of Card -> " + header.getText());
                    softAssert.assertFalse(header.getText().isEmpty(), "No text in card header");

                    ExtendedWebElement footer = e.findExtendedWebElement(By.xpath(".//div[@class='a-cardui-footer']//h2"));
                    System.out.println("The header of Card -> " + footer.getText());
                    softAssert.assertFalse(footer.getText().isEmpty(), "No text in card footer");

                    ExtendedWebElement link = e.findExtendedWebElement(By.xpath(".//a[@href][1]"));
                    softAssert.assertFalse(link.getText().isEmpty(), "Link is empty in card");
                });
        softAssert.assertAll();
    }
}
