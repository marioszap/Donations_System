public class NotEntitledToThisDonation extends Exception{
    public NotEntitledToThisDonation(){
        super("You are not intitled to this donation");
    }
    public NotEntitledToThisDonation(String message){
        super(message);
    }
}