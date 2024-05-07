package Pages;
import Framework.Browser;
import Framework.Constants.Constants.*;
import Framework.Util.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
public class RevenueIQPage extends BasePage {
    public RevenueIQPage(PageTitle Title) {
        super(Title);
    }

    public void clickOnTreatment() {
        WebElement Treatment = DriverManager.getInstance().Driver.findElement(By.xpath("//a[@href='/revenue_opportunities/1/Treatment/']"));
        Browser.clickOnElement(Treatment);
    }

    public void clickOnSearchButton() {
        Browser.waitForElementToBeVisible(By.xpath("//button[@class='btn btn-primary search-button']"));
        WebElement searchButton = DriverManager.getInstance().Driver.findElement(By.xpath("//button[@class='btn btn-primary search-button']"));
        Browser.scrollToVisibleElement(searchButton);
        Browser.clickOnElement(searchButton);
    }

    public void clickOnPatientNameToOpenTheirPatientWindow() {
        WebElement patientTable = DriverManager.getInstance().Driver.findElement(By.xpath("//*[@id='DataTables_Table_0']"));
        Browser.waitForElementToDisplay(patientTable);
        Browser.waitForTableToLoad(patientTable);
        List<WebElement> patientName = patientTable.findElements(By.xpath(".//div[@class='patient-name-container']"));
        Browser.waitForElementToBeClickable(patientName.getFirst());
        Browser.scrollToVisibleElement(patientName.getFirst());
        Browser.clickOnElement(patientName.getFirst());
    }
}