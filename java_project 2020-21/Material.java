final public class Material extends Entity{
    final double level1;
    final double level2;
    final double level3;
    final boolean isMaterial = true;
    
Material(double level1, double level2,double level3){
    this.level1 = level1;
    this.level2 = level2;
    this.level3 = level3;
    }

    String getDetails(){
        return "\ndetails: "+description+"\n\nLevel1: " +level1+"\nLevel2: " 
        +level2+"\nLevel3: " +level3 +"\n\nThis is a Material product";
    }
}