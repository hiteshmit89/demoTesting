package StepDefinitions;

import DataModels.UserData;
import Framework.Browser;
import Framework.Root.PbNUIApp;
import Framework.Util.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.HasDownloads;
import org.openqa.selenium.WebElement;

import java.sql.Driver;

public class CampaignsStepDefinition {
    @Given("I click on profile dropdown")
    public void iClickOnProfileDropdown(){
        HomeStepDefinition HD = new HomeStepDefinition();
        HD.iLoginToPbNApp();
        HD.iClickOnPracticeName();
        HD.iWillSeeActivityForPractice();
        DriverManager.getInstance().Driver.findElement(By.xpath("//li[@class='dropdown account-dropdown']/a/i[@class='fa fa-caret-down']")).click();


    }

    @When("I click on Campaigns")
    public void IClickOnCampaigns(){
        DriverManager.getInstance().Driver.findElement(By.xpath("//ul[@class='dropdown-menu']//i[@class='fa fa-list fa-fw']")).click();
    }

    @Then("I am redirected to the campaigns page")
    public void IamRedirectedToTheCampaignsPage(){
        WebElement CampaignsHeading = DriverManager.getInstance().Driver.findElement(By.xpath("//li[@class='active']/a"));
        Assert.assertTrue("Follow-up Campaigns", CampaignsHeading.isDisplayed());

    }


}
