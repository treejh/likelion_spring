package jpa실습.erd;

import java.time.LocalDate;
import java.util.Arrays;
import jpa실습.실습.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class Application{
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }


    @Bean
    public CommandLineRunner run(EmployeeRepository employeeRepository) {
        return args -> {
//            Employee employee = employeeRepository.findById(101L).get();
//            log.info(employee.getEmail());

//            log.info("Employees with last name 'King':");
//            employeeRepository.findByLastName("King").forEach(employee -> log.info(employee.toString()));

//            log.info("Employees with salary greater than or equal to 55000:");
//            employeeRepository.findBySalaryGreaterThanEqual(55000.0)
//                    .forEach(employee -> log.info(employee.toString()));

//            log.info("Employee with employee ID 1:");
//            employeeRepository.findById(100L).ifPresent(employee -> log.info(employee.toString()));  // 수정된 부분
//
//            log.info("Employees with salary less than 5000.0 or greater than 10000.0:");
//            employeeRepository.findBySalaryLessThanOrSalaryGreaterThan(5000.0, 10000.0).forEach(employee -> log.info(employee.toString()));
//
//            log.info("Employees hired between 2018-01-01 and 2021-01-01:");
//            employeeRepository.findByHireDateBetween( LocalDate.of(2018, 1, 1), LocalDate.of(2021, 1, 1)).forEach(employee -> log.info(employee.toString()));
//
//            log.info("Employees in departments 1 and 2:");
//            employeeRepository.findByDepartmentIdIn(Arrays.asList(1, 2)).forEach(employee -> log.info(employee.toString()));




        };



    }
}
