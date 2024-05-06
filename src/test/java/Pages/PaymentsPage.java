package Pages;

import Framework.Browser;
import Framework.Constants.Constants;
import Framework.Util.ConfigManager;
import Framework.Util.DriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.Random;


import java.util.Random;

public class PaymentsPage extends BasePage {
    public PaymentsPage(Constants.PageTitle title) {
        super(title);
    }

    private WebElement paymentsTab = DriverManager.getInstance().Driver.findElement(By.xpath("//li[@class='active']//a[contains(text(),'Payments')]"));
    private WebElement widgetLink = DriverManager.getInstance().Driver.findElement(By.xpath("//a[@id='payment-page-tab-Widgets']"));
    private final WebElement paymentMethodsTab = DriverManager.getInstance().Driver.findElement(By.xpath("//a[@id='payment-page-tab-Payment Methods']"));

    public void clickOnWidgetslink() {
        WebElement widgetsTab = DriverManager.getInstance().Driver.findElement(By.xpath("//a[@id='payment-page-tab-Widgets']"));
        Browser.waitForElementToBeClickable(widgetsTab);
        Browser.clickOnElement(widgetsTab);
    }

    public void clickOnWidgets() {
        Browser.waitForElementToBeVisible((By.xpath("//a[@id='payment-page-tab-Widgets']")));
        WebElement widgets = DriverManager.getInstance().Driver.findElement(By.xpath("//a[@id='payment-page-tab-Widgets']"));
        Browser.clickOnElement(widgets);
        Browser.waitForElementToBeVisible(By.xpath("//span[contains(text(),'https://www.patientsreach.com/payment/')]"));
    }

    public void createPaymentURLAndNavigate() {
        WebElement eLink = DriverManager.getInstance().Driver.findElement(By.xpath("//span[contains(text(),'https://www.patientsreach.com/payment/')]"));
        String urlText = eLink.getText();
        String[] arrOfStr = urlText.split("payment");
        String URL = ConfigManager.getInstance().getProperty("URL");
        URL = String.join("", URL, "/payment", arrOfStr[1]);
        Browser.navigateToNewURL(URL);
    }

    public void clickPaymentsMenu() {
        Browser.clickOnElement(paymentsTab);
    }

    public void clickPaymentsMethodsTab() {
        Browser.clickOnElement(paymentMethodsTab);
    }

    public void clickCardIcon(){
        Browser.waitForElementToBeVisible(By.xpath("(//*[@class='svg-inline--fa fa-credit-card fa-w-18 card-icon'])[1]"));
        Browser.waitForElementToBeClickable(By.xpath("(//*[@class='svg-inline--fa fa-credit-card fa-w-18 card-icon'])[1]"));
        WebElement cardIcon = DriverManager.getInstance().Driver.findElement(By.xpath("(//*[@class='svg-inline--fa fa-credit-card fa-w-18 card-icon'])[1]"));
        Browser.clickOnElement(cardIcon);
    }

    public void selectDropdownValue(){
        Browser.waitForElementToBeVisible(By.xpath("//*[@id='payment-methods-selector']"));
        Browser.waitForElementToBeClickable(By.xpath("//*[@id='payment-methods-selector']"));
        WebElement dropdownSelectPaymentMethod = DriverManager.getInstance().Driver.findElement(By.xpath("//*[@id='payment-methods-selector']"));
        Browser.selectIndexFromDropdown(dropdownSelectPaymentMethod, 1);
    }

    public void enterAmount(){
        WebElement enterAmountTextBox = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@type='number']"));
        Random random = new Random();
        int randomNumber = random.nextInt(10000);
        Browser.enterTextInEditBox(enterAmountTextBox, String.valueOf(randomNumber));
    }

    public void enterChargeDescription(){
        WebElement enterAmountTextBox = DriverManager.getInstance().Driver.findElement(By.xpath("//textarea[@class='charge-description-input-box form-control']"));
        Browser.enterTextInEditBox(enterAmountTextBox,"Entered Description");
    }

    public void clickChargeButtonOnModal(){
        WebElement chargeButton = DriverManager.getInstance().Driver.findElement(By.xpath("//button[@class='btn btn-default']//span[text()=' Charge ']"));
        Browser.clickOnElement(chargeButton);
        WebElement chargeConfirmationPopUp = DriverManager.getInstance().Driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
        Browser.clickOnElement(chargeConfirmationPopUp);
    }

    public void verifyChargeConfirmationText(){
        Browser.waitForElementToBeVisible(By.xpath("//span[@class='success' and contains(text(),'Charge Successful for')]"));
        WebElement textChargeSuccessful = DriverManager.getInstance().Driver.findElement(By.xpath("//span[@class='success' and contains(text(),'Charge Successful for')]"));
        if(Browser.getTextFromElement(textChargeSuccessful).contains("Charge Successful for")){
            Assert.assertTrue("Charge Successful for",textChargeSuccessful.isDisplayed());
        } else {
            Assert.assertFalse("Charge Successful for",textChargeSuccessful.isDisplayed());
        }
    }


}


