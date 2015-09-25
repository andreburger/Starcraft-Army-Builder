package ac.za.cput.andre.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by student on 2015/04/26.
 */
@Entity
public class Zerg implements  Race,Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String armyName;
    int armyPop;
    @Column(length = 8000)
    private ArrayList<HashMap<String,String>> armyunits = new ArrayList();
    String user;

    public Zerg()
    {

    }

    public long getID()
    {
        return id;
    }
    public void setID(long id)
    {
        this.id = id;
    }
    public void setArmyName(String nm)
    {
        armyName = nm;
    }

    public void setArmyPop(int pop)
    {
        armyPop = pop;
    }

    public String getArmyName(){return armyName;}
    public void setUser(String user)
    {
        this.user = user;
    }

    public String getUser()
    {
        return user;
    }
    public  ArrayList<HashMap<String,String>> getArmy()
    {
        return armyunits;
    }

    public Unit addUnit(String name)
    {
        HashMap<String,String> unit = new HashMap();
        if(name.equals("Zergling"))
        {
            Zergling zergling = new Zergling();

            unit.put("name",zergling.name());
            unit.put("damage",String.valueOf(zergling.damage()));
            unit.put("range",String.valueOf(zergling.range()));
            unit.put("hp",String.valueOf(zergling.hp()));
            unit.put("speed",String.valueOf(zergling.speed()));
            unit.put("armor",String.valueOf(zergling.armor()));
            unit.put("popcap",String.valueOf(zergling.popcap()));
            unit.put("type",zergling.type());
            unit.put("strongVS",zergling.strongVS());
            unit.put("weakVS",zergling.weakVS());

            armyunits.add(unit);

            return zergling;
        }
        else if(name.equals("Hydralisk"))
        {
            Hydralisk hydralisk = new Hydralisk();

            unit.put("name",hydralisk.name());
            unit.put("damage",String.valueOf(hydralisk.damage()));
            unit.put("range",String.valueOf(hydralisk.range()));
            unit.put("hp",String.valueOf(hydralisk.hp()));
            unit.put("speed",String.valueOf(hydralisk.speed()));
            unit.put("armor",String.valueOf(hydralisk.armor()));
            unit.put("popcap",String.valueOf(hydralisk.popcap()));
            unit.put("type",hydralisk.type());
            unit.put("strongVS",hydralisk.strongVS());
            unit.put("weakVS",hydralisk.weakVS());

            armyunits.add(unit);

            return hydralisk;
        }
        else if(name.equals("Ultralisk"))
        {
            Ultralisk ultralisk = new Ultralisk();

            unit.put("name",ultralisk.name());
            unit.put("damage",String.valueOf(ultralisk.damage()));
            unit.put("range",String.valueOf(ultralisk.range()));
            unit.put("hp",String.valueOf(ultralisk.hp()));
            unit.put("speed",String.valueOf(ultralisk.speed()));
            unit.put("armor",String.valueOf(ultralisk.armor()));
            unit.put("popcap",String.valueOf(ultralisk.popcap()));
            unit.put("type",ultralisk.type());
            unit.put("strongVS",ultralisk.strongVS());
            unit.put("weakVS",ultralisk.weakVS());

            armyunits.add(unit);

            return ultralisk;
        }
        else if(name.equals("Mutalisk"))
        {
            Mutalisk mutalisk = new Mutalisk();

            unit.put("name",mutalisk.name());
            unit.put("damage",String.valueOf(mutalisk.damage()));
            unit.put("range",String.valueOf(mutalisk.range()));
            unit.put("hp",String.valueOf(mutalisk.hp()));
            unit.put("speed",String.valueOf(mutalisk.speed()));
            unit.put("armor",String.valueOf(mutalisk.armor()));
            unit.put("popcap",String.valueOf(mutalisk.popcap()));
            unit.put("type",mutalisk.type());
            unit.put("strongVS",mutalisk.strongVS());
            unit.put("weakVS",mutalisk.weakVS());

            armyunits.add(unit);

            return mutalisk;
        }
        else
            return null;
    }

}
