package DataModels;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Practice {
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
    ArrayList<FormsData> formsData;
    @JsonProperty("role")
    public String getRole() {
        return this.role; }
    public void setRole(String role) {
        this.role = role; }
    String role;
    @JsonProperty("password")
    public String getPassword() {
        return this.password; }
    public void setPassword(String password) {
        this.password = password; }
    String password;
    @JsonProperty("user_name")
    public String getUser_name() {
        return this.user_name; }
    public void setUser_name(String user_name) {
        this.user_name = user_name; }
    String user_name;
    @JsonProperty("patient_name")
    public String getPatient_name() {
        return this.patient_name; }
    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name; }
    String patient_name;

    @JsonProperty("task_description")
    public String getTask_description () {
        return this.task_description;}
    public void setTask_description(String task_type){
        this.task_description = task_type; }

    String task_description;

    @JsonProperty("task_type")
    public String getTask_type () {
        return this.task_type;}
    public void setTask_type(String task_type){
        this.task_type = task_type; }

    String task_type;

}
