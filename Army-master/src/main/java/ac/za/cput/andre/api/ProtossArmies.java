package ac.za.cput.andre.api;

import ac.za.cput.andre.domain.Protoss;
import ac.za.cput.andre.domain.Terran;
import ac.za.cput.andre.domain.Zerg;
import ac.za.cput.andre.model.ProtossResource;
import ac.za.cput.andre.model.TerranResource;
import ac.za.cput.andre.model.ZergResource;
import ac.za.cput.andre.services.ProtossService;
import ac.za.cput.andre.services.TerranService;
import ac.za.cput.andre.services.ZergService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.hateoas.Link;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/24.
 */
@RestController
@RequestMapping("api/services/**")
public class ProtossArmies {

    @Autowired
    private ProtossService serviceP;

    @RequestMapping(value="/protoss/{email}", method= RequestMethod.GET)
    public ResponseEntity<List<Protoss>> getSingleProtoss(@PathVariable String email) {

        List<Protoss> protoss = serviceP.getSingleProtoss(email);
        if(protoss == null)
        {
            System.out.println("Protoss Army/s from user with email " + email + " not found");
            return new ResponseEntity<List<Protoss>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Protoss>>(protoss, HttpStatus.OK);
    }

    @RequestMapping(value = "/protoss", method = RequestMethod.GET)
    public List<ProtossResource> getProtoss(){
        List<ProtossResource> hatoes = new ArrayList<>();
        List<Protoss> pro = serviceP.getProtoss();
        for(Protoss protoss: pro)
        {
            ProtossResource res = new ProtossResource
                    .Builder(protoss.getArmyName())
                    .resid(protoss.getID())
                    .armyUnits(protoss.getArmy())
                    .build();

            Link link = new Link("http://localhost:8080/api/home/protoss/"+protoss.getUser()).withRel("depts");
            res.add(link);
            hatoes.add(res);
        }

        return hatoes;
    }
}
