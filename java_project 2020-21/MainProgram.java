

public class MainProgram{
    public static void main(String[] args){
        
        //Users___________________________________________________________________
        Donator nikos = new Donator();
        nikos.name = "nikos";
        nikos.phone = "1234567890";
    
        Admin kostas = new Admin();
        kostas.name = "kostas";
        kostas.phone = "0987654321";

        Beneficiary nick = new Beneficiary();
        nick.name = "nick";
        nick.phone = "1111111111";

        Beneficiary adam = new Beneficiary();
        adam.name = "adam";
        adam.phone = "2222222222";

        //Materials________________________________________________________________
        Material milk = new Material(1.2, 1.7, 2.2);
        milk.name = "milk";
        milk.id = 1;
        milk.description = "goat milk";

        Material sugar = new Material(0.5, 1.0, 1.3);
        sugar.name = "suger";
        sugar.id = 2;
        sugar.description = "brown sugar";

        Material rice = new Material(2.3, 3.0, 4.2);
        rice.name = "uncleBen";
        rice.id = 3;
        rice.description = "carolina";

        //Services_________________________________________________________________
        Service MedicalSupport = new Service();
        MedicalSupport.name = "medicalSupport";
        MedicalSupport.id = 4;
        MedicalSupport.description = "Medicine and doctor";

        Service NurserySupport = new Service();
        NurserySupport.name = "NurserySupport";
        NurserySupport.id = 5;
        NurserySupport.description = "treating patients";

        Service BabySitting = new Service();
        BabySitting.name = "BabySitting";
        BabySitting.id = 6;
        BabySitting.description = "feeding, games and teaching";

        //Organization_____________________________________________________________
        Organization orgAE = new Organization();
        orgAE.name = "argAE";
        

        

    }
}