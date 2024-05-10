package DataModels;

import com.fasterxml.jackson.annotation.JsonProperty;
public class CardData {
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
    }


