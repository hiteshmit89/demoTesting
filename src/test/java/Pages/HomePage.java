package Pages;

import Framework.Browser;
import Framework.Constants.Constants.PageTitle;
import Framework.Util.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends BasePage {
    public HomePage(PageTitle title) {
        super(title);
    }

    private WebElement userHeader = DriverManager.getInstance().Driver.findElement(By.xpath("//div//li[@class='user-header-info']"));
    private WebElement practiceInfoTable = DriverManager.getInstance().Driver.findElement(By.xpath("//*[@aria-describedby='practice_table_info']"));


    public void verifyUserHeaderIsDisplayed() {
        Browser.waitForElementToDisplay(userHeader);
    }

    public void clickOnPracticeInPracticeInfoTable(String practiceName) {
        List<WebElement> rows = practiceInfoTable.findElements(By.xpath(".//tr"));
        for (WebElement row: rows) {
            WebElement practice =  row.findElements(By.xpath("//td")).getFirst();
            if (Browser.getTextFromElement(practice).equals(practiceName)) {
                Browser.clickOnElement(practice);
                break;
            }
        }
    }
}
