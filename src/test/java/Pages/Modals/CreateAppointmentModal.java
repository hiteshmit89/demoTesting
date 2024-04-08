package Pages.Modals;

import Framework.Browser;
import Framework.Root.PbNUIApp;
import Framework.Util.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CreateAppointmentModal {
    private WebElement modalTitle = DriverManager.getInstance().Driver.findElement(By.xpath("/html/body//div/h[@class='modal-title']"));
    private List<WebElement> appointmentCalendar = DriverManager.getInstance().Driver.findElements(By.xpath("//*[@id='chat-box']//div[@class='rbc-events-container']"));


    CreateAppointmentModal() {
        Browser.waitForElementToBeVisible(modalTitle);
        Browser.waitForPageReady();
    }

    public static void selectPatient(String patientName) {
        WebElement patientSelector = DriverManager.getInstance().Driver.findElement(By.xpath("//*[contains(text(),'Search for Patient')]"));
        Browser.clickOnElement(patientSelector);
    }

    public static void clickOnAddNewPatient() {
        WebElement addNewPatient = DriverManager.getInstance().Driver.findElement(By.xpath("//button[@class='pull-right btn btn-default']"));
        Browser.clickOnElement(addNewPatient);
    }

    public static void enterFirstName(String firstNameData) {
        Browser.waitForElementToBeVisible(By.xpath("//input[@placeholder='First Name']"));
        WebElement firstNameID = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@placeholder='First Name']"));
        Browser.enterTextInEditBox(firstNameID, firstNameData);
    }

    public static void enterLastName(String lastNameData) {
        WebElement lastNameID = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
        Browser.enterTextInEditBox(lastNameID, lastNameData);
    }

    public static void enterPhoneNumber(String phoneNumberData) {
        WebElement phoneNumberID = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@placeholder='Cell Phone Number']"));
        Browser.enterTextInEditBox(phoneNumberID, phoneNumberData);
    }

    public static void enterEmailID(String emailIdData) {
        WebElement emailID = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@placeholder='Email (optional)']"));
        Browser.enterTextInEditBox(emailID, emailIdData);
    }

    public static void enterBirthDate(String birthDateData) {
        WebElement birthDate = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@placeholder='Date of Birth']"));
        Browser.clickOnElement(birthDate);
        Browser.pressEnter();
    }

    public static void fillAppointmentBookingDetails() {
        enterFirstName(PbNUIApp.userdata().getPractices().getFirst().getFormsData().getFirst().getFirst_name());
        enterLastName(PbNUIApp.userdata().getPractices().getFirst().getFormsData().getFirst().getLast_name());
        enterPhoneNumber(PbNUIApp.userdata().getPractices().getFirst().getFormsData().getFirst().getPhone_number());
        enterEmailID(PbNUIApp.userdata().getPractices().getFirst().getFormsData().getFirst().getEmail_id());
        enterBirthDate(PbNUIApp.userdata().getPractices().getFirst().getFormsData().getFirst().getBirth_date());
    }

    public static void selectProvider() {
        WebElement provider = DriverManager.getInstance().Driver.findElement(By.xpath("(//div[@class=' css-1hwfws3'])[4]"));
        Browser.clickOnElement(provider);
        Browser.pressEnter();
    }

    public static void appointmentType() {
        WebElement appointmentType = DriverManager.getInstance().Driver.findElement(By.xpath("(//div[@class=' css-1hwfws3'])[5]"));
        Browser.clickOnElement(appointmentType);
        Browser.pressEnter();
    }

    public static void clickOnCreateButton() {
        WebElement appointmentType = DriverManager.getInstance().Driver.findElement(By.xpath("//button[text()='Create']"));
        Browser.clickOnElement(appointmentType);
    }
}