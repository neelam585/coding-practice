package designPattern;

 class PaymentFactory {
    public static PaymentService getPaymentService(String type){
        if (type.equals("CARD")){
            return new CardPaymentService();
        } else if (type.equals("UPI")) {
            return new UpiPaymentService();
        } else if (type.equals("WALET")) {
            return new WaletPaymentService();
        }else {
            throw new  IllegalArgumentException("Invalid payment type");
        }
    }
}
 class Order{
    public static void placeOrder(String type){
        PaymentService paymentService = PaymentFactory.getPaymentService(type);
        paymentService.pay();
    }
     public static void main(String[] args) {
         placeOrder("WALET");
        /* placeOrder("UPI");
         placeOrder("WALLET");*/
     }
}
class WaletPaymentService implements PaymentService{
    @Override
    public void pay(){
        System.out.println("WaletPaymentService payment service");
    }
}
class UpiPaymentService implements PaymentService{
    @Override
    public void pay(){
        System.out.println("Upi payment service");
    }
}
class CardPaymentService implements PaymentService{
    @Override
    public void pay(){
        System.out.println("Card payment service");
    }
}
interface PaymentService{
    void pay();
}