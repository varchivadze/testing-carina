package org.testing.gui.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class FBLoginBase extends AbstractPage {

    public FBLoginBase(WebDriver driver) {
        super(driver);
        this.setPageAbsoluteURL("https://www.facebook.com/");
    }
}
