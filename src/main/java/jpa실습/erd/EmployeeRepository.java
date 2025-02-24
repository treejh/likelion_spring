package jpa실습.erd;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    List<Employee> findByLastName(String lastName);

    List<Employee> findBySalaryGreaterThanEqual(Double salary);

    List<Employee> findBySalaryLessThanOrSalaryGreaterThan(Double salary1, Double salary2);

    List<Employee> findByHireDateBetween(LocalDate startDate, LocalDate  endDate);

    List<Employee> findByDepartmentIdIn(List<Integer> departmentIds);

    @Query("SELECT e FROM Employee e JOIN FETCH e.department d WHERE d.id IN :departmentIds AND e.salary BETWEEN :minSalary AND :maxSalary")
    List<Employee> findByDepartmentIdInAndSalaryBetween(@Param("departmentIds") List<Integer> departmentIds, @Param("minSalary") Double minSalary, @Param("maxSalary")Double maxSalary);

    List<Employee> findByManagerIdIsNull();

    List<Employee> findByManagerIdIsNotNull();

    List<Employee> findByCommissionPctNotNullOrderBySalaryDescCommissionPctDesc();

    List<Employee> findByLastNameStartingWith(String prefix);
}