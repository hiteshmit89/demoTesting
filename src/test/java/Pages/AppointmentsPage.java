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
        Browser.waitForElementToDisplay(widgetsTab);
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
        Browser.clickOnElementUsingJavascript(setupInsuranceButton);
    }

    public void clickOnDisableInsurance() {
        WebElement disableInsurance = DriverManager.getInstance().Driver.findElement(By.xpath("//label[text()='Ask Patients for their insurance Information']"));
        Browser.scrollToVisibleElement(disableInsurance);
        Browser.clickOnElementUsingJavascript(disableInsurance);
    }

    public void clickOnSaveButton() {
        WebElement saveButton = DriverManager.getInstance().Driver.findElement(By.xpath("(//button[text()='Save'])[5]"));
        Browser.scrollToVisibleElement(saveButton);
        Browser.waitForElementToBeClickable(saveButton);
        Browser.clickOnElementUsingJavascript(saveButton);
    }

    public void clickOnSettingSaveButton() {
        WebElement saveButton = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@class='bottom-buttons-row']//button[text()='Save']"));
        Browser.scrollToVisibleElement(saveButton);
        Browser.clickOnElementUsingJavascript(saveButton);
    }

    public void clickOnSetupCreditCard() {
        Browser.waitForElementToBeVisible(By.xpath("//button[text()='Setup Credit Card Collection']"));
        WebElement setupCreditCardButton = DriverManager.getInstance().Driver.findElement(By.xpath("//button[text()='Setup Credit Card Collection']"));
        Browser.scrollToVisibleElement(setupCreditCardButton);
        Browser.clickOnElement(setupCreditCardButton);
        //Browser.clickOnElementUsingJavascript(setupInsuranceButton);
    }

    public void clickOnEnableCreditCard() {
        WebElement enableCreditCard = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@id='card-setup-toggle']"));
        Browser.scrollToVisibleElement(enableCreditCard);
        Browser.clickOnElementUsingJavascript(enableCreditCard);
    }
}