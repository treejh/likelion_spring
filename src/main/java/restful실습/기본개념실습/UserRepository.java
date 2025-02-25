package restful실습.기본개념실습;

import org.springframework.data.jpa.repository.JpaRepository;
import restful실습.crud실습.domain.User;

public interface UserRepository extends JpaRepository<User,Long> {
}