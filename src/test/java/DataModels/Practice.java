package DataModels;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Practice {
    @JsonProperty("practice_id")
    public int getPractice_id() {
        return this.practice_id; }
    public void setPractice_id(int practice_id) {
        this.practice_id = practice_id; }
    int practice_id;
    @JsonProperty("email")
    public String getEmail() {
        return this.email; }
    public void setEmail(String email) {
        this.email = email; }
    String email;
    @JsonProperty("user_id")
    public int getUser_id() {
        return this.user_id; }
    public void setUser_id(int user_id) {
        this.user_id = user_id; }
    int user_id;
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
}
