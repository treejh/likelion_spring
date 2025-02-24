package restful실습.Todo실습.repostiroy;

import org.springframework.data.jpa.repository.JpaRepository;
import restful실습.Todo실습.domain.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
