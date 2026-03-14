package designPattern;

  /*class Main {
    public static void main(String[] args){
        Charger charger = new ChargerAdaptor(new OldCharger());
        charger.chargePhone();
    }
}
 class ChargerAdaptor implements Charger{

    private OldCharger oldCharger;
     public ChargerAdaptor(OldCharger oldCharger){
         this.oldCharger = oldCharger;
     }
    public void chargePhone(){
        oldCharger.chargePhoneWithOldCharger();
    }
}*/
class AdapterCharger implements Charger{
    private OldCharger oldCharger;
    public AdapterCharger(){
        this.oldCharger = new OldCharger();
    }
    @Override
      public void chargePhone(){
        oldCharger.chargePhoneWithOldCharger();
    }
  }
class Main2{
    public static void main(String[] args){
        Charger charger = new AdapterCharger();
        charger.chargePhone();
    }
}

class OldCharger{
    public void chargePhoneWithOldCharger(){
        System.out.println("Charge Phone with old charger");
    }
}
interface Charger{
     void chargePhone();
}
