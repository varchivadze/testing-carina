package org.testing.gui.components.mobile;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testing.gui.common.FooterNavBase;
import org.testing.gui.common.FooterNavMobileBase;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = FooterNavBase.class)
public class FooterNav extends FooterNavMobileBase {

    @FindBy(xpath = "//*[normalize-space(text())='Your Orders']")
    private ExtendedWebElement amazonOrders;

    @FindBy(xpath = "//*[normalize-space(text())='Your Lists']")
    private ExtendedWebElement amazonYourList;

    public FooterNav(WebDriver driver) {
        super(driver);
    }

    public FooterNav(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public void openAmazonCom() {
        while (!amazonOrders.isDisplayed() || !amazonOrders.isClickable(2)) {
            amazonOrders.scrollTo();
        }
        amazonOrders.click();
    }

    @Override
    public void openYourList() {
        while (!amazonYourList.isDisplayed() || !amazonYourList.isClickable(2)) {
            amazonYourList.scrollTo();
        }
        amazonYourList.click();
    }

    public ExtendedWebElement getAmazonYourList(){
        return amazonYourList;
    }


}
