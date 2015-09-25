package ac.za.cput.andre.api;

import ac.za.cput.andre.domain.Terran;
import ac.za.cput.andre.model.TerranResource;
import ac.za.cput.andre.services.TerranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.hateoas.Link;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/24.
 */
@RestController
@RequestMapping("api/services/**")
public class TerranArmies {

    @Autowired
    private TerranService serviceT;

    @RequestMapping(value="/terran/{email}", method= RequestMethod.GET)
    public ResponseEntity<List<Terran>> getSingleTerran(@PathVariable String email) {

        List<Terran> terran = serviceT.getSingleTerran(email);
        if(terran == null)
        {
            System.out.println("Terran Army/s from user with email " + email + " not found");
            return new ResponseEntity<List<Terran>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Terran>>(terran,HttpStatus.OK);
    }

    @RequestMapping(value = "/terran", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TerranResource> getTerran(){
        List<TerranResource> hatoes = new ArrayList<>();
        List<Terran> ter = serviceT.getTerran();
        for(Terran terran: ter)
        {
            TerranResource res = new TerranResource
                    .Builder(terran.getArmyName())
                    .resid(terran.getID())
                    .armyUnits(terran.getArmy())
                    .build();

            Link link = new Link("http://localhost:8080/api/home/terran/"+ terran.getUser()).withRel("depts");
            res.add(link);
            hatoes.add(res);
        }

        return hatoes;
    }

    @RequestMapping(value = "/terran/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createArmy(@RequestBody List<String> army,String raceSel,String armyname,String email){
        serviceT.createArmy(army,raceSel,armyname,email);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}
