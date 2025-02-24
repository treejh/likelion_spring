package jpa실습.실습;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long>, UserRepositoryCustomer{
}
