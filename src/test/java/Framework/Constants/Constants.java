package Framework.Constants;

import Pages.SettingsPage;

public class Constants {
    public static enum PageTitle {
        LoginTitle("Log In"),
        HomeTitle("Practice by Numbers: Home"),
        CampaignsTitle("Practice by Numbers: communication"),

        SettingsTitle("Practice by Numbers: Settings");

        public final String label;

        PageTitle(String label) { this.label = label; }
    }
}
