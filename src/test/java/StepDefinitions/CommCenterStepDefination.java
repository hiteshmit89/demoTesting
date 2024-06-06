package StepDefinitions;

import Framework.Root.PbNUIApp;
import Pages.Modals.PBNModals;
import io.cucumber.java.en.And;

public class CommCenterStepDefination {
    @And("I click on the Floating Comms Center CTA")
    public void iClickOnTheFloatingCommsCenterCTA() {
        PBNModals.messageModal().clickOnFloatingCommCenterButton();;
    }

    @And("I Search the patient")
    public void iSearchThePatient() {PBNModals.messageModal().enterPatientNameInSearchBox();
    }

    @And("I click on three dots of patient Avatar")
    public void iClickOnThreeDotsOfPatientAvatar() {PBNModals.messageModal().clickOnPatientAvatarThreeDots();
    }

    @And("I click on Charge")
    public void iClickOnCharge() {PBNModals.messageModal().clickOnChargeOption();
    }

    @And("I click on Request payment")
    public void iClickOnRequestPayment() {PBNModals.messageModal().clickOnRequestOption();
    }

    @And("I am able to see {string} floating button")
    public void iAmAbleToSeeFloatingButton(String arg0) {PBNModals.messageModal().verifyPaymentFloatingButton();
    }
}

