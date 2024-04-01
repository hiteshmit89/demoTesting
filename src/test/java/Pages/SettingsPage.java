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

    public WebElement paymentToggleAdyen = DriverManager.getInstance().Driver.findElement(By.xpath("//label[@class='custom-control-label']"));


    public void clicktoggleButton() {
        Browser.waitForPageReady();
        Browser.scrollToVisibleElement(paymentToggleAdyen);
        Browser.clickOnElement(paymentToggleAdyen);
    }


}
