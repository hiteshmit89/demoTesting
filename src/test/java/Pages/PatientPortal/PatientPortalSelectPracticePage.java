package Pages.PatientPortal;

import Framework.Browser;
import Framework.Constants.Constants;
import Framework.Util.DriverManager;
import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PatientPortalSelectPracticePage extends BasePage {
    public PatientPortalSelectPracticePage(Constants.PageTitle title) {
        super(title);
    }


   public void clickOnSelectPractice() {
        Browser.waitForElementToBeVisible(By.xpath("//button[@class = 'btn text-white mt-3 rounded-5 px-5 py-2']"));
        WebElement selectPractice = DriverManager.getInstance().Driver.findElement(By.xpath("//button[@class = 'btn text-white mt-3 rounded-5 px-5 py-2']"));
        Browser.clickOnElement(selectPractice);
    }
}
