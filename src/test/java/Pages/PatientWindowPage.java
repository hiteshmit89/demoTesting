package Pages;

import Framework.Browser;
import Framework.Constants.Constants.PageTitle;
import Framework.Util.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class PatientWindowPage extends BasePage {
    public PatientWindowPage(PageTitle title) {
        super(title);
    }

    private String getCurrentDate() {
        return (new SimpleDateFormat("MM/dd/yyyy").format(new Date()));
    }

    private final WebElement taskButton = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@class='patient-actions']//div[@class='action-item']//span[contains(text(),'Task')]/.."));

    public void selectTask(String taskType) {
        Browser.clickOnElementUsingJavascript(taskButton);
        Browser.waitForPageReady();
        Browser.waitForPresenceOfElement(By.xpath("//*[@id='patient-window-tabs-id']//div[@class='col-xs-12']//span[text()='General Task']"));
        WebElement taskList = DriverManager.getInstance().Driver.findElement(By.xpath("//form[@class='create-task-form']"));
        List<WebElement> taskElements = taskList.findElements(By.xpath(".//label[@title]/span"));
        for (WebElement row : taskElements) {
            if (Browser.getTextFromElement(row).equals(taskType)) {
                System.out.println(row);
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

    public void closePatientWindow() {
        WebElement closePatientWindow = DriverManager.getInstance().Driver.findElement(By.xpath("//button[@class='close-button']"));
        Browser.clickOnElement(closePatientWindow);
    }
}