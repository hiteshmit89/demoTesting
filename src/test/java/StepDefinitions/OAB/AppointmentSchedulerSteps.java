package StepDefinitions.OAB;

import Framework.Browser;
import Framework.Root.PbNUIApp;
import Pages.Modals.AppointmentScheduleModal;
import Pages.Modals.CreateAppointmentModal;
import Pages.Modals.PBNModals;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Pages.*;

import static Framework.Constants.Constants.Sections.Schedule;

public class AppointmentSchedulerSteps {

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
}
