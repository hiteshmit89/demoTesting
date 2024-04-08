package Pages;

import Framework.Browser;
import Framework.Constants.Constants.PageTitle;
import Framework.Util.DriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AppHomePage extends BasePage {
    public AppHomePage(PageTitle title) {
        super(title);
    }

    private WebElement userHeader = DriverManager.getInstance().Driver.findElement(By.xpath("//div//li[@class='user-header-info']"));
    private List<WebElement> practiceInfoTableRows = DriverManager.getInstance().Driver.findElements(By.xpath("//*[@aria-describedby='practice_table_info']/tbody/tr"));



    public void verifyUserHeaderIsDisplayed() {
        Browser.waitForElementToDisplay(userHeader);
    }

    public void clickOnPracticeInPracticeInfoTable(String practiceName) {
        boolean found = false;
        for (WebElement row: practiceInfoTableRows) {
            List<WebElement> practice =  row.findElements(By.xpath(".//td/a"));
            String currPracticeName = Browser.getTextFromElement(practice.get(0));
            if (currPracticeName.equals(practiceName)) {
                Browser.clickOnElement(practice.get(0));
                found = true;
                break;
            }
        }
        if (!found) {
            Assert.fail("Unable to find practice: " +practiceName);
        }
    }

    public void verifyWelcomeTextDisplayed() {
        WebElement welcomeText = DriverManager.getInstance().Driver.findElement(By.xpath("//*[@id='HomePageRoot']//h1[contains(text(),'Welcome')]"));
        Assert.assertTrue("Welcome text not displayed on practice home page.", welcomeText.isDisplayed());
    }
}