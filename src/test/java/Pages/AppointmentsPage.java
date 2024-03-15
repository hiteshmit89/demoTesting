package Pages;

import Framework.Browser;
import Framework.Constants.Constants.PageTitle;
import Framework.Util.DriverManager;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;
import java.util.List;

public class AppointmentsPage extends BasePage {

    public AppointmentsPage(PageTitle title) {
        super(title);
    }



    public void clickOnWidgets() {
        WebElement widgetsTab = DriverManager.getInstance().Driver.findElement(By.xpath("//a[@id='appointment-booking-page-tab-Widgets']"));
        Browser.clickOnElement(widgetsTab);
    }

    public void clickOnCopyUrl() {
        WebElement CopyUrlIcon = DriverManager.getInstance().Driver.findElement(By.xpath("(//i[@class='fa fa-copy'])[1]"));
        Browser.clickOnElement(CopyUrlIcon);
        //CopyUrlIcon.sendKeys(Keys.CONTROL+ "v");
        WebElement e = DriverManager.getInstance().Driver.findElement(By.xpath("(//span[contains(text(),'https://www.patientsreach.com/schedule/')])[1]"));
        System.out.println(e.getText());
        String urlText = e.getText();
        String[] arrOfStr = urlText.split("schedule");
        for (String a : arrOfStr) {
            System.out.println(a);
        }
       String URL = "https://qa3.pbn-dev.com";
               URL = String.join("", URL,"/schedule",arrOfStr[1] );
        System.out.println(URL);
        //System.out.println(arrOfStr);
        // ((JavascriptExecutor) DriverManager.getInstance().Driver).executeScript("window.open(urlText)");
        ChromeDriver driver = new ChromeDriver();

        //login
        //driver.get(URL);
        driver.navigate().to(URL);
        driver.manage().window().maximize();
        String originalWindow = driver.getWindowHandle();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        //driver.switchTo().newWindow(WindowType.WINDOW);
    }

    public void clickOnPickLocation() {

        WebElement pickLocation = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@class='location-item-name'and text()='Romans, Burke and Wagner']"));
        Browser.clickOnElement(pickLocation);
    }

    public void clickOnSelectNewPatient(){
        WebElement selectNewPatient = DriverManager.getInstance().Driver.findElement(By.xpath("//span[normalize-space()=\"I'm a New Patient\"]"));
        Browser.clickOnElement(selectNewPatient);
    }
    public void clickOnSelectReturningPatient(){
        WebElement selectReturningPatient = DriverManager.getInstance().Driver.findElement(By.xpath("//span[normalize-space()=\"I'm a Returning Patient\"]"));
        Browser.clickOnElement(selectReturningPatient);
    }
    public void clickOnEmergencyConsult(){
        WebElement selectEmergencyConsult = DriverManager.getInstance().Driver.findElement(By.xpath("(//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text hover-transition'])[1]"));
        Browser.clickOnElement(selectEmergencyConsult);
    }

    public void clickOnEarliest(){
        WebElement selectEarliest = DriverManager.getInstance().Driver.findElement(By.xpath("(//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text'])[2]"));
        Browser.clickOnElement(selectEarliest);
    }
    public void enterFirstName(){
        WebElement firstName = DriverManager.getInstance().Driver.findElement(By.xpath("//input[@placeholder='Patient First Name']"));
        Browser.enterTextInEditBox(firstName,);
    }




}


