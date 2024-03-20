package Pages;

import Framework.Browser;
import Framework.Constants.Constants.PageTitle;
import Framework.Util.DriverManager;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppointmentsPage extends BasePage {

    public AppointmentsPage(PageTitle title) {
        super(title);
    }

    WebElement header = DriverManager.getInstance().Driver.findElement(By.xpath("//*[@id='appointment-booking']//span[text()='Online Appointment Booking']"));
    WebElement eUrl = DriverManager.getInstance().Driver.findElement(By.xpath("(//span[contains(text(),'https://www.patientsreach.com/schedule/')])[1]"));
    
    public void clickOnWidgets() {
        WebElement widgetsTab = DriverManager.getInstance().Driver.findElement(By.xpath("//a[@id='appointment-booking-page-tab-Widgets']"));
        Browser.clickOnElement(widgetsTab);
    }

    public void clickOnCopyUrl() {

        Browser.clickOnElement(CopyUrlIcon);
        String urlText = eUrl.getText();
        String[] arrOfStr = urlText.split("schedule");
        for (String a : arrOfStr) {
            System.out.println(a);
        }
        String URL = "https://qa3.pbn-dev.com";
        URL = String.join("", URL, "/schedule", arrOfStr[1]);
        System.out.println(URL);
        Browser.navigateToNewURL(URL);
    }


}


