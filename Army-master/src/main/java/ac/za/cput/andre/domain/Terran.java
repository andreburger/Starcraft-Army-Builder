package ac.za.cput.andre.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by student on 2015/04/26.
 */
@Entity
public class Terran implements Race,Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String armyName;
    int armyPop;
    @Column(length = 8000)
    private ArrayList<HashMap<String,String>> armyunits = new ArrayList();
    String user;

    public Terran()
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
    public ArrayList<HashMap<String,String>> getArmy()
    {
        return armyunits;
    }
    public Unit addUnit(String name)
    {
        HashMap<String,String> unit = new HashMap();
        if(name.equals("Marine"))
        {
            Marine marine = new Marine();
            unit.put("name", marine.name());
            unit.put("damage", String.valueOf(marine.damage()));
            unit.put("range", String.valueOf(marine.range()));
            unit.put("hp", String.valueOf(marine.hp()));
            unit.put("speed", String.valueOf(marine.speed()));
            unit.put("armor", String.valueOf(marine.armor()));
            unit.put("popcap", String.valueOf(marine.popcap()));
            unit.put("type", marine.type());
            unit.put("strongVS", marine.strongVS());
            unit.put("weakVS", marine.weakVS());

            armyunits.add(unit);
            return marine;
        }
        else  if(name.equals("Thor"))
        {
            Thor thor = new Thor();
            unit.put("name", thor.name());
            unit.put("damage", String.valueOf(thor.damage()));
            unit.put("range", String.valueOf(thor.range()));
            unit.put("hp", String.valueOf(thor.hp()));
            unit.put("speed", String.valueOf(thor.speed()));
            unit.put("armor", String.valueOf(thor.armor()));
            unit.put("popcap", String.valueOf(thor.popcap()));
            unit.put("type", thor.type());
            unit.put("strongVS", thor.strongVS());
            unit.put("weakVS", thor.weakVS());

            armyunits.add(unit);
            return thor;
        }
        else if(name.equals("Marauder"))
        {
            Marauder marauder = new Marauder();
            unit.put("name", marauder.name());
            unit.put("damage", String.valueOf(marauder.damage()));
            unit.put("range", String.valueOf(marauder.range()));
            unit.put("hp", String.valueOf(marauder.hp()));
            unit.put("speed", String.valueOf(marauder.speed()));
            unit.put("armor", String.valueOf(marauder.armor()));
            unit.put("popcap", String.valueOf(marauder.popcap()));
            unit.put("type", marauder.type());
            unit.put("strongVS", marauder.strongVS());
            unit.put("weakVS", marauder.weakVS());

            armyunits.add(unit);
            return marauder;
        }
        else if(name.equals("Viking"))
        {
            Viking viking = new Viking();
            unit.put("name", viking.name());
            unit.put("damage", String.valueOf(viking.damage()));
            unit.put("range", String.valueOf(viking.range()));
            unit.put("hp", String.valueOf(viking.hp()));
            unit.put("speed", String.valueOf(viking.speed()));
            unit.put("armor", String.valueOf(viking.armor()));
            unit.put("popcap", String.valueOf(viking.popcap()));
            unit.put("type", viking.type());
            unit.put("strongVS", viking.strongVS());
            unit.put("weakVS", viking.weakVS());

            armyunits.add(unit);
            return viking;
        }
        else
            return null;
    }

}
