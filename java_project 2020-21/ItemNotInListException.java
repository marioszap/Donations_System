public class ItemNotInListException extends Exception{
    public ItemNotInListException(){
        super("This entity does not exist in our entityList");
    }
    public ItemNotInListException(String message){
        super(message);
    }
}