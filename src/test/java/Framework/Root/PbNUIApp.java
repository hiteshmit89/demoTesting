package Framework.Root;

import DataModels.UserData;
import Pages.AppointmentsPage;
import Pages.HomePage;
import Pages.LoginPage;
import Framework.Constants.Constants;
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

    public static AppointmentsPage appointmentsPage() {
        return new AppointmentsPage(AppointmentsTitle);
    }
}

