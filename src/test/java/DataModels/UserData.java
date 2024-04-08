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
}