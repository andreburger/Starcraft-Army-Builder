package ac.za.cput.andre.services;


import ac.za.cput.andre.domain.Zerg;

import java.util.List;

/**
 * Created by student on 2015/05/21.
 */
public interface ZergService {
    List<Zerg> getZerg();
    List<Zerg> getSingleZerg(String email);
}
