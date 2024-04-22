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
        PbNUIApp.appointmentsPage().enterStartDate("01/01/2024");
        PbNUIApp.appointmentsPage().enterEndDate("31/12/2024");
    }

    @Then("I will be able to see appointments list page list")
    public void iWillBeAbleToSeeAppointmentsListPageList() {
    }
}
