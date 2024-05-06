package Pages;

import Framework.Browser;
import Framework.Constants.Constants.*;
import Framework.Root.PbNUIApp;
import Framework.Util.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.security.Key;
import java.util.List;
import java.util.Random;

public class OnlinePaymentPortalPage extends BasePage {
    public OnlinePaymentPortalPage(PageTitle title) {
        super(title);
    }

    public void fillPaymentPortalDetails() {
        enterFirstName(PbNUIApp.userdata().getPractices().getFirst().getFormsData().getFirst().getFirst_name());
        enterLastName(PbNUIApp.userdata().getPractices().getFirst().getFormsData().getFirst().getLast_name());
        enterBirthDate(PbNUIApp.userdata().getPractices().getFirst().getFormsData().getFirst().getBirth_date());
    }

    public void enterFirstName(String firstNameData) {
        Browser.waitForElementToBeVisible(By.xpath("//input[@placeholder='First Name']"));
        WebElement firstNameID = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@placeholder='First Name']"));
        Browser.enterTextInEditBox(firstNameID, firstNameData);
    }

    public void enterLastName(String lastNameData) {
        Browser.waitForElementToBeVisible(By.xpath("//input[@placeholder='Last Name']"));
        WebElement lastNameID = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
        Browser.enterTextInEditBox(lastNameID, lastNameData);
    }

    public void enterBirthDate(String birthdate) {
        Browser.waitForElementToBeVisible(By.xpath("//input[@placeholder='MM/DD/YYYY']"));
        WebElement birthDateID = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@placeholder='MM/DD/YYYY']"));
        Browser.enterTextInEditBox(birthDateID, birthdate);
    }

    public void clickOnContinueButton() {
        WebElement continueButton = DriverManager.getInstance().Driver.findElement(By.xpath("//div[contains(text(),'Continue')]"));
        Browser.clickOnElement(continueButton);
    }

    public void enterPaymentAmount() {
        Browser.waitForElementToBeVisible(By.xpath("//*[@id='payment-portal-card-border']//label[text()='Payment Amount']/following-sibling::div/input"));
        Browser.waitForElementToBeClickable(By.xpath("//*[@id='payment-portal-card-border']//label[text()='Payment Amount']/following-sibling::div/input"));
        WebElement paymentTextBox = DriverManager.getInstance().Driver.findElement(By.xpath("//*[@id='payment-portal-card-border']//label[text()='Payment Amount']/following-sibling::div/input"));
        Random randon = new Random();
        int amount = randon.nextInt(10000);
        Browser.waitForElementToBeClickable(paymentTextBox);
        Browser.waitForElementToDisplay(paymentTextBox);
        Browser.enterTextInEditBox(paymentTextBox, String.valueOf(amount));
    }

    public void clickOnPayFullAmount(){
        WebElement payFullAmount = DriverManager.getInstance().Driver.findElement(By.xpath("//div[contains(text(),'Pay full amount')]"));
        Browser.clickOnElement(payFullAmount);
    }

    public void enterCardNumber (String cardNumber){
        //WebElement iframe = DriverManager.getInstance().Driver.findElement(By.xpath("//iframe[@name='__privateStripeFrame4223']"));
        //Browser.switchToFrame(iframe);
        Browser.waitForElementToBeVisible(By.xpath("//input[@placeholder='1234 5678 9012 3456']"));
        WebElement useCardNumber = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@placeholder='1234 5678 9012 3456']"));
        Browser.enterTextInEditBox(useCardNumber, cardNumber);

    }
}
