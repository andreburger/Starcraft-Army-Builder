package ac.za.cput.andre.repository;

import ac.za.cput.andre.App;
import ac.za.cput.andre.domain.Race;
import ac.za.cput.andre.domain.Unit;
import ac.za.cput.andre.domain.User;
import ac.za.cput.andre.domain.Zerg;
import ac.za.cput.andre.factory.RaceSelector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by student on 2015/05/20.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class ZergCrudTest extends AbstractTestNGSpringContextTests {
    private Long id;
    @Autowired
    private ZergRepository repository;

    @Test
    public void create() throws Exception {
        ArrayList<HashMap<String,String>> army = new ArrayList<>();
        RaceSelector race = new RaceSelector();

        Race zerg = race.getRace("Zerg");
        Unit unit1 = zerg.addUnit("Zergling");
        Unit unit2 = zerg.addUnit("Hydralisk");

        army = zerg.getArmy();

        User user = new User
                .Builder("mitchthorngmailcom")
                .firstname("Mitchel")
                .lastname("Thorn")
                .userpassword("moo")
                .build();
        String username = user.getEmail();
        zerg.setArmyName("MitchelsArmy");
        zerg.setUser(username);

        repository.save((Zerg)zerg);
        id=zerg.getID();
        Assert.assertNotNull(zerg);
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Race terran = repository.findOne(id);
        Assert.assertNotNull(terran);

    }

    @Test(dependsOnMethods = "read")
    public void delete() throws Exception {
        Race zerg = repository.findOne(id);
        repository.delete((Zerg)zerg);
        Race deletedZerg = repository.findOne(id);
        Assert.assertNull(deletedZerg);
    }

}