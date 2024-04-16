package Pages.Modals;

import Framework.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PBNModals {
    public static AppointmentScheduleModal appointmentScheduleModal() {
        return new AppointmentScheduleModal();
    }

    public static CreateAppointmentModal createAppointmentModal() {
        return new CreateAppointmentModal();
    }

    public static PatientWindowModal patientWindowModal() {
        return new PatientWindowModal();
    }
    public static PatientOverviewModal patientOverviewModal() {
        return new PatientOverviewModal();
    }
}
