package Framework.Root;

import DataModels.UserData;
import Pages.*;
import Pages.Modals.PatientOverviewPage;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import static Framework.Constants.Constants.PageTitle.*;

public class PbNUIApp {
    private static UserData userdata = new UserData();

    public static UserData userdata() {
        ObjectMapper om = new ObjectMapper();
        try {
            userdata = om.readValue(new File("src/test/resources/Data/Userdata.json"), UserData.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return userdata;
    }

    public static LoginPage loginPage() {
        return new LoginPage(LoginTitle);
    }

    public static FormsPage formsPage() {
        return new FormsPage(FormsTitle);
    }

    public static AppHomePage appHomePage() {
        return new AppHomePage(HomeTitle);
    }

    public static PracticeHomePage practiceHomePage() {
        return new PracticeHomePage(HomeTitle);
    }

    public static CampaignsPage campaignsPage() {
        return new CampaignsPage(CampaignsTitle);
    }

    public static SettingsPage settingsPage() {
        return new SettingsPage(SettingsTitle);
    }
        public static PaymentsPage paymentsPage() {
        return new PaymentsPage(PaymentsTitle); }

    public static Navigator navigator() {
        return new Navigator();
    }

    public static AppointmentsPage appointmentsPage() {
        return new AppointmentsPage(AppointmentsTitle);
    }

    public static TasksPage tasksPage() {
        return new TasksPage(TasksTitle);
    }

    public static AppointmentBookingPage appointmentBookingPage() {
        return new AppointmentBookingPage(AppointmentBookingTitle);
    }

    public static PatientOverviewPage patientOverviewPage() {
        return new PatientOverviewPage(HomeTitle);
        }

        public static OnlinePaymentPortalPage OnlinePaymentPortalPage () {
        return new OnlinePaymentPortalPage(OnlinePaymentPortalTitle);
    }
}
