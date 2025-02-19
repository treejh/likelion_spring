package spring_jpa_mapping.ManyToOne;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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
@Table(name = "schools")
@Getter
@Setter
@NoArgsConstructor
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255,nullable = false)
    String name;

    //매핑을 하는게 아닌
    //스쿨을 얻어오면, 스클에 해당하는 리스트를 쓴다고 말해주는 것이다.
    //studen의 School school을 사용한다는 말이고,
    //학교를 가지고올때 학생 리스트를 같이 가지고 오는 것이다.
    //school의 id를 보내서, student

    //CascadeType -> 부모 삭제 되면 연속적으로 들어있는 학생 모두 삭제
    //orphanRemoval -> 부모에서 학생을 삭제(=관계가 끊기면)하면, 해당되는 학생이 삭제
    //이 연결은 하나만 이썽야 가능하다 1:1 연결로 되어져 있으면 사용 안하는게 좋다
        //예를들면 학생이 학교, 알바 두개 다 속해져 있으면 1:1 관계가 아닌거임
        //학교에서 학생의 연결이 끊기면 학생이 삭제되므로, 알바에서는 그 학생을 찾을 수 없다.는 단점 존재
    //포스트 -> 댓글
    @OneToMany(mappedBy = "school",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Student> students = new ArrayList<>();


    public School(String name) {
        this.name = name;
    }


}
