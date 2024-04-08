package DataModels;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FormsData {
    @JsonProperty("FormType")
    public String getFormType() {
        return this.formType; }
    public void setFormType(String formType) {
        this.formType = formType; }
    String formType;
    @JsonProperty("first_name")
    public String getFirst_name() {
        return this.first_name; }
    public void setFirst_name(String first_name) {
        this.first_name = first_name; }
    String first_name;
    @JsonProperty("last_name")
    public String getLast_name() {
        return this.last_name; }
    public void setLast_name(String last_name) {
        this.last_name = last_name; }
    String last_name;
    @JsonProperty("phone_number")
    public String getPhone_number() {
        return this.phone_number; }
    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number; }
    String phone_number;
    @JsonProperty("email_id")
    public String getEmail_id() {
        return this.email_id; }
    public void setEmail_id(String email_id) {
        this.email_id = email_id; }
    String email_id;
    @JsonProperty("birth_date")
    public String getBirth_date() {
        return this.birth_date; }
    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date; }
    String birth_date;
}