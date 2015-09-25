package ac.za.cput.andre.services;

import ac.za.cput.andre.domain.User;

/**
 * Created by student on 2015/09/24.
 */
public interface UserService {

    boolean checkUser(User user);
    User save(User user);
    void delete(User user);
    User update(User user);
}
