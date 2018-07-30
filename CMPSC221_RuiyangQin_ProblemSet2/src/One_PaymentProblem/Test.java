package One_PaymentProblem;

public class Test{
    public static void main(String[] args){
        CreditCardPayment a = new CreditCardPayment(10000.0,"Tom","10/09/2021","9367-2587-3516-4009");
        CreditCardPayment a1 = new CreditCardPayment(34.78,"Tony","08/20/2022","9476-7523-5989-0236");
        a.paymentDetails();
        a1.paymentDetails();

        CashPayment b = new CashPayment(100.0);
        b.paymentDetails();
    }

}
