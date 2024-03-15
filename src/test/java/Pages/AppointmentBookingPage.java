package Pages;

import Framework.Browser;
import Framework.Constants.Constants.PageTitle;
import Framework.Util.DriverManager;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppointmentBookingPage extends BasePage {
    public AppointmentBookingPage(PageTitle title) {
        super(title);
    }
    public void clickOnPickLocation() {
        WebElement pickLocation = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@class='location-item-name'and text()='Romans, Burke and Wagner']"));
        Browser.clickOnElement(pickLocation);
    }
    public void clickOnSelectNewPatient() {
        WebElement selectNewPatient = DriverManager.getInstance().Driver.findElement(By.xpath("//span[normalize-space()=\"I'm a New Patient\"]"));
        Browser.clickOnElement(selectNewPatient);
    }
}
