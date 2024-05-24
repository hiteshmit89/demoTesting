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

    @And("I select payment method")
    public void iSelectPaymentMethod() {
        PBNModals.collectPaymentModal().selectPaymentMethod();
        PBNModals.collectPaymentModal().enterChargeDescription();
    }

    /*@And("I click on the initiate payment")
    public void iClickOnTheInitiatePayment() {
        PBNModals.collectPaymentModal().selectPaymentMethod();
    }*/
}
