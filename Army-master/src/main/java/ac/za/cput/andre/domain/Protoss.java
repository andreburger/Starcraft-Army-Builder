package ac.za.cput.andre.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by student on 2015/04/26.
 */
@Entity
public class Protoss implements Race,Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String armyName;
    int armyPop;
    @Column(length = 8000)
    private ArrayList<HashMap<String,String>> armyunits = new ArrayList();
    String user;

    public Protoss()
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
    public String getArmyName()
    {
        return armyName;
    }

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
        if(name.equals("Zealot"))
        {
            Zealot zealot = new Zealot();

            unit.put("name",zealot.name());
            unit.put("damage",String.valueOf(zealot.damage()));
            unit.put("range",String.valueOf(zealot.range()));
            unit.put("hp",String.valueOf(zealot.hp()));
            unit.put("speed",String.valueOf(zealot.speed()));
            unit.put("armor",String.valueOf(zealot.armor()));
            unit.put("popcap",String.valueOf(zealot.popcap()));
            unit.put("type",zealot.type());
            unit.put("strongVS",zealot.strongVS());
            unit.put("weakVS",zealot.weakVS());

            armyunits.add(unit);
            return zealot;
        }
        else  if(name.equals("Colossus"))
        {
            Colossus colossus = new Colossus();
            unit.put("name", colossus.name());
            unit.put("damage", String.valueOf(colossus.damage()));
            unit.put("range", String.valueOf(colossus.range()));
            unit.put("hp", String.valueOf(colossus.hp()));
            unit.put("speed", String.valueOf(colossus.speed()));
            unit.put("armor", String.valueOf(colossus.armor()));
            unit.put("popcap", String.valueOf(colossus.popcap()));
            unit.put("type", colossus.type());
            unit.put("strongVS", colossus.strongVS());
            unit.put("weakVS", colossus.weakVS());

            armyunits.add(unit);
            return colossus;
        }
        else if(name.equals("Stalker"))
        {
            Stalker stalker = new Stalker();
            unit.put("name", stalker.name());
            unit.put("damage", String.valueOf(stalker.damage()));
            unit.put("range", String.valueOf(stalker.range()));
            unit.put("hp", String.valueOf(stalker.hp()));
            unit.put("speed", String.valueOf(stalker.speed()));
            unit.put("armor", String.valueOf(stalker.armor()));
            unit.put("popcap", String.valueOf(stalker.popcap()));
            unit.put("type", stalker.type());
            unit.put("strongVS", stalker.strongVS());
            unit.put("weakVS", stalker.weakVS());

            armyunits.add(unit);
            return stalker;
        }
        else if(name.equals("Immortal"))
        {
            Immortal immortal = new Immortal();
            unit.put("name", immortal.name());
            unit.put("damage", String.valueOf(immortal.damage()));
            unit.put("range", String.valueOf(immortal.range()));
            unit.put("hp", String.valueOf(immortal.hp()));
            unit.put("speed", String.valueOf(immortal.speed()));
            unit.put("armor", String.valueOf(immortal.armor()));
            unit.put("popcap", String.valueOf(immortal.popcap()));
            unit.put("type", immortal.type());
            unit.put("strongVS", immortal.strongVS());
            unit.put("weakVS", immortal.weakVS());

            armyunits.add(unit);
            return immortal;
        }
        else
            return null;

    }


}
