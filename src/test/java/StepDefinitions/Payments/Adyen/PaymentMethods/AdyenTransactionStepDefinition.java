package StepDefinitions.Payments.Adyen.PaymentMethods;

import Framework.Browser;
import Framework.Root.PbNUIApp;
import Framework.Util.DriverManager;
import Pages.Modals.PBNModals;
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
        PBNModals.collectPaymentModal().enterAmount();
        PBNModals.collectPaymentModal().selectPaymentMethodAsAddNewCard();
        PBNModals.collectPaymentModal().enterCardDetails();
        PBNModals.collectPaymentModal().clickOnChargeButton();
    }
    @Then("I Click on Charge button")
    public void iClickOnChargeButton() {
        PBNModals.collectPaymentModal().clickOnChargeButton();
    }

    @And("Verify Successful toast message")
    public void verifySuccessfulToastMessage() {
        PBNModals.collectPaymentModal().verifyPaymentSuccess();
    }

    @And("Verify I am able to download Payment receipt")
    public void verifyIAmAbleToDownloadPaymentReceipt() {
        PBNModals.collectPaymentModal().downloadPaymentReciept();
    }

    @And("I click on disable Payment Confirmation Modal")
    public void iClickOnDisablePaymentConfirmationModal() {
        PBNModals.collectPaymentModal().dismissPaymentConfirmationModal();
    }

    @And("I click on Payment menu")
    public void iClickOnPaymentMenu() {
        PbNUIApp.paymentsPage().clickPaymentsMenu();
    }

    @And("I click on sort icon to sort the transaction via date")
    public void iClickOnSortIconToSortTheTransactionViaDate() {
        PbNUIApp.paymentsPage().ClickOnSortIconForPaymentTableViaDate();
    }

    @And("I Verify the payment details in Payments Table")
    public void iVerifyThePaymentDetailsInPaymentsTable() {
        PbNUIApp.paymentsPage().paymentDetailsInPaymentTable();
    }


}
