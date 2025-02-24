package jpa실습.jpql실습;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "jpa_customer")
@Getter
@Setter
@NoArgsConstructor
public class JpaCustomer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private int age;

    @OneToMany(mappedBy = "jpaCustomer"
            , cascade = CascadeType.ALL, orphanRemoval = true)
    List<JpaOrder> orderList = new ArrayList<>();


}
