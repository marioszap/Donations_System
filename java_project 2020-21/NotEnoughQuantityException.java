public class NotEnoughQuantityException extends Exception{
    public NotEnoughQuantityException(){
        super("There is not enough og the product in stock");
    }
    public NotEnoughQuantityException(String message){
        super(message);
    }
}