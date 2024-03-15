package Framework.Constants;

public class Constants {
    public static enum PageTitle {
        LoginTitle("Log In"),
        HomeTitle("Practice by Numbers: Home"),
        AppointmentsTitle("Practice by Numbers: Appointment Booking"),
        AppointmentBookingTitle("Appointment Booking");
        public final String label;

        PageTitle(String label) { this.label = label; }
    }
}
