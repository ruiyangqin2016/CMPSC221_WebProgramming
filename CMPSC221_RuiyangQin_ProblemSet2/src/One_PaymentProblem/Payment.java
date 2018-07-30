package One_PaymentProblem;

public class Payment {

    protected Double amountPayment;

    public Payment(Double amontPayment) {
        this.amountPayment = amontPayment;
    }

    public Double getAmountPayment() {

        return amountPayment;
    }

    public void setAmountPayment(Double amountPayment) {
        this.amountPayment = amountPayment;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "amountPayment=" + amountPayment +
                '}';
    }

    public void paymentDetails(){

    }
}
