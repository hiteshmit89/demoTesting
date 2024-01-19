package Framework.Util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class DriverManager {
    private WebDriver webDriver = null;
    public SearchContext Driver = null;
    private static ThreadLocal<DriverManager> manager = new ThreadLocal<DriverManager>();

    private DriverManager() {

    }

    public static DriverManager getInstance() {
        if (manager.get() == null) {
            manager.set(new DriverManager());
        }
        return manager.get();
    }

    public void loadDriver(String browser) {
        switch (browser) {
            case "edge":
                setDriver(new EdgeDriver());
                break;
            case "firefox" :
                setDriver(new FirefoxDriver());
                break;
            case "safari" :
                setDriver(new SafariDriver());
                break;
            default:
                setDriver(new ChromeDriver());
                break;
        }
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(
                Integer.parseInt(ConfigManager.getInstance().getProperty("Timeout"))));
        webDriver.manage().window().maximize();
    }

    public Wait<WebDriver> fluentwait(){
        return new FluentWait<WebDriver>(webDriver)
                .withTimeout(Duration.ofSeconds(Integer.parseInt(ConfigManager.getInstance().getProperty("Timeout"))))
                .pollingEvery(Duration.ofMillis(Integer.parseInt(ConfigManager.getInstance().getProperty("Polling"))))
                .ignoring(NoSuchElementException.class);
    }

    public void pageReady(){
        Wait<WebDriver> wait = fluentwait();
        wait.until(webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));
    }

    public void navigateToURL(String url) {
        webDriver.get(url);
    }

    public void closeDriver() {
        if (webDriver != null) {
            webDriver.close();
        }
    }

    public void quitDriver() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

    private void setDriver(WebDriver driver) {
        if (this.webDriver == null) {
            this.webDriver = driver;
            Driver = webDriver;
        }
    }

    public String getPgeTitle() {
        return webDriver.getTitle();
    }

    public String getPageURL() {
        return webDriver.getCurrentUrl();
    }

    public String getPageHandle() {
        return webDriver.getWindowHandle();
    }

    public void killSession(){
        webDriver = null;
        Driver = null;
    }

    public void remove(){
        manager.remove();
    }

}
