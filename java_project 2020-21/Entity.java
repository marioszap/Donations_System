
public abstract class Entity{

    public String name;
    public String description;
    public int id;
    boolean isMaterial;

    
    public String toString(){
        String k = getEntityInfo()+getDetails();
        return k;
    }

    String getEntityInfo(){
        return "\nname: "+name+"\nid: "+String.valueOf(id);
    }

    String getDetails(){
        return "\ndetails: "+description;
    }
}