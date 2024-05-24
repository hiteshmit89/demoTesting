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
    CollectPaymentModal(){
        Browser.waitForPageReady();
    }

    public void clickOnFloatingPaymentButton(){
        PbNUIApp.navigator().ClickOnFloatingButton(Payments);
    }

    public void enterPatientName(){
        WebElement patientEditBox = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@class='rbt-input-main form-control rbt-input']"));
        Browser.enterTextInEditBox(patientEditBox, PbNUIApp.userdata().getPatientName(1,1));
        WebElement parent = DriverManager.getInstance().Driver.findElement(By.xpath("//*[@id='charge-now-tabs-id-pane-1']//div[@class='rbt']"));
        Browser.waitForElementChildren(parent, By.xpath(".//div[@id='PatientSearchInput']"),1);
        WebElement child = parent.findElement(By.xpath(".//a[@class='dropdown-item patient-search-result-menu-item ']"));
        Browser.clickOnElementUsingJavascript(child.findElement(By.xpath("//a[@id='PatientSearchInput-item-0']")));
    }

    public void enterAmount(){
        Browser.waitForElementInvisibility(DriverManager.getInstance().Driver.findElement(By.xpath("//*[@data-icon='spinner']")));
        WebElement amountBox = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@class='form-control requested-amount-input']"));
        Random random = new Random();
        int amount = random.nextInt(1000);
        Browser.waitForElementToBeClickable(amountBox);
        Browser.waitForElementToBeVisible(amountBox);
        Browser.enterTextInEditBox(amountBox, String.valueOf(amount));
    }

    public void selectPaymentMethod(){
        WebElement paymentMethodRadioButton = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@name='mui-66678']"));
        Browser.clickOnElementUsingJavascript(paymentMethodRadioButton);
        WebElement chargeNewCard = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@class='MuiBox-root jss46 pm-new-card-btn']"));
        Browser.clickOnElementUsingJavascript(chargeNewCard);
        Browser.waitForPageReady();
        Browser.waitForFrameToLoad(By.xpath("//iframe[@title='Iframe for card number']"));
        WebElement cardNumber = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@data-fieldtype='encryptedCardNumber']"));
        Browser.enterTextInEditBox(cardNumber,PbNUIApp.userdata().getCardNumber(2, "1"));
        Browser.switchToDefaultContent();
        Browser.waitForFrameToLoad(By.xpath("//iframe[@title='Iframe for expiry date']"));
        WebElement cardDate = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@data-fieldtype='encryptedExpiryDate']"));
        Browser.enterTextInEditBox(cardDate,PbNUIApp.userdata().getCardMonth(2, "1"));
        Browser.switchToDefaultContent();
        Browser.waitForFrameToLoad(By.xpath("//iframe[@title='Iframe for security code']"));
        WebElement CVC = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@data-fieldtype='encryptedSecurityCode']"));
        Browser.enterTextInEditBox(CVC,PbNUIApp.userdata().getCardCVC(2, "1"));
        Browser.switchToDefaultContent();
        WebElement postalCode = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@name='postalCode']"));
        Browser.enterTextInEditBox(postalCode,PbNUIApp.userdata().getPostalCode(2, "1"));
        WebElement charge = DriverManager.getInstance().Driver.findElement(By.xpath("//button[text()='Charge']"));
        Browser.clickOnElementUsingJavascript(charge);
        WebElement confirmYes = DriverManager.getInstance().Driver.findElement(By.xpath("//button[text()='Yes']"));
        Browser.clickOnElementUsingJavascript(confirmYes);
        Browser.waitForElementInvisibility(DriverManager.getInstance().Driver.findElement(By.xpath("//*[@data-icon='spinner']")));
        WebElement paymentLabel = DriverManager.getInstance().Driver.findElement(By.xpath("//p[@class='MuiTypography-root pc-text-success MuiTypography-body1']"));
        String Label = paymentLabel.getText();
        Assert.assertEquals(Label,"Payment Successful!");
    }
}
