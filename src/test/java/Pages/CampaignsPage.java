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
    private final List<WebElement> patientFollowUpTable = DriverManager.getInstance().Driver.findElements(By.xpath("//*[@id='root']//table"));

    public void verifyCampaignsHeadingDisplayedOnCampaignsPage() {
        Assert.assertTrue("Follow up Campaigns heading is not visible on campaigns page.", followUpCampaignsHeading.isDisplayed());
        Assert.assertTrue("Custom Campaigns heading is not visible on campaigns page.", customCampaignsHeading.isDisplayed());
        Assert.assertTrue("Email templates heading is not visible on campaigns page.", emailTemplatesHeading.isDisplayed());
        Assert.assertTrue("SMS templates heading is not visible on campaigns page.", smsTemplatesHeading.isDisplayed());
        Browser.waitForElementToBeVisible(By.xpath("//div[@id='Communication']//li/a[contains(text(),'Review Reply Templates')]"));
        Browser.waitForElementToBeClickable(By.xpath("//div[@id='Communication']//li/a[contains(text(),'Review Reply Templates')]"));
        WebElement reviewReplyTemplatesHeading = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@id='Communication']//li/a[contains(text(),'Review Reply Templates')]"));
        Assert.assertTrue("Review reply templates heading is not visible on campaigns page.", reviewReplyTemplatesHeading.isDisplayed());
    }

    public void verifyFollowUpPageUiFor(String campaignName) {
        Browser.waitForTableSizeToBe(patientFollowUpTable.getFirst(), 5);
        Browser.waitForTableSizeToBe(patientFollowUpTable.get(1), 3);
        Browser.waitForTableSizeToBe(patientFollowUpTable.get(2), 3);
        Browser.waitForTableSizeToBe(patientFollowUpTable.get(3), 3);
        Browser.waitForElementToBeVisible(DriverManager.getInstance().Driver.findElement(By.xpath("//div[@class='table-responsive']//td[contains(text(),'" + campaignName + "')]")));
        WebElement campaignTitle = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@class='table-responsive']//td[contains(text(),'" + campaignName + "')]"));
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
        WebElement activeStatus = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@class='table-responsive']//td[contains(text(),'"+campaignName+"')]/..//button[@id]/../following-sibling::ul//div[contains(text(),'Active')]"));
        WebElement inActiveStatus = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@class='table-responsive']//td[contains(text(),'"+campaignName+"')]/..//button[@id]/../following-sibling::ul//div[contains(text(),'Inactive')]"));
        Assert.assertTrue("Active status is not visible in campaigns page",activeStatus.isDisplayed());
        Assert.assertTrue("Inactive status is not visible in campaigns page",inActiveStatus.isDisplayed());
    }

    public void verifyCampaignsEllipsisActionItems(String campaignName) {
        WebElement campaignEllipsisIcon = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@class='table-responsive']//td[contains(text(),'"+campaignName+"')]/..//button[contains(@class,'ellipsis')]"));
        Browser.clickOnElement(campaignEllipsisIcon);
        List<WebElement> editOptions = DriverManager.getInstance().Driver.findElements(By.xpath("//div[@class='table-responsive']//td[contains(text(),'Recall Campaign')]/../td[@id]//ul/li"));
        if (editOptions.size() > 4){
            Browser.doubleClickOnElement(campaignEllipsisIcon);
        }
        WebElement editCampaignAction = DriverManager.getInstance().Driver.findElement(By.linkText("Edit"));
        WebElement duplicateCampaignAction = DriverManager.getInstance().Driver.findElement(By.linkText("Duplicate"));
        WebElement deleteCampaignAction = DriverManager.getInstance().Driver.findElement(By.linkText("Delete"));
        Assert.assertTrue("Edit campaign action item is not visible in campaigns page", editCampaignAction.isDisplayed());
        Assert.assertTrue("Duplicate campaign action item is not visible in campaigns page", duplicateCampaignAction.isDisplayed());
        Assert.assertTrue("Delete campaign action item is not visible in campaigns page", deleteCampaignAction.isDisplayed());
        WebElement createNewCampaignAction = DriverManager.getInstance().Driver.findElement(By.linkText("Create new from default"));
        Assert.assertTrue("Create new campaign action item is not visible in campaigns page", createNewCampaignAction.isDisplayed());
    }

    public void clickOnAppointmentRemindersCampaign() {
        Browser.waitForElementToBeVisible(By.xpath("//td[text()='Appointment Reminders Campaign']"));
        WebElement arcLink = DriverManager.getInstance().Driver.findElement(By.xpath("//td[text()='Appointment Reminders Campaign']"));
        Browser.clickOnElement(arcLink);
    }

    public void clickOnPrimaryEarlyReminderEditEmailTemplateButton() {
        Browser.waitForElementToBeVisible(By.xpath("(//button[text()='Edit'])[3]"));
        WebElement primaryEarlyReminderEditEmailTemplateButton = DriverManager.getInstance().Driver.findElement(By.xpath("(//button[text()='Edit'])[3]"));
        Browser.clickOnElement(primaryEarlyReminderEditEmailTemplateButton);
    }

    public void clickOnPreHeaderAndSelectPlaceholder(String preHeaderData) {
        Browser.waitForElementToBeVisible(By.xpath("//label[text()='Preheader:']/following-sibling::div//div[@data-editor]/div"));
        Browser.waitForElementToBeClickable(By.xpath("//label[text()='Preheader:']/following-sibling::div//div[@data-editor]/div"));
        List<WebElement> preHeaderDataEnter = DriverManager.getInstance().Driver.findElements(By.xpath("//label[text()='Preheader:']/following-sibling::div//div[@data-editor]/div"));
        Browser.enterTextInEditBox(preHeaderDataEnter.get(1), preHeaderData);
        WebElement clickSaveButton = DriverManager.getInstance().Driver.findElement(By.xpath("//button[text()='Cancel']/following-sibling::button"));
        Browser.clickOnElement(clickSaveButton);
    }

    public void verifyErrorToastMessageDisplayed() {
        Browser.waitForElementToBeVisible(By.xpath("//div[@class='react-toast-notifications__toast__content css-1ad3zal']"));
        WebElement errorMessage = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@class='react-toast-notifications__toast__content css-1ad3zal']"));
        String errorMsg = "Invalid Merge Tag: , {Please confirm your upcoming dental appointment at {{ practice_name }";
        Assert.assertEquals("Invalid Merge Tag Error Message", errorMsg, errorMessage.getText());
    }

    public void activateCampaign(String campaignName) {
        Browser.waitForTableSizeToBe(patientFollowUpTable.getFirst(), 5);
        Browser.waitForTableSizeToBe(patientFollowUpTable.get(1), 3);
        Browser.waitForTableSizeToBe(patientFollowUpTable.get(2), 3);
        Browser.waitForTableSizeToBe(patientFollowUpTable.get(3), 3);
        Browser.waitForElementToBeVisible(DriverManager.getInstance().Driver.findElement(By.xpath("//div[@class='table-responsive']//td[contains(text(),'" + campaignName + "')]")));
        WebElement campaignTitle = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@class='table-responsive']//td[contains(text(),'" + campaignName + "')]"));
        Browser.scrollToVisibleElement(campaignTitle);
        List<WebElement> gridCells = campaignTitle.findElements(By.xpath("./following-sibling::td"));
        if (gridCells.size() == 1) {
            Browser.clickOnElement(gridCells.getFirst());
            Browser.waitForElementToBeVisible(By.xpath("//div[@class='table-responsive']//td[contains(text(),'"+campaignName+"')]/..//button[@id]"));
            verifyCampaignsStatusItems(campaignName);
            WebElement activeStatus = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@class='table-responsive']//td[contains(text(),'"+campaignName+"')]/..//button[@id]/../following-sibling::ul//div[contains(text(),'Active')]"));
            Browser.clickOnElement(activeStatus);
            Browser.waitForElementToBeClickable(By.xpath("//div[@class='table-responsive']//td[contains(text(),'"+campaignName+"')]/..//button[contains(text(),'Active')]"));
        }
        else {
            markCampaignActive(campaignName);
        }
    }

    private void markCampaignActive(String campaignName) {
        verifyCampaignsStatusItems(campaignName);
        WebElement activeStatus = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@class='table-responsive']//td[contains(text(),'"+campaignName+"')]/..//button[@id]/../following-sibling::ul//div[contains(text(),'Active')]"));
        Browser.clickOnElement(activeStatus);
        Browser.waitForElementToBeVisible(By.xpath("//div[@class='table-responsive']//td[contains(text(),'"+campaignName+"')]/..//button[contains(text(),'Active')]"));
        Browser.waitForElementToBeClickable(By.xpath("//div[@class='table-responsive']//td[contains(text(),'"+campaignName+"')]/..//button[contains(text(),'Active')]"));
    }

    public void openCampaign(String campaignName) {
        WebElement clickOnCampaignName = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@class='table-responsive']//td[contains(text(),'"+campaignName+"')]"));
        Browser.clickOnElement(clickOnCampaignName);
        Browser.waitForElementToBeVisible(By.xpath("//div[@class='row']/ol/li[@class='active']"));
    }
}