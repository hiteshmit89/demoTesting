package Pages.Modals;

import Framework.Browser;
import Framework.Util.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AppointmentScheduleModal {
    private WebElement modalTitle = DriverManager.getInstance().Driver.findElement(By.xpath("//*[@id='chat-box']//p"));

    AppointmentScheduleModal() {
        Browser.waitForPageReady();
        Browser.waitForElementToBeVisible(modalTitle);
    }

    public void doubleClickOnAppointmentScheduleCalendarFirstProvider() {
        Browser.waitForPageReady();
        WebElement timeColumn = DriverManager.getInstance().Driver.findElement(By.xpath("//div[@class='rbc-time-gutter rbc-time-column']"));
        int firstTimeSlot = Integer.parseInt(timeColumn.findElements(By.xpath(".//span")).getFirst().getText().split(" ")[0].split(":")[0]);
        Browser.waitForElementList(By.xpath("//*[@id='chat-box']//div[contains(@class,'rbc-today-off rbc-day-slot')]"));
        List<WebElement> columns = DriverManager.getInstance().Driver.findElements(RelativeLocator.with(By.xpath("//*[@id='chat-box']//div[contains(@class,'rbc-today-off rbc-day-slot')]")).toRightOf(timeColumn));
        WebElement firstColumnEventContainer = columns.getFirst().findElement(By.xpath(".//div[@class='rbc-events-container']"));
        Set<Integer> occupiedSlots = new HashSet<>();
        try {
            List<WebElement> eventsInFirstColumn = firstColumnEventContainer.findElements(By.xpath("./div"));
            //Events found. Calculate time slots we cannot click on
            for (WebElement element : eventsInFirstColumn) {
                occupiedSlots.add(Integer.valueOf(element.getAttribute("title").substring(0, 1)));
            }
            List<WebElement> timeSlotGroupsToday = columns.getFirst().findElements(By.xpath(".//div[@class='rbc-timeslot-group']"));
            Integer currentSlot = firstTimeSlot;
            for (WebElement timeSlot : timeSlotGroupsToday) {
                //Check if this is occupied
                if (occupiedSlots.contains(currentSlot)) {
                    currentSlot++;
                } else {
                    Browser.doubleClickOnElement(timeSlot);
                    break;
                }
            }
        } catch (Exception e) {
            //No events exist click anywhere in column
            Browser.doubleClickOnElement(columns.getFirst());
        }

/*
        List<WebElement> timeSlotLabels = DriverManager.getInstance().Driver.findElements(By.xpath("//*[@id=\"chat-box\"]//div[@class='rbc-timeslot-group']//span"));
        //int firstAppointmentTime = Integer.parseInt(timeSlotLabels.getFirst().getText().split(" ")[0].split(":")[0]);
        List<WebElement> timeSlots = DriverManager.getInstance().Driver.findElements(By.xpath("//*[@id='chat-box']//div[contains(@class,'rbc-today-off rbc-day-slot')]"));
        //List<WebElement> appointmentSlots = timeSlots.getFirst().findElements(By.xpath(".//div[@class='rbc-time-slot slotDefault']"));

        //WebElement availableSlot = appointmentSlots.getFirst().findElement(RelativeLocator.with(By.xpath()))
        List<WebElement> eventsContainer = DriverManager.getInstance().Driver.findElements(By.xpath("//*[@id='chat-box']//div[@class='rbc-events-container']"));
        for (WebElement label: timeSlotLabels) {
            try {
                WebElement availableSlot = eventsContainer.getFirst().findElement(RelativeLocator.with(By.xpath("./div")).toRightOf(label));
            } catch (Exception e) {
                Browser.doubleClickOnElement(timeSlots.getFirst());
            }
        }
        */
    }
}