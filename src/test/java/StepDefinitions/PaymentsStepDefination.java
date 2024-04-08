package StepDefinitions;

import Framework.Browser;
import Framework.Constants.Constants;
import Framework.Root.PbNUIApp;
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

    @Then("The user is able to make payment")
    public void theUserIsAbleToMakePayment() {
       PbNUIApp.OnlinePaymentPortalPage().fillPaymentPortalDetails();
       PbNUIApp.OnlinePaymentPortalPage().enterFirstName("First Name");
//       PbNUIApp.OnlinePaymentPortalPage().enterLastName("Last Name");
//       PbNUIApp.OnlinePaymentPortalPage().enterBirthDate("01/01/2001");
       PbNUIApp.OnlinePaymentPortalPage().clickOnContinueButton();
       PbNUIApp.OnlinePaymentPortalPage().enterPaymentAmount("100");
    }
}

