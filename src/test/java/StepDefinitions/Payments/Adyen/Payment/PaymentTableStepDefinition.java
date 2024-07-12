package StepDefinitions.Payments.Adyen.Payment;

import Framework.Root.PbNUIApp;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class PaymentTableStepDefinition {

    @And("I Click on Payment from side nav")
    public void iClickOnPaymentFromSideNav() {
        PbNUIApp.paymentsPage().clickOnPaymentsInSideNav();
    }

    @Then("I able to see labels in the Payment table")
    public void iAbleToSeeLabelsInThePaymentTable() {
        PbNUIApp.paymentsPage().verifyPaymentTableLabel();
    }

    @Then("I able to see a refund icon with a Dollar sign")
    public void iAbleToSeeARefundIconWithADollarSign() {
        PbNUIApp.paymentsPage().displayedRefundDollarIcon();
    }
}