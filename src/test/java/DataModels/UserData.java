package DataModels;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class UserData {
    @JsonProperty("Practices")
    public ArrayList<Practice> getPractices() {
        return this.practices; }
    public void setPractices(ArrayList<Practice> practices) {
        this.practices = practices; }
    ArrayList<Practice> practices;


    //region ####################Do not delete below code when updating models####################
    public Practice getPractice(int practiceId) {
        Practice practice = null;
        for (Practice p : getPractices()) {
            if (p.practice_id == practiceId) {
                practice = p;
                break;
            }
        }
        return practice;
    }

    public String getPracticeName(int practiceId) {
        return getPractice(practiceId).getPractice_name();
    }

    public User getUser(int practiceId, int userId) {
        User user = null;
        for (User u : getPractice(practiceId).getUsers()) {
            if (u.getUser_id() == userId) {
                user = u;
                break;
            }
        }
        return user;
    }

    public String getUserEmail(int practiceId, int userId) {
        return getUser(practiceId, userId).getEmail();
    }

    public String getPassword(int practiceId, int userId) {
        return getUser(practiceId, userId).getPassword();
    }

    public PatientData getPatientData(int practiceId, int patientId) {
        PatientData patientData = null;
        for (PatientData pd : getPractice(practiceId).getPatientData()) {
            if (pd.getPatient_id() == patientId) {
                patientData = pd;
                break;
            }
        }
        return patientData;
    }

    public String getPatientName(int practiceId, int patientId) {
        return getPatientData(practiceId, patientId).getPatient_name();
    }

    public String getTaskType(int practiceId, int patientId) {
        return getPatientData(practiceId, patientId).getTask_type();
    }

    public String getTaskDescription(int practiceId, int patientId) {
        return getPatientData(practiceId, patientId).getTask_description();
    }

    public FormsData getFormsData(int practiceId, String formsDataId) {
        FormsData formsData = null;
        for (FormsData fd : getPractice(practiceId).getFormsData()) {
            if (fd.getFormType().equals(formsDataId)) {
                formsData = fd;
                break;
            }
        }
        return formsData;
    }

    public String getFirstName(int practiceId, String formsDataId) {
        return getFormsData(practiceId, formsDataId).getFirst_name();
    }

    public String getLastName(int practiceId, String formsDataId) {
        return getFormsData(practiceId, formsDataId).getLast_name();
    }

    public String getPhoneNumber(int practiceId, String formsDataId) {
        return getFormsData(practiceId, formsDataId).getPhone_number();
    }

    public String getEmailId(int practiceId, String formsDataId) {
        return getFormsData(practiceId, formsDataId).getEmail_id();
    }

    public String getBirthDate(int practiceId, String formsDataId) {
        return getFormsData(practiceId, formsDataId).getBirth_date();
    }
    //endregion

    public CardData getCardData(int practiceId, String cardDataId) {
        CardData cardData = null;
        for (CardData cd : getPractice(practiceId).getCardData()) {
            if (cd.getCard_Id().equals(cardDataId)) {
                cardData = cd;
                break;
            }
        }
        return cardData;
    }

    public String getCardNumber(int practiceId, String CardDataId) {
        return getCardData(practiceId, CardDataId).getCard_number_Adyen();
    }
    public String getCardNumberStripe(int practiceId, String CardDataId) {
        return getCardData(practiceId, CardDataId).getCard_number_Stripe();
    }
    public String setCardNumberStripe(int practiceId, String CardDataId) {
        return getCardData(practiceId, CardDataId).getCard_number_Stripe();

    }
    public String getCardMonth(int practiceId, String CardDataId) {
        return getCardData(practiceId, CardDataId).getMonth_date();
    }
    public String getCardCVC(int practiceId, String CardDataId) {
        return getCardData(practiceId, CardDataId).getCvc();
    }

    public String getCountry(int practiceId, String CardDataId) {
        return getCardData(practiceId, CardDataId).getCountry();
    }
    public String getStreet(int practiceId, String CardDataId) {
        return getCardData(practiceId, CardDataId).getStreet();
    }
    public String getHouseNumber(int practiceId, String CardDataId) {
        return getCardData(practiceId, CardDataId).getHouseNumber();
    }
    public String getPostalCode(int practiceId, String CardDataId) {
        return getCardData(practiceId, CardDataId).getPostalCode();
    }
    public String getCity(int practiceId, String CardDataId) {
        return getCardData(practiceId, CardDataId).getCity();
    }


}
