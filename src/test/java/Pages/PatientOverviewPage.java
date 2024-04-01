package Pages;

import Framework.Browser;
import Framework.Constants.Constants;
import Framework.Util.DriverManager;
import junit.framework.Assert;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PatientOverviewPage extends BasePage {
    public PatientOverviewPage(Constants.PageTitle PageTitle) {
        super(PageTitle);
    }

    public void clickViewTasksList() {
        Browser.waitForElementToDisplay(DriverManager.getInstance().Driver.findElement(By.xpath("//span[@class='task-heading']")));
        Browser.clickUsingJavascript(DriverManager.getInstance().Driver.findElement(By.xpath("//span[@class='task-heading']")));
    }

    public void clickOpenTasksButton() {
        DriverManager.getInstance().fluentwait().until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Open']")));
        Browser.clickOnElement(DriverManager.getInstance().Driver.findElement(By.xpath("//button[text()='Open']")));
    }

    public void clickInProgressTasksButton() {
        DriverManager.getInstance().fluentwait().until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='In progress']")));
        Browser.clickOnElement(DriverManager.getInstance().Driver.findElement(By.xpath("//button[text()='In progress']")));
    }

    public void validateAllButtonStatus() {
        Browser.waitForPageReady();
        Browser.waitForElementToBeVisible(By.xpath("//*[text()='No tasks available']"));
        WebElement entry = DriverManager.getInstance().Driver.findElement(By.xpath("//*[text()='No tasks available']"));
        Assert.assertTrue(Browser.getTextFromElement(entry).contains("No tasks available"));
    }

    public void validateClosedStatus() {
        Browser.waitForPageReady();
        Browser.clickOnElement(DriverManager.getInstance().Driver.findElement(By.xpath("//button[text()='Closed']")));
        Browser.waitForElementToBeVisible(By.xpath("(//tbody/tr[@class='custom-row-class']/td[2])[1]"));
        List<WebElement> closed = DriverManager.getInstance().Driver.findElements(By.xpath("//tbody/tr[@class='custom-row-class']/td[2]"));
        try {
            for (WebElement webElement : closed) {
                softAssertions.assertThat(Browser.getTextFromElement(webElement)).contains("Closed");
            }
            softAssertions.assertAll();
        } catch (AssertionError e) {
            Logger().warning("error :" + e.getMessage());
        }
        Browser.clickOnElement(DriverManager.getInstance().Driver.findElement(By.xpath("//button[text()='Closed']")));
    }

    public void validateOpenStatus() {
        Browser.clickOnElement(DriverManager.getInstance().Driver.findElement(By.xpath("//button[text()='Open']")));
        Browser.waitForPageReady();
        Browser.waitForElementToBeVisible(By.xpath("(//tbody/tr[@class='custom-row-class']/td[2])[1]"));
        List<WebElement> open = DriverManager.getInstance().Driver.findElements(By.xpath("//tbody/tr[@class='custom-row-class']/td[2]"));
        try {
            for (WebElement webElement : open) {
                softAssertions.assertThat(Browser.getTextFromElement(webElement)).contains("Open");
            }
            softAssertions.assertAll();
        } catch (AssertionError e) {
            Logger().warning("error :" + e.getMessage());
        }
        Browser.clickOnElement(DriverManager.getInstance().Driver.findElement(By.xpath("//button[text()='Open']")));
    }

    public void validateInProgressStatus() {
        Browser.clickOnElement(DriverManager.getInstance().Driver.findElement(By.xpath("//button[text()='In progress']")));
        Browser.waitForPageReady();
        Browser.waitForElementToBeVisible(By.xpath("(//tbody/tr[@class='custom-row-class']/td[2])[1]"));
        List<WebElement> InProgress = DriverManager.getInstance().Driver.findElements(By.xpath("//tbody/tr[@class='custom-row-class']/td[2]"));
        try {
            for (WebElement webElement : InProgress) {
                softAssertions.assertThat(Browser.getTextFromElement(webElement)).contains("In Progress");
            }
            softAssertions.assertAll();
        } catch (AssertionError e) {
            Logger().warning("error :" + e.getMessage());
        }
        Browser.clickOnElement(DriverManager.getInstance().Driver.findElement(By.xpath("//button[text()='In progress']")));
    }
}
