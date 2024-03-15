package Pages;

import Framework.Browser;
import Framework.Constants.Constants.PageTitle;
import Framework.Util.DriverManager;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppointmentsPage extends BasePage {

    public AppointmentsPage(PageTitle title) {
        super(title);
    }

    WebElement header = DriverManager.getInstance().Driver.findElement(By.xpath("//*[@id='appointment-booking']//span[text()='Online Appointment Booking']"));
    WebElement CopyUrlIcon = DriverManager.getInstance().Driver.findElement(By.xpath("(//i[@class='fa fa-copy'])[1]"));
    WebElement e = DriverManager.getInstance().Driver.findElement(By.xpath("(//span[contains(text(),'https://www.patientsreach.com/schedule/')])[1]"));


    public void clickOnWidgets() {
        WebElement widgetsTab = DriverManager.getInstance().Driver.findElement(By.xpath("//a[@id='appointment-booking-page-tab-Widgets']"));
        Browser.clickOnElement(widgetsTab);
    }

    public void clickOnCopyUrl() {

        Browser.clickOnElement(CopyUrlIcon);
        String urlText = e.getText();
        String[] arrOfStr = urlText.split("schedule");
        for (String a : arrOfStr) {
            System.out.println(a);
        }
        String URL = "https://qa3.pbn-dev.com";
        URL = String.join("", URL, "/schedule", arrOfStr[1]);
        System.out.println(URL);
        //Browser.openNewTab();
        Browser.navigateToNewURL(URL);
    }

    public void clickOnPickLocation() {
        WebElement pickLocation = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@class='location-item-name'and text()='Romans, Burke and Wagner']"));
        Browser.clickOnElement(pickLocation);
    }

    public void clickOnSelectNewPatient() {
        WebElement selectNewPatient = DriverManager.getInstance().Driver.findElement(By.xpath("//span[normalize-space()=\"I'm a New Patient\"]"));
        Browser.clickOnElement(selectNewPatient);
    }

    public void clickOnSelectReturningPatient() {
        WebElement selectReturningPatient = DriverManager.getInstance().Driver.findElement(By.xpath("//span[normalize-space()=\"I'm a Returning Patient\"]"));
        Browser.clickOnElement(selectReturningPatient);
    }

    public void clickOnEmergencyConsult() {
        WebElement selectEmergencyConsult = DriverManager.getInstance().Driver.findElement(By.xpath("(//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text hover-transition'])[1]"));
        Browser.clickOnElement(selectEmergencyConsult);
    }

    public void clickOnEarliest() {
        WebElement selectEarliest = DriverManager.getInstance().Driver.findElement(By.xpath("(//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text'])[2]"));
        Browser.clickOnElement(selectEarliest);
    }

    public void enterFirstName(String firstNameData) {
        WebElement firstNameID = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@placeholder='Patient First Name']"));
        Browser.enterTextInEditBox(firstNameID, firstNameData);
    }

    public void enterLastName(String lastNameData) {
        WebElement lastNameID = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@placeholder='Patient Last Name']"));
        Browser.enterTextInEditBox(lastNameID, lastNameData);
    }

    public void enterPhoneNumber(String phoneNumberData) {
        WebElement phoneNumberID = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@placeholder='//input[@placeholder='(###) ###-####']"));
        Browser.enterTextInEditBox(phoneNumberID, phoneNumberData);
    }

    public void enterEmailID(String emailIdData) {
        WebElement emailID = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@placeholder='//input[@placeholder='email']"));
        Browser.enterTextInEditBox(emailID, emailIdData);
    }

    public void enterBirthDate(String birthDateData) {
        WebElement birthDate = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@placeholder='(//input[@placeholder='MM/DD/YYYY'])[1]"));
        Browser.enterTextInEditBox(birthDate, birthDateData);
    }

    public void clickOnCheckBox() {
        WebElement agreeCheckBox = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@type='checkbox']"));
        Browser.clickOnElement(agreeCheckBox);
    }

    public void clickOnNextButton() {
        WebElement nextButton = DriverManager.getInstance().Driver.findElement(By.xpath("//span[@class='MuiButton-label' and contains(text(),'Next')]"));
        Browser.clickOnElement(nextButton);
    }


}


