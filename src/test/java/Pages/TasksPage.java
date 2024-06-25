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
        WebElement interceptElement = DriverManager.getInstance().Driver.findElement(By.xpath("//*[@id=\"task-list\"]/div[2]"));
        Browser.waitForElementInvisibility(interceptElement);
        WebElement taskListCheckbox = DriverManager.getInstance().Driver.findElement(By.xpath("//*[@id=\"DataTables_Table_0\"]/thead//input"));
        Browser.scrollToVisibleElement(taskListCheckbox);
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

    public void selectTaskFromTaskList ()
    {
     WebElement taskList = DriverManager.getInstance().Driver.findElement(By.xpath("//table[@class='table table-hover avatar-table dataTable no-footer dtr-inline']//tbody//tr[@role='row'][2]"));
        Browser.clickOnElementUsingJavascript(taskList);
    }

    public void closePatientWindow ()
    {
        WebElement closePatientWindow = DriverManager.getInstance().Driver.findElement(By.xpath("//button[@class='close-button']"));
        Browser.clickOnElement(closePatientWindow);
    }
}