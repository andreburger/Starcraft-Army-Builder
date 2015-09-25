package ac.za.cput.andre.services.impl;

import ac.za.cput.andre.domain.Terran;
import ac.za.cput.andre.domain.Unit;
import ac.za.cput.andre.domain.Zerg;
import ac.za.cput.andre.repository.TerranRepository;
import ac.za.cput.andre.repository.ZergRepository;
import ac.za.cput.andre.services.ZergService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/21.
 */
@Service
public class ZergServiceImpl implements ZergService {
    @Autowired
    ZergRepository repository;
    public List<Zerg> getZerg()
    {
        List<Zerg> allZergArmies = new ArrayList<>();
        Iterable<Zerg> values = repository.findAll();

        for (Zerg zerg : values)
            allZergArmies.add(zerg);

        return allZergArmies;
    }

    public List<Zerg> getSingleZerg(String email)
    {
        List<Zerg> allZergArmies = new ArrayList<>();
        Iterable<Zerg> values = repository.findAll();

        for (Zerg zerg : values) {
            String user = zerg.getUser();
            if(user.equals(email)) {
                allZergArmies.add(zerg);
            }
        }
        return allZergArmies;
    }
}
