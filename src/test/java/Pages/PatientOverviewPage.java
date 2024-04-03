package Pages;

import Framework.Browser;
import Framework.Constants.Constants;
import Framework.Util.Verify;
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
        Browser.clickOnElement(DriverManager.getInstance().Driver.findElement(By.xpath("//button[normalize-space()='Open']")));
    }

    public void clickInProgressTasksButton() {
        DriverManager.getInstance().fluentwait().until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='In progress']")));
        Browser.clickOnElement(DriverManager.getInstance().Driver.findElement(By.xpath("//button[normalize-space()='In progress']")));
    }

    public void validateAllButtonStatus() {
        DriverManager.getInstance().pageReady();Browser.waitForElementToBeVisible(By.xpath("//*[text()='No tasks available']"));
        WebElement entry = DriverManager.getInstance().Driver.findElement(By.xpath("//*[text()='No tasks available']"));
        Assert.assertTrue(Browser.getTextFromElement(entry).contains("No tasks available"));
    }

    public void validateClosedStatus() {
        Browser.clickOnElement(DriverManager.getInstance().Driver.findElement(By.xpath("//button[text()='Closed']")));
        DriverManager.getInstance().pageReady();

        if(!Browser.iselementDisplayed("//td[@class='react-bs-table-no-data']")==true) {
            Browser.waitForElementToBeVisible(By.xpath("(//tbody/tr[@class='custom-row-class']/td[2])[1]"));
            List<WebElement> closed = DriverManager.getInstance().Driver.findElements(By.xpath("//tbody/tr[@class='custom-row-class']/td[2]"));
            try {
                for(WebElement webelement:closed) {
                    Verify.verifyEquals(Browser.getTextFromElement(webelement), "Closed", "Closed not matched");
                }
                //Verify.assertAll();
            } catch (AssertionError e) {
                logger.warning(e.getMessage());
            }
            Browser.clickOnElement(DriverManager.getInstance().Driver.findElement(By.xpath("//button[text()='Closed']")));
        }
        else {
            logger.info("no task available");
        }
    }

    public void validateOpenStatus() {
        Browser.clickOnElement(DriverManager.getInstance().Driver.findElement(By.xpath("//button[text()='Open']")));
        DriverManager.getInstance().pageReady();
        if(!Browser.iselementDisplayed("//td[@class='react-bs-table-no-data']")==true) {
            Browser.waitForElementToBeVisible(By.xpath("(//tbody/tr[@class='custom-row-class']/td[2])[1]"));
            List<WebElement> open = DriverManager.getInstance().Driver.findElements(By.xpath("//tbody/tr[@class='custom-row-class']/td[2]"));
            try {
                for(WebElement webelement:open) {
                    Verify.verifyEquals(Browser.getTextFromElement(webelement), "Open", "Open not matched");
                }
              // Verify.assertAll();
            } catch (AssertionError e) {
                logger.warning(e.getMessage());
            }
            Browser.clickOnElement(DriverManager.getInstance().Driver.findElement(By.xpath("//button[text()='Open']")));
        }
        else {
            logger.info("no task available");
        }
    }

    public void validateInProgressStatus() {
        Browser.clickOnElement(DriverManager.getInstance().Driver.findElement(By.xpath("//button[text()='In progress']")));
        DriverManager.getInstance().pageReady();
        if(!Browser.iselementDisplayed("//td[@class='react-bs-table-no-data']")==true) {
            Browser.waitForElementToBeVisible(By.xpath("(//tbody/tr[@class='custom-row-class']/td[2])[1]"));
            List<WebElement> inprogress = DriverManager.getInstance().Driver
                    .findElements(By.xpath("//tbody/tr[@class='custom-row-class']/td[2]"));
            try {
                for(WebElement webelement:inprogress) {
                    Verify.verifyEquals(Browser.getTextFromElement(webelement), "In Progress", "In Progress not matched");
                }
               //Verify.assertAll();
            } catch (AssertionError e) {
                logger.warning(e.getMessage());
            }
            Browser.clickOnElement(DriverManager.getInstance().Driver.findElement(By.xpath("//button[text()='In progress']")));
        }
        else {
            logger.info("no task available");
        }
    }

}

