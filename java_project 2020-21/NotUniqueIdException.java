public class NotUniqueIdException extends Exception{
    public NotUniqueIdException(){
        super("The ID you entered is commited to another product");
    }
    public NotUniqueIdException(String message){
        super(message);
    }
}