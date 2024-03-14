package Framework.Constants;

public class Constants {
    public static enum PageTitle {
        LoginTitle("Log In"),
        HomeTitle("Practice by Numbers: Home"),
        CampaignsTitle("Practice by Numbers: communication");

        public final String label;

        PageTitle(String label) { this.label = label; }
    }
}
