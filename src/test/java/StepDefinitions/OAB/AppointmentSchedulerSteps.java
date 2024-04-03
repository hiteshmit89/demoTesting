package StepDefinitions.OAB;

import Framework.Root.PbNUIApp;
import io.cucumber.java.en.And;
import static Framework.Constants.Constants.Sections.Schedule;

public class AppointmentSchedulerSteps {

    @And("I click on schedule on floating chatbox")
    public void iClickOnScheduleOnFloatingChatbox() {
        PbNUIApp.navigator().ClickOnFloatingButton(Schedule);
    }
}
