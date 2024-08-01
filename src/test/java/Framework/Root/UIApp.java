package Framework.Root;

import Framework.Util.ConfigManager;
import Pages.*;
import Pages.PatientPortal.PatientPortalDashboardPage;
import Pages.PatientPortal.PatientPortalLoginPage;
import com.fasterxml.jackson.databind.ObjectMapper;
import Pages.PatientPortal.PatientPortalSelectPracticePage;

import java.io.File;

import static Framework.Constants.Constants.PageTitle.*;

public class PbNUIApp {

    public static LoginPage loginPage() {
        return new LoginPage(LoginTitle);
    }

    public static AppHomePage appHomePage() {
        return new AppHomePage(HomeTitle);
    }
}


