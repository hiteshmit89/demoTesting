package Pages;

import Framework.Browser;

import java.util.logging.Logger;

import static Framework.Constants.Constants.PageTitle;


public class BasePage {

    public static final Logger logger = Logger.getLogger("PBN");

    public BasePage(PageTitle title) {
        Browser.waitForPageReady();
        Browser.waitForPageTitle(title);
    }
}
