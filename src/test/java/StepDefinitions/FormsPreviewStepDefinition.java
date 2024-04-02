
package StepDefinitions;
import Framework.Constants.Constants;
import Framework.Root.PbNUIApp;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class FormsPreviewStepDefinition {
    @When("I click on the forms")
    public void iClickOnTheForms() {
        PbNUIApp.navigator().NavigateTo(Constants.Destination.Forms);

    }

    @And("I click on Completed forms on left-hand side")
    public void iClickOnCompletedFormsOnLeftHandSide() {
        PbNUIApp.formsPage().clickCompletedForms();
    }

    @Then("I will see heading Completed forms")
    public void iWillSeeHeadingCompletedForms() {
        PbNUIApp.formsPage().verifyCompletedFormsHeadingIsVisible();
    }

    @And("I click on toggle next to Only show completed forms that have not synced")
    public void iClickOnToggleNextToOnlyShowCompletedFormsThatHaveNotSynced()  {
        PbNUIApp.formsPage().clickTextNextToCheckNotSyncedForms();
    }

    @Then("I Click on the preview icon")
    public void iClickOnThePreviewIcon() {
        PbNUIApp.formsPage().clickPreviewIcon();
    }
    @Then("I click on download icon")
    public void iClickOnDownloadIcon() {
        PbNUIApp.formsPage().clickDownloadIcon();
    }

    @Then("I am able to search patient on completed forms page")
    public void iAmAbleToSearchPatientOnCompletedFormsPage() {
        PbNUIApp.formsPage().searchPatient();
    }
    @Then("I click on Custom drop down on forms Page")
    public void iClickOnCustomDropDownOnFormsPage() {
        PbNUIApp.formsPage().clickCustomDropDown();
    }
}
