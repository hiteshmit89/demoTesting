package Pages;

import Framework.Browser;
import Framework.Constants.Constants;
import Framework.Util.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import javax.swing.*;

public class SettingsPage extends BasePage{

    public static WebElement paymentToggleAdyen = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@class='custom-control-input']"));
    public static void toggleButton(){
        Browser.waitForElementToDisplay(paymentToggleAdyen);
        paymentToggleAdyen.isEnabled();

    }



    public SettingsPage(Constants.PageTitle title) {
        super(title);
    }

}
