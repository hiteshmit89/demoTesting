package Pages;

import Framework.Browser;
import Framework.Constants.Constants;
import Framework.Util.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class TasksPage extends BasePage {
    public TasksPage(Constants.PageTitle title) {
        super(title);
    }

    public void selectFilter() {
        WebElement filter = DriverManager.getInstance().Driver.findElement(By.xpath("//button[@class='btn btn-default']"));
        Browser.clickOnElement(filter);
    }

    public void searchTask(String TaskDescription) {
        WebElement taskSearchBox = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@type='search']"));
        Browser.enterTextInEditBox(taskSearchBox, TaskDescription);
    }

    public void selectTaskListCheckbox() {
        Browser.waitForPageReady();
        WebElement taskListCheckbox = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@class='col-sm-12']//th[@class='table-task-select sorting_disabled']"));
        Browser.waitForElementToBeClickable(taskListCheckbox);
        Browser.clickOnElement(taskListCheckbox);

    }

    public void closeSelectedTaskList() {
        WebElement closeButton = DriverManager.getInstance().Driver.findElement(By.xpath("//button[text()='Close']"));
        Browser.waitForElementToBeVisible(closeButton);
        Browser.waitForElementToBeClickable(closeButton);
        Browser.clickOnElementUsingJavascript(closeButton);
        WebElement updateTaskStatus = DriverManager.getInstance().Driver.findElement(By.xpath("//button[text()='Update']"));
        Browser.waitForElementToBeClickable(updateTaskStatus);
        Browser.clickOnElementUsingJavascript(updateTaskStatus);
    }
}