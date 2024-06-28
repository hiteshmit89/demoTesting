package Pages;

import Framework.Browser;
import Framework.Constants.Constants;
import Framework.Root.PbNUIApp;
import Framework.Util.DriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.security.PublicKey;
import java.util.List;


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

    public void searchTaskViaPatientName() {
        WebElement taskSearchBox = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@type='search']"));
        Browser.enterTextInEditBox(taskSearchBox, PbNUIApp.userdata().getPatientName(1, 2));
    }

    public void selectTaskFromTaskList() {
        Browser.waitForPageReady();
        WebElement interceptElement = DriverManager.getInstance().Driver.findElement(By.xpath("//*[@id=\"task-list\"]/div[2]"));
        Browser.waitForElementInvisibility(interceptElement);
        WebElement table = DriverManager.getInstance().Driver.findElement(By.xpath("//*[@id='DataTables_Table_0']/tbody"));
        Browser.waitForTableToLoad(table);
        List<WebElement> taskList = table.findElements(By.xpath("(//tr)"));
        if (!taskList.isEmpty()) {
            Browser.waitForElementToBeClickable(taskList.get(2));
            Browser.clickOnElement(taskList.get(2));
        }
    }

    public void closePatientWindow() {
        WebElement closePatientWindow = DriverManager.getInstance().Driver.findElement(By.xpath("//button[@class='close-button']"));
        Browser.waitForTableToLoad(closePatientWindow);
        Browser.clickOnElement(closePatientWindow);
    }

    public void verifyTaskListHeader() {
        WebElement verifyTaskListHeader = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@class='task-list-header']//span[@class='task-list-title']"));
        if (!verifyTaskListHeader.isDisplayed()) {
            WebElement closeButton = DriverManager.getInstance().Driver.findElement(By.xpath("//*[name()='svg'][@role='button']"));
            Browser.clickOnElement(closeButton);
        }
    }

    public void closeTaskListInPatientWindow() {
        Browser.waitForElementToBeClickable(By.xpath("//div[@class='pop-window-close-btn']//*[name()='svg']"));
        Browser.waitForElementToBeClickable(By.xpath("//div[@class='pop-window-close-btn']//*[name()='svg']"));
        WebElement closeTaskList = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@class='pop-window-close-btn']//*[name()='svg']"));
        Browser.clickOnElement(closeTaskList);
    }

    public void verifyPatientWindowForSelectedPatient() {
        WebElement patientNameInPatientWindow = DriverManager.getInstance().Driver.findElement(By.xpath("//span[@class='full-name' and contains(text(),'" + PbNUIApp.userdata().getPatientName(1, 2) + "')]"));
        Assert.assertEquals(patientNameInPatientWindow.getText(), PbNUIApp.userdata().getPatientName(1, 2));
    }
}