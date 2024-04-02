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

    private final WebElement followUpCampaignsHeading = DriverManager.getInstance().Driver.findElement(By.xpath("//li[@class='active']/a"));
    private final WebElement customCampaignsHeading = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@id='Communication']//li/a[contains(text(),'Custom Campaigns')]"));
    private final WebElement emailTemplatesHeading = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@id='Communication']//li/a[contains(text(),'Email Templates')]"));
    private final WebElement smsTemplatesHeading = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@id='Communication']//li/a[contains(text(),'SMS Templates')]"));
    private final WebElement reviewReplyTemplatesHeading = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@id='Communication']//li/a[contains(text(),'Review Reply Templates')]"));
    private final List<WebElement> patientFollowUpTable = DriverManager.getInstance().Driver.findElements(By.xpath("//*[@id='root']//table"));

    public void verifyCampaignsHeadingDisplayedOnCampaignsPage() {
        Browser.waitForElementToDisplay(followUpCampaignsHeading);
        Assert.assertTrue("Follow up Campaigns heading is not visible on campaigns page.", followUpCampaignsHeading.isDisplayed());
        Assert.assertTrue("Custom Campaigns heading is not visible on campaigns page.", customCampaignsHeading.isDisplayed());
        Assert.assertTrue("Email templates heading is not visible on campaigns page.", emailTemplatesHeading.isDisplayed());
        Assert.assertTrue("SMS templates heading is not visible on campaigns page.", smsTemplatesHeading.isDisplayed());
        Assert.assertTrue("Review reply templates heading is not visible on campaigns page.", reviewReplyTemplatesHeading.isDisplayed());
    }

    public void verifyFollowUpPageUi() throws InterruptedException {
        Browser.waitForTableSizeToBe(patientFollowUpTable.getFirst(), 5);
        WebElement recallCampaign = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@class='table-responsive']//td[contains(text(),'Recall Campaign')]"));
        List<WebElement> gridCells = recallCampaign.findElements(By.xpath("./following-sibling::td"));
        if (gridCells.size() == 1) {
            Browser.clickOnElement(gridCells.getFirst());
            String gridCellsText = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@class='table-responsive']//td[contains(text(),'Recall Campaign')]/..//button[@id]")).getText();
        }
        else {
        }
    }
}
