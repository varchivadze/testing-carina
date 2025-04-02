package org.testing.gui.components.desktop;

import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testing.gui.common.FBLoginBase;

public class FBLogin extends FBLoginBase {

    @FindBy(id = "email")
    private ExtendedWebElement inputEmail;

    @FindBy(id = "pass")
    private ExtendedWebElement inputPass;

    @FindBy(xpath = "//button[@name='login']")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//*[@aria-label='Decline optional cookies' and @tabindex='0']")
    private ExtendedWebElement cook;

    public FBLogin(WebDriver driver) {
        super(driver);
    }

    public void fbPerformLogin() {

        inputEmail.type(Configuration.getRequired("fb_log"));
        inputPass.type(Configuration.getRequired("fb_pass"));
        loginButton.hover();
        loginButton.click();
    }

    public void clickCookieIfPresent() {
        cook.clickIfPresent(5L);
    }

}
