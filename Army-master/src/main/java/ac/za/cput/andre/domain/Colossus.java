package ac.za.cput.andre.domain;
/**
 * Created by student on 2015/04/26.
 */
public class Colossus implements Unit {

    public String name(){return "Colossus"; }

    public double damage(){
        return 30.0;
    }

    public double range() {
        return 500.0;
    }

    public double hp(){
        return 350.00;
    }

    public double speed(){
        return 300.0;
    }

    public int armor(){
        return 0;
    }

    public int popcap(){
        return 5;
    }

    public String type(){
        return "Mech";
    }

    public String strongVS(){
        return "Bio";
    }

    public String weakVS(){return "Mech"; }
}
