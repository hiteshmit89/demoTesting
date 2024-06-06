package StepDefinitions.PatientPortal;
import Framework.Root.PbNUIApp;
import Pages.Modals.PBNModals;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static Framework.Root.PbNUIApp.patientPortalLoginPage;

public class PatientPortalLoginStepDefinition {


    @Given("I enter user credential")
    public void iEnterUserCredential() {
        patientPortalLoginPage().enterEmail(PbNUIApp.userdata().getUserEmail(2, 2));
        patientPortalLoginPage().enterPassword(PbNUIApp.userdata().getPassword(2, 2));}

    @Then("I am navigated to Dashboard")
    public void IAmNavigatedToDashboard() {
            PbNUIApp.patientPortalDashboardPage().verifyMyDashboardTextDisplayed();}

    @When("I click on SignIn Button")
    public void iClickOnSignInButton() {
        PbNUIApp.patientPortalLoginPage().clickOnSignInButton();
    }

    @And("I am able to select practices")
    public void iAmAbleToSelectPractices() {
        PbNUIApp.patientPortalSelectPracticePage().clickOnSelectPractice();
    }
}