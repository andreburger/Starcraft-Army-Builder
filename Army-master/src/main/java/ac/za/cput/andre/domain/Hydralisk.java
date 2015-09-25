package ac.za.cput.andre.domain;

/**
 * Created by student on 2015/04/26.
 */
public class Hydralisk implements  Unit{

    public String name(){ return "Hydralisk"; }

    public double damage(){return 10.0; }

    public double range() {
        return 500.0;
    }

    public double hp(){
        return 250.00;
    }

    public double speed(){
        return 300.0;
    }

    public int armor(){
        return 1;
    }

    public int popcap(){
        return 2;
    }

    public String type(){
        return "Bio";
    }

    public String strongVS(){
        return "Bio";
    }

    public String weakVS(){
        return "Mech";
    }
}
