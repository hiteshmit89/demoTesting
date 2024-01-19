package Framework.Root;

import Pages.HomePage;
import Pages.LoginPage;
import Framework.Constants.Constants;

import static Framework.Constants.Constants.PageTitle.HomeTitle;
import static Framework.Constants.Constants.PageTitle.LoginTitle;

public class PbNUIApp {
    public static LoginPage loginPage() {
        return new LoginPage(LoginTitle);
    }

    public static HomePage homePage() {
        return new HomePage(HomeTitle);
    }
}
