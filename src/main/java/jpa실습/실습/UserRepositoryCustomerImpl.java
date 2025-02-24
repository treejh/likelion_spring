package jpa실습.실습;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Currency;

@RequiredArgsConstructor
public class UserRepositoryCustomerImpl implements UserRepositoryCustomer {
    private final EntityManager entityManager;


    @Override
    public List<User> findUsersByName(String name){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
        Root<User> user = query.from(User.class);
        //query.select(user).where(criteriaBuilder.equal(user.get("name"),name));
        //like도 사용 가능
        query.select(user).where(criteriaBuilder.like(user.get("name"),"%"+name+"%"));
        //select u from User u where u.name = name;
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<User> findUsersByEmail(String email) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
        Root<User> user = query.from(User.class);
        query.select(user).where(criteriaBuilder.equal(user.get("email"),email));
        return entityManager.createQuery(query).getResultList();

    }

    @Override
    public List<User> findUsersDynamically(String name, String email) {
        CriteriaBuilder cb  = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = cb.createQuery(User.class);
        Root<User> user = query.from(User.class);

        //조건에 따라서 boolean을 return하는데 어떻게 쿼리문을 넣는건가요 ..?
        List<Predicate> predicates = new ArrayList<>();
        if(name !=null){
            predicates.add(cb.equal(user.get("name"),name));
        }
        if(email != null){
            predicates.add(cb.equal(user.get("email"),email));
        }

        query.select(user).where(cb.or(predicates.toArray(new Predicate[0])));
        return entityManager.createQuery(query).getResultList();
    }

    public List<User> deleteUserByName(String name){
        return null;
    }

}
