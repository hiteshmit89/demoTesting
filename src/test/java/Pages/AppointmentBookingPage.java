package Pages;

import Framework.Browser;
import Framework.Constants.Constants.PageTitle;
import Framework.Util.DriverManager;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
public class AppointmentBookingPage extends BasePage {
    public AppointmentBookingPage(PageTitle title) {
        super(title);
    }
private List<WebElement> locationFinder = DriverManager.getInstance().Driver.findElements(By.xpath("//*[@id='patient-appointment-booking-page']//div[@class='location-item-name']"));

    public void clickOnPickLocation() {
        Browser.clickOnElement(locationFinder.getFirst());
    }
    public void clickOnSelectNewPatient() {
        DriverManager.getInstance().fluentwait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button/span[text()='New Patient']")));
        WebElement selectNewPatient = DriverManager.getInstance().Driver.findElement(By.xpath("//button/span[text()='New Patient']"));
        Browser.waitForElementToDisplay(selectNewPatient);
        Browser.clickOnElement(selectNewPatient);
    }
    public void clickOnEmergencyConsult() {
            DriverManager.getInstance().fluentwait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Emergency Consult')]")));
            WebElement selectEmergencyConsult = DriverManager.getInstance().Driver.findElement(By.xpath("//button/span[text()='Emergency Consult']"));
            Browser.clickOnElement(selectEmergencyConsult);
    }
    public void clickOnEarliest() {
        DriverManager.getInstance().fluentwait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='MuiButton-label' and contains(text(),'Earliest: ')]")));
        WebElement selectEarliest = DriverManager.getInstance().Driver.findElement(By.xpath("//span[@class='MuiButton-label' and contains(text(),'Earliest: ')]"));
        Browser.clickOnElement(selectEarliest);
    }
    public void enterFirstName(String firstNameData) {
        DriverManager.getInstance().fluentwait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Patient First Name']")));
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
        Browser.scrollByVisibleElement(agreeCheckBox);
        agreeCheckBox.click();
    }

    public void clickOnNextButton() {
        WebElement nextButton = DriverManager.getInstance().Driver.findElement(By.xpath("//span[@class='MuiButton-label' and contains(text(),'Next')]"));
        Browser.clickOnElement(nextButton);

    }
    public void clickOnIDontHaveInsurance() {
        DriverManager.getInstance().fluentwait().until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='MuiButton-label' and contains(text(),'I do')]")));
        DriverManager.getInstance().fluentwait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='MuiButton-label' and contains(text(),'I do')]")));
        WebElement iDontHaveInsuranceButton = DriverManager.getInstance().Driver.findElement(By.xpath("//span[@class='MuiButton-label' and contains(text(),'I do')]"));
        Browser.clickOnElement(iDontHaveInsuranceButton);
    }
    public void clickOnUseCellPhone() {
        DriverManager.getInstance().fluentwait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='MuiButton-label' and contains(text(),'Use Cell Phone')]")));
        WebElement useCellPhone = DriverManager.getInstance().Driver.findElement(By.xpath("//span[@class='MuiButton-label' and contains(text(),'Use Cell Phone')]"));
        Browser.clickOnElement(useCellPhone);
    }
    public void enterOTP(String OTP) {
        DriverManager.getInstance().fluentwait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='XXXX']")));
        WebElement varOTP = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@placeholder='XXXX']"));
        Browser.enterTextInEditBox(varOTP, OTP);
    }
    public void verifySuccessfulTextDisplayed() {
        WebElement successfulText = DriverManager.getInstance().Driver.findElement(By.xpath("//*[@id='HomePageRoot']//h1[contains(text(),'Successful')]"));
        Assert.assertTrue("Successful text not displayed on appointment booking page.", successfulText.isDisplayed());
    }
}


