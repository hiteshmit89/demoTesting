package Pages;

import Framework.Browser;
import Framework.Constants.Constants;
import Framework.Util.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.sql.Driver;

public class SettingsPage extends BasePage {


    public SettingsPage(Constants.PageTitle title) {
        super(title);
    }

    public WebElement paymentToggleAdyen = DriverManager.getInstance().Driver.findElement(By.xpath("//label[@class='custom-control-label']"));


    public void clickToggleButton() {
        Browser.waitForPageReady();
        Browser.scrollToPageDown();
        if (paymentToggleAdyen.isEnabled()) {
            logger.info("toggle is enabled already");
        } else {
            logger.info("enabling toggle button");
            paymentToggleAdyen.click();
        }
    }


}
