package Pages.Modals;

import Framework.Browser;
import Framework.Util.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AppointmentScheduleModal {
    private WebElement modalTitle = DriverManager.getInstance().Driver.findElement(By.xpath("//*[@id='chat-box']//p"));

    AppointmentScheduleModal() {
        Browser.waitForElementToBeVisible(modalTitle);
        Browser.waitForPageReady();
    }

    public static void doubleClickOnAppointmentScheduleCalendarFirstProvider() {
        List<WebElement> timeSlots = DriverManager.getInstance().Driver.findElements(By.xpath("//*[@id='chat-box']//div[contains(@class,'rbc-today-off rbc-day-slot')]"));
        Browser.waitForElementToDisplay(timeSlots.getFirst());
        //WebElement timeSlots = DriverManager.getInstance().Driver.findElement(By.xpath("//*[@id='chat-box']//div[@class='rbc-time-gutter rbc-time-column']"));
        //Browser.waitForElementToDisplay(timeSlots);
        //WebElement parent = DriverManager.getInstance().Driver.findElement(By.xpath("/html/body"));
        //Browser.waitForAttributeValue(parent, "class", "freeze-body");

        //Browser.waitForElementPresence(By.xpath("//*[@id='chat-box']//div[@class='schedule-window float-window fade in']"));
        Browser.waitForPageReady();

        List<WebElement> appointmentSlots = timeSlots.getFirst().findElements(By.xpath(".//div[@class='rbc-time-slot slotDefault']"));
        System.out.println(appointmentSlots.size());
        Browser.waitForElementToBeClickable(appointmentSlots.getFirst());
        //Browser.clickOnElement(appointmentCalendar.getFirst());
        Browser.doubleClickOnElement(appointmentSlots.getFirst());
    }
}
