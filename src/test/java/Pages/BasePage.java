package Pages;

import Framework.Browser;
import Framework.Constants.Constants;
import Framework.Util.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static Framework.Constants.Constants.*;

public class BasePage {
    private WebElement appoinmentsNav = DriverManager.getInstance().Driver.findElement(By.xpath("//ul[@class='nav navbar-nav navbar-left pn-master-dashboard-nav']/li/a[contains(text(),'Appointments')]"));
    private WebElement formsNav = DriverManager.getInstance().Driver.findElement(By.xpath("//ul[@class='nav navbar-nav navbar-left pn-master-dashboard-nav']/li/a[contains(text(),'Forms')]"));

    public BasePage(PageTitle title) {
        Browser.waitForPageReady();
        Browser.waitForPageTitle(title);
    }

    public void clickAppointmentsNav(){
        Browser.clickOnElement(appoinmentsNav);
    }
    public void clickformsNav(){
        Browser.clickOnElement(formsNav);
    }
}
