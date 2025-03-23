package org.testing.gui.pages;

import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testing.gui.common.HomePageBase;
import org.testing.gui.common.MainShopNavBarBase;
import org.testing.gui.components.Footer;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageBase.class) // where to put DeviceType? Why should we note parentClass if it extended?
public class HomePage extends HomePageBase {

    @FindBy(id = "navFooter")
    private Footer footer;

    @FindBy(id = "nav-xshop-container")
    private MainShopNavBarBase navbar;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public Footer getFooter(){
        return footer;
    }
}
