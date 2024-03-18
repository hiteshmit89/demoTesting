package Pages;

import Framework.Browser;
import Framework.Constants.Constants.PageTitle;
import Framework.Util.DriverManager;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AppointmentBookingPage extends BasePage {
    public AppointmentBookingPage(PageTitle title) {
        super(title);
    }


    public void clickOnPickLocation() {
        try {
            DriverManager.getInstance().fluentwait().until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='location-item-name'and text()='Romans, Burke and Wagner']")));
            Browser.clickOnElement(DriverManager.getInstance().Driver.findElement(By.xpath("//div[@class='location-item-name'and text()='Romans, Burke and Wagner']")));

        } catch (Exception e) {
            clickOnEmergencyConsult();
        }
       // WebElement pickLocation = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@class='location-item-name'and text()='Romans, Burke and Wagner']"));
       // Browser.clickOnElement(pickLocation);
    }
    public void clickOnSelectNewPatient() {
        WebElement selectNewPatient = DriverManager.getInstance().Driver.findElement(By.xpath("//span[normalize-space()=\"I'm a New Patient\"]"));
        Browser.clickOnElement(selectNewPatient);
    }
    /*public void clickOnSelectReturningPatient() {
        WebElement selectReturningPatient = DriverManager.getInstance().Driver.findElement(By.xpath("//span[normalize-space()=\"I'm a Returning Patient\"]"));
        Browser.clickOnElement(selectReturningPatient);
    }*/
    public void clickOnEmergencyConsult() {
        try {
            DriverManager.getInstance().fluentwait().until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='MuiButton-label' and contains(text(),'Emergency Consult')]")));
            Browser.clickOnElement(DriverManager.getInstance().Driver.findElement(By.xpath("//span[@class='MuiButton-label' and contains(text(),'Emergency Consult')]")));

        } catch (Exception e) {
            clickOnEmergencyConsult();
        }
       // WebElement selectEmergencyConsult = DriverManager.getInstance().Driver.findElement(By.xpath("//span[@class='MuiButton-label' and contains(text(),'Emergency Consult')]"));
       // Browser.clickOnElement(selectEmergencyConsult);
    }
    public void clickOnEarliest() {
        try {
            DriverManager.getInstance().fluentwait().until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='MuiButton-label' and contains(text(),'Earliest: ')]")));
            Browser.clickOnElement(DriverManager.getInstance().Driver.findElement(By.xpath("//span[@class='MuiButton-label' and contains(text(),'Earliest: ')]")));

        } catch (Exception e) {
            clickOnEarliest();
        }
    }
    public void enterFirstName(String firstNameData) {
        DriverManager.getInstance().fluentwait().until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Patient First Name']")));
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
       // Browser.clickOnElement(agreeCheckBox);
        agreeCheckBox.click();
    }

    public void clickOnNextButton() {
        WebElement nextButton = DriverManager.getInstance().Driver.findElement(By.xpath("//span[@class='MuiButton-label' and contains(text(),'Next')]"));
        Browser.clickOnElement(nextButton);

    }
    public void clickOnIDontHaveInsurance() {


        try {
            DriverManager.getInstance().fluentwait().until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='MuiButton-label' and contains(text(),'I do')]")));
            WebElement iDontHaveInsuranceButton = DriverManager.getInstance().Driver.findElement(By.xpath("//span[@class='MuiButton-label' and contains(text(),'I do')]"));
            Browser.clickOnElement(iDontHaveInsuranceButton);

        } catch (Exception e) {
            clickOnIDontHaveInsurance();
        }
    }


}

