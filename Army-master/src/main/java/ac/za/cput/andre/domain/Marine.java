package ac.za.cput.andre.domain;

/**
 * Created by student on 2015/04/26.
 */
public class Marine implements Unit{
    String nm = "Marine";
    double dmg = 8.0;
    double ran= 500.0;
    double heal = 150.0;
    double spe = 300.0;
    int arm = 0;
    int cap = 2;
    String typ = "Bio";
    String strong = "Bio";
    String weak = "Mech";

    public String name(){ return nm; }

    public double damage(){return dmg; }

    public double range() {
        return ran;
    }

    public double hp(){
        return heal;
    }

    public double speed(){
        return spe;
    }

    public int armor(){
        return arm;
    }

    public int popcap(){
        return cap;
    }

    public String type(){
        return typ;
    }

    public String strongVS(){
        return strong;
    }

    public String weakVS(){
        return weak;
    }


}
