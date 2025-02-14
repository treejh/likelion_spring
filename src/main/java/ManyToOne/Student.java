package ManyToOne;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="students")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(length = 255,nullable = false)
    private String name;


    //본인을 기준으로 한다 .
    //학생을 기준으로 하기 때문에 many로 시작하는것이다.
    //학생을 기준으로 시작해서 @ManyToOne이 되는거고, 만약 학교를 기준으로 하면 @OneToMany가 되는거네요
    @ManyToOne
    //실제 students의 school_id를 적어주는 것이다.
    //school의 id를 가리키는게 아님 !
    @JoinColumn(name = "school_id")
    //테이블 처럼 ID를 가지는 것이 아닌 객체 그 자체를 가진다
    private School school;


    public Student(String name, School school) {
        this.name = name;
        this.school = school;
    }
}
