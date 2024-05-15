package DataModels;

import com.fasterxml.jackson.annotation.JsonProperty;
public class CardData {
    @JsonProperty("card_Id")
    public String getCard_Id() {
        return this.card_Id; }
    public void setCard_Id(String card_Id) {
        this.card_Id = card_Id; }
    String card_Id;
    @JsonProperty("card_number_Adyen")
    public String getCard_number_Adyen() {
        return this.card_number_Adyen; }
    public void setCard_number_Adyen(String card_number_Adyen) {
        this.card_number_Adyen = card_number_Adyen; }
    String card_number_Adyen;
    @JsonProperty("month_date")
    public String getMonth_date() {
        return this.month_date; }
    public void setMonth_date(String month_date) {
        this.month_date = month_date; }
    String month_date;
    @JsonProperty("cvc")
    public String getCvc() {
        return this.cvc; }
    public void setCvc(String cvc) {
        this.cvc = cvc; }
    String cvc;
    @JsonProperty("card_number_Stripe")
    public String getCard_number_Stripe() {
        return this.card_number_Stripe; }
    public void setCard_number_Stripe(String card_number_Stripe) {
        this.card_number_Stripe = card_number_Stripe; }
    String card_number_Stripe;
    @JsonProperty("country")
    public String getCountry() {
        return this.country; }
    public void setCountry(String country) {
        this.country = country; }
    String country;
    @JsonProperty("street")
    public String getStreet() {
        return this.street; }
    public void setStreet(String street) {
        this.street = street; }
    String street;
    @JsonProperty("houseNumber")
    public String getHouseNumber() {
        return this.houseNumber; }
    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber; }
    String houseNumber;
    @JsonProperty("postalCode")
    public String getPostalCode() {
        return this.postalCode; }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode; }
    String postalCode;
    @JsonProperty("city")
    public String getCity() {
        return this.city; }
    public void setCity(String city) {
        this.city = city; }
    String city;
    }


