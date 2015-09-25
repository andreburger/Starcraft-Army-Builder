package ac.za.cput.andre.services;


import ac.za.cput.andre.domain.Terran;

import java.util.List;


/**
 * Created by student on 2015/05/21.
 */
public interface TerranService {
    List<Terran> getTerran();
    List<Terran> getSingleTerran(String email);
    void createArmy(List<String> units,String race, String armyname, String email);
}
