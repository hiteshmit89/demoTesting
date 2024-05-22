package StepDefinitions.Payments.Adyen.Payment;

import Framework.Browser;
import Pages.Modals.PBNModals;
import Pages.Navigator;
import io.cucumber.java.en.And;

public class PaymentCTAStepDefinition {

    @And("I click on the Floating Payment CTA")
    public void i_click_on_the_floating_payment_cta() {
       PBNModals.collectPaymentModal().clickOnFloatingPaymentButton();
    }

    @And("I enter the Patient Name")
    public void i_enter_the_patient_name() {
        PBNModals.collectPaymentModal().enterPatientName();
    }

    @And("I enter the Amount")
    public void i_enter_the_amount() {
        PBNModals.collectPaymentModal().enterAmount();
    }

    @And("I select payment method")
    public void i_select_payment_method() {
        PBNModals.collectPaymentModal().selectPaymentMethod();
    }

    @And("I enter the note")
    public void i_enter_the_note() {

    }
    @And("I click on the initiate payment")
    public void i_click_on_the_initiate_payment() {

    }
    @And("I I click on payments from header nav")
    public void i_i_click_on_payments_from_header_nav() {

    }
    @And("I Click on Payments from side nav")
    public void i_click_on_payments_from_side_nav() {

    }
    @And("I download the PDF of the last payment made")
    public void i_download_the_pdf_of_the_last_payment_made() {

    }
}
