package Framework.Constants;

public class Constants {
    public static enum PageTitle {
        LoginTitle("Log In"),
        HomeTitle("Practice by Numbers: Home"),
        SettingsTitle("Practice by Numbers: Settings");



        public final String label;

        PageTitle(String label) { this.label = label; }
    }
}
