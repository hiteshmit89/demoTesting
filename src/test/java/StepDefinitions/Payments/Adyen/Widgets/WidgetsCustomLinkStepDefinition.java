package StepDefinitions.Payments.Adyen.Widgets;

import Framework.Root.PbNUIApp;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import static Framework.Constants.Constants.Destination.Payments;

public class WidgetsCustomLinkStepDefinition {

    @When("I click on payments from header")
    public void iClickOnPaymentsFromHeader() {
        PbNUIApp.navigator().NavigateTo(Payments);
    }
    @And("I Click on Widgets from side nav")
    public void i_click_on_widgets_from_side_nav() {
        PbNUIApp.paymentsPage().clickWidgetsTab();
    }
    @And("I enter custom text to create link")
    public void i_enter_custom_text_to_create_link() {
        PbNUIApp.paymentsPage().createAndSaveCustomLink();
    }

    @And("I click on copy icon")
    public void i_click_on_copy_icon() {
        PbNUIApp.paymentsPage().createCustomURLAndNavigate();
    }

    @And("I am able to enter first name, Last name and Birthdate of the patient and click continue")
    public void i_am_able_to_enter_first_name_last_name_and_birthdate_of_the_patient_and_click_continue() {
        PbNUIApp.OnlinePaymentPortalPage().fillPaymentPortalDetails();
        PbNUIApp.OnlinePaymentPortalPage().clickOnContinueButton();
        PbNUIApp.OnlinePaymentPortalPage().enterPaymentAmount();
    }
    @And("i am able to enter payment amount, statement number and account number and click pay full amount button")
    public void i_am_able_to_enter_payment_amount_statement_number_and_account_number_and_click_pay_full_amount_button() {
        PbNUIApp.OnlinePaymentPortalPage().clickOnPayFullAmount();
    }
    @And("I am able to select card and able to enter card number, Expiry date and CVC code")
    public void i_am_able_to_select_card_and_able_to_enter_card_number_expiry_date_and_cvc_code() {
        PbNUIApp.OnlinePaymentPortalPage().enterCardDetails();
        PbNUIApp.OnlinePaymentPortalPage().enterBillingAddress();
    }
    @And("I am able to click on Pay now Button")
    public void i_am_able_to_click_on_pay_now_button() {
        PbNUIApp.OnlinePaymentPortalPage().clickPayNow();
    }

    @And("I am able to verify payment successfully message")
    public void i_am_able_to_verify_payment_successfully_message() {
        PbNUIApp.OnlinePaymentPortalPage().paymentSuccessfulLabel();
    }

}
