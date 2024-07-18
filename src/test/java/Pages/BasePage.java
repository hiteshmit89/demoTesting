package Pages;

import Framework.Browser;
import Framework.Util.DriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.logging.Logger;

import static Framework.Constants.Constants.PageTitle;


public class BasePage {

    public static final Logger logger = Logger.getLogger("PBN");

    public BasePage(PageTitle title) {
        Browser.waitForPageReady();
        Browser.waitForPageTitle(title);
    }

    public void verifyNotificationText(String text) {
        Browser.waitForElementToBeVisible(By.xpath("//div[@class='react-toast-notifications__toast__content css-1ad3zal']"));
        WebElement notificationsContainer = DriverManager.getInstance().Driver.findElement(By.xpath("/html/body/div[contains(@class,'react-toast-notifications__container ')]"));
        Browser.waitForElementChildren(notificationsContainer, By.xpath(".//div"), 4);
        List<WebElement> notifications = notificationsContainer.findElements(By.xpath(".//div[text()]"));
        for (WebElement notification : notifications) {
            Assert.assertEquals("Notification text did not appear as expected. Expected: " + text
                    + " Actual: " + notification.getText(), text, notification.getText());
        }
    }
}
