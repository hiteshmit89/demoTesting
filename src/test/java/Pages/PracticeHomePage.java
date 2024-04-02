package Pages;
import Framework.Browser;
import Framework.Constants.Constants.*;
import Framework.Root.PbNUIApp;
import Framework.Util.DriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.util.List;

public class PracticeHomePage extends BasePage {
    public PracticeHomePage(PageTitle title) {
        super(title);
    }

    private final WebElement userProfileDropdown = DriverManager.getInstance().Driver.findElement(By.xpath("//li[contains(@class,'dropdown account-dropdown')]/a/i[@class='fa fa-caret-down']"));
    private final WebElement campaignsMenuItem = DriverManager.getInstance().Driver.findElement(By.xpath("//ul[@class='dropdown-menu']//i[@class='fa fa-list fa-fw']"));
    private final WebElement settingMenuItem = DriverManager.getInstance().Driver.findElement(By.xpath("//ul[@class='dropdown-menu']//i[@class='fa fa-gear fa-fw']"));
    public void clickOnUserProfileDropdown() {
        Browser.clickOnElement(userProfileDropdown);
    }

    public void iClickOn(String dropdownOption) {
        switch (dropdownOption) {
            case "Campaigns":
                PbNUIApp.navigator().selectProfileDropdownOption(userProfileOptions.Campaigns);
                break;
            case "User Profile":
                PbNUIApp.navigator().selectProfileDropdownOption(userProfileOptions.UserProfile);
                break;
            case "Goals":
                PbNUIApp.navigator().selectProfileDropdownOption(userProfileOptions.Goals);
                break;
            case "Goals Report":
                PbNUIApp.navigator().selectProfileDropdownOption(userProfileOptions.GoalsReport);
                break;
            case "Communications":
                PbNUIApp.navigator().selectProfileDropdownOption(userProfileOptions.Communications);
                break;
            case "Notifications":
                PbNUIApp.navigator().selectProfileDropdownOption(userProfileOptions.Notifications);
                break;
            case "Settings":
                PbNUIApp.navigator().selectProfileDropdownOption(userProfileOptions.Settings);
                break;
            case "Support":
                PbNUIApp.navigator().selectProfileDropdownOption(userProfileOptions.Support);
                break;
            case "Logout":
                PbNUIApp.navigator().selectProfileDropdownOption(userProfileOptions.Logout);
                break;
            default:
                Assert.fail("Unable to find " + dropdownOption + " from userOptionsDropDown.");
        }
    }
    public void clickOnSettingsMenuItem() {
        Browser.clickOnElement(settingMenuItem);
    }
}


