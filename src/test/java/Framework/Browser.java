package Framework;

import Framework.Constants.Constants.PageTitle;
import Framework.Util.ConfigManager;
import Framework.Util.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

import java.util.function.BooleanSupplier;

public class Browser {


    public static void waitForElementToDisplay(WebElement element) {
        retry(() -> element.isDisplayed() && element.isEnabled());
    }

    public static void waitForPageTitle(PageTitle title) {
        retry(() -> DriverManager.getInstance().getPgeTitle().contains(title.label));
    }

    public static void clickOnElement(WebElement element) {
        waitForElementToDisplay(element);
        element.click();
    }

    public static String getTextFromElement(WebElement element) {
        waitForElementToDisplay(element);
        return element.getText();
    }

    public static void enterTextInEditBox(WebElement element, String text) {
        waitForElementToDisplay(element);
        element.clear();
        element.sendKeys(text);
    }

    public static void waitForAttributeValue(WebElement element, String attribute, String expectedValue) {
        retry(() -> element.getAttribute(attribute).equals(expectedValue));
    }

    public static void waitForPageReady() {
        DriverManager.getInstance().pageReady();
    }

    public static void navigateToNewURL(String url) {
        DriverManager.getInstance().navigateToURL(url);
    }

    public static void openNewTab() {
        DriverManager.getInstance().openNew(WindowType.TAB);
    }

    public static void openNewWindow() {
        DriverManager.getInstance().openNew(WindowType.WINDOW);
    }

    public static void closeWindowAndGetOriginalPage() {
        DriverManager.getInstance().closeNewWindow();
    }

    private static void retry(BooleanSupplier function)
    {
        int count = 0;
        Exception exception = null;
        String exceptionMessage = "";
        int retryInterval = Integer.parseInt(ConfigManager.getInstance().getProperty("Polling"));
        int timeOut = Integer.parseInt(ConfigManager.getInstance().getProperty("Timeout"));
        float temp = ((float) retryInterval/1000) % 60;
        int retryCount = (int) (timeOut/ temp);
        do
        {
            try
            {
                if (function.getAsBoolean()) {
                    return;
                }
                else{
                    Thread.sleep(retryInterval);
                    count++;
                }
            }
            catch (Exception ex)
            {
                exception = ex;
                count++;
            }
        } while (count != retryCount);
        System.out.println(exceptionMessage = "Retry Timed Out while trying to execute - " + new Throwable().getStackTrace()[1].getMethodName());
        throw new RuntimeException(exceptionMessage + exception);
    }
}
