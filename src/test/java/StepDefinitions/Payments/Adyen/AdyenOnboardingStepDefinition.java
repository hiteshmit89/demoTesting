package StepDefinitions.Payments.Adyen;
import Framework.Root.PbNUIApp;
import Pages.HeaderNavigation;
import Pages.AppHomePage;
import Pages.SettingsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdyenOnboardingStepDefinition {

    @Given("The User is able to login")
    public void the_user_is_able_to_login() {
        PbNUIApp.loginPage().enterEmail("chris.lau@practicenumbers.com");
        PbNUIApp.loginPage().enterPassword("ppp###2025");
        PbNUIApp.loginPage().clickOnLoginButton();
    }

    @And("The user is able to select practice")
    public void theUserIsAbleToSelectPractice() {
        PbNUIApp.AppHomePage.clickOnPracticeInPracticeInfoTable("Romans, Burke and Wagner");

    }

    @And("The user in on HomePage")
    public void theUserInOnHomePage() {
        AppHomePage.verifyWelcomeTextDisplayed();
    }


    @When("The user is able to click on Profile icon")
    public void theUserIsAbleToClickOnProfileIcon() {
        HeaderNavigation.clickOnProfileIcon();
    }

    @Then("The user is able to click on settings")
    public void theUserIsAbleToClickOnSettings() {
        HeaderNavigation.clickSettingIcon();
    }

    @Then("The user is able to enable checkbox for adyen")
    public void theUserIsAbleToEnableCheckboxForAdyen() {
        SettingsPage.toggleButton();

    }
}

