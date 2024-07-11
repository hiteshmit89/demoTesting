
package StepDefinitions;
import Framework.Root.PbNUIApp;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static Framework.Constants.Constants.Destination.*;

public class FormsPreviewStepDefinition {
    @When("I click on the forms")
    public void iClickOnTheForms() {
        PbNUIApp.navigator().NavigateTo(Forms);
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

    @And("I will click on the pending forms on the left hand side")
    public void iWillClickOnThePendingFormsOnTheLeftHandSide() { PbNUIApp.formsPage().clickPendingFormsOnTheLeftHandSide();

    }

    @Then("I will search for a patient")
    public void iWillSearchForAPatient() {
        PbNUIApp.formsPage().pendingFormsSearchPatient();
    }

    @And("I will click on the custom filter")
    public void iWillClickOnTheCustomFilter() { PbNUIApp.formsPage().clickCustomDropDown();
    }

    @And("I click on the forms dropdown")
    public void iClickOnTheFormsDropdown() {
        PbNUIApp.formsPage().clickFormsDropdown();
    }

    @Then("I select option select all from dropdown")
    public void iSelectOptionSelectAllFromDropdown() {
        PbNUIApp.formsPage().formsFilterSelectAll();
    }

    @And("I click on the send reminder bell icon")
    public void iClickOnTheSendReminderBellIcon() { PbNUIApp.formsPage().clickOnBellIcon();
    }

    @Then("I click on yes button")
    public void iClickOnYesButton() { PbNUIApp.formsPage().confirmationYesButton();
    }
}
