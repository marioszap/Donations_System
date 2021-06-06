import java.util.ArrayList;
import java.util.*;
import java.util.InputMismatchException;

public class Organization{
    String name;
    Admin admin = new Admin();
    RequestDonationList currentDonations = new RequestDonationList();
    ArrayList<Entity> entityList = new ArrayList<Entity>();
    ArrayList<Donator> donatorList = new ArrayList<Donator>();
    ArrayList<Beneficiary> beneficiaryList = new ArrayList<Beneficiary>();

    public void setAdmin(Admin a){
        Scanner scan = new Scanner(System.in);
        char choice;
        if(admin == null){
            System.out.println("Welcome to our organization new admin "+a.name);
            admin = a;
            a.org = this;
        }
        else{
            System.out.println("Do you want to delete our current admin: "+admin.name+"?");
            System.out.println("Please respond with one character: (y = yes/n = no)");
            try{
            choice = scan.next().charAt(0);
            if(choice != 'y' && choice != 'n')
            throw new notValidOptionException();
            }catch(notValidOptionException e){
                System.out.println("You can only type 'y' or 'no'");
                return;
            }
            if(choice == 'y'){
                admin.org = null;
                admin = a;
                a.org = this;
            }
            else return;
        }   
    }

    public Admin getAdmin(){      
        return admin;
    }

    public void addEntity(Entity e){
        
        try{ 
        if(entityList.contains(e))
        throw new AlreadyInListException();
        for(Entity en : entityList){
            if(!e.equals(en) && e.id == en.id)
            throw new NotUniqueIdException();
        }
        entityList.add(e);
            }
        catch(Exception ex) {         
            System.out.println("Please insert an entity that is not in the list and has unique id");    
            return;
        } 
    }

    void removeEntity(Entity e){
        try{
            if(entityList.contains(e))
            entityList.remove(e);
            else throw new ItemNotInListException();
        }
        catch(ItemNotInListException ex){
            System.out.println("Please try an entity that exists in our list\n");
            return;
        }
    }

    void insertDonator(Donator d){
        try{
            if(donatorList.contains(d))
                throw new AlreadyInListException();
            else {
                donatorList.add(d);
                d.org = this;
            }
            
        }catch(AlreadyInListException e){
            System.out.println("Please insert a user that is not already in the list:\n");
            System.out.println(donatorList+"\n");
            return;
        }
    }

    void removeDonator(Donator d){
        try{
            if(donatorList.contains(d)){
            donatorList.remove(d);
            d.org = null;
            }
            else throw new ItemNotInListException();                 
        }catch(ItemNotInListException e){
            System.out.println("Please insert a donator that is in our list\n");
            System.out.println(donatorList+"\n");
        }
    }

    void insertBeneficiary(Beneficiary b){
        try{
            if(beneficiaryList.contains(b))
            throw new AlreadyInListException();
            beneficiaryList.add(b);
            b.org = this;
        } catch(AlreadyInListException e){
            System.out.println("Please insert a beneficiary that is in our list\n");
        }
    }

    void removeBeneficiary(Beneficiary b){
        try{
            if(beneficiaryList.contains(b)){
            beneficiaryList.remove(b);
            b.org = null;
            }
            else throw new ItemNotInListException();
        }catch(ItemNotInListException e){
            System.out.println("Please remove a beneficiary that is already in our list \n");
        }
    }

    void listEntities(){
        System.out.println("Materials:\n");
        for(Entity e : entityList){
            if(e.isMaterial)
            System.out.println(e.getEntityInfo()+"\n");
        }
        System.out.println("Services: \n");
        for(Entity e : entityList){
            if(!e.isMaterial)
            System.out.println(e.getEntityInfo()+"\n");
        }
    }

    void listBeneficiaries(){
        System.out.println("Our Beneficiaries are: \n");
        for(Beneficiary b : beneficiaryList){
            System.out.println(b.name+" has received: \n");
            for(RequestDonation r : b.receivedList.rdEntities){
                System.out.println(r.entity.name+"\tof quantity\t"+r.quantity+"\n");
            }
        }
    }

    void listDonators(){
        System.out.println("Our donators are: \n");
        for(Donator d : donatorList){
            System.out.println(d.name+"\n");
        }
    }
}
