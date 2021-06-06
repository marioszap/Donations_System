import java.util.Scanner;

public class Donator extends User{

    Scanner scan = new Scanner (System.in);
    Offers offersList = new Offers();
    final boolean isDonator = true; 
    int input;
    int input1;
    String strInput;


    void donAdd(RequestDonation r){
        System.out.println("Please enter the id of the product you want: ");
        input = scan.nextInt();
        System.out.println("PLease type the name of this product: ");
        strInput = scan.nextLine();
        System.out.println("Now please enter the quantity you want: ");
        input1 = scan.nextInt();
        r.entity.name = strInput;
        r.entity.id = input;
        r.quantity = input1;
        try{
            for(RequestDonation re : offersList.rdEntities){
                if(re.entity.id == input)
                throw new NotUniqueIdException();
            }
            offersList.rdEntities.add(r);
        }catch(NotUniqueIdException e){
        System.out.println("This id already exists in your offersList");
        return;
        }
    }


    void donRemove(RequestDonation r){
        try{            
            if(!offersList.rdEntities.contains(r))
                throw new ItemNotInListException();            
        }catch(ItemNotInListException e){
            System.out.println("The item you are trying to remove doesn't exist in the list");
        }
        offersList.rdEntities.remove(r);
    }


    void donCommit(RequestDonation r){
        for(RequestDonation re : org.currentDonations.rdEntities){
            if(r.entity.equals(re.entity)){
                re.quantity += r.quantity;
                return;
            }
        }
        org.currentDonations.rdEntities.add(r);
        System.out.println("Offer committed successfully");
    }
  
}