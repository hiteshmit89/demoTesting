package StepDefinitions.Appointments;

import Framework.Browser;
import Framework.Constants.Constants;
import Framework.Root.PbNUIApp;
import Framework.Util.ConfigManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AppointmentCreditCardFeature {
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
        PbNUIApp.appHomePage().clickOnPracticeInPracticeInfoTable(PbNUIApp.userdata().getPractices().getFirst().getPractice_name());
        PbNUIApp.navigator().NavigateTo(Constants.Destination.Appointments);
        PbNUIApp.appointmentsPage().clickOnAppointmentSettingTab();
        PbNUIApp.appointmentsPage().clickOnSetupCreditCard();
        PbNUIApp.appointmentsPage().clickOnEnableCreditCard();
        PbNUIApp.appointmentsPage().clickOnSaveButton();
        PbNUIApp.appointmentsPage().clickOnSettingSaveButton();
    }
}
