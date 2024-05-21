package Pages.PatientPortal;

import Framework.Browser;
import Framework.Constants.Constants;
import Framework.Util.DriverManager;
import Pages.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PatientPortalDashboardPage extends BasePage {

    public PatientPortalDashboardPage(Constants.PageTitle title) {
        super(title);
    }

    public void verifyMyDashboardTextDisplayed() {
        WebElement myDashboardText = DriverManager.getInstance().Driver.findElement(By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 page-heading-style css-9l3uo3']"));
        Assert.assertEquals("My Dashboard", true, myDashboardText.isDisplayed());
    }
}