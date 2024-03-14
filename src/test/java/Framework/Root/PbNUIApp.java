package Framework.Root;

import DataModels.UserData;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.SettingsPage;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

import static Framework.Constants.Constants.PageTitle.*;

public class PbNUIApp {
    private static UserData userdata = new UserData();
    public static UserData userdata(){
        ObjectMapper om = new ObjectMapper();
        try {
            userdata = om.readValue(new File("src/test/resources/Data/Userdata.json"), UserData.class);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return userdata;
    }
    public static LoginPage loginPage() {
        return new LoginPage(LoginTitle);
    }

    public static HomePage homePage() {
        return new HomePage(HomeTitle);
    }
    public static SettingsPage settingsPage() {

        return new SettingsPage(SettingsTitle);
    }
}
