public class Service extends Entity{
    final boolean isMaterial = false;
    String getDetails(){
        return "\ndetails: "+description+ "\n\nThis product is Service, not material";
    }
}