package Pages;
import Framework.Browser;
import Framework.Constants.Constants;
import Framework.Root.PbNUIApp;
import Framework.Util.DriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PracticeHomePage extends BasePage {
    public PracticeHomePage(Constants.PageTitle title) {
        super(title);
    }

    private WebElement userProfileDropdown = DriverManager.getInstance().Driver.findElement(By.xpath("//li[contains(@class,'dropdown account-dropdown')]/a/i[@class='fa fa-caret-down']"));


    public void clickOnUserProfileDropdown() {
        Browser.clickOnElement(userProfileDropdown);
    }

    public void iClickOn(String dropdownOption) {
        switch (dropdownOption) {
            case "Campaigns":
                PbNUIApp.navigator().selectProfileDropdownOption(Constants.userProfileOptions.Campaigns);
                break;
            case "User Profile":
                PbNUIApp.navigator().selectProfileDropdownOption(Constants.userProfileOptions.UserProfile);
                break;
            case "Goals":
                PbNUIApp.navigator().selectProfileDropdownOption(Constants.userProfileOptions.Goals);
                break;
            case "Goals Report":
                PbNUIApp.navigator().selectProfileDropdownOption(Constants.userProfileOptions.GoalsReport);
                break;
            case "Communications":
                PbNUIApp.navigator().selectProfileDropdownOption(Constants.userProfileOptions.Communications);
                break;
            case "Notifications":
                PbNUIApp.navigator().selectProfileDropdownOption(Constants.userProfileOptions.Notifications);
                break;
            case "Settings":
                PbNUIApp.navigator().selectProfileDropdownOption(Constants.userProfileOptions.Settings);
                break;
            case "Support":
                PbNUIApp.navigator().selectProfileDropdownOption(Constants.userProfileOptions.Support);
                break;
            case "Logout":
                PbNUIApp.navigator().selectProfileDropdownOption(Constants.userProfileOptions.Logout);
                break;
            default:
                Assert.fail("Unable to find " + dropdownOption + " from userOptionsDropDown.");

        }
    }

}


