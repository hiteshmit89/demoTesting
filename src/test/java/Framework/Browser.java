package Framework;

import Framework.Constants.Constants.PageTitle;
import Framework.Util.ConfigManager;
import Framework.Util.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.time.Duration;
import java.util.function.BooleanSupplier;

public class Browser {

    public static void waitForElementToDisplay(WebElement element) {
        retry(() -> element.isDisplayed() && element.isEnabled());
    }

    public static void waitForElementToBeVisible(WebElement element) {
        getFluentWait().until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementToBeClickable(WebElement element) {
        getFluentWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForElementToBeClickable(By locator) {
        getFluentWait().until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitForElementToBeVisible(By locator) {
        getFluentWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private static FluentWait<WebDriver> getFluentWait() {
        return new FluentWait<WebDriver>((WebDriver) DriverManager.getInstance().Driver)
                .withTimeout(Duration.ofSeconds(Integer.parseInt(ConfigManager.getInstance().getProperty("Timeout"))))
                .pollingEvery(Duration.ofMillis(Integer.parseInt(ConfigManager.getInstance().getProperty("Polling"))))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementClickInterceptedException.class)
                .ignoring(ElementNotInteractableException.class);
    }

    public static void waitForAttributeValue(WebElement element, String attribute, String expectedValue) {
        retry(() -> element.getAttribute(attribute).equals(expectedValue));
    }

    public static void waitForPageTitle(PageTitle title) {
        retry(() -> DriverManager.getInstance().getPgeTitle().contains(title.label));
    }

    public static void waitForTableToLoad(WebElement table) {
        retry(() -> !table.findElements(By.xpath(".//tr")).isEmpty());
    }

    public static void waitForTableToUnload(WebElement table) {
        retry(() -> table.findElements(By.xpath(".//tr")).isEmpty());
    }

    public static void waitForTableSizeToBe(WebElement table, int size) {
        retry(() -> table.findElements(By.xpath(".//tr")).size() >= size);
    }

    public static void waitForTableRowSizeToBe(WebElement table, int size) {
        retry(() -> table.findElements(By.xpath("./../td/div")).size() >= size);
    }

    public static void clickOnElement(WebElement element) {
        waitForElementToDisplay(element);
        element.click();
    }

    public static void doubleClickOnElement(WebElement element) {
        waitForElementToDisplay(element);
        Actions mouseAction = new Actions((WebDriver) DriverManager.getInstance().Driver);
        mouseAction.doubleClick(element).build().perform();
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

    public static void waitForPresenceOfElement(By locator) {
        getFluentWait().until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static void waitForPageReady() {
        DriverManager.getInstance().pageReady();
    }

    public static void navigateToNewURL(String url) {
        DriverManager.getInstance().navigateToURL(url);
    }

    public static void openNewTab() {
        DriverManager.getInstance().openNewWindow(WindowType.TAB);
    }

    public static void openNewWindow() {
        DriverManager.getInstance().openNewWindow(WindowType.WINDOW);
    }

    public static void closeWindowAndGetOriginalPage() {
        DriverManager.getInstance().closeNewWindow();
    }

    public static void scrollToVisibleElement(WebElement object) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getInstance().Driver;
        js.executeScript("arguments[0].scrollIntoView();", object);
    }

    public static void switchToFrame(WebElement iFrame) {
        waitForElementToDisplay(iFrame);
        waitForElementToBeClickable(iFrame);
        ((WebDriver) DriverManager.getInstance().Driver).switchTo().frame(0);
    }

    public static void clickOnElementUsingJavascript(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor)DriverManager.getInstance().Driver;
        js.executeScript("arguments[0].click();", element);
    }

    private static void retry(BooleanSupplier function)
    {
        int count = 0;
        Exception exception = null;
        String exceptionMessage = "";
        int retryInterval = Integer.parseInt(ConfigManager.getInstance().getProperty("Polling"));
        int timeOut = Integer.parseInt(ConfigManager.getInstance().getProperty("Timeout"));
        float temp = ((float) retryInterval / 1000) % 60;
        int retryCount = (int) (timeOut / temp);
        do {
            try {
                if (function.getAsBoolean()) {
                    return;
                } else {
                    Thread.sleep(retryInterval);
                    count++;
                }
            } catch (Exception ex) {
                exception = ex;
                count++;
            }
        } while (count != retryCount);
        System.out.println(exceptionMessage = "Retry Timed Out while trying to execute - " + new Throwable().getStackTrace()[1].getMethodName());
        throw new RuntimeException(exceptionMessage + exception);
    }
}
