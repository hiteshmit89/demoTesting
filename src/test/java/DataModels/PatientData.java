package DataModels;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PatientData {

    @JsonProperty("patient_name")
    public String getPatient_name() {
        return this.patient_name; }
    public void setPatient_name(String first_name) {
        this.patient_name = first_name; }
    String patient_name;
    @JsonProperty("task_description")

    public String getTask_description() {
        return this.task_description;
    }

    public void setTask_description(String task_type) {
        this.task_description = task_type;
    }

    String task_description;

    @JsonProperty("task_type")
    public String getTask_type() {
        return this.task_type;
    }

    public void setTask_type(String task_type) {
        this.task_type = task_type;
    }
    String task_type;
}