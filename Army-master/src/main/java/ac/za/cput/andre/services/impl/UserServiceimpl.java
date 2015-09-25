package ac.za.cput.andre.services.impl;

import ac.za.cput.andre.domain.User;
import ac.za.cput.andre.repository.UserRepository;
import ac.za.cput.andre.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by student on 2015/09/24.
 */
@Service
public class UserServiceimpl implements UserService{
    @Autowired
    UserRepository repository;

    public boolean checkUser(User user)
    {


        return true;
    }

    public User save(User entity) {
        return repository.save(entity);
    }

    public void delete(User entity) {
        repository.delete(entity);

    }

    public User update(User entity) {
        return repository.save(entity);
    }
}
