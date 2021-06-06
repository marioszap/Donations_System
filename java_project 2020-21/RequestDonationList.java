import java.util.ArrayList;

public class RequestDonationList{
    ArrayList<RequestDonation> rdEntities = new ArrayList<RequestDonation>();




RequestDonation get(int id){
    for (RequestDonation r : rdEntities){
        if(r.entity.id == id)
            return r;
        }
    System.out.println("The entity you searched does not seem to exist in our list");
    return null;
}




void add(RequestDonation r, Organization o){
    try{
    if(!o.entityList.contains(r))
    throw new ItemNotInListException();
    }catch(ItemNotInListException e){
        System.out.println("This entity does not exist in the organization's entiy list");
    }
    for(RequestDonation re : o.currentDonations.rdEntities){
        if (r.equals(re))
        re.quantity += r.quantity;
        else {
            o.currentDonations.rdEntities.add(r);
            System.out.println("This item is already in the list, so its quantity increases by one");
            return ;
        }
    }
}




void remove(RequestDonation r, Organization o){
    try{
        if(!o.currentDonations.rdEntities.contains(r))
        throw new ItemNotInListException();
        o.currentDonations.rdEntities.remove(r);
    }catch(ItemNotInListException e){
        System.out.println("The item you chose cannot be deleted because it is not in the list");
    }
}




void modify(int id, double newQuantity){
    try{
    for (RequestDonation r : rdEntities){
        if (r.entity.id == id)
            r.quantity = newQuantity;
        
        else throw new ItemNotInListException();
    }
    }catch(ItemNotInListException e){
        System.out.println("Sorry, item not in list");
    }
}




void monitor(){
    for (RequestDonation r : rdEntities){
        System.out.println("Name: "+r.entity.name+" quantity: "+r.quantity+"\n");
    } 
}



void reset(){
    rdEntities.clear();
}
}