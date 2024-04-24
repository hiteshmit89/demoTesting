package DataModels;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PatientData {

    @JsonProperty("patient_id")
    public int getPatient_id() {
        return this.patient_id;
    }

    int patient_id;

    @JsonProperty("patient_name")
    public String getPatient_name() {
        return this.patient_name;
    }

    String patient_name;

    @JsonProperty("task_description")

    public String getTask_description() {
        return this.task_description;
    }

    String task_description;

    @JsonProperty("task_type")
    public String getTask_type() {
        return this.task_type;
    }

    String task_type;
}
