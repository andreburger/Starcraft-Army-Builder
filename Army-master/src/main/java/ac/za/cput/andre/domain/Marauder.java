package ac.za.cput.andre.domain;

/**
 * Created by student on 2015/04/26.
 */
public class Marauder implements  Unit {

    public String name(){ return "Marauder"; }

    public double damage(){return 30.0; }

    public double range() {
        return 600.0;
    }

    public double hp(){
        return 150.00;
    }

    public double speed(){
        return 300.0;
    }

    public int armor(){
        return 3;
    }

    public int popcap(){
        return 2;
    }

    public String type(){
        return "Mech";
    }

    public String strongVS(){
        return "Mech";
    }

    public String weakVS(){
        return "";
    }
}