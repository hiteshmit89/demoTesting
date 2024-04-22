package StepDefinitions.Appointments;

import Framework.Browser;
import Framework.Constants.Constants;
import Framework.Root.PbNUIApp;
import Framework.Util.ConfigManager;
import Pages.Modals.PBNModals;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static Framework.Constants.Constants.Sections.Schedule;

public class AppointmentsStepdefinition {
    @When("I click on appointments Setting tab and activate credit card settings")
    public void iClickOnAppointmentsSettingTabAndActivateCreditCardSettings() {
        PbNUIApp.navigator().NavigateTo(Constants.Destination.Appointments);
        PbNUIApp.appointmentsPage().clickOnAppointmentSettingTab();
        PbNUIApp.appointmentsPage().clickOnSetupCreditCard();
        PbNUIApp.appointmentsPage().clickOnEnableCreditCard();
        PbNUIApp.appointmentsPage().clickOnSaveButton();
        PbNUIApp.appointmentsPage().clickOnSettingSaveButton();
        PbNUIApp.appointmentsPage().clickOnWidgets();
        PbNUIApp.appointmentsPage().createAppointmentURLAndNavigate();
    }

    @And("I click on appointment tab and try to book appointment")
    public void iClickOnAppointmentTabAndTryToBookAppointment() {
        PbNUIApp.appointmentBookingPage().clickOnPickLocation();
        PbNUIApp.appointmentBookingPage().clickOnSelectNewPatient();
        PbNUIApp.appointmentBookingPage().clickOnEmergencyConsult();
        PbNUIApp.appointmentBookingPage().clickOnEarliest();
        PbNUIApp.appointmentBookingPage().fillAppointmentBookingForm();
        PbNUIApp.appointmentBookingPage().clickOnCheckBox();
        PbNUIApp.appointmentBookingPage().clickOnNextButton();
    }

    @Then("I will be able to see credit card page on appointment booking page.")
    public void iWillBeAbleToSeeCreditCardPageOnAppointmentBookingPage() {
        PbNUIApp.appointmentBookingPage().verifyCreditCardPage();
        Browser.navigateToNewURL(ConfigManager.getInstance().getProperty("URL"));
        PbNUIApp.appHomePage().clickOnPracticeInPracticeInfoTable(PbNUIApp.userdata().getPracticeName(0));
        PbNUIApp.navigator().NavigateTo(Constants.Destination.Appointments);
        PbNUIApp.appointmentsPage().clickOnAppointmentSettingTab();
        PbNUIApp.appointmentsPage().clickOnSetupCreditCard();
        PbNUIApp.appointmentsPage().clickOnEnableCreditCard();
        PbNUIApp.appointmentsPage().clickOnSaveButton();
        PbNUIApp.appointmentsPage().clickOnSettingSaveButton();
    }

    @When("I click on appointments Setting tab and deactivate insurance settings")
    public void iClickOnAppointmentsSettingTabAndDeactivateInsuranceSettingsAndTryToBookAppointment() {
        PbNUIApp.navigator().NavigateTo(Constants.Destination.Appointments);
        PbNUIApp.appointmentsPage().clickOnAppointmentSettingTab();
        PbNUIApp.appointmentsPage().clickOnSetupInsurance();
        PbNUIApp.appointmentsPage().clickOnDisableInsurance();
        PbNUIApp.appointmentsPage().clickOnSaveButton();
        PbNUIApp.appointmentsPage().clickOnSettingSaveButton();
        PbNUIApp.appointmentsPage().clickOnWidgets();
        PbNUIApp.appointmentsPage().createAppointmentURLAndNavigate();
    }

    @And("I click on appointments tab and try to book appointment")
    public void iClickOnAppointmentsTabAndTryToBookAppointment() {
        PbNUIApp.appointmentBookingPage().clickOnPickLocation();
        PbNUIApp.appointmentBookingPage().clickOnSelectNewPatient();
        PbNUIApp.appointmentBookingPage().clickOnEmergencyConsult();
        PbNUIApp.appointmentBookingPage().clickOnEarliest();
        PbNUIApp.appointmentBookingPage().fillAppointmentBookingForm();
        PbNUIApp.appointmentBookingPage().clickOnCheckBox();
        PbNUIApp.appointmentBookingPage().clickOnNextButton();
    }

    @Then("I will not be able to see insurance page on appointment booking page.")
    public void iWillNotBeAbleToSeeInsurancePageOnAppointmentBookingPage() {
        PbNUIApp.appointmentBookingPage().verifyInsurancePage();
        Browser.navigateToNewURL(ConfigManager.getInstance().getProperty("URL"));
        PbNUIApp.appHomePage().clickOnPracticeInPracticeInfoTable(PbNUIApp.userdata().getPracticeName(0));
        PbNUIApp.navigator().NavigateTo(Constants.Destination.Appointments);
        PbNUIApp.appointmentsPage().clickOnAppointmentSettingTab();
        PbNUIApp.appointmentsPage().clickOnSetupInsurance();
        PbNUIApp.appointmentsPage().clickOnDisableInsurance();
        PbNUIApp.appointmentsPage().clickOnSaveButton();
        PbNUIApp.appointmentsPage().clickOnSettingSaveButton();
    }

    @When("I click on appointments tab and try to book appointments for inactive patient who has insurance")
    public void iClickOnAppointmentsTabAndTryToBookAppointmentsForInactivePatientWhoHasInsurance() {
        PbNUIApp.navigator().NavigateTo(Constants.Destination.Appointments);
        PbNUIApp.appointmentsPage().clickOnWidgets();
        PbNUIApp.appointmentsPage().createAppointmentURLAndNavigate();
        PbNUIApp.appointmentBookingPage().clickOnPickLocation();
        PbNUIApp.appointmentBookingPage().clickOnSelectNewPatient();
        PbNUIApp.appointmentBookingPage().clickOnEmergencyConsult();
        PbNUIApp.appointmentBookingPage().clickOnEarliest();
        PbNUIApp.appointmentBookingPage().fillAppointmentBookingFormForInactivePatient();
        PbNUIApp.appointmentBookingPage().clickOnCheckBox();
        PbNUIApp.appointmentBookingPage().clickOnNextButton();
    }

    @When("I click on appointments tab and try to book appointments for patient who has Automation tag")
    public void iClickOnAppointmentsTabAndTryToBookAppointmentsForPatientWhoHasAutomationTag() {
        PbNUIApp.navigator().NavigateTo(Constants.Destination.Appointments);
        PbNUIApp.appointmentsPage().clickOnWidgets();
        PbNUIApp.appointmentsPage().createAppointmentURLAndNavigate();
        PbNUIApp.appointmentBookingPage().clickOnPickLocation();
        PbNUIApp.appointmentBookingPage().clickOnSelectNewPatient();
        PbNUIApp.appointmentBookingPage().clickOnEmergencyConsult();
        PbNUIApp.appointmentBookingPage().clickOnEarliest();
        PbNUIApp.appointmentBookingPage().fillAppointmentBookingFormForPatientWithTags();
        PbNUIApp.appointmentBookingPage().clickOnCheckBox();
        PbNUIApp.appointmentBookingPage().clickOnNextButton();
    }

    @Then("I will not be able to book appointment with message")
    public void iWillNotBeAbleToBookAppointmentWithMessageUnableToBookAppointment() {
        PbNUIApp.appointmentBookingPage().verifyTextDisplayedMessage("Unable to book Appointment text is not displayed on appointment booking page");
    }

    @When("I click on schedule on floating chatbox and try to book appointment from scheduler")
    public void iClickOnScheduleOnFloatingChatboxAndTryToBookAppointmentFromScheduler() {
        PbNUIApp.navigator().ClickOnFloatingButton(Schedule);
        Browser.waitForPageReady();
        PBNModals.appointmentScheduleModal().doubleClickOnAppointmentScheduleCalendarFirstProvider();
        PBNModals.createAppointmentModal().clickOnAddNewPatient();
        PBNModals.createAppointmentModal().fillAppointmentBookingDetails();
        PBNModals.createAppointmentModal().selectProvider();
        PBNModals.createAppointmentModal().appointmentType();
        PBNModals.createAppointmentModal().clickOnCreateButton();
    }

    @Then("I will be able to book appointment from scheduler")
    public void iWillBeAbleToBookAppointmentFromScheduler() {
    }

    @Given("I login to PbN app and select the practice")
    public void iLoginToPbNApp() {
        PbNUIApp.loginPage().enterEmail(PbNUIApp.userdata().getUserEmail(0,0));
        PbNUIApp.loginPage().enterPassword(PbNUIApp.userdata().getPassword(0,0));
        PbNUIApp.loginPage().clickOnLoginButton();
        PbNUIApp.appHomePage().clickOnPracticeInPracticeInfoTable(PbNUIApp.userdata().getPracticeName(0));
    }

    @When("I click on appointments tab and try to book appointments for new patient")
    public void iClickOnAppointmentsAndTryToBookAppointmentsForNewPatient() {
        PbNUIApp.navigator().NavigateTo(Constants.Destination.Appointments);
        PbNUIApp.appointmentsPage().clickOnWidgets();
        PbNUIApp.appointmentsPage().createAppointmentURLAndNavigate();
        PbNUIApp.appointmentBookingPage().clickOnPickLocation();
        PbNUIApp.appointmentBookingPage().clickOnSelectNewPatient();
        PbNUIApp.appointmentBookingPage().clickOnEmergencyConsult();
        PbNUIApp.appointmentBookingPage().clickOnEarliest();
        PbNUIApp.appointmentBookingPage().fillAppointmentBookingForm();
        PbNUIApp.appointmentBookingPage().clickOnCheckBox();
        PbNUIApp.appointmentBookingPage().clickOnNextButton();
        PbNUIApp.appointmentBookingPage().clickOnIDoNotHaveInsurance();
        PbNUIApp.appointmentBookingPage().clickOnNextButton();
        PbNUIApp.appointmentBookingPage().clickOnUseCellPhone();
        PbNUIApp.appointmentBookingPage().enterOTP("1234");
    }

    @Then("I will be able to see successful message for appointment booking.")
    public void iWillBeAbleToSeeSuccessfulMessageForAppointmentBooking() {
        PbNUIApp.appointmentBookingPage().verifySuccessfulTextDisplayed();
    }
}
