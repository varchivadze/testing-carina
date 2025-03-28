package org.testing.android;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.testing.gui.components.mobile.CardsLayout;

import org.testing.gui.components.mobile.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class AmazonProductCardsTest implements IAbstractTest {

    @Test
    public void cardWithPictureTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        pause(5);




        SoftAssert softAssert = new SoftAssert();
        CardsLayout cardsLayout = homePage.getCardsLayout();
        List<ExtendedWebElement> cardsNew = cardsLayout.getCards();
        Assert.assertFalse(cardsNew.isEmpty(), "The list of Cards is empty!!!");
        cardsNew.stream()
                .peek(e -> System.out.println(e.getTagName() + e.getTitle() + e.getAttribute("id")))
                .forEach(e -> {

                    softAssert.assertTrue(e.isPresent(), "The card is not present!");
                    softAssert.assertTrue(e.isClickable(), "The card is not clickable!");

                    ExtendedWebElement header = e.findExtendedWebElement(By.xpath(".//div[contains(@class, a-cardui-header)]"));
                    ExtendedWebElement headerText = header.findExtendedWebElement(By.xpath(".//span[contains(@class, 'a-truncate-full') and contains(@class, 'a-offscreen')]"));
                    System.out.println("The header of Card -> " + headerText.getText());
                    softAssert.assertFalse(header.getText().isEmpty(), "No text in card header");

                    ExtendedWebElement footer = e.findExtendedWebElement(By.xpath(".//span[contains(@class, a-cardui-footer)]"));
                    ExtendedWebElement footerText = footer.findExtendedWebElement(By.xpath(".//span[contains(@class, a-truncate-full) and contains(@class, a-offscreen)]"));
                    System.out.println("The footer of Card -> " + footerText.getText());
                    softAssert.assertFalse(footer.getText().isEmpty(), "No text in card footer");
                });
        softAssert.assertAll();
    }
}
