package Pages;

import Framework.Browser;
import Framework.Root.PbNUIApp;
import Framework.Util.ConfigManager;
import Framework.Constants.Constants.PageTitle;
import Framework.Util.DriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class PaymentsPage extends BasePage {

    public PaymentsPage(PageTitle title) {
        super(title);
    }

    private final WebElement paymentsTab = DriverManager.getInstance().Driver.findElement(By.xpath("//a[@id='payment-page-tab-Payments']"));
    private final WebElement paymentMethodsTab = DriverManager.getInstance().Driver.findElement(By.xpath("//a[@id='payment-page-tab-Payment Methods']"));
    private final WebElement widgetsTab = DriverManager.getInstance().Driver.findElement(By.xpath("//a[@id='payment-page-tab-Widgets']"));

    String SelectPaginationNumber = "100";
    int initialTableSize = 0;

    public void clickOnWidgetslink() {
        WebElement widgetsTab = DriverManager.getInstance().Driver.findElement(By.xpath("//a[@id='payment-page-tab-Widgets']"));
        Browser.waitForElementToBeClickable(widgetsTab);
        Browser.clickOnElement(widgetsTab);
    }

    public void createPaymentURLAndNavigate() {
        Browser.waitForElementPresence(By.xpath("(//span[contains(text(),'https://www.patientsreach.com/payment/portal/')])[1]"));
        Browser.waitForElementToBeVisible(By.xpath("(//span[contains(text(),'https://www.patientsreach.com/payment/portal/')])[1]"));
        WebElement eLink = DriverManager.getInstance().Driver.findElement(By.xpath("(//span[contains(text(),'https://www.patientsreach.com/payment/portal/')])[1]"));
        String urlText = eLink.getText();
        System.out.println(urlText);
        String[] arrOfStr = urlText.split("payment/portal");
        String URL = ConfigManager.getInstance().getProperty("URL");
        URL = String.join("", URL, "/payment/portal", arrOfStr[1]);
        Browser.navigateToNewURL(URL);
    }

    public void clickPaymentsMenu() {
        Browser.clickOnElement(paymentsTab);
    }

    public void clickPaymentsMethodsTab() {
        Browser.clickOnElement(paymentMethodsTab);
    }

    public void clickWidgetsTab() {
        Browser.clickOnElement(widgetsTab);
    }

    public void clickCardIcon() {
        Browser.waitForElementToBeVisible(By.xpath("(//*[@class='svg-inline--fa fa-credit-card fa-w-18 card-icon'])[1]"));
        Browser.waitForElementToBeClickable(By.xpath("(//*[@class='svg-inline--fa fa-credit-card fa-w-18 card-icon'])[1]"));
        WebElement cardIcon = DriverManager.getInstance().Driver.findElement(By.xpath("(//*[@class='svg-inline--fa fa-credit-card fa-w-18 card-icon'])[1]"));
        Browser.clickOnElement(cardIcon);
    }

    public void enterCardDetailsOnPaymentModal() {
        WebElement cardButton = DriverManager.getInstance().Driver.findElement(By.xpath("//span[@class='MuiButton-startIcon MuiButton-iconSizeSmall']"));
        Browser.clickOnElement(cardButton);
        Browser.waitForFrameToLoad(By.xpath("//iframe[@title='Iframe for card number']"));
        enterCardNumber(PbNUIApp.userdata().getCardNumber(2, "1"));
        enterCardDate(PbNUIApp.userdata().getCardMonth(2, "1"));
        enterCVC(PbNUIApp.userdata().getCardCVC(2, "1"));
    }

    public void enterCardNumber(String cardNumber) {
        Browser.waitForElementPresence(By.xpath("//input[@data-fieldtype='encryptedCardNumber']"));
        Browser.waitForElementToBeVisible(By.xpath("//input[@data-fieldtype='encryptedCardNumber']"));
        WebElement cardNumberID = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@data-fieldtype='encryptedCardNumber']"));
        Browser.enterTextInEditBox(cardNumberID, cardNumber);
        Browser.switchToDefaultContent();
    }

    public void enterCardDate(String cardDate) {
        Browser.waitForFrameToLoad(By.xpath("//iframe[@title='Iframe for expiry date']"));
        Browser.waitForElementPresence(By.xpath("//input[@data-fieldtype='encryptedExpiryDate']"));
        Browser.waitForElementToBeVisible(By.xpath("//input[@data-fieldtype='encryptedExpiryDate']"));
        WebElement cardDateID = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@data-fieldtype='encryptedExpiryDate']"));
        Browser.enterTextInEditBox(cardDateID, cardDate);
        Browser.switchToDefaultContent();
    }

    public void enterCVC(String cardCVC) {
        Browser.waitForFrameToLoad(By.xpath("//iframe[@title='Iframe for security code']"));
        Browser.waitForElementPresence(By.xpath("//input[@placeholder='3 digits']"));
        Browser.waitForElementToBeVisible(By.xpath("//input[@placeholder='3 digits']"));
        WebElement cardCVCID = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@placeholder='3 digits']"));
        Browser.enterTextInEditBox(cardCVCID, cardCVC);
        Browser.switchToDefaultContent();

    }

    public void enterAmount() {
        WebElement enterAmountTextBox = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@type='number']"));
        Random random = new Random();
        int randomNumber = random.nextInt(1000);
        Browser.enterTextInEditBox(enterAmountTextBox, String.valueOf(randomNumber));
    }

    public void enterChargeDescription() {
        WebElement enterAmountTextBox = DriverManager.getInstance().Driver.findElement(By.xpath("//textarea[@class='charge-description-input-box form-control']"));
        Browser.enterTextInEditBox(enterAmountTextBox, "Entered Description");
    }

    public void clickChargeButtonOnModal() {
        WebElement chargeButton = DriverManager.getInstance().Driver.findElement(By.xpath("//button[@class='btn btn-default']//span[text()=' Charge ']"));
        Browser.clickOnElement(chargeButton);
        WebElement chargeConfirmationPopUp = DriverManager.getInstance().Driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
        Browser.clickOnElement(chargeConfirmationPopUp);
    }

    public void verifyChargeConfirmationText() {
        Browser.waitForElementToBeVisible(By.xpath("//span[@class='success' and contains(text(),'Charge Successful for')]"));
        WebElement textChargeSuccessful = DriverManager.getInstance().Driver.findElement(By.xpath("//span[@class='success' and contains(text(),'Charge Successful for')]"));
        if (Browser.getTextFromElement(textChargeSuccessful).contains("Charge Successful for")) {
            Assert.assertTrue("Charge Successful for", textChargeSuccessful.isDisplayed());
        } else {
            Assert.assertFalse("Charge Successful for", textChargeSuccessful.isDisplayed());
        }
    }

    public void verifyPaymentReceiptIsDownloaded() {
        WebElement downloadIcon = DriverManager.getInstance().Driver.findElement(By.xpath("//span[@role='button' and @tabindex='0']"));
        Browser.clickOnElement(downloadIcon);
    }

    public void createAndSaveCustomLink() {
        WebElement customTextBox = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@class='payment-link-input-field form-control']"));
        Browser.enterTextInEditBox(customTextBox, "TestAutomation");
        WebElement saveButton = DriverManager.getInstance().Driver.findElement(By.xpath("//button[text()='Save']"));
        Browser.clickOnElement(saveButton);
    }

    public void createCustomURLAndNavigate() {
        WebElement eLink = DriverManager.getInstance().Driver.findElement(By.xpath("(//span[contains(text(),'https://www.patientsreach.com/payment/')])[2]"));
        String urlText = eLink.getText();
        String[] arrOfStr = urlText.split("payment");
        String URL = ConfigManager.getInstance().getProperty("URL");
        URL = String.join("", URL, "/payment", arrOfStr[1]);
        Browser.navigateToNewURL(URL);
    }

    public void ClickOnSortIconForPaymentTableViaDate() {
        WebElement sortIconPaymentDate = DriverManager.getInstance().Driver.findElement(By.xpath("//*[@class='sortable' and contains(text(),'Payment Date')]"));
        Browser.clickOnElement(sortIconPaymentDate);
    }

    public void paymentDetailsInPaymentTable() {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
        Date date = new Date();
        String expectedDate = dateFormat.format(date);
        WebElement actualDate = DriverManager.getInstance().Driver.findElement(By.xpath("//*[@class='table table-striped table-hover']//tbody//tr[1]//td[10]"));
        Assert.assertEquals(actualDate.getText(), expectedDate);
    }


    public void searchPatientInPaymentMethod() {
        Browser.waitForElementToBeVisible(By.xpath("//input[@class='patient-search-box ']"));
        Browser.waitForElementToBeClickable(By.xpath("//input[@class='patient-search-box ']"));
        WebElement searchTextBox = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@class='patient-search-box ']"));
        Browser.enterTextInEditBox(searchTextBox, PbNUIApp.userdata().getPatientName(2, 1));
        Browser.waitForElementList(By.xpath("//div[@class='patient-row patient-row-enabled  row']"));
        Browser.waitForElementToBeVisible(DriverManager.getInstance().Driver.findElement(By.xpath("//div[@class='fade in patient-popover popover bottom']//div[@class='patient-row patient-row-enabled  row']")));
        WebElement patientName = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@class='fade in patient-popover popover bottom']//div[@class='patient-row patient-row-enabled  row']"));
        Browser.clickOnElement(patientName);
    }

    public void setSelectPaginationNumber() {
        Browser.slowWaitForPresenceOfElement(By.xpath("/html/body/div[@role='dialog']"));
        Browser.waitForElementPresence(By.xpath("//div[@class='modal-body']//div[@class='row react-bootstrap-table-pagination']//button[@id='pageDropDown']"));
        WebElement pagination = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@class='modal-body']//div[@class='row react-bootstrap-table-pagination']//button[@id='pageDropDown']"));
        Browser.clickOnElementUsingJavascript(pagination);
        List<WebElement> selectPaginationDropDown = DriverManager.getInstance().Driver.findElements(By.xpath("//div[@class='content-section']//ul[@role='menu']//li//a"));
        for (WebElement element : selectPaginationDropDown) {
            if (element.getText().contains(SelectPaginationNumber)) {
                element.click();
                break;
            }
        }
    }

    public void AddAdyenCardWithPatient() {
        List<WebElement> listOfAdyenCard = DriverManager.getInstance().Driver.findElements(By.xpath("//div[@class='modal-body']//tbody//tr"));
        initialTableSize = listOfAdyenCard.size();
        Browser.waitForPresenceOfElement(By.xpath("//button[text()='Add a new Card']"));
        WebElement addNewCard = DriverManager.getInstance().Driver.findElement(By.xpath("//button[text()='Add a new Card']"));
        Browser.clickOnElement(addNewCard);
        Browser.scrollToVisibleElement(DriverManager.getInstance().Driver.findElement(By.xpath("//button[text()='Save card']")));
        Browser.waitForElementToBeVisible(By.xpath("//iframe[@title='Iframe for card number']"));
        Browser.waitForFrameToLoad(By.xpath("//iframe[@title='Iframe for card number']"));
        Browser.waitForElementToBeVisible(By.xpath("//input[@data-fieldtype='encryptedCardNumber']"));
        WebElement cardNumber = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@data-fieldtype='encryptedCardNumber']"));
        Browser.enterTextInEditBox(cardNumber, PbNUIApp.userdata().getCardNumber(2, "1"));
        Browser.switchToDefaultContent();
        enterCardDate();
        enterCVC();
        enterPostalCode();
        clickOnSaveButton();
        verifyAdyenCardWithPatient();
    }

    public void enterCardDate() {
        Browser.waitForFrameToLoad(By.xpath("//iframe[@title='Iframe for expiry date']"));
        WebElement cardDate = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@data-fieldtype='encryptedExpiryDate']"));
        Browser.enterTextInEditBox(cardDate, PbNUIApp.userdata().getCardMonth(2, "1"));
        Browser.switchToDefaultContent();
    }

    public void enterCVC() {
        Browser.waitForFrameToLoad(By.xpath("//iframe[@title='Iframe for security code']"));
        WebElement CVC = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@data-fieldtype='encryptedSecurityCode']"));
        Browser.enterTextInEditBox(CVC, PbNUIApp.userdata().getCardCVC(2, "1"));
        Browser.switchToDefaultContent();
    }

    public void enterPostalCode() {
        WebElement postalCode = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@name='postalCode']"));
        Browser.enterTextInEditBox(postalCode, PbNUIApp.userdata().getPostalCode(2, "1"));
    }

    public void clickOnSaveButton() {
        WebElement saveButton = DriverManager.getInstance().Driver.findElement(By.xpath("//button[text()='Save card']"));
        Browser.clickOnElement(saveButton);
    }

    public void verifyAdyenCardWithPatient() {
        Browser.refreshPage();
        searchPatientInPaymentMethod();
        Browser.waitForPageReady();
        setSelectPaginationNumber();
        List<WebElement> updatedListOfAdyenCard = DriverManager.getInstance().Driver.findElements(By.xpath("//div[@class='modal-body']//tbody//tr"));
        int updatedTableSize = updatedListOfAdyenCard.size();
        Assert.assertEquals("card not Added", initialTableSize + 1, updatedTableSize);
    }

    public void verifyPaymentTableLabel() {
        Browser.waitForPageReady();
        Browser.waitForElementToBeVisible(By.xpath("//div[@class='react-bootstrap-table table-responsive']//table"));
        WebElement patientNameLabel = DriverManager.getInstance().Driver.findElement(By.xpath("//th[@aria-label='Patient Name sortable' and contains(text(),'Patient Name')]"));
        Assert.assertEquals("PATIENT NAME", patientNameLabel.getText());
        WebElement netAmountLabel = DriverManager.getInstance().Driver.findElement(By.xpath("//th[@aria-label='Net sortable' and contains(text(),'Net')]"));
        Assert.assertEquals("NET", netAmountLabel.getText());
        WebElement transactionId = DriverManager.getInstance().Driver.findElement(By.xpath("//th[text()='Txn. Id']"));
        Assert.assertEquals("TXN. ID", transactionId.getText());
        WebElement paymentDate = DriverManager.getInstance().Driver.findElement(By.xpath("//th[@aria-label='Payment Date sortable' and contains(text(),'Payment Date')]"));
        Assert.assertEquals("PAYMENT DATE", paymentDate.getText());
        WebElement surcharge = DriverManager.getInstance().Driver.findElement(By.xpath("//span[text()='Surcharge']"));
        Assert.assertEquals("SURCHARGE", surcharge.getText());
    }

    public void clickOnPaymentSideNav() {
        Browser.waitForElementToBeClickable(By.xpath("//a[@id='payment-page-tab-Payments']"));
        WebElement paymentSideNav = DriverManager.getInstance().Driver.findElement(By.xpath("//a[@id='payment-page-tab-Payments']"));
        Browser.clickOnElement(paymentSideNav);
    }

    public void clickOnPaymentTabInSideNavigation() {
        Browser.waitForElementToBeClickable(By.xpath("//a[@id='payment-page-tab-Payments']"));
        WebElement paymentSideNav = DriverManager.getInstance().Driver.findElement(By.xpath("//a[@id='payment-page-tab-Payments']"));
        Browser.clickOnElement(paymentSideNav);
    }

    public void setSelectPagination() {
        Browser.scrollToVisibleElement(DriverManager.getInstance().Driver.findElement(By.xpath("//button[@id='pageDropDown']")));
        WebElement paginationDropDown = DriverManager.getInstance().Driver.findElement(By.xpath("//button[@id='pageDropDown']"));
        Browser.clickOnElement(paginationDropDown);
        List<WebElement> selectPaginationDropDown = DriverManager.getInstance().Driver.findElements(By.xpath("//span//ul[@role='menu']//li//a"));
        for (WebElement element : selectPaginationDropDown) {
            if (element.getText().contains(SelectPaginationNumber)) {
                element.click();
                break;
            }
        }
    }

    public void displayedRefundDollarIcon() {
        setSelectPagination();
        WebElement container = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@data-testid='wrapper']"));
        Browser.waitForChildToDisappear(container, By.xpath("//div[@class='text-center']"));
        WebElement table = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@class='react-bootstrap-table table-responsive']//tbody"));
        Browser.waitForTableToLoad(table);
        List<WebElement> patientTableRows = DriverManager.getInstance().Driver.findElements(By.xpath("//div[@class='react-bootstrap-table table-responsive']//tbody//tr"));
        String patientToVerify = PbNUIApp.userdata().getPatientName(2, 1);
        for (WebElement row : patientTableRows) {
            Browser.waitForPresenceOfElement(By.xpath("//div[@class='react-bootstrap-table table-responsive']//tbody//tr//a"));
            WebElement patientName = row.findElement(By.xpath(".//a"));
            String actualPatientName = patientName.getText().trim();
            if (actualPatientName.equals(patientToVerify)) {
                WebElement dollarIcon = row.findElement(By.xpath("//div[@class='flex-row flex-vertical-center']//div[@style]"));
                boolean isDollarIconDisplayed = dollarIcon.isDisplayed();
                Assert.assertTrue("Dollar icon should be displayed for patient: " + patientToVerify, isDollarIconDisplayed);
                break;
            }
        }
    }
}

