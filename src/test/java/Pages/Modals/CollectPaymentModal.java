package Pages.Modals;

import Framework.Browser;
import Framework.Root.PbNUIApp;
import Framework.Util.DriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.Random;
import static Framework.Constants.Constants.Sections.Payments;

public class CollectPaymentModal {
    CollectPaymentModal() {
        Browser.waitForPageReady();
    }

    public void clickOnFloatingPaymentButton() {
        PbNUIApp.navigator().ClickOnFloatingButton(Payments);
    }

    public void enterPatientName() {
        Browser.waitForElementToBeClickable(By.xpath("//input[@class='rbt-input-main form-control rbt-input']"));
        WebElement patientEditBox = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@class='rbt-input-main form-control rbt-input']"));
        Browser.enterTextInEditBox(patientEditBox, PbNUIApp.userdata().getPatientName(2, 1));
        Browser.waitForElementToBeVisible(By.xpath("//a[@class='dropdown-item patient-search-result-menu-item ']"));
        WebElement name = DriverManager.getInstance().Driver.findElement(By.xpath("//a[@class='dropdown-item patient-search-result-menu-item ']"));
        Browser.clickOnElement(name);
    }

    public void selectPaymentMethodAsAddNewCard() {
        Browser.waitForPageReady();
        WebElement paymentMethodRadioButton = DriverManager.getInstance().Driver.findElement(By.xpath("//span[text()='Credit / Debit Card']"));
        Browser.waitForElementToBeVisible(paymentMethodRadioButton);
        Browser.waitForElementToBeClickable(paymentMethodRadioButton);
        Browser.clickOnElement(paymentMethodRadioButton);
        WebElement chargeNewCardButton = DriverManager.getInstance().Driver.findElement(By.xpath("//*[text()='Charge from New Card']"));
        Browser.scrollToVisibleElement(chargeNewCardButton);
        Browser.waitForElementToBeVisible(By.xpath("//*[text()='Charge from New Card']"));
        WebElement chargeNewCard = DriverManager.getInstance().Driver.findElement(By.xpath("//*[text()='Charge from New Card']"));
        Browser.waitForElementToBeClickable(chargeNewCard);
        Browser.waitForElementToBeVisible(chargeNewCard);
        Browser.clickOnElementUsingJavascript(chargeNewCard);
    }

    public void enterCardDetails() {
        Browser.waitForElementPresence(By.xpath("//div[@class='adyen-checkout__spinner adyen-checkout__spinner--large']"));
        Browser.waitForElementInvisibility(DriverManager.getInstance().Driver.findElement(By.xpath("//div[@class='adyen-checkout__spinner adyen-checkout__spinner--large']")));
        Browser.waitForFrameToLoad(By.xpath("//iframe[@title='Iframe for card number']"));
        WebElement cardNumber = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@data-fieldtype='encryptedCardNumber']"));
        DriverManager.getInstance().startListeningToAPIResponses("test.adyen.com");
        Browser.enterTextInEditBox(cardNumber, PbNUIApp.userdata().getCardNumber(2, "1"));
        Browser.waitForAPIResponse(200);
        Browser.switchToDefaultContent();
        enterCardDate();
        enterCVC();
        enterPostalCode();
    }

    public void enterAndValidateCardDetailsWithIncorrectCvc() {
        Browser.waitForElementPresence(By.xpath("//div[@class='adyen-checkout__spinner adyen-checkout__spinner--large']"));
        Browser.waitForElementInvisibility(DriverManager.getInstance().Driver.findElement(By.xpath("//div[@class='adyen-checkout__spinner adyen-checkout__spinner--large']")));
        Browser.waitForFrameToLoad(By.xpath("//iframe[@title='Iframe for card number']"));
        WebElement cardNumber = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@data-fieldtype='encryptedCardNumber']"));
        Browser.enterTextInEditBox(cardNumber, PbNUIApp.userdata().getCardNumber(2, "1"));
        Browser.switchToDefaultContent();
        enterCardDate();
        enterIncorrectCvc();
        enterPostalCode();
        WebElement cvcValidationMessage = DriverManager.getInstance().Driver.findElement(By.xpath("//span[@class='adyen-checkout__error-text' and contains(text(),'Enter the complete security code')]"));
        Assert.assertEquals("Enter the complete security code",cvcValidationMessage.getText() );
    }

    public void enterCardDate() {
        Browser.waitForFrameToLoad(By.xpath("//iframe[@title='Iframe for expiry date']"));
        WebElement cardDate = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@data-fieldtype='encryptedExpiryDate']"));
        Browser.enterTextInEditBox(cardDate, PbNUIApp.userdata().getCardMonth(2, "1"));
        Browser.switchToDefaultContent();
    }

    public void enterCVC() {
        Browser.waitForFrameToLoad(By.xpath("//iframe[@title='Iframe for security code']"));
        WebElement CVC = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@data-fieldtype='encryptedSecurityCode']"));
        Browser.enterTextInEditBox(CVC, PbNUIApp.userdata().getCardCVC(2, "1"));
        Browser.switchToDefaultContent();
    }

    public void enterIncorrectCvc() {
        Browser.waitForFrameToLoad(By.xpath("//iframe[@title='Iframe for security code']"));
        WebElement CVC = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@data-fieldtype='encryptedSecurityCode']"));
        Browser.enterTextInEditBox(CVC, PbNUIApp.userdata().getIncorrect_cvc(2, "1"));
        Browser.switchToDefaultContent();
    }

    public void enterPostalCode() {
        WebElement postalCode = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@name='postalCode']"));
        Browser.enterTextInEditBox(postalCode, PbNUIApp.userdata().getPostalCode(2, "1"));
    }

    public void enterAmount() {
        Browser.waitForElementInvisibility(DriverManager.getInstance().Driver.findElement(By.xpath("//*[@data-icon='spinner']")));
        WebElement amountBox = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@class='form-control requested-amount-input']"));
        WebElement mutedText = DriverManager.getInstance().Driver.findElement(By.xpath("//*[@id='charge-now-tabs-id-pane-1']//span[@class='text-muted']"));
        Random random = new Random();
        double randomValue = 1 + (100 - 1) * random.nextDouble();
        String amountString = String.format("%.2f", randomValue);
        Browser.waitForElementToBeClickable(amountBox);
        amountBox.clear();
        Browser.clickOnElement(mutedText);
        Browser.waitForAttributeValue(amountBox,"value","");
        amountBox.sendKeys(amountString);
        Browser.doubleClickOnElement(mutedText);
        Browser.waitForAttributeValue(amountBox,"value",amountString);
    }

    public void clickOnChargeButton() {
        Browser.waitForElementToBeVisible(By.xpath("//button[text()='Charge']"));
        WebElement charge = DriverManager.getInstance().Driver.findElement(By.xpath("//button[text()='Charge']"));
        Browser.clickOnElement(charge);
        WebElement confirmYes = DriverManager.getInstance().Driver.findElement(By.xpath("//button[text()='Yes']"));
        Browser.clickOnElement(confirmYes);
        Browser.waitForElementInvisibility(DriverManager.getInstance().Driver.findElement(By.xpath("//*[@class='svg-inline--fa fa-spinner fa-w-16 fa-spin fa-3x ']")));
    }

    public void enterChargeDescription() {
        WebElement enterAmountTextBox = DriverManager.getInstance().Driver.findElement(By.xpath("//textarea[@class='payment-note-input form-control']"));
        Browser.enterTextInEditBox(enterAmountTextBox, "Entered Description");
    }

    public void verifyPaymentSuccess() {
        Browser.waitForPresenceOfElement(By.xpath("//p[@class='MuiTypography-root pc-text-success MuiTypography-body1']"));
        WebElement paymentLabel = DriverManager.getInstance().Driver.findElement(By.xpath("//p[@class='MuiTypography-root pc-text-success MuiTypography-body1']"));
        Browser.waitForPresenceOfElement(By.xpath("//p[@class='MuiTypography-root pc-text-success MuiTypography-body1']"));
        Assert.assertEquals(paymentLabel.getText(), "Payment Successful!");
    }

    public void downloadPaymentReceipt(){
        Browser.waitForElementToBeVisible(By.xpath("//button[@class='btn btn-default' and contains(text(),'Download Receipt')]"));
        WebElement downloadButton = DriverManager.getInstance().Driver.findElement(By.xpath("//button[@class='btn btn-default' and contains(text(),'Download Receipt')]"));
        Browser.clickOnElement(downloadButton);
    }

    public void dismissPaymentConfirmationModal(){
        WebElement crossIcon = DriverManager.getInstance().Driver.findElement(By.xpath("//*[name()='svg' and @class='MuiSvgIcon-root close-confirmation-window']"));
        Browser.clickOnElement(crossIcon);
    }
}