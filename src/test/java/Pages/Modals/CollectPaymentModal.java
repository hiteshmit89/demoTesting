package Pages.Modals;

import Framework.Browser;
import Framework.Root.PbNUIApp;
import Framework.Util.DriverManager;
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
        WebElement patientSearchBox = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@class='rbt-input-main form-control rbt-input']"));
        Browser.enterTextInEditBox(patientSearchBox,PbNUIApp.userdata().getPatientName(1, 1));
    }

    public void enterAmount(){
        WebElement amountSearchBox = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@class='amount-input-fields']"));
        Random randon = new Random();
        int amount = randon.nextInt(10000);
        Browser.enterTextInEditBox(amountSearchBox,String.valueOf(amount));
    }

    public void selectPaymentMethod(){
        WebElement paymentMethodRadioButton = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@name='mui-66678']"));
        Browser.clickOnElementUsingJavascript(paymentMethodRadioButton);
        WebElement chargeNewCard = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@class='MuiBox-root jss46 pm-new-card-btn']"));
        Browser.clickOnElementUsingJavascript(chargeNewCard);
        Browser.waitForPageReady();
        Browser.waitForFrameToLoad(By.xpath("//iframe[@title='Iframe for card number']"));
        WebElement enterCardNumber = DriverManager.getInstance().Driver.findElement(By.xpath(""));


    }



}
