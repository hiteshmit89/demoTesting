package DataModels;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class PatientData {

    @JsonProperty("patient_id")
    public int getPatient_id() {
        return this.patient_id; }
    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id; }
    int patient_id;
    @JsonProperty("patient_name")
    public String getPatient_name() {
        return this.patient_name; }
    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name; }
    String patient_name;
    @JsonProperty("task_description")
    public String getTask_description() {
        return this.task_description; }
    public void setTask_description(String task_description) {
        this.task_description = task_description; }
    String task_description;
    @JsonProperty("task_type")
    public String getTask_type() {
        return this.task_type; }
    public void setTask_type(String task_type) {
        this.task_type = task_type; }
    String task_type;
}
