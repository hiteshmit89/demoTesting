package Pages;

import Framework.Browser;
import Framework.Constants.Constants;
import Framework.Util.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.sql.Driver;
import java.util.List;

public class PaymentsPage extends BasePage{

    public PaymentsPage(Constants.PageTitle title) {
        super(title);
    }
    WebElement paymentstab = DriverManager.getInstance().Driver.findElement(By.xpath("//a[@id='payment-page-tab-Payments']"));
    WebElement paymentMethodsTab = DriverManager.getInstance().Driver.findElement(By.xpath("//a[@id='payment-page-tab-Payments']"));
    WebElement patientCardCount = DriverManager.getInstance().Driver.findElement(By.xpath("//*[@id=\"payment-page-pane-Payment Methods\"]/div/div[3]/div[2]/div/table/tbody/tr[1]/td[2]/div/div[2]"));
    WebElement modalBtnChargePatient = DriverManager.getInstance().Driver.findElement(By.xpath("//button[@class='btn btn-primary' and contains(text(),'Charge Patient')]"));
    WebElement dropdownSelectPaymentMethod = DriverManager.getInstance().Driver.findElement(By.xpath("//*[@id='payment-methods-selector']"));




    public void clickPaymentsMenu(){
        Browser.clickOnElement(paymentstab);
    }
    public void clickPaymentsMethodsMenu(){
        Browser.clickOnElement(paymentMethodsTab);
    }
    public void chargePatientusingCard(){
        Browser.clickOnElement(patientCardCount);
        Browser.waitForPageReady();
        Browser.clickOnElement(modalBtnChargePatient);
        List<WebElement> paymentMethodDropdown = DriverManager.getInstance().Driver.findElements(By.xpath("//*[@id='payment-methods-selector']"));
        for(WebElement s: paymentMethodDropdown){

        }




    }
}
