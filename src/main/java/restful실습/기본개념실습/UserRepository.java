package restful실습.기본개념실습;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restful실습.crud실습.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}