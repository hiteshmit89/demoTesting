package Pages;


import Framework.Browser;
import Framework.Constants.Constants;
import Framework.Util.DriverManager;
import java.util.Date;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.text.SimpleDateFormat;


public class PatientWindowPage extends BasePage {

    public PatientWindowPage(Constants.PageTitle title) {
        super(title);

    }
    public String getCurrentDate () {
        return (new SimpleDateFormat("MM/dd/yyyy").format(new Date()));

    }
    public void createTaskInPatientWindow (String TaskDescription) throws InterruptedException {
        WebElement taskButton = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@class=\"patient-actions\"]//div[@class='action-item']//span[contains(text(),'Task')]"));
        Browser.waitForElementToDisplay(taskButton);
        Browser.clickOnElement(taskButton);

        Thread.sleep(1000);

        WebElement taskWindow = DriverManager.getInstance().Driver.findElement(By.xpath("//h3[contains(text(),'Create Task')]"));
        String title = taskWindow.getText();
        Assert.assertEquals("Create Task", title);


        WebElement taskDescription = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@class='margin-top description-section form-group']//input[@id='formControlsDescription']"));
        Browser.enterTextInEditBox(taskDescription, TaskDescription);

    }

    public void taskDueDate () {
        //String currentDate = new SimpleDateFormat("MM/dd/yyyy").format(new Date());
        WebElement taskDueDate = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@id='due_date']"));
        Browser.enterTextInEditBox(taskDueDate, getCurrentDate());


    }
    public void taskCreation () {
        WebElement taskCreation = DriverManager.getInstance().Driver.findElement(By.xpath("// div[@class='create-task-btn']//button[normalize-space()='Create']"));
        Browser.clickOnElement(taskCreation);

    }



}
