package ac.za.cput.andre.domain;

/**
 * Created by student on 2015/04/26.
 */
public class Zealot implements  Unit{

    public String name(){ return "Zealot"; }

    public double damage(){return 15.0; }

    public double range() {
        return 0.0;
    }

    public double hp(){
        return 200.00;
    }

    public double speed(){
        return 300.0;
    }

    public int armor(){
        return 0;
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
