package Pages;

import Framework.Browser;
import Framework.Constants.Constants;
import Framework.Util.DriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CampaignsPage extends BasePage {

    public CampaignsPage(Constants.PageTitle title) {
        super(title);
    }

    private WebElement followUpCampaignsHeading = DriverManager.getInstance().Driver.findElement(By.xpath("//li[@class='active']/a"));
    private WebElement customCampaignsHeading = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@id='Communication']//li/a[contains(text(),'Custom Campaigns')]"));
    private WebElement emailTemplatesHeading = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@id='Communication']//li/a[contains(text(),'Email Templates')]"));
    private WebElement smsTemplatesHeading = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@id='Communication']//li/a[contains(text(),'SMS Templates')]"));
    private WebElement reviewReplyTemplatesHeading = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@id='Communication']//li/a[contains(text(),'Review Reply Templates')]"));


    public void verifyCampaignsHeadingDisplayedOnCampaignsPage() {
        Browser.waitForElementToDisplay(followUpCampaignsHeading);
        Assert.assertTrue("Follow up Campaigns heading is not visible on campaigns page.", followUpCampaignsHeading.isDisplayed());
        Assert.assertTrue("Custom Campaigns heading is not visible on campaigns page.", customCampaignsHeading.isDisplayed());
        Assert.assertTrue("Email templates heading is not visible on campaigns page.", emailTemplatesHeading.isDisplayed());
        Assert.assertTrue("SMS templates heading is not visible on campaigns page.", smsTemplatesHeading.isDisplayed());
        Assert.assertTrue("Review reply templates heading is not visible on campaigns page.", reviewReplyTemplatesHeading.isDisplayed());

    }
}
