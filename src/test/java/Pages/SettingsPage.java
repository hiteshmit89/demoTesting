package Pages;

import Framework.Browser;
import Framework.Constants.Constants;
import Framework.Util.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import javax.swing.*;

public class SettingsPage extends BasePage{


    public SettingsPage(Constants.PageTitle title) {
        super(title);
    }
    public static WebElement paymentToggleAdyen = DriverManager.getInstance().Driver.findElement(By.xpath("//label[@class='custom-control-label']"));


    public void clicktoggleButton(){

        Browser.scrollToView(paymentToggleAdyen);
        paymentToggleAdyen.click();

    }





}
