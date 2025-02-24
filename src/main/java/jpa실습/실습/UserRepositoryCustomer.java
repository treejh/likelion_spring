package jpa실습.실습;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryCustomer{
    List<User> findUsersByName(String name);

    List<User>findUsersByEmail(String email);

    List<User> findUsersDynamically(String name, String email);

    //List<User> deleteUserByName(String name);
}
