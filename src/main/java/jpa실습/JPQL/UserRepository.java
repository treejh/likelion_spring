package jpa실습.JPQL;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User,Long> {

    //이름을 기준으로 조회 name필드명은 대소문주 잘봐야함
    List<User> findByName(String name);
    List<User> findByEmail(String email);
    //List<User> findByNameContaining(String name); //select * from jpa_user where
    List<User> findByNameAndEmail(String name, String email);
    List<User> findByNameOrEmail(String name, String email);

    @Query("select u from User u where u.name = :name")
    List<User> selectUser(@Param("name") String name);

    @Query("select u from User u where u.name like %:name%")
    List<User> selectUserLike(@Param("name") String name);


    @Transactional
    @Modifying
    @Query("delete from User u where u.email= :email")
    int deleteByEmail(@Param("email") String email);


    @Modifying
    @Transactional
    @Query("update User u set u.email = :email where u.id = :id")
    int updateByEmail(@Param("id")Long id,@Param("email") String email);

    //jp쿼리말고, 일반 쿼리를 쓰고 싶다면?
    @Query(nativeQuery = true, value = "select * from jpa_user where email like %:email%")
    List<User> selectByEmailNative(@Param("email") String email);


    //?를 쓰면 @param을 안써도 된다.
    @Query(nativeQuery = true, value = "select * from jpa_user where email like %:?1%")
    List<User> selByEmail(String email);


    List<User> findByNameContaining(String name, Pageable pageable);




}
