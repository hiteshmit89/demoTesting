package Pages;

import Framework.Browser;
import static Framework.Constants.Constants.*;
import java.util.logging.Logger;
import org.assertj.core.api.SoftAssertions;

public class BasePage {
    private static  Logger logger =null;
    public SoftAssertions softAssertions=null;

    public BasePage(PageTitle title) {
        Browser.waitForPageReady();
        Browser.waitForPageTitle(title);
        softAssertions=softAssertions();
        logger=Logger();
    }

    public SoftAssertions softAssertions() {
        return  new SoftAssertions();
    }

    public Logger Logger() {
        return  Logger.getLogger(BasePage.class.getName());
    }
}
