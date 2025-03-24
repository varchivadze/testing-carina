package org.testing.gui.footer;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testing.gui.sidepages.AmazonMusic;

public class FooterNav extends FooterNavBase {

    @FindBy(xpath = "//*[@id=\"navFooter\"]/div[4]/div/ul[1]/li[1]/a")
    private ExtendedWebElement amazonMusicLink;

    @FindBy(xpath = "//*[@id=\"navFooter\"]/div[4]/div/ul[2]/li[1]/a")
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
