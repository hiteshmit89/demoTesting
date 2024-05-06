package StepDefinitions;

import Framework.Browser;
import Framework.Constants.Constants;
import Framework.Root.PbNUIApp;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PaymentsStepDefination {
    @When("The user is able to click on Payments tab")
    public void theUserIsAbleToClickOnPaymentsTab() {
        PbNUIApp.navigator().NavigateTo(Constants.Destination.Payments);
    }

    @Then("The user is able to click on widgets tab")
    public void theUserIsAbleToClickOnWidgetsTab() {
        PbNUIApp.paymentsPage().clickOnWidgets();
    }

    @When("The user is able to copy widget link and navigate to payment screen")
    public void theUserShouldBeAbleToCopyWidgetLink() {
       PbNUIApp.paymentsPage().createPaymentURLAndNavigate();
    }

    @Then("The user is able to enter amount in Payment box")
    public void theUserIsAbleToMakePayment() {
       PbNUIApp.OnlinePaymentPortalPage().fillPaymentPortalDetails();
       PbNUIApp.OnlinePaymentPortalPage().clickOnContinueButton();
       PbNUIApp.OnlinePaymentPortalPage().enterPaymentAmount();
    }

    @And("The  user is able to click on Pay full amount button and redirect to checkout screen")
    public void theUserIsAbleToClickOnButtonAndRedirectToCheckoutScreen() {
        PbNUIApp.OnlinePaymentPortalPage().clickOnPayFullAmount();
    }

    @And("The user is able to complete the payment")
    public void theUserIsAbleToCompleteThePayment() {
        PbNUIApp.OnlinePaymentPortalPage().enterCardNumber("5454 5454 5454 5454");

    }
}

