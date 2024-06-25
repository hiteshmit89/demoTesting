package Framework.Constants;

import Pages.RevenueIQPage;
import Pages.SettingsPage;

public class Constants {
    public static enum PageTitle {
        LoginTitle("Log In"),
        HomeTitle("Practice by Numbers: Home"),
        AppointmentsTitle("Practice by Numbers: Appointment Booking"),
        AppointmentBookingTitle("Appointment Booking"),
        CampaignsTitle("Practice by Numbers: communication"),
        SettingsTitle("Practice by Numbers: Settings"),
        PaymentsTitle("Practice by Numbers: Payment"),
        FormsTitle("Practice by Numbers: online_forms"),
        OnlinePaymentPortalTitle("Payment Portal"),
        TasksTitle("Practice by Numbers: Tasks"),
        RevenueIQTitle("Practice by Numbers: RevenueOpportunities"),

        PatientPortalLoginPageTitle("Patient Portal: Login"),

        PatientPortalSelectPracticePageTitle("Patient Portal: Select Practice"),

        PatientPortalDashboardPageTitle("Patient Portal: Dashboard");



        public final String label;

        PageTitle(String label) {
            this.label = label;
        }
    }

    public static enum Destination {
        PracticeIQ("Practice IQ"),
        ReveneueIQ("Revenue IQ"),
        Tasks("Tasks"),
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

    public static enum userProfileOptions {
        UserProfile("User Profile"),
        Goals("Goals"),
        Campaigns("Campaigns"),
        GoalsReport("Goals Report"),
        Communications("Communications"),
        Notifications("Notifications"),
        Settings("Settings"),
        Support("Support"),
        Logout("Logout");

        public final String label;

        userProfileOptions(String label) {
            this.label = label;
        }
    }

    public static enum Sections {
        CommCenter("message-section"),
        Schedule("schedule-section"),
        Operations("hidden-xs operations-section"),
        Payments("payments-section"),
        TeamMessaging("team-message-section");

        public final String label;

        Sections(String label) {
            this.label = label;
        }
    }
}
