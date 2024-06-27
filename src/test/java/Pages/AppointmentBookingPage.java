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
        Browser.waitForElementToBeVisible(By.xpath("//div[@class='location-item-name' and contains(text(),'" + PbNUIApp.userdata().getPracticeName(1)+ "')]"));
        boolean present = false;
        WebElement setLocation = null;
        try {
            setLocation = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@class='location-item-name' and contains(text(),'" + PbNUIApp.userdata().getPracticeName(1)+ "')]"));
            present = true;
        } catch (NoSuchElementException ignored) {
        }
        if (present) {
            Browser.clickOnElement(setLocation);
        }
    }

    public void clickOnSelectNewPatient() {
        Browser.waitForElementToBeVisible(By.xpath("//button/span[text()='New Patient']"));
        WebElement selectNewPatient = DriverManager.getInstance().Driver.findElement(By.xpath("//button/span[text()='New Patient']"));
        Browser.waitForElementToDisplay(selectNewPatient);
        Browser.clickOnElement(selectNewPatient);
    }

    public void clickOnSelectExistingPatient() {
        Browser.waitForElementToBeVisible(By.xpath("//button/span[text()='Returning Patient']"));
        WebElement selectExistingPatient = DriverManager.getInstance().Driver.findElement(By.xpath("//button/span[text()='Returning Patient']"));
        Browser.waitForElementToDisplay(selectExistingPatient);
        Browser.clickOnElement(selectExistingPatient);
    }

    public void clickOnEmergencyConsult() {
        Browser.waitForElementToBeVisible(By.xpath("//div[text()='What would you like to be seen for?']/following-sibling::div//span[@class='MuiButton-label']"));
        WebElement selectEmergencyConsult = DriverManager.getInstance().Driver.findElement(By.xpath("//div[text()='What would you like to be seen for?']/following-sibling::div//span[@class='MuiButton-label']"));
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
        enterFirstName(PbNUIApp.userdata().getFirstName(1, "1"));
        enterLastName(PbNUIApp.userdata().getLastName(1, "1"));
        enterPhoneNumber(PbNUIApp.userdata().getPhoneNumber(1, "1"));
        enterEmailID(PbNUIApp.userdata().getEmailId(1, "1"));
        enterBirthDate(PbNUIApp.userdata().getBirthDate(1, "1"));
    }

    public void fillAppointmentBookingFormForInactivePatient() {
        enterFirstName(PbNUIApp.userdata().getFirstName(1, "3"));
        enterLastName(PbNUIApp.userdata().getLastName(1, "3"));
        enterPhoneNumber(PbNUIApp.userdata().getPhoneNumber(1, "3"));
        enterEmailID(PbNUIApp.userdata().getEmailId(1, "3"));
        enterBirthDate(PbNUIApp.userdata().getBirthDate(1, "3"));
    }

    public void fillAppointmentBookingFormForPatientWithTags() {
        enterFirstName(PbNUIApp.userdata().getFirstName(1, "2"));
        enterLastName(PbNUIApp.userdata().getLastName(1, "2"));
        enterPhoneNumber(PbNUIApp.userdata().getPhoneNumber(1, "2"));
        enterEmailID(PbNUIApp.userdata().getEmailId(1, "2"));
        enterBirthDate(PbNUIApp.userdata().getBirthDate(1, "2"));
    }

    public void fillAppointmentBookingFormForValidateInsuranceDob() {
        enterFirstName(PbNUIApp.userdata().getFirstName(1, "4"));
        enterLastName(PbNUIApp.userdata().getLastName(1, "4"));
        enterPhoneNumber(PbNUIApp.userdata().getPhoneNumber(1, "4"));
        enterEmailID(PbNUIApp.userdata().getEmailId(1, "4"));
        enterBirthDate(PbNUIApp.userdata().getBirthDate(1, "4"));
    }

    public void fillAppointmentBookingFormForValidatePatientDob() {
        enterFirstName(PbNUIApp.userdata().getFirstName(1, "5"));
        enterLastName(PbNUIApp.userdata().getLastName(1, "5"));
        enterPhoneNumber(PbNUIApp.userdata().getPhoneNumber(1, "5"));
        enterEmailID(PbNUIApp.userdata().getEmailId(1, "5"));
        enterBirthDate(PbNUIApp.userdata().getBirthDate(1, "5"));
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
        Browser.waitForElementToBeVisible(By.xpath("//span[@class='MuiButton-label' and contains(text(),'Next')]"));
        WebElement nextButton = DriverManager.getInstance().Driver.findElement(By.xpath("//span[@class='MuiButton-label' and contains(text(),'Next')]"));
        Browser.clickOnElementUsingJavascript(nextButton);
    }

    public void enterBirthDateOnInsurancePage(String birthDateData) {
        Browser.waitForElementToBeVisible(By.xpath("//input[@placeholder='MM-DD-YYYY']"));
        WebElement birthDate = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@placeholder='MM-DD-YYYY']"));
        Browser.scrollToVisibleElement(birthDate);
        Browser.enterTextInEditBox(birthDate, birthDateData);
    }

    public void clickOnIDoNotHaveInsurance() {
        Browser.waitForElementToBeVisible(By.xpath("//span[@class='MuiButton-label' and contains(text(),'I do')]"));
        boolean present = false;
        WebElement iDoNotHaveInsuranceButton = null;
        try {
            iDoNotHaveInsuranceButton = DriverManager.getInstance().Driver.findElement(By.xpath("//span[@class='MuiButton-label' and contains(text(),'I do')]"));
            present = true;
        } catch (NoSuchElementException ignored) {
        }
        if (present) {
            Browser.clickOnElementUsingJavascript(iDoNotHaveInsuranceButton);
            clickOnNextButton();
        }
    }

    public void insuranceUnchanged() {
        Browser.waitForElementToBeVisible(By.xpath("//span[@class='MuiButton-label' and contains(text(),'Insurance Unchanged')]"));
        WebElement insuranceUnchangedButton = DriverManager.getInstance().Driver.findElement(By.xpath("//span[@class='MuiButton-label' and contains(text(),'Insurance Unchanged')]"));
        Browser.clickOnElementUsingJavascript(insuranceUnchangedButton);
    }

    public void goToNextAvailability() {
        Browser.waitForElementToBeVisible(By.xpath("//span[@class='MuiButton-label' and contains(text(),'go to next availability')]"));
        boolean present = false;
        WebElement goToNextAvailabilityButton = null;
        try {
            goToNextAvailabilityButton = DriverManager.getInstance().Driver.findElement(By.xpath("//span[@class='MuiButton-label' and contains(text(),'go to next availability')]"));
            present = true;
        } catch (NoSuchElementException ignored) {
        }
        if (present) {
            Browser.clickOnElement(goToNextAvailabilityButton);
            clickOnEarliest();
            clickOnNextButton();
            clickOnIDoNotHaveInsurance();
        }
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

    public void clickOnVerifyAndSchedule() {
        WebElement verifyAndScheduleButton = DriverManager.getInstance().Driver.findElement(By.xpath("//span[@class='MuiButton-label' and contains(text(),'Verify & Schedule')]"));
        Browser.clickOnElement(verifyAndScheduleButton);
    }

    public void verifySuccessfulTextDisplayed() {
        WebElement successfulText = DriverManager.getInstance().Driver.findElement(By.xpath("//*[@id='HomePageRoot']//h1[contains(text(),'Successful')]"));
        Assert.assertTrue("Successful text not displayed on appointment booking page.", successfulText.isDisplayed());
    }

    public void verifyErrorTextDisplayed() {
        Browser.waitForElementToBeVisible(By.xpath("//div[@class='react-toast-notifications__toast__content css-1ad3zal']"));
        WebElement errorMessage = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@class='react-toast-notifications__toast__content css-1ad3zal']"));
        String errorMsg = "Error! Could not verify otp.";
        Assert.assertEquals("Error toast message displayed", errorMsg, errorMessage.getText());
    }

    public void verifyTextDisplayedMessage(String message) {
        WebElement successfulText = DriverManager.getInstance().Driver.findElement(By.xpath("//*[@id='HomePageRoot']//h1[contains(text(),'Successful')]"));
        Assert.assertTrue("Successful text not displayed on appointment booking page.", successfulText.isDisplayed());
    }

    public void verifyDateErrorMessage() {
        Browser.waitForElementToBeVisible(By.xpath("//div[text()='Age must be greater than 18 years']"));
        WebElement verifyText = DriverManager.getInstance().Driver.findElement(By.xpath("//div[text()='Age must be greater than 18 years']"));
        Assert.assertTrue("Age must be greater than 18 years", verifyText.isDisplayed());
    }

    public void verifyDateConfirmationMessage() {
        Browser.waitForElementToBeVisible(By.xpath("//p[@class='MuiTypography-root MuiTypography-body1']"));
        WebElement verifyText = DriverManager.getInstance().Driver.findElement(By.xpath("//p[@class='MuiTypography-root MuiTypography-body1']"));
        Assert.assertTrue("Can you please confirm that the patient's DOB is correct?", verifyText.isDisplayed());
    }
}