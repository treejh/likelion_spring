package restful실습;

import org.springframework.data.jpa.repository.JpaRepository;
import restful실습.domain.User;

public interface UserRepository extends JpaRepository<User,Long> {
}