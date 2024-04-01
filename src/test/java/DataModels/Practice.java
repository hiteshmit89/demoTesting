package DataModels;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Practice {
    ArrayList<PatientData> patientData;
    ArrayList<FormsData> formsData;

    @JsonProperty("practice_id")
    public int getPractice_id() {
        return this.practice_id; }
    public void setPractice_id(int practice_id) {
        this.practice_id = practice_id; }
    int practice_id;
    @JsonProperty("practice_name")
    public String getPractice_name() {
        return this.practice_name; }
    public void setPractice_name(String practice_name) {
        this.practice_name = practice_name; }
    String practice_name;
    @JsonProperty("address")
    public int getAddress() {
        return this.address; }
    public void setAddress(int address) {
        this.address = address; }
    int address;
    @JsonProperty("Users")
    public ArrayList<User> getUsers() {
        return this.users; }
    public void setUsers(ArrayList<User> users) {
        this.users = users; }
    ArrayList<User> users;
    @JsonProperty("FormsData")
    public ArrayList<FormsData> getFormsData() {
        return this.formsData; }

    public void setFormsData(ArrayList<FormsData> formsData) {
        this.formsData = formsData; }

    @JsonProperty("PatientData")
    public ArrayList<PatientData> getPatientData() {
        return this.patientData; }
    @JsonProperty("PatientData")
    public ArrayList<PatientData> setPatientData() {
        return this.patientData; }
}