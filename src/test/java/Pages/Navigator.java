package Pages;

import Framework.Browser;
import Framework.Constants.Constants.Destination;
import Framework.Util.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.security.PrivateKey;
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

    public void findAndSelectPatientByExactMatchOf(String patientName) {
        WebElement topNavSearch = DriverManager.getInstance().Driver.findElement(By.xpath("/html/body//li//i[@class='fa fa-search']"));
        Browser.clickOnElement(topNavSearch);
        WebElement patientFinderPopup = DriverManager.getInstance().Driver.findElement(By.xpath("//*[contains(@class,'popover popover-patient-finder')]"));
        Browser.waitForElementToDisplay(patientFinderPopup);
        WebElement patientSearch = patientFinderPopup.findElement(By.xpath(".//input"));
        Browser.enterTextInEditBox(patientSearch, patientName);
        WebElement searchResults = patientFinderPopup.findElement(By.xpath(".//div[@class='search-results']"));
        Browser.waitForTableToLoad(searchResults);
        List<WebElement> tableRows = searchResults.findElements(By.xpath(".//tr"));
        for (WebElement row: tableRows) {
            if (Browser.getTextFromElement(row).equals(patientName)) {
                Browser.clickOnElement(row);
                break;
            }
        }
    }
}
