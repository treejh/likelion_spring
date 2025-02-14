package ManyToMany;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "employees")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false, length=255)
    private String name;


    @ManyToMany
            @JoinTable(
                    //name = "em_pj", //자동으로 테이블을 만들어주거나,  만들어준 테이블을 쓴다.
                    name = "employees_projects",
                    joinColumns  = @JoinColumn(name="employee_id"), //연관 관계에서 내가(직원이) 조인한 컬럼
                    inverseJoinColumns = @JoinColumn(name="project_id") //연관관계에서 나의 반대(프로젝트) 조인한 컬럼
            )
    List<Project>  projectList = new ArrayList<>();


    public Employee(String name) {
        this.name = name;
    }
}
