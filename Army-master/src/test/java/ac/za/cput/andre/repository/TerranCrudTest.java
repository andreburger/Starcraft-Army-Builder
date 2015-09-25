package ac.za.cput.andre.repository;

import ac.za.cput.andre.App;
import ac.za.cput.andre.domain.Race;
import ac.za.cput.andre.domain.Terran;
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

/**
 * Created by student on 2015/05/20.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TerranCrudTest extends AbstractTestNGSpringContextTests {
    private Long id;
    @Autowired
    private TerranRepository repository;

    @Test
    public void create() throws Exception {
        ArrayList<HashMap<String,String>> army = new ArrayList<>();
        RaceSelector race = new RaceSelector();


        Race terran = race.getRace("Terran");
        Unit unit1 = terran.addUnit("Marine");
        Unit unit2 = terran.addUnit("Thor");


        User user = new User
                .Builder("pazburgergmailcom")
                .firstname("Andre")
                .lastname("Burger")
                .userpassword("Deadman828")
                .build();

        String username = user.getEmail();
        army = terran.getArmy();

        terran.setArmyName("AndresArmy");
        terran.setUser(username);
        repository.save((Terran)terran);
        id=terran.getID();
        Assert.assertNotNull(terran);
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Race terran = repository.findOne(id);
        Assert.assertNotNull(terran);

    }

   @Test(dependsOnMethods = "read")
    public void delete() throws Exception {
        Race terran = repository.findOne(id);
        repository.delete((Terran)terran);
        Race deletedTerran = repository.findOne(id);
        Assert.assertNull(deletedTerran);
    }

}
