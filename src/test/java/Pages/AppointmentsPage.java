package Pages;

import Framework.Browser;
import Framework.Constants.Constants.PageTitle;
import Framework.Util.DriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
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
    }

}


