package jpa실습.erd;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Set;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "jobs")
@Getter
@Setter
@NoArgsConstructor
public class Job {
    @Id
    @Column(name = "job_id")
    private String id;
    @Column(name = "job_title")
    private String title;
    @Column(name = "max_salary")
    private Long maxSalary;
    @Column(name = "min_salary")
    private Long minSalary;

    @OneToMany(mappedBy = "job")
    private Set<Employee> employees;

    @OneToMany(mappedBy = "job")
    private Set<JobHistory> jobHistories;


}
