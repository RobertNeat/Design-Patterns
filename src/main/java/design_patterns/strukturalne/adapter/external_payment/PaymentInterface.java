package design_patterns.strukturalne.adapter.external_payment;

public interface PaymentInterface {
    //PLN currency operation
    double performPlnPayment(double pln_bamance, double pln_amount);
}
