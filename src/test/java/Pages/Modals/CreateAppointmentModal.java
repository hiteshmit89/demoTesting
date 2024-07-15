package Pages.Modals;

import Framework.Browser;
import Framework.Root.PbNUIApp;
import Framework.Util.DriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CreateAppointmentModal {
    private List<WebElement> appointmentCalendar = DriverManager.getInstance().Driver.findElements(By.xpath("//*[@id='chat-box']//div[@class='rbc-events-container']"));


    CreateAppointmentModal() {
        Browser.waitForPageReady();
    }

    public void clickOnAddNewPatient() {
        WebElement addNewPatient = DriverManager.getInstance().Driver.findElement(By.xpath("//button[@class='pull-right btn btn-default']"));
        Browser.clickOnElementUsingJavascript(addNewPatient);
        Browser.clickOnElement(addNewPatient);
    }

    public void enterFirstName(String firstNameData) {
        Browser.waitForElementToBeVisible(By.xpath("//input[@placeholder='First Name']"));
        WebElement firstNameID = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@placeholder='First Name']"));
        Browser.enterTextInEditBox(firstNameID, firstNameData);
    }

    public void clearFirstName() {
        WebElement firstNameID = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@placeholder='First Name']"));
        firstNameID.clear();
        firstNameID.sendKeys(Keys.BACK_SPACE);
    }

    public void enterLastName(String lastNameData) {
        WebElement lastNameID = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
        Browser.enterTextInEditBox(lastNameID, lastNameData);
    }

    public void clearLastName() {
        WebElement lastNameID = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
        lastNameID.clear();
    }

    public void enterPhoneNumber(String phoneNumberData) {
        WebElement phoneNumberID = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@placeholder='Cell Phone Number']"));
        Browser.enterTextInEditBox(phoneNumberID, phoneNumberData);
    }

    public void clearPhoneNumber() {
        WebElement phoneNumberID = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@placeholder='Cell Phone Number']"));
        phoneNumberID.clear();
    }

    public void enterEmailID(String emailIdData) {
        WebElement emailID = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@placeholder='Email (optional)']"));
        Browser.enterTextInEditBox(emailID, emailIdData);
    }

    public void enterBirthDate(String birthDateData) {
        WebElement birthDate = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@placeholder='Date of Birth']"));
        Browser.enterTextInEditBox(birthDate, birthDateData);
    }

    public void clearBirthDate() {
        WebElement birthDate = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@placeholder='Date of Birth']"));
        birthDate.clear();
    }

    public void fillAppointmentBookingDetails() {
        enterFirstName(PbNUIApp.userdata().getPractices().getFirst().getFormsData().getFirst().getFirst_name());
        enterLastName(PbNUIApp.userdata().getPractices().getFirst().getFormsData().getFirst().getLast_name());
        enterPhoneNumber(PbNUIApp.userdata().getPractices().getFirst().getFormsData().getFirst().getPhone_number());
        enterEmailID(PbNUIApp.userdata().getPractices().getFirst().getFormsData().getFirst().getEmail_id());
        enterBirthDate(PbNUIApp.userdata().getPractices().getFirst().getFormsData().getFirst().getBirth_date());
    }

    public void selectProvider() {
        WebElement provider = DriverManager.getInstance().Driver.findElement(By.xpath("(//div[@class=' css-1hwfws3'])[4]"));
        Browser.clickOnElement(provider);
        Browser.waitForElementToBeVisible(By.xpath("//div[@class=' css-26l3qy-menu']//div[contains(@class,'option')]/.."));
        List<WebElement> providerDropDownOption = DriverManager.getInstance().Driver.findElements(By.xpath("//div[@class=' css-26l3qy-menu']//div[contains(@class,'option')]"));
        Browser.clickOnElement(providerDropDownOption.getFirst());
    }

    public void appointmentType() {
        WebElement appointmentType = DriverManager.getInstance().Driver.findElement(By.xpath("(//div[@class=' css-1hwfws3'])[5]"));
        Browser.clickOnElement(appointmentType);
        Browser.waitForElementToBeVisible(By.xpath("//div[@class=' css-26l3qy-menu']//div[contains(@class,'option')]/.."));
        List<WebElement> appointmentDropDownOption = DriverManager.getInstance().Driver.findElements(By.xpath("//div[@class=' css-26l3qy-menu']//div[contains(@class,'option')]"));
        Browser.clickOnElement(appointmentDropDownOption.getFirst());
    }

    public void clickOnCreateButton() {
        WebElement createButton = DriverManager.getInstance().Driver.findElement(By.xpath("//button[text()='Create']"));
        Browser.clickOnElement(createButton);
    }

    public void verifyCreateButtonState(boolean enable) {
        WebElement createButton = DriverManager.getInstance().Driver.findElement(By.xpath("//button[text()='Create']"));
        if (enable) {
            Assert.assertTrue("create button is not enabled as expected.", createButton.isEnabled());
        } else {
            Assert.assertFalse("create button is not disabled as expected.", createButton.isEnabled());
        }
    }
}