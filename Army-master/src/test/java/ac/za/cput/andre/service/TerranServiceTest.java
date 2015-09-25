package ac.za.cput.andre.service;

import ac.za.cput.andre.App;
import ac.za.cput.andre.domain.Race;
import ac.za.cput.andre.domain.Terran;
import ac.za.cput.andre.domain.Unit;
import ac.za.cput.andre.factory.RaceSelector;
import ac.za.cput.andre.repository.TerranRepository;
import ac.za.cput.andre.services.TerranService;
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
public class TerranServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private TerranService service;

    private Long id;

    @Autowired
    private TerranRepository repository;

    @Test
    public void create() throws Exception {

        ArrayList<Unit> army = new ArrayList<>();
        RaceSelector race = new RaceSelector();

        Race terran = race.getRace("Terran");
        Unit unit1 = terran.addUnit("Marine");
        Unit unit2 = terran.addUnit("Thor");

        army.add(unit1);
        army.add(unit2);


        int popcap = 0;
        for(int i = 0;i<army.size();i++)
        {
            popcap = popcap + army.get(i).popcap();
        }
        terran.setArmyName("Terran");
        terran.setArmyPop(popcap);
        repository.save((Terran)terran);
        id=terran.getID();
        Assert.assertNotNull(terran);
    }

    @Test
    public void testGetTerrans() throws Exception {
        List<Terran> army = service.getTerran();
        int size = army.size()-1;
        Assert.assertEquals(army.get(size).getArmyName(),"Terran");

    }
}
