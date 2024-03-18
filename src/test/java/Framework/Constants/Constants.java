package Framework.Constants;

public class Constants {
    public static enum PageTitle {
        LoginTitle("Log In"),
        HomeTitle("Practice by Numbers: Home"),
        AppointmentsTitle("Practice by Numbers: Appointment Booking"),
        AppointmentBookingTitle("Appointment Booking"),
        CampaignsTitle("Practice by Numbers: communication");

        public final String label;

        PageTitle(String label) { this.label = label; }
    }

    public static enum Destination {
        PracticeIQ("Practice IQ"),
        ReveneueIQ("Revenue IQ"),
        Tasks("Tasks "),
        PhoneIQ("Phone IQ"),
        MarketingIQ("Marketing IQ"),
        Insurance("Insurance"),
        Huddle("Huddle"),
        Reputation("Reputation"),
        Appointments("Appointments"),
        Forms("Forms"),
        Payments("Payments");
        public final String label;

        Destination(String label) {
            this.label = label;
        }
    }
}
