package org.testing.gui.common;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.testing.gui.components.Footer;

public abstract class HomePageBase extends AbstractPage {

    public HomePageBase(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void open() {
        super.open();
    }

    public abstract Footer getFooter();

}
