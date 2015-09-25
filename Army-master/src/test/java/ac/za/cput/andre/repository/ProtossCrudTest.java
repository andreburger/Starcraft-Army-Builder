package ac.za.cput.andre.repository;

import ac.za.cput.andre.App;
import ac.za.cput.andre.domain.Protoss;
import ac.za.cput.andre.domain.Race;
import ac.za.cput.andre.domain.Unit;
import ac.za.cput.andre.domain.User;
import ac.za.cput.andre.factory.RaceSelector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by student on 2015/05/20.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class ProtossCrudTest extends AbstractTestNGSpringContextTests {
    private Long id;
    @Autowired
    private ProtossRepository repository;

    @Test
    public void create() throws Exception {
        ArrayList<HashMap<String,String>> army = new ArrayList<>();
        RaceSelector race = new RaceSelector();

        Race protoss = race.getRace("Protoss");
        Unit unit1 = protoss.addUnit("Zealot");
        Unit unit2 = protoss.addUnit("Colossus");

        army = protoss.getArmy();

        User user = new User
                .Builder("ryancgmailcom")
                .firstname("Ryan")
                .lastname("Carstens")
                .userpassword("Fluffy")
                .build();
        String username = user.getEmail();
        protoss.setArmyName("RyansArmy");
        protoss.setUser(username);
        repository.save((Protoss)protoss);
        id=protoss.getID();
        Assert.assertNotNull(protoss);
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Race terran = repository.findOne(id);
        Assert.assertNotNull(terran);

    }

    @Test(dependsOnMethods = "read")
    public void delete() throws Exception {
        Race protoss = repository.findOne(id);
        repository.delete((Protoss)protoss);
        Race deletedProtoss = repository.findOne(id);
        Assert.assertNull(deletedProtoss);
    }

}
