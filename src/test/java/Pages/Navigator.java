package Pages;

import Framework.Browser;
import Framework.Constants.Constants.Destination;
import Framework.Util.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Navigator {
    public void NavigateTo(Destination destination) {
        List<WebElement> mainMenuItems = DriverManager.getInstance().Driver.findElements(By.xpath("//div/ul[contains(@class,'nav navbar-nav navbar-left pn-master-dashboard-nav')]/li/a"));
        for (WebElement item: mainMenuItems) {
            if (Browser.getTextFromElement(item).equals(destination.label)) {
                Browser.clickOnElement(item);
                break;
            }
        }
    }

    public void selectProfileDropdownOption(String dropdownOption) {
        DriverManager.getInstance().Driver.findElement(By.linkText(dropdownOption)).click();
    }

}
