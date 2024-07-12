package Pages;

import Framework.Browser;
import Framework.Constants.Constants.PageTitle;
import Framework.Root.PbNUIApp;
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

    public void clickOnWidgets() {
        WebElement widgetsTab = DriverManager.getInstance().Driver.findElement(By.xpath("//a[@id='appointment-booking-page-tab-Widgets']"));
        Browser.clickOnElement(widgetsTab);
        WebElement colourScheme = DriverManager.getInstance().Driver.findElement(By.xpath("//*[text()='Color Scheme:']"));
        Browser.waitForElementToDisplay(colourScheme);
    }

    public void createAppointmentURLAndNavigate() {
        Browser.waitForElementToBeVisible(By.xpath("//span[contains(text(),'https://www.patientsreach.com/schedule/qwerty')]"));
        WebElement eUrl = DriverManager.getInstance().Driver.findElement(By.xpath("(//span[contains(text(),'https://www.patientsreach.com/schedule/')])[1]"));
        String urlText = eUrl.getText();
        String[] arrOfStr = urlText.split("schedule");
        String URL = ConfigManager.getInstance().getProperty("URL");
        URL = String.join("", URL, "/schedule", arrOfStr[1]);
        Browser.navigateToNewURL(URL);
    }

    public void clickOnAppointmentSettingTab() {
        WebElement appointmentSetting = DriverManager.getInstance().Driver.findElement(By.xpath("//a[@id='appointment-booking-page-tab-Settings']"));
        Browser.clickOnElement(appointmentSetting);
        Browser.waitForPresenceOfElement(By.xpath("//label[contains(text(),'Auto update the PMS with the booked appointments')]/input[@type='checkbox']"));
        Browser.waitForElementToBeVisible(DriverManager.getInstance().Driver.findElement(By.xpath("//label[contains(text(),'Auto update the PMS with the booked appointments')]/input[@type='checkbox']")));
    }

    public void clickOnAppointmentListTab() {
        WebElement appointmentList = DriverManager.getInstance().Driver.findElement(By.xpath("//a[@id='appointment-booking-page-tab-Appointment List']"));
        Browser.clickOnElement(appointmentList);
    }

    public void clickOnAppointmentTemplateTab() {
        WebElement appointmentList = DriverManager.getInstance().Driver.findElement(By.xpath("//a[@id='appointment-booking-page-tab-Templates']"));
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

    public void clickOnEnableInsurance() {
        WebElement disableInsurance = DriverManager.getInstance().Driver.findElement(By.id("insurance-active"));
        Browser.scrollToVisibleElement(disableInsurance);
        if (!disableInsurance.isSelected()) {
            Browser.clickOnElementUsingJavascript(disableInsurance);
        }
    }

    public void clickOnSaveButton() {
        Browser.waitForElementToBeVisible(By.xpath("//div[@class='modal-footer']/button[@class='btn btn-primary']"));
        Browser.waitForElementToBeClickable(By.xpath("//div[@class='modal-footer']/button[@class='btn btn-primary']"));
        WebElement saveButton = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@class='modal-footer']/button[@class='btn btn-primary']"));
        Browser.scrollToVisibleElement(saveButton);
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
        Browser.waitForElementToBeVisible(By.xpath("//h3[text()='Credit Card Setup']"));
        Browser.waitForPresenceOfElement(By.xpath("//input[@id='card-setup-toggle']"));
        WebElement enableCreditCard = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@id='card-setup-toggle']"));
        Browser.waitForElementToBeVisible(enableCreditCard.findElement(By.xpath("./..")));
        Browser.scrollToVisibleElement(enableCreditCard);
        if (!enableCreditCard.isSelected()) {
            Browser.clickOnElementUsingJavascript(enableCreditCard);
        }
    }

    public void clickOnDisableCreditCard() {
        Browser.waitForElementToBeVisible(By.xpath("//h3[text()='Credit Card Setup']"));
        Browser.waitForPresenceOfElement(By.xpath("//input[@id='card-setup-toggle']"));
        WebElement enableCreditCard = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@id='card-setup-toggle']"));
        Browser.waitForElementToBeVisible(enableCreditCard.findElement(By.xpath("./..")));
        Browser.scrollToVisibleElement(enableCreditCard);
        if (enableCreditCard.isSelected()) {
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
        Browser.waitForElementToBeVisible(By.xpath("//label[text()='Blocked Out Times']"));
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
        Browser.waitForElementToBeVisible(By.xpath("//h3[text()='Providers']"));
        WebElement providerHeader = DriverManager.getInstance().Driver.findElement(By.xpath("//h3[text()='Providers']"));
        Browser.scrollToVisibleElement(providerHeader);
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
        Browser.waitForElementToBeVisible(By.xpath("//span[text()='15 Minutes']"));
        WebElement select15MinCheckbox = DriverManager.getInstance().Driver.findElement(By.xpath("//span[text()='15 Minutes']"));
        Browser.clickOnElement(select15MinCheckbox);
    }

    public void clickOnExistingPatient() {
        WebElement appointmentTable = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@class='react-bootstrap-table table-responsive']"));
        Browser.waitForTableToLoad(appointmentTable);
        List<WebElement> rowElements = DriverManager.getInstance().Driver.findElements(By.xpath("//div[@class='react-bootstrap-table table-responsive']//tr"));
        int i = 0;
        for (WebElement row : rowElements) {
            if (i == 0) {
                i++;
            } else {
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
            if (i == 0) {
                i++;
            } else {
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

    public void clickOnSortTableButton() {
        Browser.waitForElementToBeVisible(By.xpath("//div[@class='react-bootstrap-table table-responsive']//tr[1]/th[3]"));
        WebElement sortProvider = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@class='react-bootstrap-table table-responsive']//tr[1]/th[3]"));
        Browser.clickOnElement(sortProvider);
    }

    public void enterPatientNameInSearchBox(String patientName) {
        WebElement searchBox = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@placeholder='Search by Patient Name']"));
        Browser.enterTextInEditBox(searchBox, patientName);
    }

    public void verifyPatientNameInAppointmentList() {
        boolean check = false;
        Browser.waitForTableToFinishShrinking(By.xpath("//div[@class='react-bootstrap-table table-responsive']//tr"));
        List<WebElement> verifyPatientName = DriverManager.getInstance().Driver.findElements(By.xpath("//div[@class='react-bootstrap-table table-responsive']//tr//td//div//span"));
        for (WebElement element : verifyPatientName) {
            if (PbNUIApp.userdata().getFirstName(1,"5").equals(element.getText()) ) {
                Assert.assertEquals("Patient Found", PbNUIApp.userdata().getFirstName(1,"5"), element.getText());
                check = true;
                break;
            }
        }
        Assert.assertTrue("Patient Not Found", check);
    }

    public void clickOnProviderTimeAvailabilityCheckbox() {
        Browser.waitForPresenceOfElement(By.xpath("//label[contains(text(),'Provider Time Availability')]/input[@type='checkbox']"));
        Browser.waitForElementToBeVisible(DriverManager.getInstance().Driver.findElement(By.xpath("//label[contains(text(),'Provider Time Availability')]/input[@type='checkbox']")));
        WebElement providerTimeAvailabilityCheckBox = DriverManager.getInstance().Driver.findElement(By.xpath("//label[contains(text(),'Provider Time Availability')]/input[@type='checkbox']"));
        Browser.scrollToVisibleElement(providerTimeAvailabilityCheckBox);
        if (!providerTimeAvailabilityCheckBox.isSelected()) {
            Browser.clickOnElement(providerTimeAvailabilityCheckBox);
        }
        Assert.assertTrue("Provider Time Availability is not selected", providerTimeAvailabilityCheckBox.isSelected());
    }

    public void uncheckOnProviderTimeAvailabilityCheckbox() {
        Browser.waitForPresenceOfElement(By.xpath("//label[contains(text(),'Provider Time Availability')]/input[@type='checkbox']"));
        Browser.waitForElementToBeVisible(DriverManager.getInstance().Driver.findElement(By.xpath("//label[contains(text(),'Provider Time Availability')]/input[@type='checkbox']")));
        WebElement providerTimeAvailabilityCheckBox = DriverManager.getInstance().Driver.findElement(By.xpath("//label[contains(text(),'Provider Time Availability')]/input[@type='checkbox']"));
        Browser.scrollToVisibleElement(providerTimeAvailabilityCheckBox);
        if (providerTimeAvailabilityCheckBox.isSelected()) {
            Browser.clickOnElement(providerTimeAvailabilityCheckBox);
        }
        Assert.assertFalse("Provider Time Availability is selected", providerTimeAvailabilityCheckBox.isSelected());
    }

    public void clickOnBlockedPatientToggleButton() {
        Browser.waitForElementToBeVisible(DriverManager.getInstance().Driver.findElement(By.xpath("//h4[text()='Blocked Patient']")));
        WebElement blockPatientToggle = DriverManager.getInstance().Driver.findElement(By.xpath("//*[@id='template-toggle-blocked_patient']"));
        Browser.scrollToVisibleElement(blockPatientToggle);
        if (blockPatientToggle.isSelected()) {
            Browser.clickOnElementUsingJavascript(blockPatientToggle);
        }
        Assert.assertFalse("Blocked Patient Toggle Button is not disabled", blockPatientToggle.isSelected());
    }

    public void clickOnConflictedAppointmentToggleButton() {
        WebElement conflictedAppointmentToggle = DriverManager.getInstance().Driver.findElement(By.xpath("//*[@id='template-toggle-conflicted_appointment_email']"));
        Browser.scrollToVisibleElement(conflictedAppointmentToggle);
        if (conflictedAppointmentToggle.isSelected()) {
            Browser.clickOnElementUsingJavascript(conflictedAppointmentToggle);
        }
        Assert.assertFalse("Conflicted Appointment Toggle Button is not disabled", conflictedAppointmentToggle.isSelected());
    }

    public void clickOnExistingPatientBookedAppointmentToggleButton() {
        Browser.waitForElementToBeVisible(DriverManager.getInstance().Driver.findElement(By.xpath("//h4[text()='Blocked Patient']")));
        Browser.waitForPresenceOfElement(By.xpath("//input[@id='template-toggle-existing_patient_booked_appointment']"));
        WebElement existingPatientBookedAppointmentToggle = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@id='template-toggle-existing_patient_booked_appointment']"));
        Browser.scrollToVisibleElement(existingPatientBookedAppointmentToggle);
        if (existingPatientBookedAppointmentToggle.isSelected()) {
            Browser.clickOnElementUsingJavascript(existingPatientBookedAppointmentToggle);
        }
        Assert.assertFalse("Existing Patient Booked Appointment Toggle Button is not disabled", existingPatientBookedAppointmentToggle.isSelected());
    }

    public void clickOnNewPatientBookedAppointmentToggleButton() {
        WebElement newPatientBookedAppointmentToggle = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@id='template-toggle-new_patient_booked_appointment']"));
        Browser.scrollToVisibleElement(newPatientBookedAppointmentToggle);
        if (newPatientBookedAppointmentToggle.isSelected()) {
            Browser.clickOnElementUsingJavascript(newPatientBookedAppointmentToggle);
        }
        Assert.assertFalse("New Patient Booked Appointment Toggle Button is not disabled", newPatientBookedAppointmentToggle.isSelected());
    }

    public void clickOnClusterAppointmentsCheckbox() {
        Browser.waitForPresenceOfElement(By.xpath("//label[contains(text(),'Cluster Appointments')]/input[@type='checkbox']"));
        Browser.waitForElementToBeVisible(DriverManager.getInstance().Driver.findElement(By.xpath("//label[contains(text(),'Cluster Appointments')]/input[@type='checkbox']")));
        WebElement clusterAppointmentsCheckBox = DriverManager.getInstance().Driver.findElement(By.xpath("//label[contains(text(),'Cluster Appointments')]/input[@type='checkbox']"));
        Browser.scrollToVisibleElement(clusterAppointmentsCheckBox);
        if (!clusterAppointmentsCheckBox.isSelected()) {
            Browser.clickOnElement(clusterAppointmentsCheckBox);
        }
        Assert.assertTrue("Cluster Appointments checkbox is not selected", clusterAppointmentsCheckBox.isSelected());
    }

    public void clickOnSettingIconButton() {
        Browser.waitForElementToBeVisible(DriverManager.getInstance().Driver.findElement(By.xpath("//button[@class='btn btn-default']//i[@class='fa fa-cog']")));
        WebElement settingIconButton = DriverManager.getInstance().Driver.findElement(By.xpath("//button[@class='btn btn-default']//i[@class='fa fa-cog']"));
        Browser.clickOnElement(settingIconButton);
    }

    public void clickOnLanguageTab() {
        Browser.waitForElementToBeVisible(DriverManager.getInstance().Driver.findElement(By.xpath("//a[@id='communication-settings-modal-side-bar-tab-open_languages_block']")));
        WebElement languageTab = DriverManager.getInstance().Driver.findElement(By.xpath("//a[@id='communication-settings-modal-side-bar-tab-open_languages_block']"));
        Browser.clickOnElement(languageTab);
    }

    public void clickOnSpanishLanguageToggleButton() {
        Browser.waitForPresenceOfElement(By.xpath("//*[@id='communication-settings-modal-side-bar-pane-open_languages_block']//div[@class='custom-control custom-switch ']/input"));
        WebElement spanishLanguageToggleButton = DriverManager.getInstance().Driver.findElement(By.xpath("//*[@id='communication-settings-modal-side-bar-pane-open_languages_block']"));
        Browser.clickOnElementUsingJavascript(spanishLanguageToggleButton.findElement(By.xpath(".//div[@class='custom-control custom-switch ']/input")));
        Browser.waitForElementToBeVisible(By.xpath("//div[@class='react-toast-notifications__toast__content css-1ad3zal']"));
        WebElement successMessage = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@class='react-toast-notifications__toast__content css-1ad3zal']"));
        String successMsg = "Language settings updated";
        Assert.assertEquals("Language settings successfully updated", successMsg, successMessage.getText());
    }

    public void clickOnResetButton() {
        Browser.waitForElementToBeVisible(DriverManager.getInstance().Driver.findElement(By.xpath("//button[@class='btn btn-default']//span")));
        WebElement resetButton = DriverManager.getInstance().Driver.findElement(By.xpath("//button[@class='btn btn-default']//span"));
        if (resetButton.isDisplayed()) {
            Browser.clickOnElement(resetButton);
        }
        Assert.assertTrue("Reset button is not displayed", resetButton.isDisplayed());
        Browser.waitForElementToBeVisible(DriverManager.getInstance().Driver.findElement(By.xpath("//button[@class='btn btn-danger']")));
        WebElement yesButton = DriverManager.getInstance().Driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
        Browser.clickOnElement(yesButton);
        Browser.waitForElementToBeVisible(By.xpath("//div[@class='react-toast-notifications__toast__content css-1ad3zal']"));
        WebElement successMessage = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@class='react-toast-notifications__toast__content css-1ad3zal']"));
        String successMsg = "Template reset successful";
        Assert.assertEquals("Template reset successful", successMsg, successMessage.getText());
    }

    public void clickOnAutoUpdatePmsCheckbox() {
        Browser.waitForPresenceOfElement(By.xpath("//label[contains(text(),'Auto update the PMS with the booked appointments')]/input[@type='checkbox']"));
        Browser.waitForElementToBeVisible(DriverManager.getInstance().Driver.findElement(By.xpath("//label[contains(text(),'Auto update the PMS with the booked appointments')]/input[@type='checkbox']")));
        WebElement autoUpdatePmsCheckbox = DriverManager.getInstance().Driver.findElement(By.xpath("//label[contains(text(),'Auto update the PMS with the booked appointments')]/input[@type='checkbox']"));
        if (autoUpdatePmsCheckbox.isSelected()) {
            Browser.clickOnElement(autoUpdatePmsCheckbox);
        }
        Assert.assertFalse("Auto update the PMS with the booked appointments checkbox is selected", autoUpdatePmsCheckbox.isSelected());
        WebElement autoUpdatePmsText = DriverManager.getInstance().Driver.findElement(By.xpath("//label[contains(text(),'Auto update the PMS with the booked appointments')]"));
        String verifiedText = "Auto update the PMS with the booked appointments  ";
        Assert.assertEquals("Auto Update the PMS text verified", verifiedText, autoUpdatePmsText.getText());
    }

    public void clickOnAlertAndAutoSyncCheckbox() {
        WebElement alertAndAutoSyncCheckbox = DriverManager.getInstance().Driver.findElement(By.xpath("//label[contains(text(),'Alert and don’t auto sync appointments')]/input[@type='checkbox']"));
        if (!alertAndAutoSyncCheckbox.isSelected()) {
            Browser.clickOnElement(alertAndAutoSyncCheckbox);
        }
        Assert.assertTrue("Auto update the PMS with the booked appointments checkbox is not selected", alertAndAutoSyncCheckbox.isSelected());
        WebElement alertAndAutoSyncText = DriverManager.getInstance().Driver.findElement(By.xpath("//label[contains(text(),'Alert and don’t auto sync appointments')]"));
        String applicationText = alertAndAutoSyncText.getText();
        String verifiedText = "Alert and don’t auto sync appointments for patients who book as existing patients but we are unable to find a matching patient record. By default, our system will create a new patient in that case. By turning on this feature, our system will allow you to link an existing patient record to the requested appointment. We do not recommend enabling this feature.";
        Assert.assertEquals("Alert and don’t auto sync appointments", verifiedText, alertAndAutoSyncText.getText());
    }
    
    public void appointmentAvailabilityColumnRadioButton() {
        Browser.waitForPresenceOfElement(By.xpath("//label[contains(text(),'Provider Time Availability')]/input[@type='checkbox']"));
        Browser.waitForElementToBeVisible(DriverManager.getInstance().Driver.findElement(By.xpath("//label[contains(text(),'Provider Time Availability')]/input[@type='checkbox']")));
        WebElement appointmentAvailabilityColumnRadioButton = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@class='radio-container-1']//label//input"));
        Browser.scrollToVisibleElement(appointmentAvailabilityColumnRadioButton);
        Assert.assertTrue("Appointment Time Interval Radio Button is not selected", appointmentAvailabilityColumnRadioButton.isSelected());
    }

    public void appointmentAvailabilityColumnRadioButtons() {
        Browser.waitForPresenceOfElement(By.xpath("//label[contains(text(),'Provider Time Availability')]/input[@type='checkbox']"));
        Browser.waitForElementToBeVisible(DriverManager.getInstance().Driver.findElement(By.xpath("//label[contains(text(),'Provider Time Availability')]/input[@type='checkbox']")));
        WebElement appointmentAvailabilityColumn = DriverManager.getInstance().Driver.findElement(By.xpath("//label[contains(text(),'Appointment Time Interval')]"));
        Browser.scrollToVisibleElement(appointmentAvailabilityColumn);
        Assert.assertTrue("Appointment Time Interval Column is not displayed", appointmentAvailabilityColumn.isDisplayed());
    }

    public void appointmentAvailabilityColumnRadioButtons1() {
        Browser.waitForPresenceOfElement(By.xpath("//label[contains(text(),'Provider Time Availability')]/input[@type='checkbox']"));
        Browser.waitForElementToBeVisible(DriverManager.getInstance().Driver.findElement(By.xpath("//label[contains(text(),'Provider Time Availability')]/input[@type='checkbox']")));
        WebElement appointmentAvailabilityColumnRadioButton10Minutes = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@class='radio-container-1']//label//input"));
        Browser.scrollToVisibleElement(appointmentAvailabilityColumnRadioButton10Minutes);
        Assert.assertTrue("Appointment Time Interval 10 minutes Radio Button is not displayed", appointmentAvailabilityColumnRadioButton10Minutes.isDisplayed());
        WebElement appointmentAvailabilityColumnRadioButton15Minutes = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@class='radio-container-2']//label//input"));
        Browser.scrollToVisibleElement(appointmentAvailabilityColumnRadioButton15Minutes);
        Assert.assertTrue("Appointment Time Interval 15 minutes Radio Button is not displayed", appointmentAvailabilityColumnRadioButton15Minutes.isDisplayed());
    }
}