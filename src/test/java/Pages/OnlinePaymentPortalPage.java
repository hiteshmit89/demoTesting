package Pages;

import Framework.Browser;
import Framework.Constants.Constants;
import Framework.Root.PbNUIApp;
import Framework.Util.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.security.Key;
import java.util.List;

public class OnlinePaymentPortalPage extends BasePage {
    public OnlinePaymentPortalPage(Constants.PageTitle title) {
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
    public void enterPaymentAmount(String amount) {
        //Browser.waitForElementList(By.xpath("//*[@id='payment-portal-card-border']//div[contains(@class,'MuiInputBase')]"));
        Browser.waitForElementToBeVisible(By.xpath("//*[@id='payment-portal-card-border']//label[text()='Payment Amount']/following-sibling::div/input"));
        Browser.waitForElementToBeClickable(By.xpath("//*[@id='payment-portal-card-border']//label[text()='Payment Amount']/following-sibling::div/input"));
        WebElement amountt = DriverManager.getInstance().Driver.findElement(By.xpath("//*[@id='payment-portal-card-border']//label[text()='Payment Amount']/following-sibling::div/input"));
        Browser.waitForElementToBeClickable(amountt);
        Browser.waitForElementToDisplay(amountt);
        Browser.enterTextInEditBox(amountt, amount);
        /*List<WebElement> paymentAmountDiv = DriverManager.getInstance().Driver.findElements(By.xpath("//*[@id='payment-portal-card-border']//div[contains(@class,'MuiInputBase')]"));
        Browser.waitForElementToDisplay(paymentAmountDiv.getFirst());
        System.out.println(paymentAmountDiv.getFirst().isDisplayed());
        WebElement paymentAmountEditBox = paymentAmountDiv.getFirst().findElement(By.xpath("./input"));
        //paymentAmountEditBox.click();
        Browser.enterTextInEditBox(paymentAmountEditBox, amount);
        Browser.enterTextInEditBox(paymentAmountDiv.get(1).findElement(By.xpath("./input")), "123");
        Browser.enterTextInEditBox(paymentAmountDiv.get(2).findElement(By.xpath("./input")), "1234567890");*/
    }
}