package spring_jpa.ManyToOne;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="books")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String title;


    //fetch는 타입을 정할 수 있다. Eager, Lazy로 이루어져있다.
    //LAZY로 하면 한번에 author까지 가져오는 것이 아닌, 필요할때 쿼리가 실행된다.
    //EAGER로 하면 한번에 author까지 다 가져온다. 기본은 EAGER이다.
    //author가 처음 실행할때부터 필요하지 않을 수 있으니, 필요할때만 사용할 수 있도록 LAZY를 사용할 수 있다.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;


}
