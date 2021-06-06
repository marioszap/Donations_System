import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;


public class Menu2{
    ArrayList<Beneficiary> allBeneficiaries = new ArrayList<Beneficiary>();
    ArrayList<Admin> allAdmins = new ArrayList<Admin>();
    ArrayList<Donator> allDonators = new ArrayList<Donator>();
    

    void signIn(){                              
        System.out.println("Please enter your name: ");
        Scanner scan = new Scanner(System.in);
        String signInName = scan.nextLine();
        System.out.println("And now your phone: ");
        String signInPhone = scan.nextLine();
        boolean isDonator, isAdmin, isBeneficiary;

        for(Donator d : allDonators){
            if(signInName.equals(d.name) && signInPhone.equals(d.phone))
            donatorConnected(d);
        }
        

        for(Admin a : allAdmins){
            if(signInName.equals(a.name) && signInPhone.equals(a.phone))
            adminConnected(a);
        }

        for(Beneficiary b : allBeneficiaries){
            if(signInName.equals(b.name) && signInPhone.equals(b.phone))
            beneficiaryConnected(b);
        }

        System.out.println("Whould you like to sign up?(y/n)");
        try{
        char signUp = scan.next().charAt(0);
        if(signUp != 'y' && signUp != 'n')
            throw new notValidOptionException();
        else
            if(signUp == 'n')
            System.exit(0);

            else {
            signUp(signInName, signInPhone);
            }
        }catch(notValidOptionException e){
        System.out.println("Only options available are 'y' and 'n'");
        }
    }


    void signUp(String name, String phone){ 
        Beneficiary newBeneficiary = new Beneficiary();
        Donator newDonator = new Donator();              
        Scanner scan = new Scanner(System.in);              
        System.out.println("Please choose type of user(1: Donator, 2: Beneficiary): ");
        int userType = scan.nextInt();
            try{
            if(1 != userType && 2 != userType)
            throw new notValidOptionException();
            else if(1 == userType){                
                newBeneficiary.name = name;
                newBeneficiary.phone = phone;
                allBeneficiaries.add(newBeneficiary);
                beneficiaryConnected(newBeneficiary);
                }
            else if(2 == userType){               
                newDonator.name = name;
                newDonator.phone = phone;
                allDonators.add(newDonator);
                donatorConnected(newDonator);
                }
            
        }catch(notValidOptionException ex) {
            System.out.println("Only available options are '1','2' ");
        }
    }


    void donatorConnected(Donator d){
        int choice1;
        char choice;
        double choice2;
        int listSize = 1;
        Scanner scan = new Scanner(System.in);
        RequestDonation searchedReq = null;
        Entity entityToGet = null;


        System.out.println("Connected successully, hello donator "+d.name+"\n");
        System.out.println("Your organization is: "+d.org.name+"\n");
        System.out.println("What would you like to do?"+"\n");
        System.out.println("(1: Add Offer,\n2: Show Offers,\n3: Commit,\n4: Back,\n5: Logout,\n6: Exit)");


        try{
        choice1 = scan.nextInt();
        if(choice1<1 || choice1>6)
            throw new notValidOptionException();
        }catch(notValidOptionException e){
            System.out.println("Available options are: 1, 2, 3, 4, 5, 6");
            return;
        }


        if(choice1 == 6){
            System.exit(0);
        }



        else if(choice1 == 5){
            System.out.println("You have been disconnected successfully...\n\n");
            signIn();
        }


        else if(choice1 == 4){
            donatorConnected(d);
        }


        else if(choice1 == 1){
            System.out.println("Please choose between: 1. Materials, 2. Services, 3. Back:\n");
            try{
                choice1 = scan.nextInt();
                if(choice1 != 1 && choice1 != 2 && choice1 != 3)
                throw new notValidOptionException();
            }catch(notValidOptionException e){
                System.out.println("The only options availablw are '1', '2' and '3'");
                return;
            }
            System.out.println("From the entities below, you can choose one by typing its number:");
            if(choice1 ==  1){
                System.out.println("You chose materials\n\n");
                for(RequestDonation r : d.org.currentDonations.rdEntities){
                    if(r.entity.isMaterial && d.org.entityList.contains(r.entity)){
                        System.out.println(listSize+". name: "+r.entity.name+" ("+r.quantity+")\n");
                        listSize++;                      
                    }
                }
                try{
                    choice1 = scan.nextInt();
                    if(choice1 < 1 || choice1 > listSize)
                    throw new notValidOptionException();
                }catch(notValidOptionException e){
                    System.out.println("All available options are integers between 1 and "+listSize);
                    return;
                }
                for(RequestDonation r : d.org.currentDonations.rdEntities){
                    if(r.entity.isMaterial && d.org.entityList.contains(r.entity)){
                        if(choice1 == listSize){
                            entityToGet = r.entity;
                            r.entity.getEntityInfo();
                        }
                    }
                }


                        System.out.println("Would you like to donate this material? (y = yes, n = no)");
                        try{
                            choice = scan.next().charAt(0);
                            if(choice != 'y' && choice != 'n')
                            throw new notValidOptionException();
                        }catch(notValidOptionException e){
                            System.out.println("Tho only valid optioyns are 'y' and 'n'");
                            return;
                        }
                        if (choice == 'n')
                            donatorConnected(d);

                        else{
                            System.out.println("How much of this product would you like?");
                            try{
                            choice2 = scan.nextDouble();
                            }catch(InputMismatchException e){
                                System.out.println("Only mumbers are accepted");
                                return;
                            }
                            searchedReq.entity = entityToGet;
                            searchedReq.quantity = choice2;
                        d.org.currentDonations.add(searchedReq, d.org);   
                        }
            }                      
                    
                


            else if(choice1 == 2){
                System.out.println("You chose services\n\n");
                for(RequestDonation r : d.org.currentDonations.rdEntities){
                    if(!r.entity.isMaterial && d.org.entityList.contains(r.entity)){
                        System.out.println(listSize+". name: "+r.entity.name+" ("+r.quantity+")\n");
                        listSize++;
                    }
                }

                try{
                    choice1 = scan.nextInt();
                    if(choice1 < 1 || choice1 > listSize)
                    throw new notValidOptionException();
                }catch(notValidOptionException e){
                    System.out.println("All available options are integers between 1 and "+listSize);
                    return;
                }
                for(RequestDonation r : d.org.currentDonations.rdEntities){
                    if(!r.entity.isMaterial && d.org.entityList.contains(r.entity)){
                        if(choice1 == listSize){
                            entityToGet = r.entity;
                            r.entity.getEntityInfo();
                        }
                    }
                }


                    System.out.println("Would you like to donate this material? (y = yes, n = no)");
                    try{
                        choice = scan.next().charAt(0);
                        if(choice != 'y' && choice != 'n')
                        throw new notValidOptionException();
                    }catch(notValidOptionException e){
                        System.out.println("Tho only valid optioyns are 'y' and 'n'");
                        return;
                    }
                    if (choice == 'n')
                        donatorConnected(d);

                    else{
                        System.out.println("How many hours of this service would you like to donate?");
                        try{
                        choice2 = scan.nextDouble();
                        }catch(InputMismatchException e){
                            System.out.println("Only mumbers are accepted");
                            return;
                        }
                        searchedReq.entity = entityToGet;
                        searchedReq.quantity = choice2;
                    d.org.currentDonations.add(searchedReq, d.org);   
                }
            }  

            else
                donatorConnected(d);         
        } 
                   
        
        else if (choice1 == 2){
            if(d.offersList.rdEntities.isEmpty()){
                System.out.println("There are no offers here");
                return;
            }
            else {
                System.out.println("Choose one of these categories: 1. Material, 2. Service");
                try{
                choice2 = scan.nextInt();
                if(choice1>2 || choice1<1)
                throw new notValidOptionException();
                }catch(notValidOptionException e){
                    System.out.println("only available options are '1' and '2'");
                    return ;
                }
                if(choice1 == 1){
                System.out.println("What would you like to do now?(type the correspomdimg number):");
                System.out.println("1: Show List, 2: Clear all, 3:Commit");
                try{
                    choice1 = scan.nextInt();
                    if(choice1<1 || choice1>3)
                    throw new notValidOptionException();
                }catch(notValidOptionException e){
                    System.out.println("Your only options are 1, 2 or 3");
                    return ;
                }

                for(RequestDonation r : d.offersList.rdEntities){
                        if(r.entity.isMaterial){

                        }
                    }
                
                choice2 = scan.nextInt();
                }
            }
        }


        else if (choice1 == 3){
            d.offersList.commit(d.org);
            System.out.println("Your offer has been committed successfully!");
        }
    }




    void beneficiaryConnected(Beneficiary b){
        int choice1;
        Scanner scan = new Scanner(System.in);


        System.out.println("Beneficiary "+b.name+" connected successfully.");
        System.out.println("Belongs in organization: "+b.org+"\n");

        System.out.println("Please select one of these options: ");
        System.out.println("1. Add request, 2. Show Requests, 3. Commit, 4. Back, 5. Logout, 6. Exit");

        try{
            choice1 = scan.nextInt();
            if(choice1 > 6 || choice1 < 1)
            throw new notValidOptionException();
        }catch(notValidOptionException e){
            System.out.println("All the valid options are integers from 1 to 6");
            return;
        }


        if(choice1 == 6)
            System.exit(0);


        else if(choice1 == 5){
            System.out.println("You have been logged out successfully");
            signIn();
        }


        else if(choice1 == 4)
            beneficiaryConnected(b);
        

        else if(choice1 == 1){
            System.out.println("Please type the id of the product that corresponds to the offer you want(it should be in your requestList):");
            try{
                choice1 = scan.nextInt();
                for(RequestDonation r : b.requestsList.rdEntities){
                    if(choice1 == r.entity.id){
                        b.addRequest(r);
                        System.out.println("Request added successfully");
                        return;
                    }
                }
                throw new notValidOptionException();
                }catch(notValidOptionException e){
                    System.out.println("The id you chose does not seem to match a request in your list");
                    return;
                }
            }
        


        else if (choice1 == 3){
            b.commit();
            System.out.println("Your request has been committed successfully!");
        }
        

        else { //choice1 == 2
            //b.requestsList.rdEntities//<---------
        }


    }


    void adminConnected(Admin a){
        int intChoice;

        Scanner scan = new Scanner();
        
        System.out.println("Connected successully, hello admin "+a.name+"\n");
        System.out.println("Please select what you want to do: ");
        System.out.println("1. List Benediciaries, 2. List Donators, 3. back, 4. Logout, 5. Exit");
        try{
            intChoice = scan.nextInt();
            if(intChoice <1 || intChoice >5)
            throw new notValidOptionException();
        }catch(notValidOptionException e){
            System.our.println("Your only options are 1 through 5");
            return;
        }
        if(intChoice == 5)
            System.exit(0);


        else if(intChoice == 4){
            signIn();
        }


        else if(intChoice == 3){
            adminConnected(a);
        }


    }
}