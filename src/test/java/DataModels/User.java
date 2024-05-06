package DataModels;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    @JsonProperty("user_id")
    public int getUser_id() {
        return this.user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    int user_id;

    @JsonProperty("user_name")
    public String getUser_name() {
        return this.user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    String user_name;

    @JsonProperty("password")
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    String password;

    @JsonProperty("email")
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    String email;

    @JsonProperty("role")
    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    String role;
}