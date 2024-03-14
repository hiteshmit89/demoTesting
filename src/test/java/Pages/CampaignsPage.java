package Pages;

import Framework.Browser;
import Framework.Constants.Constants;
import Framework.Util.DriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CampaignsPage extends BasePage {

    public CampaignsPage(Constants.PageTitle title) {
        super(title);
    }

    private WebElement campaignsHeading = DriverManager.getInstance().Driver.findElement(By.xpath("//li[@class='active']/a"));

    public void verifyCampaignsHeadingDisplayedOnCampaignsPage() {
        Browser.waitForElementToDisplay(campaignsHeading);
        Assert.assertTrue("Campaigns heading is not visible on campaigns page.", campaignsHeading.isDisplayed());
    }
}
