package ac.za.cput.andre.domain;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by student on 2015/04/26.
 */
public interface Race{

    public Unit addUnit(String name);


    public void setID(long id);
    public void setArmyName(String nm);
    public void setArmyPop(int pop);
    public ArrayList<HashMap<String,String>>getArmy();
    public void setUser(String user);
    public String getUser();
    public String getArmyName();
    public long getID();
}
