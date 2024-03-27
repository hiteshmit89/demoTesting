package Pages;

import Framework.Browser;
import Framework.Constants.Constants;
import Framework.Util.DriverManager;
import io.cucumber.java.After;
import junit.framework.Assert;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class PatientOverviewPage extends BasePage {
    public PatientOverviewPage(Constants.PageTitle PageTitle) {
        super(PageTitle);
    }

    SoftAssertions softAssertions = new SoftAssertions();

    public void clickViewTasksList() {
        Browser.waitForElementToDisplay(DriverManager.getInstance().Driver.findElement(By.xpath("//span[@class='task-heading']")));
        Browser.clickUsingJavascript(DriverManager.getInstance().Driver.findElement(By.xpath("//span[@class='task-heading']")));
    }
        public void clickOpenTasksButton() {
            DriverManager.getInstance().fluentwait().until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Open']")));
            Browser.clickOnElement(DriverManager.getInstance().Driver.findElement(By.xpath("//button[normalize-space()='Open']")));
        }

        public void clickInProgressTasksButton() {
            DriverManager.getInstance().fluentwait().until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='In progress']")));
            Browser.clickOnElement(DriverManager.getInstance().Driver.findElement(By.xpath("//button[normalize-space()='In progress']")));
        }

        public void validateAllButtonStatus() {
            DriverManager.getInstance().pageReady();
            Browser.waitForElementToBeVisible(By.xpath("//*[text()='No tasks available']"));
            WebElement entry = DriverManager.getInstance().Driver.findElement(By.xpath("//*[text()='No tasks available']"));
            Assert.assertTrue(Browser.getTextFromElement(entry).contains("No tasks available"));

        }

        public void validateClosedStatus() {
            Browser.clickOnElement(DriverManager.getInstance().Driver.findElement(By.xpath("//button[normalize-space()='Closed']")));
            DriverManager.getInstance().pageReady();
            Browser.waitForElementToBeVisible(By.xpath("(//tbody/tr[@class='custom-row-class']/td[2])[1]"));
            List<WebElement> closed = DriverManager.getInstance().Driver.findElements(By.xpath("//tbody/tr[@class='custom-row-class']/td[2]"));

            try {
                for (WebElement webElement : closed) {
                    softAssertions.assertThat(Browser.getTextFromElement(webElement)).contains("Closed");
                }
                softAssertions.assertAll();
            } catch (AssertionError e) {
                System.out.println("error :" + e.getMessage());
            }
            Browser.clickOnElement(DriverManager.getInstance().Driver.findElement(By.xpath("//button[normalize-space()='Closed']")));
        }

        public void validateOpenStatus() {
            Browser.clickOnElement(DriverManager.getInstance().Driver.findElement(By.xpath("//button[normalize-space()='Open']")));
            DriverManager.getInstance().pageReady();
            Browser.waitForElementToBeVisible(By.xpath("(//tbody/tr[@class='custom-row-class']/td[2])[1]"));
            List<WebElement> open = DriverManager.getInstance().Driver.findElements(By.xpath("//tbody/tr[@class='custom-row-class']/td[2]"));

            try {
                for (WebElement webElement : open) {
                    softAssertions.assertThat(Browser.getTextFromElement(webElement)).contains("Open");
                }
                softAssertions.assertAll();
            } catch (AssertionError e) {
                System.out.println("error :" + e.getMessage());
            }
            Browser.clickOnElement(DriverManager.getInstance().Driver.findElement(By.xpath("//button[normalize-space()='Open']")));
        }

        public void validateInProgressStatus() {
            Browser.clickOnElement(DriverManager.getInstance().Driver.findElement(By.xpath("//button[normalize-space()='In progress']")));
            DriverManager.getInstance().pageReady();
            Browser.waitForElementToBeVisible(By.xpath("(//tbody/tr[@class='custom-row-class']/td[2])[1]"));
            List<WebElement> InProgress = DriverManager.getInstance().Driver.findElements(By.xpath("//tbody/tr[@class='custom-row-class']/td[2]"));
            try {
                for (WebElement webElement : InProgress) {
                    softAssertions.assertThat(Browser.getTextFromElement(webElement)).contains("In Progress");
                }
                softAssertions.assertAll();
            } catch (AssertionError e) {
                System.out.println("error :" + e.getMessage());
            }
            Browser.clickOnElement(DriverManager.getInstance().Driver.findElement(By.xpath("//button[normalize-space()='In progress']")));
        }
        @After
        public void teardown() {
            softAssertions.assertAll();

        }
    }
