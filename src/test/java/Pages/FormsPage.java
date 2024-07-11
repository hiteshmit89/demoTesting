package Pages;

import Framework.Browser;
import Framework.Constants.Constants.PageTitle;
import Framework.Root.PbNUIApp;
import Framework.Util.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FormsPage extends BasePage {

    public FormsPage(PageTitle title) {
        super(title);
    }

    public void clickCompletedForms() {
        WebElement completedForms = DriverManager.getInstance().Driver.findElement(By.xpath("//*[@class='form-navigation col-lg-2 col-md-12 col-sm-12 col-xs-12']//div[contains(text(),'Completed Forms')]"));
        Browser.clickOnElement(completedForms);
    }

    public void clickFormsHeading() {
        WebElement formsHeading = DriverManager.getInstance().Driver.findElement(By.xpath("//a[contains(text(),'Forms')]"));
        Browser.clickOnElement(formsHeading);
    }

    public void verifyCompletedFormsHeadingIsVisible() {
        WebElement completedFormsTextDisplay = DriverManager.getInstance().Driver.findElement(By.xpath("//*[@class='form-navigation-content col-lg-10 col-md-12 col-sm-12 col-xs-12']//h3[contains(text(),'Completed Forms')]"));
        Browser.waitForElementToDisplay(completedFormsTextDisplay);
    }

    public void clickPreviewIcon() {
        List<WebElement> previewIcon = DriverManager.getInstance().Driver.findElements(By.xpath("//table[@class='table table-striped table-hover table-bordered']//*[@data-icon='image']"));
        Browser.clickOnElement(previewIcon.getFirst());
    }

    public void clickDownloadIcon() {
        List<WebElement> downloadIcon = DriverManager.getInstance().Driver.findElements(By.xpath("//table[@class='table table-striped table-hover table-bordered']//*[@data-icon='download']"));
        Browser.clickOnElement(downloadIcon.getFirst());
    }

    public void searchPatient() {
        WebElement searchPatient = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@placeholder ='Search by Patient Name']"));
        Browser.enterTextInEditBox(searchPatient,PbNUIApp.userdata().getPatientName(3,1));
        Browser.waitForElementToDisplay(searchPatient);
    }

    public void clickCustomDropDown() {
        WebElement customDropDown = DriverManager.getInstance().Driver.findElement(By.xpath("//button[@class='multiselect dropdown-toggle btn btn-default']"));
        Browser.clickOnElement(customDropDown);
        Browser.waitForPageReady();
    }

    public void clickTextNextToCheckNotSyncedForms() {
        WebElement textNextToCheckNotSyncedForms = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@class='CompletedFormsTable-container']//label[contains(text(),'Only show completed forms that have not synced')]"));
        Browser.clickOnElement(textNextToCheckNotSyncedForms);
        Browser.waitForPageReady();
    }

    public void clickPendingFormsOnTheLeftHandSide() {
        WebElement pendingForms = DriverManager.getInstance().Driver.findElement(By.xpath("//*[@class='form-navigation col-lg-2 col-md-12 col-sm-12 col-xs-12']//div[contains(text(),'Pending Forms')]"));
        Browser.clickOnElement(pendingForms);
    }

    public void pendingFormsSearchPatient() {
        Browser.waitForPresenceOfElement(By.xpath("//div[@class='custom-table-filter-col custom-table-right-align-filter custom-table-left-align-tab col-lg-9 col-sm-8 col-xs-9']//input[@placeholder='Search by Patient Name']"));
        Browser.waitForElementToBeClickable(By.xpath("//div[@class='custom-table-filter-col custom-table-right-align-filter custom-table-left-align-tab col-lg-9 col-sm-8 col-xs-9']//input[@placeholder='Search by Patient Name']"));
        WebElement pendingFormsSearchPatient = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@class='custom-table-filter-col custom-table-right-align-filter custom-table-left-align-tab col-lg-9 col-sm-8 col-xs-9']//input[@placeholder='Search by Patient Name']"));
        Browser.enterTextInEditBox(pendingFormsSearchPatient, PbNUIApp.userdata().getPatientName(3, 1));
        Browser.waitForElementToDisplay(pendingFormsSearchPatient);
    }

    public void clickCustomFilter() {
        WebElement clickCustomFilter = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@class='btn-group']//*[@title='Custom']"));
        Browser.clickOnElement(clickCustomFilter);
        Browser.waitForPageReady();
    }

    public void clickFormsDropdown() {
        Browser.waitForElementEnable(DriverManager.getInstance().Driver.findElement(By.xpath("//span[@class='multiselect-selected-text' and contains(text(),'None')]")));
        Browser.waitForElementToBeVisible(By.xpath("//span[@class='multiselect-selected-text' and contains(text(),'None')]"));
        Browser.waitForElementToBeClickable(By.xpath("//span[@class='multiselect-selected-text' and contains(text(),'None')]"));
        WebElement formsDropdown = DriverManager.getInstance().Driver.findElement(By.xpath("//span[@class='multiselect-selected-text' and contains(text(),'None')]"));
        Browser.clickOnElementUsingJavascript(formsDropdown);
    }

    public void formsFilterSelectAll() {
        Browser.waitForPresenceOfElement(By.xpath("//input[@value='multiselect-all']"));
        WebElement selectAll = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@value='multiselect-all']"));
        Browser.clickOnElementUsingJavascript(selectAll);
    }

    public void clickOnBellIcon() {
        Browser.waitForElementList(By.xpath("//*[@id='pending-form-page-pane-pending_forms']//div//*[@data-icon='bell']"));
        List<WebElement> bellIcons = DriverManager.getInstance().Driver.findElements(By.xpath("//*[@id='pending-form-page-pane-pending_forms']//div//*[@data-icon='bell']"));
        Browser.clickOnElement(bellIcons.getFirst());
    }

    public void confirmationYesButton() {
        Browser.waitForElementToBeVisible(By.xpath("//*[@id='confirmation-popover']//*[@class='m-2 btn btn-danger']"));
        WebElement clickYesButton = DriverManager.getInstance().Driver.findElement(By.xpath("//*[@id='confirmation-popover']//*[@class='m-2 btn btn-danger']"));
        Browser.clickOnElementUsingJavascript(clickYesButton);

    }
}