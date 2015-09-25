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
public class ZergArmies {

    @Autowired
    private ZergService serviceZ;


    @RequestMapping(value = "/zerg/{email}", method = RequestMethod.GET)
    public ResponseEntity<List<Zerg>> getSingleZerg(@PathVariable String email) {

        List<Zerg> zerg = serviceZ.getSingleZerg(email);
        if(zerg == null) {
            System.out.println("Zerg Army/s from user with email " + email + " not found");
            return new ResponseEntity<List<Zerg>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Zerg>>(zerg,HttpStatus.OK);

    }

    @RequestMapping(value = "/zerg", method = RequestMethod.GET)
    public List<ZergResource> getZerg() {
        List<ZergResource> hatoes = new ArrayList<>();
        List<Zerg> zer = serviceZ.getZerg();
        for (Zerg zerg : zer) {
            ZergResource res = new ZergResource
                    .Builder(zerg.getArmyName())
                    .resid(zerg.getID())
                    .armyUnits(zerg.getArmy())
                    .build();

            Link link = new Link("http://localhost:8080/api/home/zerg/" + zerg.getUser()).withRel("depts");
            res.add(link);
            hatoes.add(res);
        }

        return hatoes;
    }

}
