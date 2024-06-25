package StepDefinitions.Appointments;

import Framework.Browser;
import Framework.Constants.Constants;
import Framework.Root.PbNUIApp;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AppointmentsSettingsStepDefinition {

    @When("I click on appointments Setting tab open provider setting")
    public void iClickOnAppointmentsSettingTabOpenProviderSetting() {
        PbNUIApp.navigator().NavigateTo(Constants.Destination.Appointments);
        PbNUIApp.appointmentsPage().clickOnAppointmentSettingTab();
        PbNUIApp.appointmentsPage().clickOnProviderEditButton();
    }

    @Then("I will be able to see days and block-out times visibility on appointment booking setting page")
    public void iWillBeAbleToSeeDaysAndBlockOutTimesVisibilityOnAppointmentBookingSettingPage() {
        PbNUIApp.appointmentsPage().verifyBlockOutTimes();
    }

    @When("I click on appointments list page and verify appointment list")
    public void iClickOnAppointmentsListPageAndVerifyAppointmentList() {
        PbNUIApp.navigator().NavigateTo(Constants.Destination.Appointments);
        PbNUIApp.appointmentsPage().clickOnAppointmentListTab();
        PbNUIApp.appointmentsPage().enterStartDate1("01/01/2024");
        PbNUIApp.appointmentsPage().enterStartDate2("01/01/2024");
        PbNUIApp.appointmentsPage().enterEndDate("31/12/2024");
    }

    @Then("I will be able to see appointments list page list")
    public void iWillBeAbleToSeeAppointmentsListPageList() {
        PbNUIApp.appointmentsPage().verifyAppointmentList();
    }

    @When("I click on appointments setting page and verify advanced Settings window of provider")
    public void iClickOnAppointmentsSettingPageAndVerifyAdvancedSettingsWindowOfProvider() {
        PbNUIApp.navigator().NavigateTo(Constants.Destination.Appointments);
        PbNUIApp.appointmentsPage().clickOnAppointmentSettingTab();
        PbNUIApp.appointmentsPage().clickOnProviderAdvanceSettingButton();
    }

    @Then("I will be able to see advanced Settings window of provider")
    public void iWillBeAbleToSeeAdvancedSettingsWindowOfProvider() {
        PbNUIApp.appointmentsPage().verifyAllowedAge();
        PbNUIApp.appointmentsPage().verifyNoProviderSelectionCheckbox();
        PbNUIApp.appointmentsPage().verifyCheckRecallDateCheckbox();
        PbNUIApp.appointmentsPage().verifyDontAutoSyncCheckbox();
        PbNUIApp.appointmentsPage().verifySoonestAppointmentAvailable();
        PbNUIApp.appointmentsPage().verifyFarthestAppointmentAvailable();
    }

    @When("I click on appointments setting page and verify add and remove provider list and visit type from appointment setting page")
    public void iClickOnAppointmentsSettingPageAndVerifyAddAndRemoveProviderListAndVisitTypeFromAppointmentSettingPage() {
        PbNUIApp.navigator().NavigateTo(Constants.Destination.Appointments);
        PbNUIApp.appointmentsPage().clickOnAppointmentSettingTab();
    }

    @Then("I will be able to add and remove provider list and visit type from appointment setting page")
    public void iWillBeAbleToAddAndRemoveProviderListAndVisitTypeFromAppointmentSettingPage() {
        PbNUIApp.appointmentsPage().clickProviderHeader();
        PbNUIApp.appointmentsPage().clickOnAddNewVisitType();
        PbNUIApp.appointmentsPage().deleteVisitType();
    }

    @When("I click on appointments setting page and verify fifteen min radio button from appointment setting page")
    public void iClickOnAppointmentsSettingPageAndVerifyFifteenMinRadioButtonFromAppointmentSettingPage() {
        PbNUIApp.navigator().NavigateTo(Constants.Destination.Appointments);
        PbNUIApp.appointmentsPage().clickOnAppointmentSettingTab();
    }

    @Then("I will be able to select fifteen min radio button from appointment setting page")
    public void iWillBeAbleToSelectFifteenMinRadioButtonFromAppointmentSettingPage() {
        PbNUIApp.appointmentsPage().select15MinCheckbox();
    }

    @When("I click on appointments list page and verify appointment details")
    public void iClickOnAppointmentsListPageAndVerifyAppointmentDetails() {
        PbNUIApp.navigator().NavigateTo(Constants.Destination.Appointments);
        PbNUIApp.appointmentsPage().clickOnAppointmentListTab();
        PbNUIApp.appointmentsPage().enterStartDate1("01/01/2024");
        PbNUIApp.appointmentsPage().enterStartDate2("01/01/2024");
    }

    @Then("I will be able to see appointments details on page list")
    public void iWillBeAbleToSeeAppointmentsDetailsOnPageList() {
        PbNUIApp.appointmentsPage().clickOnExistingPatient();
    }

    @When("I click on appointments list page and verify patient information")
    public void iClickOnAppointmentsListPageAndVerifyPatientInformation() {
        PbNUIApp.navigator().NavigateTo(Constants.Destination.Appointments);
        PbNUIApp.appointmentsPage().clickOnAppointmentListTab();
        PbNUIApp.appointmentsPage().enterStartDate1("01/01/2024");
        PbNUIApp.appointmentsPage().enterStartDate2("01/01/2024");
        PbNUIApp.appointmentsPage().clickOutsideAppointmentList();
    }

    @Then("I will be able to see patient information on page list")
    public void iWillBeAbleToSeePatientInformationOnPageList() {
        PbNUIApp.appointmentsPage().clickOnExistingPatientInformation();
    }

    @When("I click on try to filter appointments on appointment list page")
    public void iClickOnTryToFilterAppointmentsOnAppointmentListPage() {
        PbNUIApp.navigator().NavigateTo(Constants.Destination.Appointments);
        PbNUIApp.appointmentsPage().clickOnAppointmentListTab();
    }

    @Then("I will be able to see filtered appointments on page list")
    public void iWillBeAbleToSeeFilteredAppointmentsOnPageList() {
        PbNUIApp.appointmentsPage().enterStartDate1("01/01/2024");
        PbNUIApp.appointmentsPage().enterStartDate2("01/01/2024");
    }

    @When("I try to sort columns of Appointment list table on appointment list page")
    public void iTryToSortColumnsOfAppointmentListTableOnAppointmentListPage() {
        PbNUIApp.navigator().NavigateTo(Constants.Destination.Appointments);
        PbNUIApp.appointmentsPage().clickOnAppointmentListTab();
        PbNUIApp.appointmentsPage().enterStartDate1("01/01/2024");
        PbNUIApp.appointmentsPage().enterStartDate2("01/01/2024");
    }

    @Then("I will be able to sort columns of Appointment list table on appointment list page")
    public void iWillBeAbleToSortColumnsOfAppointmentListTableOnAppointmentListPage() {
        PbNUIApp.appointmentsPage().clickOnSortTableButton();
    }

    @When("I try to search the patient with patient name on appointment list page")
    public void iTryToSearchThePatientWithPatientNameOnAppointmentListPage() {
        PbNUIApp.navigator().NavigateTo(Constants.Destination.Appointments);
        PbNUIApp.appointmentsPage().clickOnAppointmentListTab();
        PbNUIApp.appointmentsPage().enterStartDate1("01/01/2024");
        PbNUIApp.appointmentsPage().enterStartDate2("01/01/2024");
        PbNUIApp.appointmentsPage().clickOutsideAppointmentList();
    }

    @Then("I will be able to search the patient with patient name on appointment list page")
    public void iWillBeAbleToSearchThePatientWithPatientNameOnAppointmentListPage() {
        PbNUIApp.appointmentsPage().enterPatientNameInSearchBox(PbNUIApp.userdata().getFirstName(1,"5"));
        PbNUIApp.appointmentsPage().verifyPatientNameInAppointmentList();

    }

    @When("I try to click on the provider time availability checkbox on appointment settings page")
    public void iTryToClickOnTheProviderTimeAvailabilityCheckboxOnAppointmentSettingsPage() {
        PbNUIApp.navigator().NavigateTo(Constants.Destination.Appointments);
        PbNUIApp.appointmentsPage().clickOnAppointmentSettingTab();
    }

    @Then("I will be able to click on the provider time availability checkbox on appointment settings page")
    public void iWillBeAbleToClickOnTheProviderTimeAvailabilityCheckboxOnAppointmentSettingsPage() {
        PbNUIApp.appointmentsPage().clickOnProviderTimeAvailabilityCheckbox();
    }

    @When("I try to click on and disable automatic messages on appointment template page")
    public void iTryToClickOnAndDisableAutomaticMessagesOnAppointmentTemplatePage() {
        PbNUIApp.navigator().NavigateTo(Constants.Destination.Appointments);
        PbNUIApp.appointmentsPage().clickOnAppointmentTemplateTab();
    }

    @Then("I will be able to click and disable automatic messages on appointment template page")
    public void iWillBeAbleToClickAndDisableAutomaticMessagesOnAppointmentTemplatePage() {
        PbNUIApp.appointmentsPage().clickOnBlockedPatientToggleButton();
        PbNUIApp.appointmentsPage().clickOnConflictedAppointmentToggleButton();
        PbNUIApp.appointmentsPage().clickOnExistingPatientBookedAppointmentToggleButton();
        PbNUIApp.appointmentsPage().clickOnNewPatientBookedAppointmentToggleButton();
    }

    @When("I try to click on the cluster appointments checkbox on appointment settings page")
    public void iTryToClickOnTheClusterAppointmentsCheckboxOnAppointmentSettingsPage() {
        PbNUIApp.navigator().NavigateTo(Constants.Destination.Appointments);
        PbNUIApp.appointmentsPage().clickOnAppointmentSettingTab();
    }

    @Then("I will be able to click on the cluster appointments checkbox on appointment settings page")
    public void iWillBeAbleToClickOnTheClusterAppointmentsCheckboxOnAppointmentSettingsPage() {
        PbNUIApp.appointmentsPage().clickOnClusterAppointmentsCheckbox();
    }

    @When("I try to select the language on the practice specific configuration popup on appointment settings page")
    public void iTryToSelectTheLanguageOnThePracticeSpecificConfigurationPopupOnAppointmentSettingsPage() {
        PbNUIApp.navigator().NavigateTo(Constants.Destination.Appointments);
        PbNUIApp.appointmentsPage().clickOnSettingIconButton();
        PbNUIApp.appointmentsPage().clickOnLanguageTab();

    }

    @Then("I will be able to select the language on the practice specific configuration popup on appointment settings page")
    public void iWillBeAbleToSelectTheLanguageOnThePracticeSpecificConfigurationPopupOnAppointmentSettingsPage() {
        PbNUIApp.appointmentsPage().clickOnSpanishLanguageToggleButton();
    }
}
