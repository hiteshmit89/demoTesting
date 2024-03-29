package Pages;

import Framework.Browser;
import Framework.Constants.Constants;
import Framework.Util.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PaymentsPage extends BasePage{

    public PaymentsPage(Constants.PageTitle title) {
        super(title);
    }
    WebElement paymentstab = DriverManager.getInstance().Driver.findElement(By.xpath("//a[@id='payment-page-tab-Payments']"));
    WebElement paymentMethodsTab = DriverManager.getInstance().Driver.findElement(By.xpath("//a[@id='payment-page-tab-Payments']"));



    public void clickPaymentsMenu(){
        Browser.clickOnElement(paymentstab);
    }
    public void clickPaymentsMethodsMenu(){
        Browser.clickOnElement(paymentMethodsTab);
    }
}
