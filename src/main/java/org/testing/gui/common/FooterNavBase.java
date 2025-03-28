package org.testing.gui.common;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class FooterNavBase extends AbstractUIObject {

    public FooterNavBase(WebDriver driver) {
        super(driver);
    }

    public FooterNavBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract AmazonMusicBase openAmazonMusicPage();

    public abstract void openAmazonBusiness();
}
