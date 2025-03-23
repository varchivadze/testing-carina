package org.testing.gui.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class AmazonMusicBase extends AbstractPage {

    public AmazonMusicBase(WebDriver driver) {
        super(driver);
        this.setPageAbsoluteURL("https://music.amazon.com/?ref=dm_aff_amz_com");
    }
}
