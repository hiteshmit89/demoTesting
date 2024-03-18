package Pages;
import Framework.Browser;
import Framework.Constants.Constants;
import Framework.Util.DriverManager;
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

}


