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
        Browser.waitForElementToBeVisible(reviewReplyTemplatesHeading);
        Assert.assertTrue("Follow up Campaigns heading is not visible on campaigns page.", followUpCampaignsHeading.isDisplayed());
        Assert.assertTrue("Custom Campaigns heading is not visible on campaigns page.", customCampaignsHeading.isDisplayed());
        Assert.assertTrue("Email templates heading is not visible on campaigns page.", emailTemplatesHeading.isDisplayed());
        Assert.assertTrue("SMS templates heading is not visible on campaigns page.", smsTemplatesHeading.isDisplayed());
        Assert.assertTrue("Review reply templates heading is not visible on campaigns page.", reviewReplyTemplatesHeading.isDisplayed());
    }

    public void verifyFollowUpPageUiFor(String campaignName) {
        Browser.waitForTableSizeToBe(patientFollowUpTable.getFirst(), 5);
        Browser.waitForTableSizeToBe(patientFollowUpTable.get(1), 3);
        Browser.waitForTableSizeToBe(patientFollowUpTable.get(2), 3);
        Browser.waitForTableSizeToBe(patientFollowUpTable.get(3), 3);
        Browser.waitForElementToBeVisible(DriverManager.getInstance().Driver.findElement(By.xpath("//div[@class='table-responsive']//td[contains(text(),'"+campaignName+"')]")));
        WebElement campaignTitle = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@class='table-responsive']//td[contains(text(),'"+campaignName+"')]"));
        Browser.scrollToVisibleElement(campaignTitle);
        List<WebElement> gridCells = campaignTitle.findElements(By.xpath("./following-sibling::td"));
        if (gridCells.size() == 1) {
            Browser.clickOnElement(gridCells.getFirst());
            Browser.waitForElementToBeVisible(By.xpath("//div[@class='table-responsive']//td[contains(text(),'"+campaignName+"')]/..//button[@id]"));
            verifyCampaignsStatusItems(campaignName);
            verifyCampaignsEllipsisActionItems(campaignName);
        }
        else {
            verifyCampaignsStatusItems(campaignName);
            verifyCampaignsEllipsisActionItems(campaignName);
        }
    }

    public void verifyCampaignsStatusItems(String campaignName){
        WebElement statusButton = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@class='table-responsive']//td[contains(text(),'"+campaignName+"')]/..//button[@id]"));
        Browser.clickOnElement(statusButton);
        WebElement activeStatus = DriverManager.getInstance().Driver.findElement(By.linkText("Active"));
        WebElement inActiveStatus = DriverManager.getInstance().Driver.findElement(By.linkText("Inactive"));
        Assert.assertTrue("Active status is not visible in campaigns page",activeStatus.isDisplayed());
        Assert.assertTrue("Inactive status is not visible in campaigns page",inActiveStatus.isDisplayed());
    }

    public void verifyCampaignsEllipsisActionItems(String campaignName) {
        WebElement campaignEllipsisIcon = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@class='table-responsive']//td[contains(text(),'"+campaignName+"')]/..//button[contains(@class,'ellipsis')]"));
        Browser.clickOnElement(campaignEllipsisIcon);
        Browser.waitForElementToBeVisible(By.linkText("Create new from default"));
        WebElement editCampaignAction = DriverManager.getInstance().Driver.findElement(By.linkText("Edit"));
        WebElement createNewCampaignAction = DriverManager.getInstance().Driver.findElement(By.linkText("Create new from default"));
        WebElement duplicateCampaignAction = DriverManager.getInstance().Driver.findElement(By.linkText("Duplicate"));
        WebElement deleteCampaignAction = DriverManager.getInstance().Driver.findElement(By.linkText("Delete"));
        Assert.assertTrue("Edit campaign action item is not visible in campaigns page", editCampaignAction.isDisplayed());
        Assert.assertTrue("Create new campaign action item is not visible in campaigns page", createNewCampaignAction.isDisplayed());
        Assert.assertTrue("Duplicate campaign action item is not visible in campaigns page", duplicateCampaignAction.isDisplayed());
        Assert.assertTrue("Delete campaign action item is not visible in campaigns page", deleteCampaignAction.isDisplayed());
    }
}