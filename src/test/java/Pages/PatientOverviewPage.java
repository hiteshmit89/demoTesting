package Pages;

import Framework.Browser;
import Framework.Constants.Constants;
import Framework.Util.DriverManager;
import junit.framework.Assert;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PatientOverviewPage extends BasePage {
    public PatientOverviewPage(Constants.PageTitle PageTitle) {super(PageTitle);}

    private String getCurrentDate() {
        return (new SimpleDateFormat("MM/dd/yyyy").format(new Date()));
    }

    public void selectTask(String taskType) {
        WebElement taskButton = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@class='patient-actions']//div[@class='action-item']//span[contains(text(),'Task')]/.."));
        Browser.clickOnElementUsingJavascript(taskButton);
        Browser.waitForPageReady();
        Browser.waitForPresenceOfElement(By.xpath("//*[@id='patient-window-tabs-id']//div[@class='col-xs-12']//span[text()='General Task']"));
        WebElement taskList = DriverManager.getInstance().Driver.findElement(By.xpath("//form[@class='create-task-form']"));
        List<WebElement> taskElements = taskList.findElements(By.xpath(".//label[@title]/span"));
        for (WebElement row : taskElements) {
            if (Browser.getTextFromElement(row).equals(taskType)) {
                Browser.clickOnElement(row);
                break;
            }
        }
    }

    public void addTaskDescription(String TaskDescription) {
        WebElement taskDescription = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@class='margin-top description-section form-group']//input[@id='formControlsDescription']"));
        Browser.enterTextInEditBox(taskDescription, TaskDescription);
    }

    public void taskDueDate() {
        WebElement taskDueDate = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@id='due_date']"));
        Browser.enterTextInEditBox(taskDueDate, getCurrentDate());
    }

    public void taskCreation() {
        WebElement taskCreation = DriverManager.getInstance().Driver.findElement(By.xpath("// div[@class='create-task-btn']//button[normalize-space()='Create']"));
        Browser.clickOnElement(taskCreation);
    }
    public void clickViewTasksList() {
        Browser.waitForPageReady();
        Browser.waitForPresenceOfElement(By.xpath("//span[@class='task-heading']"));
        WebElement ViewTasks = DriverManager.getInstance().Driver.findElement(By.xpath("//span[@class='task-heading']"));
        Browser.clickOnElementUsingJavascript(ViewTasks);
    }

    public void clickOpenTasksButton() {
        WebElement OpenButton = DriverManager.getInstance().Driver.findElement(By.xpath("//button[text()='Open']"));
        Browser.clickOnElement(OpenButton);
    }

    public void clickInProgressTasksButton() {
        WebElement InProgressButton = DriverManager.getInstance().Driver.findElement(By.xpath("//button[text()='In progress']"));
        Browser.clickOnElement(InProgressButton);
    }

    public void validateAllButtonStatus() {
        Browser.waitForElementToBeVisible(By.xpath("//*[text()='No tasks available']"));
        Browser.waitForPageReady();
        WebElement entry = DriverManager.getInstance().Driver.findElement(By.xpath("//*[text()='No tasks available']"));
        Assert.assertTrue(Browser.getTextFromElement(entry).contains("No tasks available"));
    }

    public void validateTaskStatus(String status) {
        Browser.clickOnElement(DriverManager.getInstance().Driver.findElement(By.xpath("//button[text()='" + status + "']")));
        Browser.waitForPageReady();
        WebElement askTaskTable = DriverManager.getInstance().Driver.findElement(By.xpath("//*[@id='patient-window-tabs-id']//table[@class='table table-hover table-bordered task-list-table']"));
        Browser.waitForTableToLoad(askTaskTable);
        if (!askTaskTable.findElements(By.xpath(".//tr")).isEmpty()) {
            List<WebElement> taskStatusList = askTaskTable.findElements(By.xpath(".//tr//td[2]//span"));
            for (WebElement taskStatus : taskStatusList) {
                if (!Browser.getTextFromElement(taskStatus).equals(status)) {
                    Assert.fail("Closed button filter on patient window all task table does not work as expected");
                    break;
                }
            }
        }
        Browser.clickOnElement(DriverManager.getInstance().Driver.findElement(By.xpath("//button[text()='" + status + "']")));
    }
}