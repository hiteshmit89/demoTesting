package StepDefinitions;

import Framework.Root.PbNUIApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition {
    @Given("I enter user credentials")
    public void i_enter_user_credentials() {
        PbNUIApp.loginPage().enterEmail(PbNUIApp.userdata().getUserEmail(1,1));
        PbNUIApp.loginPage().enterPassword(PbNUIApp.userdata().getPassword(1,1));
    }
    @When("I click on login button")
    public void i_click_on_login_button() {
        PbNUIApp.loginPage().clickOnLoginButton();
    }

    @Then("I am navigated to home page")
    public void i_am_navigated_to_home_page() {
        PbNUIApp.appHomePage().verifyUserHeaderIsDisplayed();
    }
}
