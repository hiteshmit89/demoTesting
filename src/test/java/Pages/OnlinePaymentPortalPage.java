package Pages;

import Framework.Browser;
import Framework.Constants.Constants.PageTitle;
import Framework.Root.PbNUIApp;
import Framework.Util.DriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
        Random random = new Random();
        int amount = random.nextInt(10000);
        Browser.waitForElementToBeClickable(paymentTextBox);
        Browser.waitForElementToDisplay(paymentTextBox);
        Browser.enterTextInEditBox(paymentTextBox, String.valueOf(amount));
    }

    public void clickOnPayFullAmount() {
        WebElement payFullAmount = DriverManager.getInstance().Driver.findElement(By.xpath("//div[contains(text(),'Pay full amount')]"));
        Browser.clickOnElement(payFullAmount);
    }

    public void enterCardDetails() {
        WebElement cardButton =DriverManager.getInstance().Driver.findElement(By.xpath("//span[@class='MuiButton-startIcon MuiButton-iconSizeSmall']"));
        Browser.clickOnElement(cardButton);
        Browser.waitForFrameToLoad(By.xpath("//iframe[@title='Iframe for card number']"));
        enterCardNumber(PbNUIApp.userdata().getCardNumber(2, "1"));
        enterCardDate(PbNUIApp.userdata().getCardMonth(2, "1"));
        enterCVC(PbNUIApp.userdata().getCardCVC(2, "1"));
    }

    public void enterCardNumber(String cardNumber) {
        Browser.waitForElementPresence(By.xpath("//input[@data-fieldtype='encryptedCardNumber']"));
        Browser.waitForElementToBeVisible(By.xpath("//input[@data-fieldtype='encryptedCardNumber']"));
        WebElement cardNumberID = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@data-fieldtype='encryptedCardNumber']"));
        Browser.enterTextInEditBox(cardNumberID, cardNumber);
        Browser.switchToDefaultContent();
    }

    public void enterCardDate(String cardDate) {
        Browser.waitForFrameToLoad(By.xpath("//iframe[@title='Iframe for expiry date']"));
        Browser.waitForElementPresence(By.xpath("//input[@data-fieldtype='encryptedExpiryDate']"));
        Browser.waitForElementToBeVisible(By.xpath("//input[@data-fieldtype='encryptedExpiryDate']"));
        WebElement cardDateID = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@data-fieldtype='encryptedExpiryDate']"));
        Browser.enterTextInEditBox(cardDateID, cardDate);
        Browser.switchToDefaultContent();
    }

    public void enterCVC(String cardCVC) {
        Browser.waitForFrameToLoad(By.xpath("//iframe[@title='Iframe for security code']"));
        Browser.waitForElementPresence(By.xpath("//input[@placeholder='3 digits']"));
        Browser.waitForElementToBeVisible(By.xpath("//input[@placeholder='3 digits']"));
        WebElement cardCVCID = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@placeholder='3 digits']"));
        Browser.enterTextInEditBox(cardCVCID, cardCVC);
        Browser.switchToDefaultContent();
    }

    public void enterBillingAddress() {
        WebElement postalCodeTextBox = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@name='postalCode']"));
        Browser.enterTextInEditBox(postalCodeTextBox,PbNUIApp.userdata().getPostalCode(2,"1"));
    }

    public void clickPayNow(){
        Browser.waitForElementToBeClickable(By.xpath("(//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text'])[2]"));
        Browser.waitForElementToBeVisible(By.xpath("(//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text'])[2]"));
        WebElement payNowButton = DriverManager.getInstance().Driver.findElement(By.xpath("(//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text'])[2]"));
        Browser.clickOnElementUsingJavascript(payNowButton);
    }
    public void paymentSuccessfulLabel(){
        Browser.waitForElementToBeClickable(By.xpath("//p[@class='MuiTypography-root card-title MuiTypography-body1' and contains(text(),'Payment Success!')]"));
        Browser.waitForElementToBeVisible(By.xpath("//p[@class='MuiTypography-root card-title MuiTypography-body1' and contains(text(),'Payment Success!')]"));
        WebElement paymentLabel = DriverManager.getInstance().Driver.findElement(By.xpath("//p[@class='MuiTypography-root card-title MuiTypography-body1' and contains(text(),'Payment Success!')]"));
        String Label = paymentLabel.getText();
        Assert.assertEquals(Label,"Payment Success!");
    }
}