package Pages;

import Framework.Browser;
import Framework.Constants.Constants;
import Framework.Util.DriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.sql.Driver;
import java.util.List;

public class SettingsPage extends BasePage {


    public SettingsPage(Constants.PageTitle title) {
        super(title);
    }
    public void clickToggleButton() {
        Browser.waitForPageReady();
        WebElement paymentToggleAdyen = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@class='custom-control-input']"));
        Browser.scrollToVisibleElement(paymentToggleAdyen);
        if (paymentToggleAdyen.isEnabled()) {
            logger.info("toggle is enabled already");

        } else {
            logger.info("enabling toggle button");
            Browser.clickOnElement(paymentToggleAdyen);
        }
    }

}
