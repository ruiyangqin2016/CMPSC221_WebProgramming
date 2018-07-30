package One_PaymentProblem;

public class CreditCardPayment extends Payment {

    private String name;
    private String expirDate;
    private String cardNum;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExpirDate() {
        return expirDate;
    }

    public void setExpirDate(String expirDate) {
        this.expirDate = expirDate;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public CreditCardPayment(Double amontPayment, String name, String expirDate, String cardNum) {
        super(amontPayment);
        this.name = name;
        this.expirDate = expirDate;
        this.cardNum = cardNum;
    }

    @Override
    public String toString() {
        return "Credit Card Payment: {" +
                "name='" + name + '\'' +
                ", expirDate='" + expirDate + '\'' +
                ", cardNum='" + cardNum + '\'' +
                ", payment type='" + "Credit Card" + '\'' +
                ", amountPayment=" + amountPayment +
                '}';
    }

    @Override
    public void paymentDetails(){
        System.out.println(toString());
    }

}
