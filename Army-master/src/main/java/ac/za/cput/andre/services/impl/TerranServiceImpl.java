package ac.za.cput.andre.services.impl;

import ac.za.cput.andre.domain.Race;
import ac.za.cput.andre.domain.Terran;
import ac.za.cput.andre.domain.Unit;
import ac.za.cput.andre.domain.User;
import ac.za.cput.andre.factory.RaceSelector;
import ac.za.cput.andre.repository.TerranRepository;
import ac.za.cput.andre.services.TerranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by student on 2015/05/21.
 */
@Service
public class TerranServiceImpl implements TerranService {
    @Autowired
    TerranRepository repository;
    public List<Terran> getTerran()
    {
        List<Terran> allTerranArmies = new ArrayList<>();
        Iterable<Terran> values = repository.findAll();

        for (Terran terran : values)
            allTerranArmies.add(terran);
        return allTerranArmies;
    }

    public List<Terran> getSingleTerran(String email)
    {
        List<Terran> allTerranArmies = new ArrayList<>();
        Iterable<Terran> values = repository.findAll();

        for (Terran terran : values) {
            String user = terran.getUser();
            if(user.equals(email)) {
                allTerranArmies.add(terran);
            }
        }
        return allTerranArmies;
    }

    public void createArmy(List<String> army,String raceSel,String armyname,String email)
    {
        RaceSelector race = new RaceSelector();
        Race terran = race.getRace(raceSel);
        for(int i = 0; i < army.size();i++)
        {
            Unit unit = terran.addUnit(army.get(i));
        }

        terran.setArmyName(armyname);
        terran.setUser(email);
        repository.save((Terran)terran);
    }
}
