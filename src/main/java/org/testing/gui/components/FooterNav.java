package org.testing.gui.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testing.gui.sidepages.AmazonMusic;

public class FooterNav extends Footer{

    @FindBy(linkText = "Amazon Music")
    private ExtendedWebElement amazonMusic;

    @FindBy(linkText = "Amazon Business")
    private ExtendedWebElement amazonBusiness;

    public FooterNav(WebDriver driver) {
        super(driver);
    }

    public FooterNav(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public AmazonMusic openAmazoneMusicPage() {
        amazonMusic.scrollTo();
        amazonMusic.hover();
        amazonMusic.click();
        return new AmazonMusic(driver);
    }
}
