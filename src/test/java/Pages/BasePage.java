package Pages;

import Framework.Browser;
import static Framework.Constants.Constants.*;
import java.util.logging.Logger;


public class BasePage {
    public static  final Logger logger = Logger.getLogger("PBN");

    public BasePage(PageTitle title) {
        Browser.waitForPageReady();
        Browser.waitForPageTitle(title);
    }
}