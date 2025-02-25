package restful실습.product실습.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restful실습.product실습.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
