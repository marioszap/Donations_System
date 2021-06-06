
public class NotValidRequestDonation extends Exception{
    public NotValidRequestDonation(){
        super("You are not intitled to getting this quantity of this item given your noOfPeople");
    }
    public NotValidRequestDonation(String message){
        super(message);
    }
}