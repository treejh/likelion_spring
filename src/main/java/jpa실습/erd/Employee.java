package jpa실습.erd;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
public class Employee {

    @Id
    @Column(name="employee_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "hire_date")
    private LocalDate hireDate;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    private Double salary;
    @Column(name = "commission_pct")
    private Double commissionPct;

    @ManyToOne
    @JoinColumn(name = "manager_id"/*,foreignKey = @ForeignKey(name = "FK_employee_manager"), nullable = true*/)
    private Employee manager;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;


//    @OneToMany(mappedBy = "manager")
//    private Set<Employee> subordinates;
//
//    @OneToMany(mappedBy = "employee")
//    private Set<JobHistory> jobHistories;


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}

