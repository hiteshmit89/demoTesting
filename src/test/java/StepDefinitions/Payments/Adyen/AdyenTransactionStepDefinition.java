package StepDefinitions.Payments.Adyen;

import Framework.Root.PbNUIApp;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static Framework.Constants.Constants.Destination.*;

public class AdyenTransactionStepDefinition {

    @Given("The User is able to login into the webapp")
    public void theUserIsAbleToLoginIntoTheWebapp() {
        PbNUIApp.loginPage().enterEmail(PbNUIApp.userdata().getPractices().getFirst().getUsers().getFirst().getEmail());
        PbNUIApp.loginPage().enterPassword(PbNUIApp.userdata().getPractices().getFirst().getUsers().getFirst().getPassword());
        PbNUIApp.loginPage().clickOnLoginButton();
    }

    @And("The user is able to select practices")
    public void theUserIsAbleToSelectPractices() {
        PbNUIApp.appHomePage().clickOnPracticeInPracticeInfoTable(PbNUIApp.userdata().getPractices().getFirst().getPractice_name());
    }

    @When("User is able to click on payments from header nav")
    public void userIsAbleToClickOnPaymentsFromHeaderNav() {
        PbNUIApp.navigator().NavigateTo(Payments);
    }

    @And("Click on Payment method from side nav")
    public void clickOnPaymentMethodFromSideNav(){
    PbNUIApp.paymentsPage().clickPaymentsMethodsMenu();
    }

    @And("click on any card from payments table to charge patient")
    public void clickOnAnyCardFromPaymentsTableToChargePatient(){
        PbNUIApp.paymentsPage().clickCardIcon();
    }

    @And("Select the payment method, enter amount, description from charge customer modal")
    public void selectThePaymentMethodEnterAmountDescriptionFromChargeCustomerModal() {
        PbNUIApp.paymentsPage().selectDropdownValue();
        PbNUIApp.paymentsPage().enterAmount();
        PbNUIApp.paymentsPage().enterChargeDescription();


    }  @Then("Click on Charge button")
    public void clickOnChargeButton() {
        PbNUIApp.paymentsPage().btnClickCharge();
    }

    @And("Verify Successful toast message")
    public void verifySuccessfulToastMessage() {
        PbNUIApp.paymentsPage().verifyChargeConfirmationText();
    }
}
