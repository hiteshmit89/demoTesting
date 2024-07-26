package Pages.PatientPortal;

import Framework.Browser;
import Framework.Constants.Constants;
import Framework.Util.DriverManager;
import Pages.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PatientPortalLoginPage extends BasePage {
    public PatientPortalLoginPage(Constants.PageTitle title) {
        super(title);
    }

    private WebElement email = DriverManager.getInstance().Driver.findElement(By.xpath("//*[@name='username']"));
    private WebElement password = DriverManager.getInstance().Driver.findElement(By.xpath("//*[@name='password']"));
    private WebElement signInButton = DriverManager.getInstance().Driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-disableElevation MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-disableElevation smaller-screen css-1hbfplg']"));

    public void enterEmail(String emailID) {
        Browser.enterTextInEditBox(email, emailID);
    }

    public void enterPassword(String passcode) {
        Browser.enterTextInEditBox(password, passcode);
    }

    public void clickOnSignInButton() {
        Browser.clickOnElement(signInButton);
    }

    public void verifyErrorMessageDisplayed() {
        Browser.waitForElementToBeVisible(By.xpath("//div[@class='Toastify__progress-bar Toastify__progress-bar--animated Toastify__progress-bar-theme--colored Toastify__progress-bar--error']"));
        WebElement ErrorMessage = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@class='Toastify__progress-bar Toastify__progress-bar--animated Toastify__progress-bar-theme--colored Toastify__progress-bar--error']"));
        Assert.assertTrue("Error message did not display as expected.", ErrorMessage.isDisplayed());
    }
}


