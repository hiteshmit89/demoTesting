package Framework.Root;

import DataModels.UserData;
import Framework.Util.ConfigManager;
import Pages.*;
import Pages.PatientPortal.PatientPortalDashboardPage;
import Pages.PatientPortal.PatientPortalLoginPage;
import com.fasterxml.jackson.databind.ObjectMapper;
import Pages.PatientPortal.PatientPortalSelectPracticePage;

import java.io.File;

import static Framework.Constants.Constants.PageTitle.*;

public class PbNUIApp {
    private static UserData userdata = new UserData();

    public static UserData userdata() {
        ObjectMapper om = new ObjectMapper();
        try {
            switch (ConfigManager.getInstance().getProperty("Environment").toUpperCase()) {
                case "QA3":
                    userdata = om.readValue(new File("src/test/resources/Data/QA3Userdata.json"), UserData.class);
                    break;
                case "QA2":
                    userdata = om.readValue(new File("src/test/resources/Data/QA2Userdata.json"), UserData.class);
                    break;
                default:
                    userdata = om.readValue(new File("src/test/resources/Data/QA1Userdata.json"), UserData.class);
            }
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
        return new PaymentsPage(PaymentsTitle);
    }

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

    public static OnlinePaymentPortalPage OnlinePaymentPortalPage() {
        return new OnlinePaymentPortalPage(OnlinePaymentPortalTitle);
    }

    public static RevenueIQPage revenueIQPage() {
        return new RevenueIQPage(RevenueIQTitle);
    }

    public static PatientPortalLoginPage patientPortalLoginPage() {
        return new PatientPortalLoginPage(PatientPortalLoginPageTitle);}

    public static PatientPortalSelectPracticePage patientPortalSelectPracticePage() {
        return new PatientPortalSelectPracticePage(PatientPortalSelectPracticePageTitle);
    }
    public static PatientPortalDashboardPage patientPortalDashboardPage() {
        return new PatientPortalDashboardPage(PatientPortalDashboardPageTitle);
    }
}


