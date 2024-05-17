package StepDefinitions.Appointments;

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
}
