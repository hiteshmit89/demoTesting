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
        Browser.waitForElementToBeVisible((By.xpath("//a[@id='appointment-booking-page-tab-Widgets']")));
        Browser.waitForElementToBeClickable((By.xpath("//a[@id='appointment-booking-page-tab-Widgets']")));
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
        Browser.waitForPageReady();
    }

    public void clickOnSetupInsurance() {
        Browser.waitForElementToBeVisible((By.xpath("//button[text()='Setup Insurances']")));
        Browser.waitForElementToBeClickable((By.xpath("//button[text()='Setup Insurances']")));
        WebElement setupInsuranceButton = DriverManager.getInstance().Driver.findElement(By.xpath("//button[text()='Setup Insurances']"));
        Browser.scrollToVisibleElement(setupInsuranceButton);
        setupInsuranceButton.click();
    }

    public void clickOnDisableInsurance() {
        Browser.waitForElementToBeVisible(By.xpath("//label[text()='Ask Patients for their insurance Information']"));
        Browser.waitForElementToBeClickable(By.xpath("//label[text()='Ask Patients for their insurance Information']"));
        WebElement disableInsurance = DriverManager.getInstance().Driver.findElement(By.xpath("//label[text()='Ask Patients for their insurance Information']"));
        Browser.scrollToVisibleElement(disableInsurance);
        Browser.clickOnElement(disableInsurance);
    }

    public void clickOnSaveButton() {
        Browser.waitForElementToBeVisible(By.xpath("(//button[text()='Save'])[5]"));
        WebElement saveButton = DriverManager.getInstance().Driver.findElement(By.xpath("(//button[text()='Save'])[5]"));
        Browser.scrollToVisibleElement(saveButton);
        Browser.clickOnElement(saveButton);
    }
    public void clickOnSettingSaveButton() {
        Browser.waitForElementToBeVisible(By.xpath("//div[@class='bottom-buttons-row']//button[text()='Save']"));
        Browser.waitForElementToBeClickable(By.xpath("//div[@class='bottom-buttons-row']//button[text()='Save']"));
        Browser.waitForPageReady();
        WebElement saveButton = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@class='bottom-buttons-row']//button[text()='Save']"));
        Browser.scrollToVisibleElement(saveButton);
        Browser.clickUsingJavascript(saveButton);
    }
    public void clickOnSetupCreditCard() {
        Browser.waitForElementToBeVisible((By.xpath("//button[text()='Setup Credit Card Collection']")));
        Browser.waitForElementToBeClickable((By.xpath("//button[text()='Setup Credit Card Collection']")));
        WebElement setupInsuranceButton = DriverManager.getInstance().Driver.findElement(By.xpath("//button[text()='Setup Credit Card Collection']"));
        Browser.scrollToVisibleElement(setupInsuranceButton);
        setupInsuranceButton.click();
    }
    public void clickOnEnableCreditCard() {
        WebElement enableCreditCard = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@id='card-setup-toggle']"));
        Browser.scrollToVisibleElement(enableCreditCard);
        Browser.clickUsingJavascript(enableCreditCard);

    }
}


