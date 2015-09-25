package ac.za.cput.andre.service;

import ac.za.cput.andre.App;
import ac.za.cput.andre.domain.Race;
import ac.za.cput.andre.domain.Unit;
import ac.za.cput.andre.domain.Zerg;
import ac.za.cput.andre.factory.RaceSelector;
import ac.za.cput.andre.repository.TerranRepository;
import ac.za.cput.andre.repository.ZergRepository;
import ac.za.cput.andre.services.TerranService;
import ac.za.cput.andre.services.ZergService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/23.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class ZergServiceTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private ZergService service;

    private Long id;

    @Autowired
    private ZergRepository repository;

    @Test
    public void create() throws Exception {
        ArrayList<Unit> army = new ArrayList<>();
        RaceSelector race = new RaceSelector();

        Race zerg = race.getRace("Zerg");
        Unit unit1 = zerg.addUnit("Zergling");
        Unit unit2 = zerg.addUnit("Hydralisk");

        army.add(unit1);
        army.add(unit2);


        int popcap = 0;
        for(int i = 0;i<army.size();i++)
        {
            popcap = popcap + army.get(i).popcap();
        }
        zerg.setArmyName("Zerg");
        zerg.setArmyPop(popcap);
        repository.save((Zerg)zerg);
        id=zerg.getID();
        Assert.assertNotNull(zerg);
    }

    @Test
    public void testGetZerg() throws Exception {
        List<Zerg> army = service.getZerg();
        int size = army.size()-1;
        Assert.assertEquals(army.get(size).getArmyName(),"Zerg");

    }
}
