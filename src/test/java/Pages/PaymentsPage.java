package Pages;

import Framework.Browser;
import Framework.Constants.Constants;
import Framework.Util.ConfigManager;
import Framework.Util.DriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PaymentsPage extends BasePage {
    public PaymentsPage(Constants.PageTitle title) {
        super(title);
    }

    private WebElement paymentsTab = DriverManager.getInstance().Driver.findElement(By.xpath("//li[@class='active']//a[contains(text(),'Payments')]"));
    private WebElement widgetLink = DriverManager.getInstance().Driver.findElement(By.xpath("//a[@id='payment-page-tab-Widgets']"));

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

}


