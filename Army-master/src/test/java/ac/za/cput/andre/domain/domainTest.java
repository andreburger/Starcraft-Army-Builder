package ac.za.cput.andre.domain;

import ac.za.cput.andre.factory.RaceSelector;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by student on 2015/04/26.
 */
public class domainTest {
    @Before
    public void setUp() throws Exception {}

    @Test
    public void testCreateAmyTerran() throws Exception
    {
        ArrayList<HashMap<String,String>> army = new ArrayList<>();
        RaceSelector race = new RaceSelector();

        Race terran = race.getRace("Terran");
        Unit unit1 = terran.addUnit("Marine");
        Unit unit2 = terran.addUnit("Thor");

        army = terran.getArmy();

        Assert.assertEquals(army.get(0).get("name"),"Marine");
        Assert.assertEquals(army.get(1).get("name"),"Thor");
    }

    @Test
    public void testCreateAmyProtoss() throws Exception
    {
        ArrayList<HashMap<String,String>> army = new ArrayList<>();
        RaceSelector race = new RaceSelector();

        Race protoss = race.getRace("Protoss");
        Unit unit1 = protoss.addUnit("Zealot");
        Unit unit2 = protoss.addUnit("Colossus");

        army = protoss.getArmy();

        Assert.assertEquals(army.get(0).get("name"),"Zealot");
        Assert.assertEquals(army.get(1).get("name"),"Colossus");
    }

    @Test
    public void testCreateAmyZerg() throws Exception
    {
        ArrayList<HashMap<String,String>> army = new ArrayList<>();
        RaceSelector race = new RaceSelector();

        Race zerg = race.getRace("Zerg");
        Unit unit1 = zerg.addUnit("Zergling");
        Unit unit2 = zerg.addUnit("Hydralisk");

        army = zerg.getArmy();

        Assert.assertEquals(army.get(0).get("name"),"Zergling");
        Assert.assertEquals(army.get(1).get("name"),"Hydralisk");
    }

}
