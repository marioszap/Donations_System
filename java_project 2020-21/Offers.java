import java.util.ArrayList;

public class Offers extends RequestDonationList{

    
    void commit(Organization o){
        for(RequestDonation r : rdEntities){
            if(!o.currentDonations.rdEntities.contains(r))
            o.currentDonations.rdEntities.add(r);
            rdEntities.clear();
        }
    }
}