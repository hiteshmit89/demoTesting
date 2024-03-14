package Pages;


import Framework.Browser;
import Framework.Constants.Constants;
import Framework.Util.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class HeaderNavigation extends BasePage {
    public HeaderNavigation(Constants.PageTitle title) {
        super(title);
    }


    public static WebElement profileIconNav = DriverManager.getInstance().Driver.findElement(By.xpath("//li[@class='dropdown account-dropdown']"));
    public static WebElement profileSettingIcon = DriverManager.getInstance().Driver.findElement(By.xpath("//ul[@class='dropdown-menu']//*[contains(@href,'/settings/1/')]"));


    //Methods related to profile and profile menu in header navigation
    public static void clickOnProfileIcon(){
        Browser.waitForElementToDisplay(profileIconNav);
        Browser.clickOnElement(profileIconNav);
    }
    public static void clickSettingIcon(){
        Browser.waitForElementToDisplay(profileSettingIcon);
        Browser.clickOnElement(profileSettingIcon);

    }



}
