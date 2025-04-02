package org.testing.desktop;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.testing.gui.components.desktop.FBLogin;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class FBLoginTest implements IAbstractTest {

    @Test
    public void LoginFBTest() {
        FBLogin fbLogin = new FBLogin(getDriver());
        fbLogin.open();

        pause(5);

        fbLogin.clickCookieIfPresent();

        Assert.assertTrue(fbLogin.isPageOpened());

        fbLogin.fbPerformLogin();
        ExtendedWebElement failed = fbLogin.findExtendedWebElement(By.xpath("//div[@class='_9ay7']"));
        Assert.assertTrue(failed != null && failed.isPresent());

    }
}
