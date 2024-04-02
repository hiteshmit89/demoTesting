package Pages.Modals;

import Framework.Browser;
import Framework.Constants.Constants.*;
import Framework.Util.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AppointmentScheduleModal {
    private WebElement modalTitle = DriverManager.getInstance().Driver.findElement(By.xpath("//*[@id='chat-box']//p"));
    private List<WebElement> appointmentCalendar = DriverManager.getInstance().Driver.findElements(By.xpath("//*[@id='chat-box']//div[@class='rbc-events-container']"));
    AppointmentScheduleModal() {
        Browser.waitForElementToBeVisible(modalTitle);
        Browser.waitForPageReady();
    }

    public void doubleClickOnAppointmentScheduleCalendarFirstProvider() {
        Browser.doubleClickOnElement(appointmentCalendar.getFirst());
    }
}
