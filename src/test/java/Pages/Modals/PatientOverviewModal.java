package Pages.Modals;

import Framework.Browser;
import Framework.Util.DriverManager;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class PatientOverviewModal {
    PatientOverviewModal() {
        Browser.waitForPageReady();
    }

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

    public void validateNoTaskAvailableButtonStatus() {
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

    public void clickOnForms() {
        WebElement Forms = DriverManager.getInstance().Driver.findElement(By.xpath("//a[@id='patient-window-tabs-id-tab-form']"));
        Browser.clickOnElement(Forms);
    }

    public void clickOnGeneralConsentFormsButton(String formsName) {
        Browser.waitForElementToBeVisible(By.xpath("//*[@data-icon='file-medical']/.."));
        Browser.waitForElementToBeClickable(By.xpath("//*[@data-icon='file-medical']/.."));
        WebElement generalConsentForms = DriverManager.getInstance().Driver.findElement(By.xpath("//*[@data-icon='file-medical']/.."));
        Browser.clickOnElementUsingJavascript(generalConsentForms);
    }

    public void clickOnPatientSelectedForm() {
        WebElement patientForm = DriverManager.getInstance().Driver.findElement(By.xpath("//button[@class='btn btn-primary' and contains(text(),'Form')]"));
        Browser.clickOnElementUsingJavascript(patientForm);
    }

    public void clickOnSearchForms(String formName) {
        WebElement searchForms = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@id='form-search-text-field']"));
        Browser.enterTextInEditBox(searchForms, formName);
        Browser.waitForPageReady();
        Browser.waitForElementToBeVisible(By.xpath("//td[@class='practice-name-column']/div[@class='checkbox']/label"));
        WebElement listOfForms = DriverManager.getInstance().Driver.findElement(By.xpath("//td[@class='practice-name-column']/div[@class='checkbox']/label"));
        Browser.clickOnElementUsingJavascript(listOfForms);
        Browser.clickOnElement(DriverManager.getInstance().Driver.findElement(By.xpath("//*[text()='Add']")));
    }

    public void checkListOfSelectedForms(String formName) {
        Browser.waitForElementToBeVisible(By.xpath("//td[@class='practice-name-column']"));
        List<WebElement> listOfSelectedForms = DriverManager.getInstance().Driver.findElements(By.xpath("//td[@class='practice-name-column']"));
        for (WebElement element : listOfSelectedForms) {
            if (element.getText().contains(formName)) {
                Assert.assertTrue(true);
                break;
            }
        }

        Browser.clickOnElementUsingJavascript(DriverManager.getInstance().Driver.findElement(By.xpath("//label[text()='Send Email']")));
        Browser.clickOnElementUsingJavascript(DriverManager.getInstance().Driver.findElement(By.xpath("//label[text()='Send Text']")));
    }

    public void clickOnFormsSendButton() {
        WebElement sendButton = DriverManager.getInstance().Driver.findElement(By.xpath("//button[text()='Send']"));
        Browser.clickOnElementUsingJavascript(sendButton);
    }

    public void verifyPendingFormsCheckList(String formName) {
        Browser.waitForElementToBeVisible(By.xpath("//td[text()='" + formName + "']"));
        Browser.waitForElementToBeClickable(By.xpath("//td[text()='" + formName + "']"));
        WebElement isSelectedFormsPresentInPendingFormList = DriverManager.getInstance().Driver.findElement(By.xpath("//td[text()='" + formName + "']"));
        Assert.assertTrue(isSelectedFormsPresentInPendingFormList.isDisplayed());
    }
}