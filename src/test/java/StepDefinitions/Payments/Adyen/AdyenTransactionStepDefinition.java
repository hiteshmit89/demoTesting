package StepDefinitions.Payments.Adyen;

import Framework.Root.PbNUIApp;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static Framework.Constants.Constants.Destination.*;

public class AdyenTransactionStepDefinition {
    @When("I click on payments from header nav")
    public void iClickOnPaymentsFromHeaderNav() {
        PbNUIApp.navigator().NavigateTo(Payments);
    }
    @And("I Click on Payment method from side nav")
    public void iClickOnPaymentMethodFromSideNav(){
    PbNUIApp.paymentsPage().clickPaymentsMethodsTab();
    }
    @And("I click on any card from payments table to charge patient")
    public void iClickOnAnyCardFromPaymentsTableToChargePatient() {
        PbNUIApp.paymentsPage().clickCardIcon();
    }
    @And("Select the payment method, enter amount, description from charge customer modal")
    public void selectThePaymentMethodEnterAmountDescriptionFromChargeCustomerModal() {
        PbNUIApp.paymentsPage().selectDropdownValue();
        PbNUIApp.paymentsPage().enterAmount();
        PbNUIApp.paymentsPage().enterChargeDescription();
    }
    @Then("I Click on Charge button")
    public void iClickOnChargeButton() {
        PbNUIApp.paymentsPage().clickChargeButtonOnModal();
    }

    @And("Verify Successful toast message")
    public void verifySuccessfulToastMessage() {
        PbNUIApp.paymentsPage().verifyChargeConfirmationText();
    }
}
