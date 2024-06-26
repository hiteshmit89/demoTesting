package StepDefinitions.Payments.Adyen.Payment;

import Pages.Modals.PBNModals;
import io.cucumber.java.en.And;

public class PaymentCTAStepDefinition {

    @And("I click on the Floating Payment CTA")
    public void iClickOnTheFloatingPaymentCta() {
        PBNModals.collectPaymentModal().clickOnFloatingPaymentButton();
    }

    @And("I enter the Patient Name")
    public void iEnterThePatientName() {
        PBNModals.collectPaymentModal().enterPatientName();
    }

    @And("I enter the Amount")
    public void iEnterTheAmount() {
        PBNModals.collectPaymentModal().enterAmount();
    }

    @And("I select payment method and enter card details")
    public void iSelectPaymentMethodAndEnterCardDetails() {
        PBNModals.collectPaymentModal().selectPaymentMethodAsAddNewCard();
        PBNModals.collectPaymentModal().enterCardDetails();
    }

    @And("I enter the charge description")
    public void iEnterTheChargeDescription() {
        PBNModals.collectPaymentModal().enterChargeDescription();
    }

    @And("I Click on Charge button on collect payment modal")
    public void iClickOnChargeButtonOnCollectPaymentModal() {
        PBNModals.collectPaymentModal().clickOnChargeButton();
    }

    @And("I verify the payment successful modal")
    public void iVerifyThePaymentSuccessfulModal() {
        PBNModals.collectPaymentModal().verifyPaymentSuccess();
    }

    @And("I am Able to download the payment receipt")
    public void iAmAbleToDownloadThePaymentReceipt() {
        PBNModals.collectPaymentModal().downloadPaymentReciept();
    }

    @And("I select payment method and enter card details with incorrect cvc and verify incorrect cvv error message")
    public void iSelectPaymentMethodAndEnterCardDetailsWithIncorrectCvc() {
        PBNModals.collectPaymentModal().selectPaymentMethodAsAddNewCard();
        PBNModals.collectPaymentModal().enterAndValidateCardDetailsWithIncorrectCvc();
    }
}