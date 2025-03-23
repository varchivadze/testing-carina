package org.testing.gui.sidepages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testing.gui.common.AmazonMusicBase;

public class AmazonMusic extends AmazonMusicBase {

    @FindBy(id = "navbarMusicLogo")
    private ExtendedWebElement musicLogo;

    public AmazonMusic(WebDriver driver) {
        super(driver);
    }
}
