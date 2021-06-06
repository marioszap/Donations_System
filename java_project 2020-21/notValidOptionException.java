public class notValidOptionException extends Exception{
    public notValidOptionException(){
        super("Your choice wasn't among valid options");
    }
    public notValidOptionException(String message){
        super(message);
    }
}