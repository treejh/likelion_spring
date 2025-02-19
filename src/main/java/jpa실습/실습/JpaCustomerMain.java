package jpa실습.실습;


import java.util.List;
import jpa실습.JPQL.JpaPracticeApplication;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class JpaCustomerMain {
    public static void main(String[] args) {
        SpringApplication.run(JpaCustomerMain.class, args);
    }

    @Bean
    public CommandLineRunner run(JpaCustomerRepository repository,JpaCustomerService jpaCustomerService){
        return args -> {
//            repository.findAll().forEach(customer ->{
//                log.info(customer.getName());

            //jpaCustomerService.getCustomer(1L);
//            //각 고객과 고객의 주문수를 알고 싶어요.
//            List<Object[]> resultList= jpaCustomerService.getCustomerCount();
//
//            resultList.forEach(result ->{
//                JpaCustomer customer = (JpaCustomer) result[0];
//                Long count = (Long) result[1];
//                log.info("고객 이름: {}, 주문 개수: {}", customer.getName(), count);
//            });

//            //고객의 세부정보와 그 고객의 가장 최근 주문 조회를 알고 싶어요
//            List<Object[]> latestOrders = repository.findCustomerWithLatestOrder();
//            latestOrders.forEach(result ->{
//                JpaCustomer jpaCustomer = (JpaCustomer) result[0];
//                JpaOrder jpaOrder = (JpaOrder) result[1];
//                log.info("고객 :: {} , 최근 주문 :: {}", jpaCustomer.getName(),jpaOrder.getDate());
//
//            });

            //평균나이보다 많은 고객을 조회하고 싶어요
            repository.findCustomersAboveAverageAge()
                    .forEach(result -> log.info(" 평균 나이 이상의 고객 : : {}",result.getName()));


        };

        };
    }

