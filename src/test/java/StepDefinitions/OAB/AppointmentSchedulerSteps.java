package StepDefinitions.OAB;

import Framework.Root.PbNUIApp;
import Pages.Modals.AppointmentScheduleModal;
import Pages.Modals.CreateAppointmentModal;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Pages.*;

import static Framework.Constants.Constants.Sections.Schedule;

public class AppointmentSchedulerSteps {

    @When("I click on schedule on floating chatbox and try to book appointment from scheduler")
    public void iClickOnScheduleOnFloatingChatboxAndTryToBookAppointmentFromScheduler() {
        PbNUIApp.navigator().ClickOnFloatingButton(Schedule);
        AppointmentScheduleModal.doubleClickOnAppointmentScheduleCalendarFirstProvider();
        CreateAppointmentModal.clickOnAddNewPatient();
        CreateAppointmentModal.fillAppointmentBookingDetails();
        CreateAppointmentModal.selectProvider();
    }

    @Then("I will be able to book appointment from scheduler")
    public void iWillBeAbleToBookAppointmentFromScheduler() {
    }
}
