package Pages;
import Framework.Browser;
import Framework.Constants.Constants.PageTitle;
import Framework.Util.DriverManager;
import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.io.BufferedWriter;
import java.sql.Driver;
import java.util.List;

public class FormsPage extends BasePage {

    public FormsPage(PageTitle title) {
        super(title);
    }

    private WebElement formsHeading = DriverManager.getInstance().Driver.findElement(By.xpath("//a[contains(text(),'Forms')]"));

    private WebElement completedForms = DriverManager.getInstance().Driver.findElement(By.xpath("//*[@class='form-navigation col-lg-2 col-md-12 col-sm-12 col-xs-12']//div[contains(text(),'Completed Forms')]"));

    private WebElement completedFormsTextDisplay = DriverManager.getInstance().Driver.findElement(By.xpath("//*[@class='form-navigation-content col-lg-10 col-md-12 col-sm-12 col-xs-12']//h3[contains(text(),'Completed Forms')]"));

    //private WebElement toggleToViewCompletedNotSyncedForms = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@class='CompletedFormsTable-container']//input[@type='checkbox']"));
    private List<WebElement> previewIcon = DriverManager.getInstance().Driver.findElements(By.xpath("//table[@class='table table-striped table-hover table-bordered']//*[@data-icon='image']"));

    private List <WebElement> downloadIcon =DriverManager.getInstance().Driver.findElements(By.xpath("//table[@class='table table-striped table-hover table-bordered']//*[@data-icon='download']"));

    private WebElement searchPatient = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@placeholder ='Search by Patient Name']"));

    private WebElement customDropDown = DriverManager.getInstance().Driver.findElement (By.xpath("//button[@class='multiselect dropdown-toggle btn btn-default']"));

    private WebElement textNextToCheckNotSyncedForms = DriverManager.getInstance().Driver.findElement (By.xpath("//div[@class='CompletedFormsTable-container']//label[contains(text(),'Only show completed forms that have not synced')]"));


    public void clickCompletedForms()
    {
        Browser.clickOnElement(completedForms);
    }

    public void setCompletedFormsTextDisplay() {
        Browser.waitForElementToDisplay(completedFormsTextDisplay);}

    public void clickFormsHeading() {
        Browser.clickOnElement(formsHeading);}

    public void verifyCompletedFormsHeadingIsVisible() {
        Browser.waitForElementToDisplay(completedFormsTextDisplay);}

    //public void clickOnToggleOnlShowCompletedFormsThatHaveNotSynced() {
    //Browser.waitForAttributeValue(toggleToViewCompletedNotSyncedForms, "isEnabled", "true");
    //toggleToViewCompletedNotSyncedForms.click();
    // }

    public void clickPreviewIcon() {
        Browser.clickOnElement(previewIcon.getFirst());}

    public void clickDownloadIcon() {
        Browser.clickOnElement(downloadIcon.getFirst());}

    public void searchPatient() {
        Browser.enterTextInEditBox(searchPatient, "Kathryn");
        Browser.waitForElementToDisplay(searchPatient);}

    public void clickCustomDropDown() {
        Browser.clickOnElement(customDropDown);
        Browser.waitForPageReady();
    }
    public void clickTextNextToCheckNotSyncedForms() {
        Browser.clickOnElement(textNextToCheckNotSyncedForms);
        Browser.waitForPageReady();
    }
}
