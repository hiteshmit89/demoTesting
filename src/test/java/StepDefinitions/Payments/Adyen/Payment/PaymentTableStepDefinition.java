package StepDefinitions.Payments.Adyen.Payment;

import Framework.Root.PbNUIApp;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PaymentTableStepDefinition {

    @And("I Click on Payment from side nav")
    public void iClickOnPaymentFromSideNav() {
        PbNUIApp.paymentsPage().clickOnPaymentTabInSideNavigation();
    }

    @Then("I able to see labels in the Payment table")
    public void iAbleToSeeLabelsInThePaymentTable() {
        PbNUIApp.paymentsPage().verifyPaymentTableLabel();
    }

    @Then("I able to see a refund icon with a Dollar sign")
    public void iAbleToSeeARefundIconWithADollarSign() {
        PbNUIApp.paymentsPage().displayedRefundDollarIcon();
    }

    @And("I Click on Payment from side navigation")
    public void iClickOnPaymentFromSideNavigation() {
        PbNUIApp.paymentsPage().clickOnPaymentTabInSideNavigation();
    }
}