package Pages.Modals;

import Framework.Browser;
import Framework.Util.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AppointmentScheduleModal {
    private WebElement modalTitle = DriverManager.getInstance().Driver.findElement(By.xpath("//*[@id='chat-box']//p"));

    AppointmentScheduleModal() {
        Browser.waitForPageReady();
        Browser.waitForElementToBeVisible(modalTitle);
    }

    public void doubleClickOnAppointmentScheduleCalendarFirstProvider() {
        Browser.waitForPageReady();
        Browser.waitForElementList(By.xpath("//*[@id='chat-box']//div[contains(@class,'rbc-today-off rbc-day-slot')]"));
        List<WebElement> timeSlots = DriverManager.getInstance().Driver.findElements(By.xpath("//*[@id='chat-box']//div[contains(@class,'rbc-today-off rbc-day-slot')]"));
        List<WebElement> appointmentSlots = timeSlots.getFirst().findElements(By.xpath(".//div[@class='rbc-time-slot slotDefault']"));
        Browser.doubleClickOnElement(timeSlots.getFirst());
    }
}
