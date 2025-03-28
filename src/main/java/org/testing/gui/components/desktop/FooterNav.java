package org.testing.gui.components.desktop;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testing.gui.common.FooterNavBase;
import org.testing.gui.sidepages.AmazonMusic;

public class FooterNav extends FooterNavBase {

    @FindBy(xpath = ".//h5[normalize-space(text())='Amazon Music']")
    private ExtendedWebElement amazonMusicLink;

    @FindBy(xpath = ".//h5[normalize-space(text())='Amazon Business']")
    private ExtendedWebElement amazonBusinessLink;

    public FooterNav(WebDriver driver) {
        super(driver);
    }

    public FooterNav(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public AmazonMusic openAmazonMusicPage() {
        amazonMusicLink.scrollTo();
        amazonMusicLink.hover();
        amazonMusicLink.click();
        return new AmazonMusic(driver);
    }

    @Override
    public void openAmazonBusiness() {
        amazonBusinessLink.scrollTo();
        amazonBusinessLink.hover();
        amazonBusinessLink.click();
    }
}
