package restful실습.product실습.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import restful실습.product실습.domain.BuildProduct;

public interface BuildProductRepository extends JpaRepository<BuildProduct,Long> {
}
