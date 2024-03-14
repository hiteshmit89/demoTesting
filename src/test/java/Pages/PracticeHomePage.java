package Pages;

import Framework.Browser;
import Framework.Constants.Constants;
import Framework.Util.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PracticeHomePage extends BasePage{
    public PracticeHomePage(Constants.PageTitle title) {
        super(title);
    }

    private WebElement userProfileDropdown = DriverManager.getInstance().Driver.findElement(By.xpath("//li[contains(@class,'dropdown account-dropdown')]/a/i[@class='fa fa-caret-down']"));
    private WebElement campaignsMenuItem = DriverManager.getInstance().Driver.findElement(By.xpath("//ul[@class='dropdown-menu']//i[@class='fa fa-list fa-fw']"));


    public void clickOnUserProfileDropdown() {
        Browser.clickOnElement(userProfileDropdown);
    }

    public void
            () {

        Browser.clickOnElement(campaignsMenuItem);
    }
}
