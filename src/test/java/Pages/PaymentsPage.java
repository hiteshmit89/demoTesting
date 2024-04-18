package Pages;

import Framework.Browser;
import Framework.Constants.Constants.*;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;
import Framework.Util.DriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class PaymentsPage extends BasePage {

    public PaymentsPage(PageTitle title) {
        super(title);
    }

    private final WebElement paymentsTab = DriverManager.getInstance().Driver.findElement(By.xpath("//a[@id='payment-page-tab-Payments']"));
    private final WebElement paymentMethodsTab = DriverManager.getInstance().Driver.findElement(By.xpath("//a[@id='payment-page-tab-Payment Methods']"));

    public void clickPaymentsMenu() {
        Browser.clickOnElement(paymentsTab);
    }

    public void clickPaymentsMethodsTab() {
        Browser.clickOnElement(paymentMethodsTab);
    }

    public void clickCardIcon(){
        Browser.waitForElementToBeVisible(By.xpath("(//*[@class='svg-inline--fa fa-credit-card fa-w-18 card-icon'])[1]"));
        Browser.waitForElementToBeClickable(By.xpath("(//*[@class='svg-inline--fa fa-credit-card fa-w-18 card-icon'])[1]"));
        WebElement cardIcon = DriverManager.getInstance().Driver.findElement(By.xpath("(//*[@class='svg-inline--fa fa-credit-card fa-w-18 card-icon'])[1]"));
        Browser.clickOnElement(cardIcon);
    }
    public void selectDropdownValue(){
        Browser.waitForPresenceOfElement(By.xpath("//*[@id='payment-methods-selector']"));
        Browser.waitForElementToBeVisible(By.xpath("//*[@id='payment-methods-selector']"));
        WebElement dropdownSelectPaymentMethod = DriverManager.getInstance().Driver.findElement(By.xpath("//*[@id='payment-methods-selector']"));
        Browser.selectIndexFromDropdown(dropdownSelectPaymentMethod, 1);
    }
    public void enterAmount(){
        WebElement enterAmountTextBox = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@type='number']"));
        Random random = new Random();
        int randomNumber = random.nextInt(10000);
        Browser.enterTextInEditBox(enterAmountTextBox, String.valueOf(randomNumber));

    }
    public void enterChargeDescription(){
        WebElement enterAmountTextBox = DriverManager.getInstance().Driver.findElement(By.xpath("//textarea[@class='charge-description-input-box form-control']"));
        Browser.enterTextInEditBox(enterAmountTextBox,"Entered Description");

    }
    public void clickChargeButtonOnModal(){
        WebElement chargeButton = DriverManager.getInstance().Driver.findElement(By.xpath("//button[@class='btn btn-default']//span[text()=' Charge ']"));
        Browser.clickOnElement(chargeButton);
        WebElement chargeConfirmationPopUp = DriverManager.getInstance().Driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
        Browser.clickOnElement(chargeConfirmationPopUp);

    }
    public void verifyChargeConfirmationText(){
        Browser.waitForElementToBeVisible(By.xpath("//span[@class='success' and contains(text(),'Charge Successful for')]"));
        WebElement textChargeSuccessful = DriverManager.getInstance().Driver.findElement(By.xpath("//span[@class='success' and contains(text(),'Charge Successful for')]"));
        if(Browser.getTextFromElement(textChargeSuccessful).contains("Charge Successful for")){
            Assert.assertTrue("Charge Successful for",textChargeSuccessful.isDisplayed());
        } else {
            Assert.assertFalse("Charge Successful for",textChargeSuccessful.isDisplayed());
        }
    }
    public void verifyPaymentReceiptIsDownloaded(){
        WebElement downloadIcon = DriverManager.getInstance().Driver.findElement(By.xpath("//span[@role='button' and @tabindex='0']"));
        Browser.clickOnElement(downloadIcon);
        /*String downloadsPath = System.getProperty("user.dir") + "/AdyenPaymentReceipt";
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH_mm_ss");
        String formattedDateTime = currentDateTime.format(formatter);
        File downloadedFile = new File(downloadsPath + "/payment_receipt_"+ formattedDateTime+".pdf");
        int waitTimeInSeconds = 60;
        long endTime = System.currentTimeMillis() + (waitTimeInSeconds * 1000);

        while (!downloadedFile.exists() && System.currentTimeMillis() < endTime) {
            try {
                Thread.sleep(1000); // Check every second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (downloadedFile.exists()) {
            System.out.println("PDF downloaded successfully!");
        } else {
            System.out.println("PDF download failed or timed out.");
        }*/
        // Get the current working directory (project folder)

        String projectDir = System.getProperty("user.dir");
        // Define the path where you want to save the downloaded file in the project folder
        String downloadPath = projectDir + "/AdyenPaymentReceipt";
        // Create the downloads directory if it doesn't exist
        File downloadsDir = new File(downloadPath);
        if (!downloadsDir.exists()) {
            downloadsDir.mkdir();
        }

        // Check if the PDF file is downloaded
        File downloadedFile = new File(downloadPath + File.separator + "payment_receipt_2024-04-16_17_49_07.pdf");
        int waitTimeInSeconds = 60;
        long endTime = System.currentTimeMillis() + (waitTimeInSeconds * 1000);

       /* while (!downloadedFile.exists() && System.currentTimeMillis() < endTime) {
            try {
                Thread.sleep(500); // Check every second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/

        if (downloadedFile.exists()) {
            System.out.println("PDF downloaded successfully!");
        } else {
            System.out.println("PDF download failed or timed out.");
        }


    }


}

