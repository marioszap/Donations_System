public class Beneficiary extends User{
    int noPersons = 1;
    RequestDonationList receivedList = new RequestDonationList();
    Requests requestsList = new Requests();
    final boolean isBeneficiary=true;

    void clearHistoryOfdRequests(){
            requestsList.reset();
            System.out.println("Allyour requests have been deleted");
    }

    void removeRequest(RequestDonation r){        
        try{
            if(!requestsList.rdEntities.contains(r))
                throw new ItemNotInListException();
            requestsList.remove(r, org);
        }catch(ItemNotInListException e){
            System.out.println("The request you searched for is not in the list");
        }

    }

    void addRequest(RequestDonation r){
        requestsList.add(r, org);
    }

    void commit(){
        
    }
}