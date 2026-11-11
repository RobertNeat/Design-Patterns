package design_patterns.strukturalne.adapter.external_payment;

public class PaymentService {
    //subtracts the payment amount from overall balance and returns balance (all operations in euro currency)
    long performEuroPayment(long euro_balance,long euro_amount){
        return euro_balance-euro_amount;
    }
}
