package ac.za.cput.andre.factory;

import ac.za.cput.andre.domain.Protoss;
import ac.za.cput.andre.domain.Race;
import ac.za.cput.andre.domain.Terran;
import ac.za.cput.andre.domain.Zerg;

/**
 * Created by student on 2015/04/26.
 */
public class RaceSelector {

    public Race getRace(String race)
    {

        if(race.equals("Terran"))
        {
         return new Terran();
        }
        else
        {
            if(race.equals("Protoss"))
            {
                return new Protoss();
            }
            else
            {
                if(race.equals("Zerg"))
                {
                    return new Zerg();
                }
                else
                    return null;
            }
        }
    }
}
