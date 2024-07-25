package Pages.Modals;

import Framework.Browser;
import Framework.Root.PbNUIApp;
import Framework.Util.DriverManager;
import org.junit.Assert;
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
    private int sizeOfSelectedForms = 0;
    String note = "Patient Test Note";
    public void selectTask(String taskType) {
        WebElement taskButton = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@class='action-item']//span[contains(text(),'Tasks')]"));
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
        Browser.clickOnElementUsingJavascript(OpenButton);
    }

    public void clickInProgressTasksButton() {
        WebElement InProgressButton = DriverManager.getInstance().Driver.findElement(By.xpath("//button[text()='In progress']"));
        Browser.clickOnElementUsingJavascript(InProgressButton);
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
        Browser.waitForElementToBeVisible(By.xpath("//span[text()='Forms']"));
        WebElement Forms = DriverManager.getInstance().Driver.findElement(By.xpath("//span[text()='Forms']"));
        Browser.clickOnElementUsingJavascript(Forms);
    }

    public void clickOnSearchForms(String formName) {
        WebElement interceptElement1 = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@style='height: 100%; width: 100%; position: absolute; top: 0px; left: 0px; display: flex; background-color: rgba(255, 255, 255, 0.8); z-index: 2000;']"));
        Browser.waitForElementInvisibility(interceptElement1);
        List<WebElement> tablesOnModal = DriverManager.getInstance().Driver.findElements(By.xpath("//table[@class='table table-striped table-hover table-bordered']/tbody"));
        boolean flag = false;
        List<WebElement> elements = tablesOnModal.getFirst().findElements(By.xpath(".//span[text()='" + formName + "']"));
        if (!elements.isEmpty()) {
            Browser.waitForElementToBeVisible(elements.getFirst());
            flag = true;
        }
        if (!flag) {
            WebElement patientFormButton = DriverManager.getInstance().Driver.findElement(By.xpath("//button[@class='btn btn-primary' and contains(text(),'Form')]"));
            Browser.clickOnElementUsingJavascript(patientFormButton);
            WebElement interceptElement = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@style='height: 100%; width: 100%; position: absolute; top: 0px; left: 0px; display: flex; background-color: rgba(255, 255, 255, 0.8); z-index: 2000;']"));
            Browser.waitForElementInvisibility(interceptElement);
            Browser.waitForElementToBeVisible(By.xpath("//input[@id='form-search-text-field']"));
            WebElement searchForms = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@id='form-search-text-field']"));
            Browser.enterTextInEditBox(searchForms, formName);
            Browser.waitForPageReady();
            Browser.waitForElementToBeVisible(By.xpath("//td[@class='practice-name-column']/div[@class='checkbox']/label"));
            Browser.waitForElementToBeClickable(By.xpath("//td[@class='practice-name-column']/div[@class='checkbox']/label"));
            WebElement listOfForms = DriverManager.getInstance().Driver.findElement(By.xpath("//td[@class='practice-name-column']/div[@class='checkbox']/label"));
            Browser.clickOnElementUsingJavascript(listOfForms);
            Browser.clickOnElementUsingJavascript(DriverManager.getInstance().Driver.findElement(By.xpath("//*[text()='Add']")));
        }
    }

    public void checkListOfSelectedForms(String formName) {
        Browser.waitForPageReady();
        List<WebElement> sendInviteTables = DriverManager.getInstance().Driver.findElements(By.xpath("//div[@class='patient-search']/following-sibling::div//table"));
        Browser.waitForTableSizeToBe(sendInviteTables.getFirst(), sizeOfSelectedForms + 1);
        List<WebElement> listOfSelectedForms = sendInviteTables.getFirst().findElements(By.xpath("./td[@class='practice-name-column']"));
        for (WebElement element : listOfSelectedForms) {
            if (element.getText().contains(formName)) {
                Assert.assertTrue("Form Displayed Successfully", true);
                break;
            }
        }
        WebElement sendEmail = DriverManager.getInstance().Driver.findElement(By.xpath("//label[text()='Send Email']"));
        Browser.clickOnElementUsingJavascript(sendEmail);
        WebElement sendText = DriverManager.getInstance().Driver.findElement(By.xpath("//label[text()='Send Text']"));
        Browser.clickOnElementUsingJavascript(sendText);
    }

    public void clickOnFormsSendButton() {
        WebElement sendButton = DriverManager.getInstance().Driver.findElement(By.xpath("//button[text()='Send']"));
        Browser.clickOnElementUsingJavascript(sendButton);
    }

    public void clickOnFormsTabInOverviewPage(){
        Browser.waitForElementToBeVisible(By.xpath("//a[@id='patient-window-tabs-id-tab-form']"));
        Browser.waitForElementToBeClickable(By.xpath("//a[@id='patient-window-tabs-id-tab-form']"));
        WebElement forms = DriverManager.getInstance().Driver.findElement(By.xpath("//a[@id='patient-window-tabs-id-tab-form']"));
        Browser.clickOnElementUsingJavascript(forms);
    }

    public void verifyPendingFormsCheckList(String formName) {
        Browser.waitForElementToBeVisible(By.xpath("//td[text()='" + formName + "']"));
        WebElement isSelectedFormsPresentInPendingFormList = DriverManager.getInstance().Driver.findElement(By.xpath("//td[text()='" + formName + "']"));
        Assert.assertTrue(isSelectedFormsPresentInPendingFormList.isDisplayed());
    }

    public void sendReminderBell(String formName) {
        Browser.waitForElementToBeVisible(By.xpath("//tbody/tr/td[text()='" + formName + "']/../td[5]/div/span[1]"));
        WebElement sendReminder = DriverManager.getInstance().Driver.findElement(By.xpath("//tbody/tr/td[text()='" + formName + "']/../td[5]/div/span[1]"));
        Browser.clickOnElementUsingJavascript(sendReminder);
        Browser.waitForElementToBeClickable(By.xpath("//button[text()='Yes']"));
        WebElement yesButton = DriverManager.getInstance().Driver.findElement(By.xpath("//button[text()='Yes']"));
        Browser.clickOnElement(yesButton);
    }

    public void clickOnCancelFormInvite(String formName) {
        Browser.waitForElementToBeClickable(By.xpath("//tbody/tr/td[text()='" + formName + "']/../td[5]/div/span[2]"));
        WebElement cancelFormInvite = DriverManager.getInstance().Driver.findElement(By.xpath("//tbody/tr/td[text()='" + formName + "']/../td[5]/div/span[2]"));
        Browser.clickOnElementUsingJavascript(cancelFormInvite);
        Browser.waitForElementToBeVisible(By.xpath("//button[text()='Yes']"));
        Browser.waitForElementToBeClickable(By.xpath("//button[text()='Yes']"));
        WebElement yesButton = DriverManager.getInstance().Driver.findElement(By.xpath("//button[text()='Yes']"));
        Browser.clickOnElementUsingJavascript(yesButton);
    }

    public void clickOnMarkAsSubmittedManuallyButton(String formName) {
        Browser.waitForElementToBeVisible(By.xpath("//tbody/tr/td[text()='" + formName + "']/../td[5]/div/div"));
        Browser.waitForElementToBeClickable(By.xpath("//tbody/tr/td[text()='" + formName + "']/../td[5]/div/div"));
        WebElement formManuallySubmitted = DriverManager.getInstance().Driver.findElement(By.xpath("//tbody/tr/td[text()='" + formName + "']/../td[5]/div/div"));
        Browser.clickOnElementUsingJavascript(formManuallySubmitted);
        Browser.waitForElementToBeClickable(By.xpath("//span[@class='m-2']/../button[2]"));
        WebElement saveButton = DriverManager.getInstance().Driver.findElement(By.xpath("//span[@class='m-2']/../button[2]"));
        Browser.clickOnElement(saveButton);
    }

    public void verifyCompletedFormsCheckList(String formName) {
        Browser.waitForElementToBeVisible(By.xpath("//tbody/tr/td/span[text()='" + formName + "']"));
        WebElement isFormPresentInCompletedForms = DriverManager.getInstance().Driver.findElement(By.xpath("//tbody/tr/td/span[text()='" + formName + "']"));
        Assert.assertTrue(isFormPresentInCompletedForms.isDisplayed());
    }

    public void clickOnDetailsTab() {
        WebElement detailsTab = DriverManager.getInstance().Driver.findElement(By.xpath("//a[@id='patient-window-tabs-id-tab-details']"));
        Browser.clickOnElement(detailsTab);
    }

    public void clickOnCommunicationPreference() {
        Browser.waitForElementToBeClickable(By.xpath("//div[@id='email--heading']//i[@class='fa-duotone fa-chevron-down']"));
        WebElement emailPreference = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@id='email--heading']//i[@class='fa-duotone fa-chevron-down']"));
        Browser.scrollToVisibleElement(emailPreference);
        Browser.clickOnElementUsingJavascript(emailPreference);
        WebElement emailCheckBox = DriverManager.getInstance().Driver.findElement(By.xpath("//div[text()='Global subscribe to all emails']/../div/label/input"));
        List<WebElement> emailcheckboxList = DriverManager.getInstance().Driver.findElements(By.xpath("//*[@id='email--body']/div/div/div"));
        if (emailcheckboxList.size() == 1) {
            Browser.clickOnElementUsingJavascript(emailCheckBox);
        }
        WebElement textPreference = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@id='sms--heading']//i[@class='fa-duotone fa-chevron-down']"));
        Browser.scrollToVisibleElement(textPreference);
        Browser.clickOnElementUsingJavascript(textPreference);
        List<WebElement> textCheckBoxList = DriverManager.getInstance().Driver.findElements(By.xpath("//*[@id='sms--body']/div/div/div"));
        WebElement textCheckBox = DriverManager.getInstance().Driver.findElement(By.xpath("//div[text()='Global subscribe to all sms']/../div/label/input"));
        if (textCheckBoxList.size() == 1) {
            Browser.clickOnElementUsingJavascript(textCheckBox);
        }
        WebElement savePreference = DriverManager.getInstance().Driver.findElement(By.xpath("//button[text()='Save Preferences']"));
        if (savePreference.isEnabled()) {
            Browser.clickOnElementUsingJavascript(savePreference);
        }
        WebElement closePatientWindow = DriverManager.getInstance().Driver.findElement(By.xpath("//button[@class='close-button']"));
        Browser.clickOnElement(closePatientWindow);
    }

    public void clickOnOptedOutPatients() {
        Browser.scrollToVisibleElement(DriverManager.getInstance().Driver.findElement(By.xpath("//a[text()='Opted Out Patients']")));
        WebElement optedOutPatient = DriverManager.getInstance().Driver.findElement(By.xpath("//a[text()='Opted Out Patients']"));
        Browser.clickOnElement(optedOutPatient);
    }

    public void verifyPatientOptedOutList() {
        Browser.waitForElementToBeVisible(By.xpath("//input[@id='searchLabel']"));
        WebElement searchTextBox = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@id='searchLabel']"));
        Browser.enterTextInEditBox(searchTextBox, PbNUIApp.userdata().getPatientName(1, 1));
        Browser.waitForTableToLoad(DriverManager.getInstance().Driver.findElement(By.xpath("//tbody")));
        List<WebElement> firstName = DriverManager.getInstance().Driver.findElements(By.xpath("//tbody/tr/td[3]"));
        List<WebElement> lastName = DriverManager.getInstance().Driver.findElements(By.xpath("//tbody/tr/td[2]"));
        for (int i = 0; i < firstName.size(); i++) {
            String firstname = firstName.get(i).getText();
            Browser.waitForElementToBeVisible(lastName.get(i));
            String lastname = lastName.get(i).getText();
            if (firstname.contains(searchTextBox.getAttribute("value").split(" ")[0]) && lastname.contains(searchTextBox.getAttribute("value").split(" ")[1])) {
                Assert.assertTrue("Patient Name Displayed Successfully", true);
                break;
            }
        }
    }

    public void clickOnPatientNote() {
        WebElement patientNote = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@class='patient-note-icon']"));
        Browser.clickOnElementUsingJavascript(patientNote);
    }

    public void clickOnAddPatientNote() {
        WebElement enterTextInPatientNote = DriverManager.getInstance().Driver.findElement(By.xpath("//textarea[@class='form-control']"));
        Browser.enterTextInEditBox(enterTextInPatientNote, note);
        WebElement addNote = DriverManager.getInstance().Driver.findElement(By.xpath("//button[text()='Add Note']"));
        Browser.clickOnElementUsingJavascript(addNote);
    }

    public void verifyPatientNoteInActivityTab() {
        WebElement activityTab = DriverManager.getInstance().Driver.findElement(By.xpath("//a[@id='patient-window-tabs-id-tab-activity']"));
        Browser.clickOnElementUsingJavascript(activityTab);
        Browser.waitForElementToBeClickable(By.xpath(" //div[@class='patient-notes-table container']"));
        WebElement patientNoteSection = DriverManager.getInstance().Driver.findElement(By.xpath(" //div[@class='patient-notes-table container']"));
        Browser.scrollToVisibleElement(patientNoteSection);
        List<WebElement> patientNoteList = DriverManager.getInstance().Driver.findElements(By.xpath("//div[contains(@class,'patient-note col-xs')]"));
        for (WebElement element : patientNoteList) {
            if (element.getText().contains(note)) {
                Assert.assertTrue("Patient Note Present in the List", true);
                break;
            }
        }
    }

    public void validateInvalidSmsNumberIcon (){
        Browser.waitForElementToBeVisible(By.xpath("//span[contains(text(),'SMS')]"));
        Browser.waitForElementToBeClickable(By.xpath("//span[contains(text(),'SMS')]"));
        WebElement smsIcon = DriverManager.getInstance().Driver.findElement(By.xpath("//span[contains(text(),'SMS')]"));
        Browser.waitForElementToBeVisible(By.xpath("//input[@placeholder='Press enter to add tag']"));
        Browser.clickOnElement(smsIcon);
        Browser.waitForElementToBeVisible(By.xpath("//div[@class='warning-verified-icon']"));
        DriverManager.getInstance().Driver.findElement(By.xpath("//img[@title='Either number is not valid, or its a landline number.']")).isDisplayed();
    }

    public void validateValidSmsNumberIcon (){
        Browser.waitForElementToBeVisible(By.xpath("//span[contains(text(),'SMS')]"));
        Browser.waitForElementToBeClickable(By.xpath("//span[contains(text(),'SMS')]"));
        WebElement smsIcon = DriverManager.getInstance().Driver.findElement(By.xpath("//span[contains(text(),'SMS')]"));
        Browser.waitForElementToBeVisible(By.xpath("//input[@placeholder='Press enter to add tag']"));
        Browser.clickOnElement(smsIcon);
        Browser.waitForElementToBeVisible(By.xpath("//div[@class='warning-verified-icon']"));
        DriverManager.getInstance().Driver.findElement(By.xpath("//img[@title='Number is valid.']")).isDisplayed();
    }
}