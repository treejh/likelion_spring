package jpa실습.JPQL;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

    public User findById(Long id){
        return repository.findById(id).orElseThrow();
    }
}