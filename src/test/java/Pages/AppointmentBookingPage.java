package Pages;

import Framework.Browser;
import Framework.Constants.Constants.PageTitle;
import Framework.Root.PbNUIApp;
import Framework.Util.DriverManager;
import org.junit.Assert;
import org.openqa.selenium.*;

import java.util.List;

public class AppointmentBookingPage extends BasePage {
    public AppointmentBookingPage(PageTitle title) {
        super(title);
    }

    private final List<WebElement> locationFinder = DriverManager.getInstance().Driver.findElements(By.xpath("//*[@id='patient-appointment-booking-page']//div[@class='location-item-name']"));

    public void clickOnPickLocation() {
        Browser.waitForElementToBeClickable(By.xpath("//div[@class='MuiPaper-root location-item-card card-background-color MuiPaper-elevation1 MuiPaper-rounded']"));
        Browser.waitForElementToBeVisible(By.xpath("//div[@class='MuiPaper-root location-item-card card-background-color MuiPaper-elevation1 MuiPaper-rounded']"));
        WebElement setLocation = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@class='MuiPaper-root location-item-card card-background-color MuiPaper-elevation1 MuiPaper-rounded']"));
        Browser.clickOnElement(setLocation);
    }

    public void clickOnSelectNewPatient() {
        Browser.waitForElementToBeVisible(By.xpath("//button/span[text()='New Patient']"));
        WebElement selectNewPatient = DriverManager.getInstance().Driver.findElement(By.xpath("//button/span[text()='New Patient']"));
        Browser.waitForElementToDisplay(selectNewPatient);
        Browser.clickOnElement(selectNewPatient);
    }

    public void clickOnEmergencyConsult() {
        Browser.waitForElementToBeVisible(By.xpath("//span[contains(text(),'Emergency Consult')]"));
        WebElement selectEmergencyConsult = DriverManager.getInstance().Driver.findElement(By.xpath("//button/span[text()='Emergency Consult']"));
        Browser.clickOnElement(selectEmergencyConsult);
    }

    public void clickOnEarliest() {
        Browser.waitForElementToBeVisible(By.xpath("//span[@class='MuiButton-label' and contains(text(),'Earliest: ')]"));
        WebElement selectEarliest = DriverManager.getInstance().Driver.findElement(By.xpath("//span[@class='MuiButton-label' and contains(text(),'Earliest: ')]"));
        Browser.clickOnElement(selectEarliest);
    }

    public void clickOnSeeMoreOptions() {
        Browser.waitForElementToBeVisible(By.xpath("//span[@class='MuiButton-label' and contains(text(),'See more options')]"));
        WebElement selectSeeMoreOptions = DriverManager.getInstance().Driver.findElement(By.xpath("//span[@class='MuiButton-label' and contains(text(),'See more options')]"));
        Browser.clickOnElement(selectSeeMoreOptions);
    }

    public void clickOnRefreshButton() {
        Browser.waitForElementToBeVisible(By.xpath("(//button[@class='MuiButtonBase-root MuiIconButton-root'])[2]"));
        WebElement selectSeeMoreOptions = DriverManager.getInstance().Driver.findElement(By.xpath("(//button[@class='MuiButtonBase-root MuiIconButton-root'])[2]"));
        Browser.clickOnElement(selectSeeMoreOptions);
    }

    public void fillAppointmentBookingForm() {
        enterFirstName(PbNUIApp.userdata().getPractices().getFirst().getFormsData().getFirst().getFirst_name());
        enterLastName(PbNUIApp.userdata().getPractices().getFirst().getFormsData().getFirst().getLast_name());
        enterPhoneNumber(PbNUIApp.userdata().getPractices().getFirst().getFormsData().getFirst().getPhone_number());
        enterEmailID(PbNUIApp.userdata().getPractices().getFirst().getFormsData().getFirst().getEmail_id());
        enterBirthDate(PbNUIApp.userdata().getPractices().getFirst().getFormsData().getFirst().getBirth_date());
    }

    public void fillAppointmentBookingFormForInactivePatient() {
        enterFirstName(PbNUIApp.userdata().getPractices().getFirst().getFormsData().get(1).getFirst_name());
        enterLastName(PbNUIApp.userdata().getPractices().getFirst().getFormsData().get(1).getLast_name());
        enterPhoneNumber(PbNUIApp.userdata().getPractices().getFirst().getFormsData().get(1).getPhone_number());
        enterEmailID(PbNUIApp.userdata().getPractices().getFirst().getFormsData().get(1).getEmail_id());
        enterBirthDate(PbNUIApp.userdata().getPractices().getFirst().getFormsData().get(1).getBirth_date());
    }

    public void fillAppointmentBookingFormForPatientWithTags() {
        enterFirstName(PbNUIApp.userdata().getPractices().getFirst().getFormsData().get(2).getFirst_name());
        enterLastName(PbNUIApp.userdata().getPractices().getFirst().getFormsData().get(2).getLast_name());
        enterPhoneNumber(PbNUIApp.userdata().getPractices().getFirst().getFormsData().get(2).getPhone_number());
        enterEmailID(PbNUIApp.userdata().getPractices().getFirst().getFormsData().get(2).getEmail_id());
        enterBirthDate(PbNUIApp.userdata().getPractices().getFirst().getFormsData().get(2).getBirth_date());
    }

    public void fillAppointmentBookingFormForValidateInsuranceDob() {
        enterFirstName(PbNUIApp.userdata().getFirstName(1,"4"));
        enterLastName(PbNUIApp.userdata().getLastName(1,"4"));
        enterPhoneNumber(PbNUIApp.userdata().getPhoneNumber(1,"4"));
        enterEmailID(PbNUIApp.userdata().getEmailId(1,"4"));
        enterBirthDate(PbNUIApp.userdata().getBirthDate(1,"4"));
    }

    public void enterFirstName(String firstNameData) {
        Browser.waitForElementToBeVisible(By.xpath("//input[@placeholder='Patient First Name']"));
        WebElement firstNameID = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@placeholder='Patient First Name']"));
        Browser.enterTextInEditBox(firstNameID, firstNameData);
    }

    public void enterLastName(String lastNameData) {
        WebElement lastNameID = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@placeholder='Patient Last Name']"));
        Browser.enterTextInEditBox(lastNameID, lastNameData);
    }

    public void enterPhoneNumber(String phoneNumberData) {
        WebElement phoneNumberID = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@placeholder='(###) ###-####']"));
        Browser.enterTextInEditBox(phoneNumberID, phoneNumberData);
    }

    public void enterEmailID(String emailIdData) {
        WebElement emailID = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@placeholder='email']"));
        Browser.enterTextInEditBox(emailID, emailIdData);
    }

    public void enterBirthDate(String birthDateData) {
        WebElement birthDate = DriverManager.getInstance().Driver.findElement(By.xpath("(//input[@placeholder='MM/DD/YYYY'])[1]"));
        Browser.enterTextInEditBox(birthDate, birthDateData);
    }

    public void clickOnCheckBox() {
        WebElement agreeCheckBox = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@type='checkbox']"));
        Browser.scrollToVisibleElement(agreeCheckBox);
        agreeCheckBox.click();
    }

    public void clickOnNextButton() {
        WebElement nextButton = DriverManager.getInstance().Driver.findElement(By.xpath("//span[@class='MuiButton-label' and contains(text(),'Next')]"));
        Browser.clickOnElement(nextButton);
    }

    public void enterBirthDateOnInsurancePage(String birthDateData) {
        Browser.waitForElementToBeVisible(By.xpath("//input[@placeholder='MM-DD-YYYY']"));
        WebElement birthDate = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@placeholder='MM-DD-YYYY']"));
        Browser.scrollToVisibleElement(birthDate);
        Browser.enterTextInEditBox(birthDate, birthDateData);
    }

    public void clickOnIDoNotHaveInsurance() {
        WebElement iDoNotHaveInsuranceButton = DriverManager.getInstance().Driver.findElement(By.xpath("//span[@class='MuiButton-label' and contains(text(),'I do')]"));
        Browser.clickOnElementUsingJavascript(iDoNotHaveInsuranceButton);
    }

    public void verifyInsurancePage() {
        Browser.waitForElementToBeClickable(By.xpath("//span[@class='MuiButton-label' and contains(text(),'Use Cell Phone')]"));
        WebElement OtpPage = DriverManager.getInstance().Driver.findElement(By.xpath("//span[@class='MuiButton-label' and contains(text(),'Use Cell Phone')]"));
        boolean status = OtpPage.isDisplayed();
        Assert.assertTrue("Insurance page is displayed on appointment booking page.", OtpPage.isDisplayed());
    }

    public void verifyCreditCardPage() {
        Browser.waitForElementToBeClickable(By.xpath("//h2[@class=contains(text(),'Please enter your credit card information')]"));
        WebElement CreditCardPage = DriverManager.getInstance().Driver.findElement(By.xpath("//h2[@class=contains(text(),'Please enter your credit card information')]"));
        Assert.assertTrue("Credit Card page is not displayed on appointment booking page.", CreditCardPage.isDisplayed());
    }

    public void clickOnUseCellPhone() {
        Browser.waitForElementToBeVisible(By.xpath("//span[@class='MuiButton-label' and contains(text(),'Use Cell Phone')]"));
        WebElement useCellPhone = DriverManager.getInstance().Driver.findElement(By.xpath("//span[@class='MuiButton-label' and contains(text(),'Use Cell Phone')]"));
        Browser.clickOnElement(useCellPhone);
    }

    public void enterOTP(String OTP) {
        Browser.waitForElementToBeVisible(By.xpath("//input[@placeholder='XXXX']"));
        WebElement varOTP = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@placeholder='XXXX']"));
        Browser.enterTextInEditBox(varOTP, OTP);
    }

    public void verifySuccessfulTextDisplayed() {
        WebElement successfulText = DriverManager.getInstance().Driver.findElement(By.xpath("//*[@id='HomePageRoot']//h1[contains(text(),'Successful')]"));
        Assert.assertTrue("Successful text not displayed on appointment booking page.", successfulText.isDisplayed());
    }

    public void verifyTextDisplayedMessage(String message) {
        Browser.waitForElementToBeVisible(By.xpath("//div[@class='MuiAlert-message']"));
        WebElement verifyText = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@class='MuiAlert-message']"));
        Assert.assertTrue(message, verifyText.isDisplayed());
    }

    public void verifyDateErrorMessage() {
        Browser.waitForElementToBeVisible(By.xpath("//div[text()='Age must be greater than 18 years']"));
        WebElement verifyText = DriverManager.getInstance().Driver.findElement(By.xpath("//div[text()='Age must be greater than 18 years']"));
        Assert.assertTrue("Age must be greater than 18 years", verifyText.isDisplayed());
    }
}