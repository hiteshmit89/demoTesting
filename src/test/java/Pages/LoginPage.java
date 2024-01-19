package Pages;

import Framework.Browser;
import Framework.Constants.Constants.PageTitle;
import Framework.Util.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    public LoginPage(PageTitle PageTitle) {
        super(PageTitle);
    }

    private WebElement email = DriverManager.getInstance().Driver.findElement(By.id("id_username"));
    private WebElement password = DriverManager.getInstance().Driver.findElement(By.id("id_password"));
    private WebElement loginButton = DriverManager.getInstance().Driver.findElement(By.xpath("//button"));

    public void enterEmail(String emailID) {
        Browser.enterTextInEditBox(email, emailID);
    }

    public void enterPassword(String passcode) {
        Browser.enterTextInEditBox(password, passcode);
    }

    public void clickOnLoginButton() {
        Browser.clickOnElement(loginButton);
    }
}
