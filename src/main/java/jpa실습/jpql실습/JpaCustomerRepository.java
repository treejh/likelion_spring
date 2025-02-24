package jpa실습.jpql실습;

import java.util.List;
import jpa실습.JPQL.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface JpaCustomerRepository extends JpaRepository<JpaCustomer,Long> {


    //이름으로 조회
    List<JpaCustomer> findByName(String name);

    //이메일로 조회
    List<JpaCustomer> findByEmail(String email);

    List<JpaCustomer> findByEmailContaining(String email,Pageable pageable);


    //이메일에 특정 문자열을 포함 하고 있는 고객 조회
    @Query("select c from JpaCustomer c where c.email like %:data%")
    List<User> findByCustomerEmailContaining(@Param("data") String data);


    //각 고객과 고객의 주문수를 알고 싶다.
    //            @Query("SELECT c, count(o) FROM Customer c LEFT JOIN c.orders o GROUP BY c")
//    @Query("select c.name, count(o) from JpaCustomer c "
//            + " left join c.orderList o "
//            + "where c.name= :name "
//            + "group by c.id, c.name")
    @Query("SELECT c, count(o) FROM JpaCustomer c LEFT JOIN c.orderList o GROUP BY c")
    List<Object[]> findByCustomerOrderCount();


    //고객의 세부 정보와 그 고객의 가장 최근 주문 조회를 알고 싶어요.
    //@Query("SELECT c, o FROM Customer c JOIN c.orders o WHERE o.date = (SELECT MAX(o2.date) FROM Order o2 WHERE o2.customer = c")
    @Query("SELECT c, o FROM JpaCustomer c " +
            "JOIN c.orderList o " +
            "WHERE o.date = (SELECT MAX(o2.date) FROM JpaOrder o2 WHERE o2.jpaCustomer = c) ")
    List<Object[]> findCustomerWithLatestOrder();


    //평균나이보다 많은 고객을 조회하고 싶어요.
    @Query("SELECT c FROM JpaCustomer c WHERE c.age > (SELECT avg(c2.age) FROM JpaCustomer c2)")
    List<JpaCustomer> findCustomersAboveAverageAge();



}
