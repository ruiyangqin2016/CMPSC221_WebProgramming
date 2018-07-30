package One_PaymentProblem;

public class CashPayment extends Payment {

    public CashPayment(Double amontPayment) {
        super(amontPayment);
    }

    @Override
    public String toString() {
        return "Cash Payment: {" +
                "amountPayment=" + amountPayment +
                '}';
    }

    @Override
    public void paymentDetails(){
        System.out.println(toString());
    }
}
