package restful실습.event실습.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restful실습.event실습.domain.Event;

@Repository
public interface EventRepository extends JpaRepository<Event,Long> {
}
