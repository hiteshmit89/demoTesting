package Pages;

import Framework.Browser;
import Framework.Constants.Constants;
import Framework.Util.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SettingsPage extends BasePage {


    public SettingsPage(Constants.PageTitle title) {
        super(title);
    }

    public void clickToggleButton() {
        Browser.waitForElementToBeVisible(By.xpath("//label[@class='custom-control-label']"));
        WebElement paymentToggleAdyen = DriverManager.getInstance().Driver.findElement(By.xpath("//label[@class='custom-control-label']"));
        Browser.scrollToVisibleElement(paymentToggleAdyen);
        String buttonText = paymentToggleAdyen.getText();
        if (buttonText.contains("Enabled")) {
            logger.info("toggle is enabled already");
        } else {
            logger.info("enabling toggle button");
            Browser.clickOnElement(paymentToggleAdyen);
        }
    }

}
