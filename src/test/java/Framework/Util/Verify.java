package Framework.Util;

import org.assertj.core.api.SoftAssertions;

public class Verify {
    private static SoftAssertions softAssertions;

    private static SoftAssertions getSoftAssertions() {
        if (softAssertions == null) {
            softAssertions = new SoftAssertions();
        }
        return softAssertions;
    }

    public static void assertAll() {
        if (softAssertions != null) {
            softAssertions.assertAll();
            softAssertions = null;
        }
    }

    public static void verifyEquals(Object actual, Object expected, String message) {
        getSoftAssertions().assertThat(actual).as(message).isEqualTo(expected);
    }

    public static void verifyTrue(boolean condition, String message) {
        getSoftAssertions().assertThat(condition).as(message).isTrue();
    }

    public static void verifyFalse(boolean condition, String message) {
        getSoftAssertions().assertThat(condition).as(message).isFalse();
    }
}