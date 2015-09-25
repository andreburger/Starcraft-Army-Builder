package ac.za.cput.andre.repository;

import ac.za.cput.andre.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by student on 2015/09/24.
 */
public interface UserRepository extends CrudRepository<User,Long> {
}
