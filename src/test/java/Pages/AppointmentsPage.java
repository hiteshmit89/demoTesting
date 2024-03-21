package Pages;

import Framework.Browser;
import Framework.Constants.Constants.PageTitle;
import Framework.Util.ConfigManager;
import Framework.Util.DriverManager;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppointmentsPage extends BasePage {

    public AppointmentsPage(PageTitle title) {
        super(title);
    }

    private WebElement header = DriverManager.getInstance().Driver.findElement(By.xpath("//*[@id='appointment-booking']//span[text()='Online Appointment Booking']"));
    private WebElement eUrl = DriverManager.getInstance().Driver.findElement(By.xpath("(//span[contains(text(),'https://www.patientsreach.com/schedule/')])[1]"));

    public void clickOnWidgets() {
        WebElement widgetsTab = DriverManager.getInstance().Driver.findElement(By.xpath("//a[@id='appointment-booking-page-tab-Widgets']"));
        Browser.clickOnElement(widgetsTab);
    }

    public void createAppointmentURLAndNavigate() {
        String urlText = eUrl.getText();
        String[] arrOfStr = urlText.split("schedule");
        String URL = ConfigManager.getInstance().getProperty("URL");
        URL = String.join("", URL, "/schedule", arrOfStr[1]);
        Browser.navigateToNewURL(URL);
    }

    public void clickOnAppointmentSettingTab() {
        WebElement appointmentSetting = DriverManager.getInstance().Driver.findElement(By.xpath("//a[@id='appointment-booking-page-tab-Settings']"));
        Browser.clickOnElement(appointmentSetting);
    }

    public void clickOnSetupInsurance() {
        WebElement setupInsuranceButton = DriverManager.getInstance().Driver.findElement(By.xpath("//button[text()='Setup Insurances']"));
        Browser.scrollToVisibleElement(setupInsuranceButton);
       // Browser.clickOnElement(setupInsuranceButton);
        setupInsuranceButton.click();
        //input[@id='insurance-active']
    }

    
}


