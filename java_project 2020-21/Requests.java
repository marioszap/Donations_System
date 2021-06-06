import java.util.ArrayList;

public class Requests extends RequestDonationList{

    void add(RequestDonation r, Organization o, Beneficiary b){
        validRequestDonation(r, o, b);
        add(r, o);
    } 


    void modify(int id, double newQuantity, Organization o, Beneficiary b){
        Material m;            

            for(RequestDonation re : o.currentDonations.rdEntities){
                if(re.entity.id == id){
                    try{
                        if(newQuantity > re.quantity)
                        throw new NotEnoughQuantityException();
                        else if(re.entity.isMaterial){
                        m = (Material) re.entity;
                        try{
                        if(b.noPersons==1){
                        if(newQuantity>m.level1)
                        throw new NotEntitledToThisDonation();
                        }

                        else if(b.noPersons <= 4){
                            if(newQuantity > m.level2)
                            throw new NotEntitledToThisDonation();
                        }

                        else if(b.noPersons >= 5){
                            if(newQuantity > m.level3)
                            throw new NotEntitledToThisDonation();
                        }
                        
                    }catch(NotEntitledToThisDonation e){
                        System.out.println("The amount you are trying to benefit from is too much for your rights");
                    }
                }
                }catch(NotEnoughQuantityException e){
                            System.out.println("There is mot emough of this product in stock");
                            return;
                }
            }
        }
        modify(id, newQuantity);
    }

    void validRequestDonation(RequestDonation r, Organization o, Beneficiary b){

        Material m;            

            for(RequestDonation re : o.currentDonations.rdEntities){
                if(re.entity.id == r.entity.id){
                    try{
                    if(r.quantity > re.quantity)
                    throw new NotEnoughQuantityException();
                    else if(r.entity instanceof Material){
                        m = (Material) r.entity;

                    try{
                        if(b.noPersons==1){
                        if(r.quantity>m.level1)
                        throw new NotEntitledToThisDonation();
                        }

                        else if(b.noPersons <= 4){
                            if(r.quantity > m.level2)
                            throw new NotEntitledToThisDonation();
                        }

                        else if(b.noPersons >= 5){
                            if(r.quantity > m.level3)
                            throw new NotEntitledToThisDonation();
                        }
                    }catch(NotEntitledToThisDonation e){
                        System.out.println("The amount you are trying to benefit from is too much for your rights");
                    }

                    } 
                    }catch(NotEnoughQuantityException e){
                        System.out.println("There is mot emough of this product in stock");
                        return;
                    }
                }
            }
    }


    void commit(RequestDonation r, Organization o, Beneficiary b){
        
        validRequestDonation(r,o,b);
        for(RequestDonation re : o.currentDonations.rdEntities){
            if(r.entity.id == re.entity.id){
                r.quantity = r.quantity - re.quantity;
                o.currentDonations.rdEntities.remove(re);
                b.receivedList.rdEntities.add(re);
            }
        }
    }
}