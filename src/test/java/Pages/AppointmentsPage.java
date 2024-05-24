package Pages;

import Framework.Browser;
import Framework.Constants.Constants.PageTitle;
import Framework.Util.ConfigManager;
import Framework.Util.DriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AppointmentsPage extends BasePage {

    public AppointmentsPage(PageTitle title) {
        super(title);
    }

    private WebElement header = DriverManager.getInstance().Driver.findElement(By.xpath("//*[@id='appointment-booking']//span[text()='Online Appointment Booking']"));
    private WebElement eUrl = DriverManager.getInstance().Driver.findElement(By.xpath("(//span[contains(text(),'https://www.patientsreach.com/schedule/')])[1]"));

    public void clickOnWidgets() {
        WebElement widgetsTab = DriverManager.getInstance().Driver.findElement(By.xpath("//a[@id='appointment-booking-page-tab-Widgets']"));
        Browser.clickOnElement(widgetsTab);
        Browser.waitForElementToDisplay(widgetsTab);
    }

    public void createAppointmentURLAndNavigate() {
        String urlText = eUrl.getText();
        String[] arrOfStr = urlText.split("schedule");
        String URL = ConfigManager.getInstance().getProperty("URL");
        URL = String.join("", URL, "/schedule", arrOfStr[1]);
        Browser.navigateToNewURL(URL);
    }

    public void clickOnAppointmentSettingTab() {
        WebElement appointmentSetting = DriverManager.getInstance().Driver.findElement(By.xpath("//a[@id='appointment-booking-page-tab-Settings']"));
        Browser.clickOnElement(appointmentSetting);
    }

    public void clickOnAppointmentListTab() {
        WebElement appointmentList = DriverManager.getInstance().Driver.findElement(By.xpath("//a[@id='appointment-booking-page-tab-Appointment List']"));
        Browser.clickOnElement(appointmentList);
    }

    public void clickOnSetupInsurance() {
        Browser.waitForElementToBeClickable(By.xpath("//button[text()='Setup Insurances']"));
        WebElement setupInsuranceButton = DriverManager.getInstance().Driver.findElement(By.xpath("//button[text()='Setup Insurances']"));
        Browser.scrollToVisibleElement(setupInsuranceButton);
        Browser.clickOnElementUsingJavascript(setupInsuranceButton);
    }

    public void clickOnDisableInsurance() {
        WebElement disableInsurance = DriverManager.getInstance().Driver.findElement(By.id("insurance-active"));
        Browser.scrollToVisibleElement(disableInsurance);
        if (disableInsurance.isSelected()) {
            Browser.clickOnElementUsingJavascript(disableInsurance);
        }
    }

    public void clickOnSaveButton() {
        WebElement saveButton = DriverManager.getInstance().Driver.findElement(By.xpath("(//button[text()='Save'])[5]"));
        Browser.scrollToVisibleElement(saveButton);
        Browser.waitForElementToBeClickable(saveButton);
        Browser.clickOnElementUsingJavascript(saveButton);
    }

    public void clickOnSettingSaveButton() {
        WebElement saveButton = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@class='bottom-buttons-row']//button[text()='Save']"));
        Browser.scrollToVisibleElement(saveButton);
        Browser.clickOnElementUsingJavascript(saveButton);
    }

    public void clickOnSetupCreditCard() {
        Browser.waitForElementToBeVisible(By.xpath("//button[text()='Setup Credit Card Collection']"));
        WebElement setupCreditCardButton = DriverManager.getInstance().Driver.findElement(By.xpath("//button[text()='Setup Credit Card Collection']"));
        Browser.scrollToVisibleElement(setupCreditCardButton);
        Browser.clickOnElement(setupCreditCardButton);
    }

    public void clickOnEnableCreditCard() {
        WebElement enableCreditCard = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@id='card-setup-toggle']"));
        Browser.waitForElementToBeVisible(enableCreditCard.findElement(By.xpath("./..")));
        Browser.scrollToVisibleElement(enableCreditCard);
        if (!enableCreditCard.isSelected()) {
            Browser.clickOnElementUsingJavascript(enableCreditCard);
        }
    }

    public void clickOnProviderEditButton() {
        Browser.waitForElementToBeVisible(By.xpath("(//button[@class='btn btn-sm'and contains(text(),'Edit')])[1]"));
        WebElement providerEditButton = DriverManager.getInstance().Driver.findElement(By.xpath("(//button[@class='btn btn-sm'and contains(text(),'Edit')])[1]"));
        Browser.scrollToVisibleElement(providerEditButton);
        Browser.clickOnElementUsingJavascript(providerEditButton);
    }

    public void verifyBlockOutTimes() {
        Browser.waitForElementToBeClickable(By.xpath("//label[text()='Blocked Out Times']"));
        WebElement blockOutTimes = DriverManager.getInstance().Driver.findElement(By.xpath("//label[text()='Blocked Out Times']"));
        Assert.assertTrue("Verify block-out times is not displayed", blockOutTimes.isDisplayed());
    }

    public void enterStartDate1(String startDateData) {
        WebElement startDate = DriverManager.getInstance().Driver.findElement(By.xpath("(//input[@name='dateStart'])[1]"));
        Browser.enterTextInEditBox(startDate, startDateData);
        Browser.waitForElementEnable(startDate);
    }

    public void enterStartDate2(String startDateData) {
        WebElement startDate = DriverManager.getInstance().Driver.findElement(By.xpath("(//input[@name='dateStart'])[2]"));
        Browser.enterTextInEditBox(startDate, startDateData);
        Browser.waitForElementEnable(startDate);
    }

    public void enterEndDate(String endDateData) {
        WebElement endDate = DriverManager.getInstance().Driver.findElement(By.xpath("(//input[@name='dateEnd'])[1]"));
        Browser.waitForElementEnable(endDate);
        Browser.enterTextInEditBox(endDate, endDateData);
        Browser.waitForElementEnable(endDate);
    }

    public void verifyAppointmentList() {
        WebElement appointmentList = DriverManager.getInstance().Driver.findElement(By.xpath("(//tr[@class='pointer'])[1]"));
        Assert.assertTrue("Appointment List is not displayed", appointmentList.isDisplayed());
    }

    public void clickOnProviderAdvanceSettingButton() {
        Browser.waitForElementToBeVisible(By.xpath("//div[@class='visit-type-setting-button-container']"));
        WebElement providerAdvanceSettingButton = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@class='visit-type-setting-button-container']"));
        Browser.scrollToVisibleElement(providerAdvanceSettingButton);
        Browser.clickOnElement(providerAdvanceSettingButton);
    }

    public void verifyAllowedAge() {
        Browser.waitForElementToBeClickable(By.xpath("//label[text()='Allowed Age']"));
        WebElement allowedAge = DriverManager.getInstance().Driver.findElement(By.xpath("//label[text()='Allowed Age']"));
        Assert.assertTrue("Allowed age is not displayed", allowedAge.isDisplayed());
    }

    public void verifyNoProviderSelectionCheckbox() {
        WebElement noProviderSelection = DriverManager.getInstance().Driver.findElement(By.xpath("//label[text()='No Provider selection']"));
        Assert.assertTrue("No Provider Selection Checkbox is not displayed", noProviderSelection.isDisplayed());
    }

    public void verifyCheckRecallDateCheckbox() {
        WebElement checkRecallDate = DriverManager.getInstance().Driver.findElement(By.xpath("//label[text()='Check Recall date']"));
        Assert.assertTrue("Check Recall Date Checkbox is not displayed", checkRecallDate.isDisplayed());
    }

    public void verifyDontAutoSyncCheckbox() {
        WebElement dontAutoSyncCheckbox = DriverManager.getInstance().Driver.findElement(By.xpath("//label[text()='Check Recall date']"));
        Assert.assertTrue("Don't Auto Sync Checkbox is not displayed", dontAutoSyncCheckbox.isDisplayed());
    }

    public void verifySoonestAppointmentAvailable() {
        WebElement soonestAppointmentAvailable = DriverManager.getInstance().Driver.findElement(By.xpath("//label[text()='Soonest Appointment Available']"));
        Assert.assertTrue("Soonest Appointment Available is not displayed", soonestAppointmentAvailable.isDisplayed());
    }

    public void verifyFarthestAppointmentAvailable() {
        WebElement farthestAppointmentAvailable = DriverManager.getInstance().Driver.findElement(By.xpath("//label[text()='Farthest Appointment Available Month(s)']"));
        Assert.assertTrue("Farthest Appointment Available is not displayed", farthestAppointmentAvailable.isDisplayed());
    }

    public void clickOnAddProvidersDropdown() {
        Browser.waitForElementToBeVisible(By.xpath("(//button[@class='multiselect dropdown-toggle btn btn-default'])[7]"));
        Browser.waitForElementToBeClickable(By.xpath("(//button[@class='multiselect dropdown-toggle btn btn-default'])[7]"));
        WebElement providerDropdown = DriverManager.getInstance().Driver.findElement(By.xpath("(//button[@class='multiselect dropdown-toggle btn btn-default'])[7]"));
        Browser.scrollToVisibleElement(providerDropdown);
        Browser.clickOnElement(providerDropdown);
        WebElement selectProvider = DriverManager.getInstance().Driver.findElement(By.xpath("//label[text()=' Bryan Jackson (TH2)']"));
        Browser.clickOnElement(selectProvider);
    }

    public void clickProviderHeader() {
        WebElement providerHeader = DriverManager.getInstance().Driver.findElement(By.xpath("//h3[text()='Providers']"));
        Browser.clickOnElement(providerHeader);
    }

    public void clickOutsideAppointmentList() {
        WebElement outsideAppointmentList = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@class='custom-table-filter-label col-lg-3 col-md-3 col-sm-3 col-xs-6']"));
        Browser.clickOnElement(outsideAppointmentList);
    }


    public void clickOnAddNewVisitType() {
        WebElement addNewButton = DriverManager.getInstance().Driver.findElement(By.xpath("//button[@class='add-button btn btn-default']"));
        Browser.clickOnElement(addNewButton);
    }

    public void deleteProvider() {
        WebElement deleteProviderButton = DriverManager.getInstance().Driver.findElement(By.xpath("(//button[@class='btn btn-sm btn-danger'])[1]"));
        Browser.clickOnElement(deleteProviderButton);
        WebElement deleteYesButton = DriverManager.getInstance().Driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
        Browser.clickOnElement(deleteYesButton);
    }

    public void deleteVisitType() {
        WebElement deleteVisitTypeButton = DriverManager.getInstance().Driver.findElement(By.xpath("(//button[@class='btn btn-sm btn-danger'])[2]"));
        Browser.clickOnElement(deleteVisitTypeButton);
        WebElement deleteYesButton = DriverManager.getInstance().Driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
        Browser.clickOnElement(deleteYesButton);
    }

    public void select15MinCheckbox() {
        WebElement select15MinCheckbox = DriverManager.getInstance().Driver.findElement(By.xpath("//span[text()='15 Minutes']"));
        Browser.clickOnElement(select15MinCheckbox);
    }

    public void clickOnExistingPatient() {
        WebElement appointmentTable = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@class='react-bootstrap-table table-responsive']"));
        Browser.waitForTableToLoad(appointmentTable);
        List<WebElement> rowElements = DriverManager.getInstance().Driver.findElements(By.xpath("//div[@class='react-bootstrap-table table-responsive']//tr"));
        int i = 0;
        for (WebElement row : rowElements) {
            if (i==0) {
                i++;
            }
            else {
                WebElement colElement = row.findElement(By.xpath(".//td[7]"));
                String colName = "Existing";
                if (Browser.getTextFromElement(colElement).equals(colName)) {
                    Browser.clickOnElement(colElement);
                    break;
                }
            }
        }
    }

    public void clickOnExistingPatientInformation() {
        List<WebElement> rowElements = DriverManager.getInstance().Driver.findElements(By.xpath("//div[@class='react-bootstrap-table table-responsive']//tr"));
        int i = 0;
        for (WebElement row : rowElements) {
            if (i==0) {
                i++;
            }
            else {
                WebElement colElement = row.findElement(By.xpath(".//td[7]"));
                WebElement clickColElement = row.findElement(By.xpath(".//td[2]"));
                String colName = "Existing";
                if (Browser.getTextFromElement(colElement).equals(colName)) {
                    Browser.clickOnElement(colElement);
                    break;
                }
            }
        }
    }
}