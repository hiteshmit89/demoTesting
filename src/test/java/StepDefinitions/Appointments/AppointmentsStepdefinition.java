package StepDefinitions.Appointments;

import Framework.Browser;
import Framework.Constants.Constants;
import Framework.Root.PbNUIApp;
import Framework.Util.ConfigManager;
import Pages.Modals.PBNModals;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static Framework.Constants.Constants.Sections.Schedule;

public class AppointmentsStepdefinition {
    @When("I click on appointments Setting tab and activate credit card settings")
    public void iClickOnAppointmentsSettingTabAndActivateCreditCardSettings() {
        PbNUIApp.navigator().NavigateTo(Constants.Destination.Appointments);
        PbNUIApp.appointmentsPage().clickOnAppointmentSettingTab();
        PbNUIApp.appointmentsPage().clickOnSetupCreditCard();
        PbNUIApp.appointmentsPage().clickOnEnableCreditCard();
        PbNUIApp.appointmentsPage().clickOnSaveButton();
        PbNUIApp.appointmentsPage().clickOnWidgets();
        PbNUIApp.appointmentsPage().createAppointmentURLAndNavigate();
    }

    @And("I click on appointment tab and try to book appointment")
    public void iClickOnAppointmentTabAndTryToBookAppointment() {
        PbNUIApp.appointmentBookingPage().verifySelectionAndClickOnPickLocation();
        PbNUIApp.appointmentBookingPage().clickOnSelectExistingPatient();
        PbNUIApp.appointmentBookingPage().clickOnEmergencyConsult();
        PbNUIApp.appointmentBookingPage().clickOnEarliest();
        PbNUIApp.appointmentBookingPage().fillAppointmentBookingForm();
        PbNUIApp.appointmentBookingPage().clickOnCheckBox();
        PbNUIApp.appointmentBookingPage().clickOnNextButton();
    }

    @Then("I will be able to see credit card page on appointment booking page.")
    public void iWillBeAbleToSeeCreditCardPageOnAppointmentBookingPage() {
        PbNUIApp.appointmentBookingPage().verifyCreditCardPage();
    }

    @When("I click on appointments Setting tab and activate insurance settings")
    public void iClickOnAppointmentsSettingTabAndActivateInsuranceSettingsAndTryToBookAppointment() {
        PbNUIApp.navigator().NavigateTo(Constants.Destination.Appointments);
        PbNUIApp.appointmentsPage().clickOnAppointmentSettingTab();
        PbNUIApp.appointmentsPage().clickOnWidgets();
        PbNUIApp.appointmentsPage().createAppointmentURLAndNavigate();
    }

    @And("I click on appointments tab and try to book appointment")
    public void iClickOnAppointmentsTabAndTryToBookAppointment() {
        PbNUIApp.appointmentBookingPage().verifySelectionAndClickOnPickLocation();
        PbNUIApp.appointmentBookingPage().clickOnSelectExistingPatient();
        PbNUIApp.appointmentBookingPage().clickOnEmergencyConsult();
        PbNUIApp.appointmentBookingPage().clickOnEarliest();
        PbNUIApp.appointmentBookingPage().fillAppointmentBookingForm();
        PbNUIApp.appointmentBookingPage().clickOnCheckBox();
        PbNUIApp.appointmentBookingPage().clickOnNextButton();
    }

    @Then("I will be able to see insurance page on appointment booking page.")
    public void iWillBeAbleToSeeInsurancePageOnAppointmentBookingPage() {
        PbNUIApp.appointmentBookingPage().verifyInsurancePage();
    }

    @When("I click on appointments tab and try to book appointments for inactive patient who has insurance")
    public void iClickOnAppointmentsTabAndTryToBookAppointmentsForInactivePatientWhoHasInsurance() {
        PbNUIApp.navigator().NavigateTo(Constants.Destination.Appointments);
        PbNUIApp.appointmentsPage().clickOnWidgets();
        PbNUIApp.appointmentsPage().createAppointmentURLAndNavigate();
        PbNUIApp.appointmentBookingPage().verifySelectionAndClickOnPickLocation();
        PbNUIApp.appointmentBookingPage().clickOnSelectExistingPatient();
        PbNUIApp.appointmentBookingPage().clickOnEmergencyConsult();
        PbNUIApp.appointmentBookingPage().clickOnEarliest();
        PbNUIApp.appointmentBookingPage().fillAppointmentBookingFormForInactivePatient();
        PbNUIApp.appointmentBookingPage().clickOnCheckBox();
        PbNUIApp.appointmentBookingPage().clickOnNextButton();
    }

    @When("I click on appointments tab and try to book appointments for patient who has Automation tag")
    public void iClickOnAppointmentsTabAndTryToBookAppointmentsForPatientWhoHasAutomationTag() {
        PbNUIApp.navigator().NavigateTo(Constants.Destination.Appointments);
        PbNUIApp.appointmentsPage().clickOnWidgets();
        PbNUIApp.appointmentsPage().createAppointmentURLAndNavigate();
        PbNUIApp.appointmentBookingPage().verifySelectionAndClickOnPickLocation();
        PbNUIApp.appointmentBookingPage().clickOnSelectExistingPatient();
        PbNUIApp.appointmentBookingPage().clickOnEmergencyConsult();
        PbNUIApp.appointmentBookingPage().clickOnEarliest();
        PbNUIApp.appointmentBookingPage().fillAppointmentBookingFormForPatientWithTags();
        PbNUIApp.appointmentBookingPage().clickOnCheckBox();
        PbNUIApp.appointmentBookingPage().clickOnNextButton();
    }

    @Then("I will not be able to book appointment with message")
    public void iWillNotBeAbleToBookAppointmentWithMessageUnableToBookAppointment() {
        PbNUIApp.appointmentBookingPage().verifyTextDisplayedMessage("Unable to book Appointment text is not displayed on appointment booking page");
    }

    @When("I click on schedule on floating chatbox")
    public void iClickOnScheduleOnFloatingChatbox() {
        PbNUIApp.navigator().ClickOnFloatingButton(Schedule);
        Browser.waitForPageReady();
        PBNModals.appointmentScheduleModal().doubleClickOnAppointmentScheduleCalendarFirstProvider();
    }


    @And("I click on create button")
    public void iClickOnCreateButton() {
        PBNModals.createAppointmentModal().clickOnCreateButton();
    }

    @And("I fill add new patient form")
    public void iFillAddNewPatientForm() {
        Browser.waitForPageReady();
        PBNModals.createAppointmentModal().clickOnAddNewPatient();
        PBNModals.createAppointmentModal().fillAppointmentBookingDetails();
        PBNModals.createAppointmentModal().selectProvider();
        PBNModals.createAppointmentModal().appointmentType();
    }

    @Then("I will see success toast notifications")
    public void iWillSeeSuccessToastNotifications() {
        PbNUIApp.appHomePage().verifyNotificationText("Successfully created the appointment");
    }

    @Given("I login to PbN app and select the practice")
    public void iLoginToPbNApp() {
        PbNUIApp.loginPage().enterEmail(PbNUIApp.userdata().getUserEmail(1,1));
        PbNUIApp.loginPage().enterPassword(PbNUIApp.userdata().getPassword(1,1));
        PbNUIApp.loginPage().clickOnLoginButton();
        PbNUIApp.appHomePage().clickOnPracticeInPracticeInfoTable(PbNUIApp.userdata().getPracticeName(1));
    }

    @Given("I login to PbN app with super user and select the practice")
    public void iLoginToPbNAppWithSuperUserAndSelectThePractice() {
        PbNUIApp.loginPage().enterEmail(PbNUIApp.userdata().getUserEmail(3,2));
        PbNUIApp.loginPage().enterPassword(PbNUIApp.userdata().getPassword(3,2));
        PbNUIApp.loginPage().clickOnLoginButton();
        PbNUIApp.appHomePage().clickOnPracticeInPracticeInfoTable(PbNUIApp.userdata().getPracticeName(3));
    }

    @Given("I login to PbN app with user id {int} and select the practice")
    public void iLoginToPbNAppWithUserIdAndSelectThePractice(int userID) {
        PbNUIApp.loginPage().enterEmail(PbNUIApp.userdata().getUserEmail(1, userID));
        PbNUIApp.loginPage().enterPassword(PbNUIApp.userdata().getPassword(1, userID));
        PbNUIApp.loginPage().clickOnLoginButton();
        PbNUIApp.appHomePage().clickOnPracticeInPracticeInfoTable(PbNUIApp.userdata().getPracticeName(1));
    }

    @When("I click on appointments tab and try to book appointments for new patient")
    public void iClickOnAppointmentsAndTryToBookAppointmentsForNewPatient() {
        PbNUIApp.navigator().NavigateTo(Constants.Destination.Appointments);
        PbNUIApp.appointmentsPage().clickOnWidgets();
        PbNUIApp.appointmentsPage().createAppointmentURLAndNavigate();
        PbNUIApp.appointmentBookingPage().verifySelectionAndClickOnPickLocation();
        PbNUIApp.appointmentBookingPage().clickOnSelectNewPatient();
        PbNUIApp.appointmentBookingPage().clickOnEmergencyConsult();
        PbNUIApp.appointmentBookingPage().clickOnEarliest();
        PbNUIApp.appointmentBookingPage().fillAppointmentBookingForm();
        PbNUIApp.appointmentBookingPage().clickOnCheckBox();
        PbNUIApp.appointmentBookingPage().clickOnNextButton();
        PbNUIApp.appointmentBookingPage().verifyCreditCardPage();
        PBNModals.collectPaymentModal().enterCardDetails();
        PbNUIApp.appointmentBookingPage().clickOnNextButton();
        PbNUIApp.appointmentBookingPage().clickOnIDoNotHaveInsurance();
        PbNUIApp.appointmentBookingPage().clickOnNextButton();
        PbNUIApp.appointmentBookingPage().clickOnUseCellPhone();
        PbNUIApp.appointmentBookingPage().enterOTP("1234");
    }

    @Then("I will be able to see successful message for appointment booking.")
    public void iWillBeAbleToSeeSuccessfulMessageForAppointmentBooking() {
        PbNUIApp.appointmentBookingPage().verifySuccessfulTextDisplayed();
    }

    @When("I click on appointments tab and try to book appointment and select DOB less than Eighteen years on insurance page")
    public void iClickOnAppointmentsTabAndTryToBookAppointmentAndSelectDOBLessThanEighteenYearsOnInsurancePage() {
        PbNUIApp.navigator().NavigateTo(Constants.Destination.Appointments);
        PbNUIApp.appointmentsPage().clickOnWidgets();
        PbNUIApp.appointmentsPage().createAppointmentURLAndNavigate();
        PbNUIApp.appointmentBookingPage().verifySelectionAndClickOnPickLocation();
        PbNUIApp.appointmentBookingPage().clickOnSelectNewPatient();
        PbNUIApp.appointmentBookingPage().clickOnEmergencyConsult();
        PbNUIApp.appointmentBookingPage().clickOnEarliest();
        PbNUIApp.appointmentBookingPage().fillAppointmentBookingFormForValidateInsuranceDob();
        PbNUIApp.appointmentBookingPage().clickOnCheckBox();
        PbNUIApp.appointmentBookingPage().clickOnNextButton();
        PbNUIApp.appointmentBookingPage().verifyCreditCardPage();
        PBNModals.collectPaymentModal().enterCardDetails();
        PbNUIApp.appointmentBookingPage().clickOnNextButton();
        PbNUIApp.appointmentBookingPage().enterBirthDateOnInsurancePage(PbNUIApp.userdata().getBirthDate(1,"4"));
    }

    @Then("I will not be able to proceed to the next page if the insurance holder age is not less than Eighteen years.")
    public void iWillNotBeAbleToProceedToTheNextPageIfTheInsuranceHolderAgeIsNotLessThanEighteenYears() {
        PbNUIApp.appointmentBookingPage().verifyDateErrorMessage();
    }

    @When("I click on appointments tab and try to book appointments and navigate to provider page")
    public void iClickOnAppointmentsTabAndTryToBookAppointmentsAndNavigateToProviderPage() {
        PbNUIApp.navigator().NavigateTo(Constants.Destination.Appointments);
        PbNUIApp.appointmentsPage().clickOnWidgets();
        PbNUIApp.appointmentsPage().createAppointmentURLAndNavigate();
        PbNUIApp.appointmentBookingPage().verifySelectionAndClickOnPickLocation();
        PbNUIApp.appointmentBookingPage().clickOnSelectNewPatient();
        PbNUIApp.appointmentBookingPage().clickOnEmergencyConsult();
        PbNUIApp.appointmentBookingPage().clickOnSeeMoreOptions();

    }

    @Then("I will be able to see refresh button on provider page during appointment booking")
    public void iWillBeAbleToSeeRefreshButtonOnProviderPageDuringAppointmentBooking() {
        PbNUIApp.appointmentBookingPage().clickOnRefreshButton();
    }

    @When("I click on appointments tab and try to book appointment and select DOB less than one year from current date on book myself page")
    public void iClickOnAppointmentsTabAndTryToBookAppointmentAndSelectDOBLessThanOneYearFromCurrentDateOnBookMyselfPage() {
        PbNUIApp.navigator().NavigateTo(Constants.Destination.Appointments);
        PbNUIApp.appointmentsPage().clickOnWidgets();
        PbNUIApp.appointmentsPage().createAppointmentURLAndNavigate();
        PbNUIApp.appointmentBookingPage().verifySelectionAndClickOnPickLocation();
        PbNUIApp.appointmentBookingPage().clickOnSelectNewPatient();
        PbNUIApp.appointmentBookingPage().clickOnEmergencyConsult();
        PbNUIApp.appointmentBookingPage().clickOnEarliest();
        PbNUIApp.appointmentBookingPage().fillAppointmentBookingFormForValidatePatientDob();
        PbNUIApp.appointmentBookingPage().clickOnCheckBox();
        PbNUIApp.appointmentBookingPage().clickOnNextButton();
    }

    @Then("I will see a pop up appears asking for the patient's confirmation to proceed to the next page if the age is less than one years.")
    public void iWillSeeAPopUpAppearsAskingForThePatientSConfirmationToProceedToTheNextPageIfTheAgeIsLessThanOneYears() {
        PbNUIApp.appointmentBookingPage().verifyDateConfirmationMessage();
    }

    @When("I click on appointments tab and try to book appointments for patient and enter invalid OTP")
    public void iClickOnAppointmentsTabAndTryToBookAppointmentsForPatientAndEnterInvalidOTP() {
        PbNUIApp.navigator().NavigateTo(Constants.Destination.Appointments);
        PbNUIApp.appointmentsPage().clickOnWidgets();
        PbNUIApp.appointmentsPage().createAppointmentURLAndNavigate();
        PbNUIApp.appointmentBookingPage().verifySelectionAndClickOnPickLocation();
        PbNUIApp.appointmentBookingPage().clickOnSelectExistingPatient();
        PbNUIApp.appointmentBookingPage().clickOnEmergencyConsult();
        PbNUIApp.appointmentBookingPage().clickOnEarliest();
        PbNUIApp.appointmentBookingPage().fillAppointmentBookingForm();
        PbNUIApp.appointmentBookingPage().clickOnCheckBox();
        PbNUIApp.appointmentBookingPage().clickOnNextButton();
        PbNUIApp.appointmentBookingPage().verifyCreditCardPage();
        PBNModals.collectPaymentModal().enterCardDetails();
        PbNUIApp.appointmentBookingPage().clickOnNextButton();
        PbNUIApp.appointmentBookingPage().clickOnIDoNotHaveInsurance();
        PbNUIApp.appointmentBookingPage().clickOnNextButton();
        PbNUIApp.appointmentBookingPage().clickOnUseCellPhone();
        PbNUIApp.appointmentBookingPage().enterOTP("1234");
        PbNUIApp.appointmentBookingPage().clickOnVerifyAndSchedule();
    }

    @Then("I will be able to see error message on entering invalid OTP")
    public void iWillBeAbleToSeeErrorMessageOnEnteringInvalidOTP() {
        PbNUIApp.appointmentBookingPage().verifyErrorTextDisplayed();
    }

    @When("I click on appointments tab and try to book appointments and navigate to list of Exam type for what Patient like to be seen for during appointment booking")
    public void iClickOnAppointmentsTabAndTryToBookAppointmentsAndNavigateToListOfExamTypeForWhatPatientLikeToBeSeenForDuringAppointmentBooking() {
        PbNUIApp.navigator().NavigateTo(Constants.Destination.Appointments);
        PbNUIApp.appointmentsPage().clickOnWidgets();
        PbNUIApp.appointmentsPage().createAppointmentURLAndNavigate();
        PbNUIApp.appointmentBookingPage().verifySelectionAndClickOnPickLocation();
        PbNUIApp.appointmentBookingPage().clickOnSelectNewPatient();
    }

    @Then("I will be able to see list of Exam type for what Patient like to be seen for")
    public void iWillBeAbleToSeeListOfExamTypeForWhatPatientLikeToBeSeenFor() {
        PbNUIApp.appointmentBookingPage().verifyListOfExamTypeForWhatPatientLikeToBeSeenFor();
    }

    @When("I click on appointments tab and try to book appointments and navigate to provider page to verify the blocked days and time")
    public void iClickOnAppointmentsTabAndTryToBookAppointmentsAndNavigateToProviderPageToVerifyTheBlockedDaysAndTime() {
        PbNUIApp.navigator().NavigateTo(Constants.Destination.Appointments);
        PbNUIApp.appointmentsPage().clickOnAppointmentSettingTab();
        PbNUIApp.appointmentsPage().clickOnProviderEditButton();
        PbNUIApp.appointmentsPage().verifyDayBlockOutDay();
        PbNUIApp.appointmentsPage().clickOnSubmitButton();
        PbNUIApp.appointmentsPage().clickOnSettingSaveButton();
        PbNUIApp.appointmentsPage().validateToastNotification();
        PbNUIApp.appointmentsPage().clickOnWidgets();
        PbNUIApp.appointmentsPage().createAppointmentURLAndNavigate();
        PbNUIApp.appointmentBookingPage().verifySelectionAndClickOnPickLocation();
        PbNUIApp.appointmentBookingPage().clickOnSelectExistingPatient();
        PbNUIApp.appointmentBookingPage().clickOnEmergencyConsult();
        PbNUIApp.appointmentBookingPage().clickOnSeeMoreOptions();
    }

    @Then("I will not be able to see the blocked days and time on provider page during appointment booking")
    public void iWillNotBeAbleToSeeTheBlockedDaysAndTimeOnProviderPageDuringAppointmentBooking() {
        PbNUIApp.appointmentBookingPage().verifyBlockedDayOnAppointmentAvailabilityPage();
    }

    @When("I click on appointments tab and try to book appointments and navigate to provider page to see appointment timing")
    public void iClickOnAppointmentsTabAndTryToBookAppointmentsAndNavigateToProviderPageToSeeAppointmentTiming() {
        PbNUIApp.navigator().NavigateTo(Constants.Destination.Appointments);
        PbNUIApp.appointmentsPage().clickOnWidgets();
        PbNUIApp.appointmentsPage().createAppointmentURLAndNavigate();
        PbNUIApp.appointmentBookingPage().verifySelectionAndClickOnPickLocation();
        PbNUIApp.appointmentBookingPage().clickOnSelectNewPatient();
        PbNUIApp.appointmentBookingPage().clickOnEmergencyConsult();
    }

    @Then("I will be able to see appointment timing for Earliest date and time on provider page during appointment booking")
    public void iWillBeAbleToSeeAppointmentTimingForEarliestDateAndTimeOnProviderPageDuringAppointmentBooking() {
        PbNUIApp.appointmentBookingPage().verifyEarliestOption();
        PbNUIApp.appointmentBookingPage().verifySeeMoreOptions();
    }

    @When("I click on appointments tab and try to book appointments and navigate to new patient and returning patient button on after location page during appointment booking")
    public void iClickOnAppointmentsTabAndTryToBookAppointmentsAndNavigateToNewPatientAndReturningPatientButtonOnAfterLocationPageDuringAppointmentBooking() {
        PbNUIApp.navigator().NavigateTo(Constants.Destination.Appointments);
        PbNUIApp.appointmentsPage().clickOnWidgets();
        PbNUIApp.appointmentsPage().createAppointmentURLAndNavigate();
        PbNUIApp.appointmentBookingPage().verifySelectionAndClickOnPickLocation();
    }

    @Then("I will be able to see new patient and returning patient button on after location page during appointment booking")
    public void iWillBeAbleToSeeNewPatientAndReturningPatientButtonOnAfterLocationPageDuringAppointmentBooking() {
        PbNUIApp.appointmentBookingPage().verifySelectExistingPatientButtonAndNewPatientButton();
    }
}
