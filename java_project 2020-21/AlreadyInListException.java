public class AlreadyInListException extends Exception{
    public AlreadyInListException(){
        super("Your choice is already in our list");
    }
    public AlreadyInListException(String message){
        super(message);
    }
}