package design_patterns.strukturalne.adapter.external_payment;

public class PaymentAdapter implements PaymentInterface{
    private final PaymentService euro_payment_service;

    public PaymentAdapter(PaymentService euroPaymentService) {
        euro_payment_service = euroPaymentService;
    }

    //conversion methods
    private double eur_to_pln(long euro){
        return euro*4.0;
    }

    private long pln_to_eur(double pln){
        return (long)(pln/4.0);
    }

    @Override
    public double performPlnPayment(double pln_balance, double pln_amount) {
        long eur_balance = this.pln_to_eur(pln_balance);
        long eur_amount = this.pln_to_eur(pln_amount);
        long result = euro_payment_service.performEuroPayment(eur_balance,eur_amount);
        return this.eur_to_pln(result);
    }
}
