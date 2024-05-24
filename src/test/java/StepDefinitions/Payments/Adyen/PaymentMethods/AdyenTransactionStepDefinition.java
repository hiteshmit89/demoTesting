package StepDefinitions.Payments.Adyen.PaymentMethods;

import Framework.Root.PbNUIApp;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static Framework.Constants.Constants.Destination.Payments;

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
        PbNUIApp.paymentsPage().enterAmount();
        PbNUIApp.paymentsPage().enterCardDetailsOnPaymentModal();
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

    @And("Verify I am able to download Payment receipt")
    public void verifyIAmAbleToDownloadPaymentReceipt() {
        PbNUIApp.paymentsPage().verifyPaymentReceiptIsDownloaded();
    }
}
