package Pages.Modals;

import Framework.Browser;
import Framework.Root.PbNUIApp;
import Framework.Util.DriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static Framework.Constants.Constants.Sections.CommCenter;

public class CommCenterModal {
    CommCenterModal() {
        Browser.waitForPageReady();
    }

    public void clickOnFloatingCommCenterButton() {
        PbNUIApp.navigator().ClickOnFloatingButton(CommCenter);
    }

    public void enterPatientNameInSearchBox() {
        WebElement searchBox = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@class='hidden-xs']//div[@class='chat-window float-window fade in']//div[@class='panel panel-default popup-container']/div//input[@placeholder='Search']"));
        Browser.enterTextInEditBox(searchBox, PbNUIApp.userdata().getPatientName(2, 1));
    }

    public void clickOnPatientAvatarThreeDots() {
        Browser.waitForElementToBeVisible(By.xpath("(//div[@class='conversation-header']//div[@id='patient-popover'])[1]"));
        Browser.waitForElementToBeClickable(By.xpath("(//div[@class='conversation-header']//div[@id='patient-popover'])[1]"));
        WebElement patientIconPopover = DriverManager.getInstance().Driver.findElement(By.xpath("(//div[@class='conversation-header']//div[@id='patient-popover'])[1]"));
        Browser.hoverOnElement(patientIconPopover);
        Browser.waitForElementToBeVisible(By.xpath("//div[@class='conversation-header']//div[@class='action-user default']//i[@class='fa-solid fa-ellipsis']"));
        WebElement clickOnPatientAvatarThreeDots = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@class='conversation-header']//div[@class='action-user default']//i[@class='fa-solid fa-ellipsis']"));
        Browser.clickOnElementUsingJavascript(clickOnPatientAvatarThreeDots);
    }

    public void clickOnChargeOption() {
        WebElement clickOnChargeOption = DriverManager.getInstance().Driver.findElement(By.xpath("//li[text()='Charge']"));
        Browser.waitForElementToDisplay(clickOnChargeOption);
        Browser.clickOnElement(clickOnChargeOption);
    }

    public void clickOnRequestOption() {
        WebElement clickOnRequestOption = DriverManager.getInstance().Driver.findElement(By.xpath("//li[text()='Request Payment']"));
        Browser.waitForElementToDisplay(clickOnRequestOption);
        Browser.clickOnElement(clickOnRequestOption);
    }

    public void verifyPaymentFloatingButton() {
        WebElement paymentFloatingButton = DriverManager.getInstance().Driver.findElement(By.xpath("//span[@class='hidden-xs']//span[@class='hidden-xs'][text()='Payments']"));
        Assert.assertTrue("Payment Floating button is not visible", paymentFloatingButton.isDisplayed());
    }
}
