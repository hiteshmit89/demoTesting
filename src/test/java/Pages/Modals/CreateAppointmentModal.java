package Pages.Modals;

import Framework.Browser;
import Framework.Util.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CreateAppointmentModal {
    private WebElement modalTitle = DriverManager.getInstance().Driver.findElement(By.xpath("/html/body//div/h[@class='modal-title']"));
    private List<WebElement> appointmentCalendar = DriverManager.getInstance().Driver.findElements(By.xpath("//*[@id='chat-box']//div[@class='rbc-events-container']"));
    private WebElement patientSelector = DriverManager.getInstance().Driver.findElement(By.xpath("//*[contains(text(),'Search for Patient')]"));

    CreateAppointmentModal() {
        Browser.waitForElementToBeVisible(modalTitle);
        Browser.waitForPageReady();
    }
}
